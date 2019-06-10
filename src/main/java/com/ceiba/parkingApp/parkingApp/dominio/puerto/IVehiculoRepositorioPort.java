package com.ceiba.parkingApp.parkingApp.dominio.puerto;

import java.util.List;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.Vehiculo;

public interface IVehiculoRepositorioPort {
	public List<Vehiculo> obtenerVehiculos();
}
