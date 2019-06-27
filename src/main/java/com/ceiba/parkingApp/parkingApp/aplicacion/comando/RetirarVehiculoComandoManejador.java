package com.ceiba.parkingApp.parkingApp.aplicacion.comando;

import com.ceiba.parkingApp.parkingApp.dominio.modelo.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.servicio.ServicioRetiroVehiculo;

public class RetirarVehiculoComandoManejador {
	
	private ServicioRetiroVehiculo servicioRetiroVehiculo;
	
	public RetirarVehiculoComandoManejador(ServicioRetiroVehiculo servicioRetiroVehiculo) {
		this.servicioRetiroVehiculo = servicioRetiroVehiculo;
	}
	
	public VehiculoComando gestionarRetiroVehiculo(int idVehiculo) {
		Vehiculo vehiculo = servicioRetiroVehiculo.cobrarSalidaVehiculo(idVehiculo);
		return new VehiculoComando(vehiculo.getId(), vehiculo.getTipoVehiculo().getId(), vehiculo.getPlaca(), vehiculo.getCilindraje(), vehiculo.getFechaEntrada(), vehiculo.getFechaSalida(), vehiculo.getTotalCobro()); 
	}

}
