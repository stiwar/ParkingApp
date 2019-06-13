package com.ceiba.parkingApp.parkingApp.aplicacion.comando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.TipoVehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.entidad.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.servicio.ServicioRegistroVehiculo;

@Component
public class RegistrarVehiculoComandoManejador {
	@Autowired
	private ServicioRegistroVehiculo servicioRegistroVehiculo;
	//private IVehiculoRepositorioPort vehiculoRepositorioPort;
	
	public VehiculoComando guardarVehiculo(VehiculoComando vehiculoComando) {
		//TipoVehiculo tipoVehiculo = new TipoVehiculo(vehiculoComando.getTipoVehiculo().getNombre());
		TipoVehiculo tipoVehiculo = new TipoVehiculo(vehiculoComando.getTipoVehiculo().getId(),vehiculoComando.getTipoVehiculo().getNombre());
		Vehiculo vehiculo = new Vehiculo(tipoVehiculo, vehiculoComando.getPlaca(), vehiculoComando.getCilindraje());
		vehiculo = servicioRegistroVehiculo.guardarRegistroVehiculo(vehiculo);
		//aqui hay que agregar la capa de servicio
		return new VehiculoComando(vehiculo.getId(), vehiculo.getTipoVehiculo(), vehiculo.getPlaca(), vehiculo.getCilindraje(), vehiculo.getFechaEntrada(), vehiculo.getEstado());
	}
}
