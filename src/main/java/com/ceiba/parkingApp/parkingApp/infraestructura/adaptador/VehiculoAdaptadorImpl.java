package com.ceiba.parkingApp.parkingApp.infraestructura.adaptador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.puerto.IVehiculoRepositorioPort;
import com.ceiba.parkingApp.parkingApp.infraestructura.adaptador.mapeo.VehiculoMapeo;
import com.ceiba.parkingApp.parkingApp.infraestructura.adaptador.repositorio.IVehiculoRepositorio;

public class VehiculoAdaptadorImpl implements IVehiculoRepositorioPort{//interface del dominio
	@Autowired
	private IVehiculoRepositorio vehiculoRepositorio;
	
	@Autowired
	private VehiculoMapeo vehiculoMapeo;
	
	@Override //metodo definido en la interface del dominio
	public List<Vehiculo> obtenerVehiculos(){
		return vehiculoMapeo.mapearADominio(vehiculoRepositorio.findAll());
	}
	
}
