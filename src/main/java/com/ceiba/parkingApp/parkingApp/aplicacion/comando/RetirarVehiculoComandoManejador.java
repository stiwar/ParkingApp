package com.ceiba.parkingApp.parkingApp.aplicacion.comando;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.servicio.ServicioRetiroVehiculo;

public class RetirarVehiculoComandoManejador {
	
	private ServicioRetiroVehiculo servicioRetiroVehiculo;
	
	public RetirarVehiculoComandoManejador(ServicioRetiroVehiculo servicioRetiroVehiculo) {
		this.servicioRetiroVehiculo = servicioRetiroVehiculo;
	}
	
	public VehiculoComando gestionarRetiroVehiculo(int idVehiculo) {
		Vehiculo vehiculo = servicioRetiroVehiculo.cobrarSalidaVehiculo(idVehiculo);
		return new VehiculoComando(vehiculo.getId(), vehiculo.getTipoVehiculo(), vehiculo.getPlaca(), vehiculo.getCilindraje(), vehiculo.getFechaEntrada(), vehiculo.getFechaSalida(), vehiculo.getEstado(), vehiculo.getTotalCobro()); 
	}

}
