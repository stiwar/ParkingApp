package com.ceiba.parkingApp.parkingApp.dominio.servicio;

import java.util.Date;

import com.ceiba.parkingApp.parkingApp.dominio.modelo.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.puerto.VehiculoRepositorioPort;

public class ServicioRetiroVehiculo {
	
	Date fechaActual = new Date();

	private VehiculoRepositorioPort vehiculoRepositorioPort;
	
	public ServicioRetiroVehiculo(VehiculoRepositorioPort vehiculoRepositorioPort) {
		this.vehiculoRepositorioPort = vehiculoRepositorioPort;	
	}
	
	public Vehiculo cobrarSalidaVehiculo(int idVehiculo) {
		Vehiculo vehiculo = recuperarVehiculo(idVehiculo);
		vehiculo.setFechaSalida(fechaActual);
		vehiculo.establecerCobro();
		
		return vehiculoRepositorioPort.retirarVehiculo(vehiculo);
	}
	
	public Vehiculo recuperarVehiculo(int idVehiculo) {
		return vehiculoRepositorioPort.obtenerVehiculoPorId(idVehiculo);
	}
		
}
