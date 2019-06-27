package com.ceiba.parkingApp.parkingApp.infraestructura.adaptador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.parkingApp.parkingApp.dominio.modelo.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.puerto.VehiculoRepositorioPort;
import com.ceiba.parkingApp.parkingApp.infraestructura.adaptador.entidad.VehiculoEntidad;
import com.ceiba.parkingApp.parkingApp.infraestructura.adaptador.mapeo.VehiculoMapeo;
import com.ceiba.parkingApp.parkingApp.infraestructura.adaptador.repositorio.VehiculoRepositorio;

@Component
public class VehiculoAdaptador implements VehiculoRepositorioPort {

	@Autowired
	private VehiculoRepositorio vehiculoRepositorio;

	@Autowired
	private VehiculoMapeo vehiculoMapeo;

	@Override
	public List<Vehiculo> obtenerVehiculos() {
		return vehiculoMapeo.mapearADominio((List<VehiculoEntidad>) vehiculoRepositorio.findAll());
	}

	@Override
	public Vehiculo registrarVehiculo(Vehiculo vehiculo) {
		VehiculoEntidad vehiculoEntidad = vehiculoRepositorio.save(vehiculoMapeo.mapearAEntidad(vehiculo));
		return vehiculoMapeo.mapearEntidadADominio(vehiculoEntidad);
	}

	@Override
	public int obtenerTotalVehiculoPorIdTipoVehiculo(int idTipoVehiculo) {
		return vehiculoRepositorio.countVehiculoByIdTipoVehiculo(new Integer(idTipoVehiculo));
	}

	@Override
	public Vehiculo retirarVehiculo(Vehiculo vehiculo) {
		VehiculoEntidad vehiculoEntidad = vehiculoRepositorio.save(vehiculoMapeo.mapearAEntidad(vehiculo));
		
		return vehiculoMapeo.mapearEntidadADominio(vehiculoEntidad);
	}

	@Override
	public Vehiculo obtenerVehiculoPorId(int idVehiculo) {
		return vehiculoMapeo.mapearEntidadADominio(vehiculoRepositorio.findById(idVehiculo));
	}

}
