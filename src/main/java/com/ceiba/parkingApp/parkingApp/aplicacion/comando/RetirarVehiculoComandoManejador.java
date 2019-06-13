package com.ceiba.parkingApp.parkingApp.aplicacion.comando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.servicio.ServicioRetiroVehiculo;

@Component
public class RetirarVehiculoComandoManejador {
	
	@Autowired
	private ServicioRetiroVehiculo servicioRetiroVehiculo;
	
	public VehiculoComando eliminarVehiculo(int idVehiculo) {
		Vehiculo vehiculo = servicioRetiroVehiculo.eliminarRegistroVehiculo(idVehiculo);
		return new VehiculoComando(vehiculo.getId(), vehiculo.getTipoVehiculo(), vehiculo.getPlaca(), vehiculo.getCilindraje(), vehiculo.getFechaEntrada(), vehiculo.getEstado()); 
	}

}
