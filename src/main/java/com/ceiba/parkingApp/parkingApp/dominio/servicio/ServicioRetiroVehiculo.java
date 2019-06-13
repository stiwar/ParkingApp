package com.ceiba.parkingApp.parkingApp.dominio.servicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.excepcion.VehiculoExcepcion;
import com.ceiba.parkingApp.parkingApp.dominio.puerto.IVehiculoRepositorioPort;

@Service
public class ServicioRetiroVehiculo {
	
	private static final String ERROR_CONVERSION_CADENA_FECHA_A_DATE = "Error de conversión de cadena a tipo Date";
	private static final int VALOR_HORA_CARRO = 1000;
	private static final int VALOR_HORA_MOTO = 500;
	private static final int VALOR_DIA_CARRO = 8000;
	private static final int VALOR_DIA_MOTO = 4000;
	private static final int LIMITE_TIEMPO_PARA_VALOR_HORA = 9;
	private static final double LIMITE_CILINDRAJE_MOTO = 500;
	private static final double EXCEDENTE_CILINDRAJE_MOTO = 2000; 
	private static final String CARRO = "Carro";
	private static final String MOTO = "Moto";
	private static final int TOTAL_HORAS_DIA = 24;
	private static int VEHICULO_ESTADO_INACTIVO = 0;
	
	Vehiculo vehiculo = null;
	Date fechaActual = new Date();
	SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	@Autowired
	private IVehiculoRepositorioPort vehiculoRepositorioPort;
	
	public Vehiculo eliminarRegistroVehiculo(int idVehiculo) {
		System.out.println("prueba ingreso");
		Vehiculo vehiculo = recuperarVehiculo(idVehiculo);
		System.out.println("placa: "+vehiculo.getPlaca());
		Date fechaIngreso = vehiculo.getFechaEntrada();
		long totalHoras = obtenerHoras(fechaIngreso, fechaActual);
		double cobro = 0;
		if(totalHoras > LIMITE_TIEMPO_PARA_VALOR_HORA ) {
			cobro = obtenerCobroPorDias(totalHoras, vehiculo);
		}else {
			cobro = obtenerCobroPorHora(totalHoras, vehiculo);
		}
		vehiculo.setEstado(VEHICULO_ESTADO_INACTIVO);
		vehiculo.setFechaSalida(new Date());
		vehiculo.setTotalCobro(cobro);
		return vehiculoRepositorioPort.retirarVehiculo(vehiculo);
	}
	
	private Vehiculo recuperarVehiculo(int idVehiculo) {
		return vehiculoRepositorioPort.obtenerVehiculoPorId(idVehiculo);
	}
	
	private long obtenerHoras(Date fechaInicial, Date fechaFinal) {
		String cadenaFechaInicial = formatearFechaACadena(fechaInicial);
		String cadenaFechaFinal = formatearFechaACadena(fechaFinal);
		Date fInicial = formatearFechaATipoDate(cadenaFechaInicial);
		Date fFinal = formatearFechaATipoDate(cadenaFechaFinal);
		long diferenciaMilisegundos = fFinal.getTime() - fInicial.getTime();
		
		//long diferenciaHoras = diferenciaMilisegundos / (60 * 60 * 1000) % 24;
		long diferenciaHoras = diferenciaMilisegundos / (60 * 60 * 1000);
		return diferenciaHoras;
	}
	
	private String formatearFechaACadena(Date fecha) {
		return format.format(fecha);
	}
	
	private Date formatearFechaATipoDate(String fechaString) {
		try {
			return format.parse(fechaString);
		} catch (ParseException e) {
			new VehiculoExcepcion(ERROR_CONVERSION_CADENA_FECHA_A_DATE);
		}
		return null;
	}
	
	private double obtenerCobroPorHora(long horas, Vehiculo vehiculo ) {
		double cobro = 0;
		String tipoVehiculo = vehiculo.getTipoVehiculo().getNombre();
		if(tipoVehiculo.equalsIgnoreCase(CARRO)) {
			return cobro = horas * VALOR_HORA_CARRO;
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
	
	private double obtenerCobroPorDias(long horas, Vehiculo vehiculo ) {
		int dias = 0;
		int residuoHoras = 0;
		double cobro = 0;
		String tipoVehiculo = vehiculo.getTipoVehiculo().getNombre();
		if(horas >= 24) {
			dias = (int) (horas/TOTAL_HORAS_DIA);
			residuoHoras = ((int) horas) % TOTAL_HORAS_DIA;
			if(tipoVehiculo.equalsIgnoreCase(CARRO)) {
				if(residuoHoras > LIMITE_TIEMPO_PARA_VALOR_HORA ) {//cobrar con valor dia carro
					cobro = (double) ((++dias)*VALOR_DIA_CARRO); 
				}else {//cobrar con valor hora carro
					cobro = (double) ((dias*VALOR_DIA_CARRO) + (residuoHoras*VALOR_HORA_CARRO));
				}
			}
			if(tipoVehiculo.equalsIgnoreCase(MOTO)) {
				
				if(residuoHoras > LIMITE_TIEMPO_PARA_VALOR_HORA ) {//cobrar con valor dia moto
					cobro = (double) ((++dias)*VALOR_DIA_MOTO);
				}else {//cobrar con valor hora carro
					cobro = (double) ((dias*VALOR_DIA_MOTO) + (residuoHoras*VALOR_HORA_MOTO));
				}
				
				double cilindrajeMoto = vehiculo.getCilindraje();
				if(cilindrajeMoto > LIMITE_CILINDRAJE_MOTO) {
					cobro += EXCEDENTE_CILINDRAJE_MOTO;
				}
			
			}
			
			return cobro;
		}
		
		//cuando es mayor a 9 y menor a 24 (siempre se cobra por dia)
		cobro = (double) (tipoVehiculo.equalsIgnoreCase(CARRO) ? VALOR_DIA_CARRO : VALOR_DIA_MOTO);	
		return cobro;
		
		
	}
	
	//calcular tiempo que estuvo en el parqueadero
	//if permanecio hasta 9 horas, se cobran las horas, sino cobrar por dias
}
