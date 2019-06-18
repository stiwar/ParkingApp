package com.ceiba.parkingApp.parkingApp.dominio.servicio;

import java.util.List;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.puerto.IVehiculoRepositorioPort;

public class ServicioConsultaVehiculo {
	
	private IVehiculoRepositorioPort vehiculoRepositorioPort;
	
	public ServicioConsultaVehiculo(IVehiculoRepositorioPort vehiculoRepositorioPort) {
		this.vehiculoRepositorioPort = vehiculoRepositorioPort;
	}
	
	public List<Vehiculo> obtenerListaVehiculos(){
		return vehiculoRepositorioPort.obtenerVehiculos();
	}
	
	public Vehiculo consultarVehiculo(int idVehiculo){
		return vehiculoRepositorioPort.obtenerVehiculoPorId(idVehiculo);
	}

}
