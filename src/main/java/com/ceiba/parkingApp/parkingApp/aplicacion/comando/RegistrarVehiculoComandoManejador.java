package com.ceiba.parkingApp.parkingApp.aplicacion.comando;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.TipoVehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.entidad.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.servicio.ServicioRegistroVehiculo;

public class RegistrarVehiculoComandoManejador {
	
	private ServicioRegistroVehiculo servicioRegistroVehiculo;
	
	public RegistrarVehiculoComandoManejador(ServicioRegistroVehiculo servicioRegistroVehiculo) {
		this.servicioRegistroVehiculo = servicioRegistroVehiculo;
	}
	
	public VehiculoComando guardarVehiculo(VehiculoComando vehiculoComando) {
		TipoVehiculo tipoVehiculo = new TipoVehiculo(vehiculoComando.getTipoVehiculo().getId(),vehiculoComando.getTipoVehiculo().getNombre());
		Vehiculo vehiculo = new Vehiculo(tipoVehiculo, vehiculoComando.getPlaca(), vehiculoComando.getCilindraje());
		vehiculo = servicioRegistroVehiculo.guardarRegistroVehiculo(vehiculo);
		return new VehiculoComando(vehiculo.getId(), vehiculo.getTipoVehiculo(), vehiculo.getPlaca(), vehiculo.getCilindraje(), vehiculo.getFechaEntrada(), vehiculo.getEstado());
	}
	
}
