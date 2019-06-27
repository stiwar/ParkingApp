package com.ceiba.parkingApp.parkingApp.dominio.servicio;

import java.util.List;

import com.ceiba.parkingApp.parkingApp.dominio.modelo.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.puerto.VehiculoRepositorioPort;

public class ServicioConsultaVehiculo {
	
	private VehiculoRepositorioPort vehiculoRepositorioPort;
	
	public ServicioConsultaVehiculo(VehiculoRepositorioPort vehiculoRepositorioPort) {
		this.vehiculoRepositorioPort = vehiculoRepositorioPort;
	}
	
	public List<Vehiculo> obtenerListaVehiculos(){
		return vehiculoRepositorioPort.obtenerVehiculos();
	}
	
	public Vehiculo consultarVehiculo(int idVehiculo){
		return vehiculoRepositorioPort.obtenerVehiculoPorId(idVehiculo);
	}

}
