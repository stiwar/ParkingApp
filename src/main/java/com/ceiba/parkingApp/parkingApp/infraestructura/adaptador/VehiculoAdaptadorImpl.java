package com.ceiba.parkingApp.parkingApp.infraestructura.adaptador;

import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.puerto.IVehiculoRepositorioPort;
import com.ceiba.parkingApp.parkingApp.infraestructura.adaptador.mapeo.VehiculoMapeo;
import com.ceiba.parkingApp.parkingApp.infraestructura.adaptador.repositorio.IVehiculoRepositorio;

@Component
public class VehiculoAdaptadorImpl implements IVehiculoRepositorioPort {// , ITipoVehiculoRepositorioPort{//interface del dominio

	@Autowired
	private IVehiculoRepositorio vehiculoRepositorio;
	// @Autowired
	// private ITipoVehiculoRepositorio tipoVehiculoRepositorio;

	@Autowired
	private VehiculoMapeo vehiculoMapeo;

	@Override // metodo definido en la interface del dominio
	public List<Vehiculo> obtenerVehiculos() {// es necesario castear de gobierno de entidad a gobierno de dominio
		return vehiculoMapeo.mapearADominio(Lists.newArrayList(vehiculoRepositorio.findAll()));
	}

	@Override
	public boolean registrarVehiculo(Vehiculo vehiculo) {
		vehiculoRepositorio.save(vehiculoMapeo.mapearAEntidad(vehiculo));
		return true;
	}

	@Override
	public int obtenerTotalPorIdTipoVehiculo(int idTipoVehiculo) {
		Integer integerTipoVehiculo = new Integer(idTipoVehiculo);
		//Integer integerTipoVehiculo = new Integer(1);
		return vehiculoRepositorio.countVehiculoByIdTipoVehiculo(integerTipoVehiculo);
	}

	@Override
	public boolean retirarVehiculo(Vehiculo vehiculo) {
		vehiculoRepositorio.delete(vehiculoMapeo.mapearAEntidad(vehiculo));
		return true;
	}

	@Override
	public Vehiculo obtenerVehiculoPorId(int idVehiculo) {
		// TODO Auto-generated method stub
		return vehiculoMapeo.mapearEntidadADominio(vehiculoRepositorio.findById(idVehiculo));
	}

}
