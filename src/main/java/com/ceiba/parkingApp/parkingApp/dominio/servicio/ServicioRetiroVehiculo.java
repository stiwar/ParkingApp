package com.ceiba.parkingApp.parkingApp.dominio.servicio;

import java.util.Date;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.puerto.IVehiculoRepositorioPort;

public class ServicioRetiroVehiculo {
	
	private static final double VALOR_HORA_CARRO = 1000;
	private static final double VALOR_HORA_MOTO = 500;
	private static final int VALOR_DIA_CARRO = 8000;
	private static final int VALOR_DIA_MOTO = 4000;
	private static final int LIMITE_TIEMPO_PARA_VALOR_HORA = 9;
	private static final double LIMITE_CILINDRAJE_MOTO = 500;
	private static final double EXCEDENTE_CILINDRAJE_MOTO = 2000; 
	private static final String CARRO = "Carro";
	private static final String MOTO = "Moto";
	private static final int TOTAL_HORAS_DIA = 24;
	private static int VEHICULO_ESTADO_INACTIVO = 0;
	private static int MILISEGUNDOS_A_SEGUNDOS = 1000;
	private static int SEGUNDOS_A_MINUTOS = 60;
	private static int MINUTOS_A_HORAS = 60;
	
	Date fechaActual = new Date();

	private IVehiculoRepositorioPort vehiculoRepositorioPort;
	
	public ServicioRetiroVehiculo(IVehiculoRepositorioPort vehiculoRepositorioPort) {
		this.vehiculoRepositorioPort = vehiculoRepositorioPort;	
	}
	
	public Vehiculo cobrarSalidaVehiculo(int idVehiculo) {
		Vehiculo vehiculo = recuperarVehiculo(idVehiculo);
		Date fechaIngreso = vehiculo.getFechaEntrada();
		int totalHoras = obtenerHoras(fechaIngreso, fechaActual);
		double cobro = 0;
		
		if(totalHoras >= LIMITE_TIEMPO_PARA_VALOR_HORA ) {
			cobro = obtenerCobroPorDias(totalHoras, vehiculo);
		}else {
			cobro = obtenerCobroPorHora(totalHoras, vehiculo);
		}
		
		vehiculo.setEstado(VEHICULO_ESTADO_INACTIVO);
		vehiculo.setFechaSalida(new Date());
		vehiculo.setTotalCobro(cobro);
		return vehiculoRepositorioPort.retirarVehiculo(vehiculo);
	}
	
	public Vehiculo recuperarVehiculo(int idVehiculo) {
		return vehiculoRepositorioPort.obtenerVehiculoPorId(idVehiculo);
	}
	
	public int obtenerHoras(Date fechaInicial, Date fechaFinal) {
		long diferenciaMilisegundos = fechaFinal.getTime() - fechaInicial.getTime();
		return (int) diferenciaMilisegundos / (MILISEGUNDOS_A_SEGUNDOS * SEGUNDOS_A_MINUTOS * MINUTOS_A_HORAS);
	}
		
	private double obtenerCobroPorHora(long horas, Vehiculo vehiculo ) {
		double cobro = 0;
		String tipoVehiculo = vehiculo.getTipoVehiculo().getNombre();
		if(tipoVehiculo.equalsIgnoreCase(CARRO)) {
			cobro = horas * VALOR_HORA_CARRO;
		}
		
		if(tipoVehiculo.equalsIgnoreCase(MOTO)) {
			double cilindrajeMoto = vehiculo.getCilindraje();
			if(cilindrajeMoto > LIMITE_CILINDRAJE_MOTO) {
				cobro = (horas * VALOR_HORA_MOTO) + EXCEDENTE_CILINDRAJE_MOTO;
			}else {
				cobro = horas * VALOR_HORA_MOTO;
			}
		}
		return cobro;
	}
	
	public double obtenerCobroPorDias(int horas, Vehiculo vehiculo ) {
		int dias = 0;
		int residuoHoras = 0;
		double cobro = 0;
		String tipoVehiculo = vehiculo.getTipoVehiculo().getNombre();
		
		if(horas < 24)
			return (double) (tipoVehiculo.equalsIgnoreCase(CARRO) ? VALOR_DIA_CARRO : VALOR_DIA_MOTO);	
			
		dias = horas/TOTAL_HORAS_DIA;
		residuoHoras = horas % TOTAL_HORAS_DIA;
		
		if(tipoVehiculo.equalsIgnoreCase(CARRO)) {
			if(residuoHoras > LIMITE_TIEMPO_PARA_VALOR_HORA ) {
				cobro = (double) ((++dias)*VALOR_DIA_CARRO); 
			}else {
				cobro = (dias*VALOR_DIA_CARRO) + (residuoHoras*VALOR_HORA_CARRO);
			}
		}
		
		if(tipoVehiculo.equalsIgnoreCase(MOTO)) {
			
			if(residuoHoras > LIMITE_TIEMPO_PARA_VALOR_HORA ) {
				cobro = (double) ((++dias)*VALOR_DIA_MOTO);
			}else {
				cobro = (dias*VALOR_DIA_MOTO) + (residuoHoras*VALOR_HORA_MOTO);
			}
			
			double cilindrajeMoto = vehiculo.getCilindraje();
			if(cilindrajeMoto > LIMITE_CILINDRAJE_MOTO) {
				cobro += EXCEDENTE_CILINDRAJE_MOTO;
			}
		
		}
		
		return cobro;
	}

}
