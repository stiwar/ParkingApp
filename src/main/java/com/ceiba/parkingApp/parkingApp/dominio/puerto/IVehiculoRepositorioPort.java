package com.ceiba.parkingApp.parkingApp.dominio.puerto;

import java.util.List;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.Vehiculo;

public interface IVehiculoRepositorioPort {

	public List<Vehiculo> obtenerVehiculos();

	public boolean registrarVehiculo(Vehiculo vehiculo);

	public int obtenerTotalPorIdTipoVehiculo(int idTipoVehiculo);

	public Vehiculo obtenerVehiculoPorId(int idVehiculo);

	public boolean retirarVehiculo(Vehiculo vehiculo);

}
