package com.ceiba.parkingApp.parkingApp.aplicacion.comando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.parkingApp.parkingApp.dominio.servicio.ServicioRetiroVehiculo;

@Component
public class RetirarVehiculoComandoManejador {
	
	@Autowired
	private ServicioRetiroVehiculo servicioRetiroVehiculo;
	
	public double eliminarVehiculo(int idVehiculo) {
		return servicioRetiroVehiculo.eliminarRegistroVehiculo(idVehiculo);
	}

}
