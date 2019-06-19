package com.ceiba.parkingApp.parkingApp.dominio.servicio;

import java.util.Date;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.puerto.IVehiculoRepositorioPort;

public class ServicioRetiroVehiculo {
	

	private static int VEHICULO_ESTADO_INACTIVO = 0;
	
	Date fechaActual = new Date();

	private IVehiculoRepositorioPort vehiculoRepositorioPort;
	
	public ServicioRetiroVehiculo(IVehiculoRepositorioPort vehiculoRepositorioPort) {
		this.vehiculoRepositorioPort = vehiculoRepositorioPort;	
	}
	
	public Vehiculo cobrarSalidaVehiculo(int idVehiculo) {
		Vehiculo vehiculo = recuperarVehiculo(idVehiculo);
		vehiculo.setEstado(VEHICULO_ESTADO_INACTIVO);
		vehiculo.setFechaSalida(fechaActual);
		vehiculo.establecerCobro();
		
		return vehiculoRepositorioPort.retirarVehiculo(vehiculo);
	}
	
	public Vehiculo recuperarVehiculo(int idVehiculo) {
		return vehiculoRepositorioPort.obtenerVehiculoPorId(idVehiculo);
	}
		
}
