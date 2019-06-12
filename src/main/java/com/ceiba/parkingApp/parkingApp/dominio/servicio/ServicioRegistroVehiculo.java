package com.ceiba.parkingApp.parkingApp.dominio.servicio;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.excepcion.VehiculoExcepcion;
import com.ceiba.parkingApp.parkingApp.dominio.puerto.IVehiculoRepositorioPort;


@Service
public class ServicioRegistroVehiculo {
	
	private static final String CARRO = "Carro";
	private static final String MOTO = "Moto";
	private static final int LIMITE_MAXIMO_CARROS = 20;
	private static final int LIMITE_MAXIMO_MOTOS = 10;
	private static final String NO_HAY_ESPACIO_PARA_CARROS = "No hay espacio disponible para carros";
	private static final String NO_HAY_ESPACIO_PARA_MOTOS = "No hay espacio disponible para motos";
	private static final int POSICION_LETRA_INICIAL = 0;
	private static final String LETRA_A = "A";
	private static final String ACCESO_DENEGADO = "Las placas que inician con la letra '" + LETRA_A + "' solo pueden ingresar los Domingos o Lunes";
	
	private String nombreTipoVehiculo = "";
	private String letraInicialPlaca = "";
	private int idTipoVehiculo = 0;
	
	
	@Autowired
	private IVehiculoRepositorioPort vehiculoRepositorioPort;
	
	//@Autowired
	//private ITipoVehiculoRepositorioPort tipoVehiculoRepositorioPort;
	
	public boolean guardarRegistroVehiculo(Vehiculo vehiculo) {
		//logica negocio registrar vehiculo
		nombreTipoVehiculo = vehiculo.getTipoVehiculo().getNombre();
		idTipoVehiculo = vehiculo.getTipoVehiculo().getId();
		
		if( nombreTipoVehiculo.equalsIgnoreCase(CARRO) && validarEspacioDisponible(idTipoVehiculo) >= LIMITE_MAXIMO_CARROS ) {
			throw new VehiculoExcepcion(NO_HAY_ESPACIO_PARA_CARROS);
		}
		
		if( nombreTipoVehiculo.equalsIgnoreCase(MOTO) && validarEspacioDisponible(idTipoVehiculo) >= LIMITE_MAXIMO_MOTOS ) {
			throw new VehiculoExcepcion(NO_HAY_ESPACIO_PARA_MOTOS);
		}
		
		letraInicialPlaca = obtenerLetraInicialPlaca(vehiculo.getPlaca());
		
		int diaSemana = obtenerDiaSemana();
		if( letraInicialPlaca.equalsIgnoreCase(LETRA_A) && (diaSemana != Calendar.SUNDAY && diaSemana != Calendar.MONDAY) ) {
			throw new VehiculoExcepcion(ACCESO_DENEGADO);
		}
		
		vehiculo.setFechaEntrada(new Date());
		return vehiculoRepositorioPort.registrarVehiculo(vehiculo);
	}
	
	//validar Espacio disponible dependiendo del tipo de vehiculo
	//verificar si la placa empieza por "A" y dia de la semana
	//verificar que el vehiculo no ha sido registrado antes
	
	private int validarEspacioDisponible(int idTipoVehiculo) {
		return vehiculoRepositorioPort.obtenerTotalPorIdTipoVehiculo(idTipoVehiculo);// .obtenerTotalPorNombreTipoVehiculo(nombreTipoVehiculo);
	}
	
	private String obtenerLetraInicialPlaca(String placa) {
		return String.valueOf(placa.charAt(POSICION_LETRA_INICIAL)); 
	}
	
	private int obtenerDiaSemana() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
}
