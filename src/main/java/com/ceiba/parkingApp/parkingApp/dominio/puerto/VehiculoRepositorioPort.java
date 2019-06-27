package com.ceiba.parkingApp.parkingApp.dominio.puerto;

import java.util.List;

import com.ceiba.parkingApp.parkingApp.dominio.modelo.Vehiculo;

public interface VehiculoRepositorioPort {

	public List<Vehiculo> obtenerVehiculos();

	public Vehiculo registrarVehiculo(Vehiculo vehiculo);

	public int obtenerTotalVehiculoPorIdTipoVehiculo(int idTipoVehiculo);

	public Vehiculo obtenerVehiculoPorId(int idVehiculo);

	public Vehiculo retirarVehiculo(Vehiculo vehiculo);

}
