package com.ceiba.parkingApp.parkingApp.infraestructura.adaptador;

import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.puerto.IVehiculoRepositorioPort;
import com.ceiba.parkingApp.parkingApp.infraestructura.adaptador.entidad.VehiculoEntidad;
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

	@Override
	public List<Vehiculo> obtenerVehiculos() {// es necesario castear de gobierno de entidad a gobierno de dominio
		return vehiculoMapeo.mapearADominio(Lists.newArrayList(vehiculoRepositorio.findAll()));
	}

	@Override
	public Vehiculo registrarVehiculo(Vehiculo vehiculo) {
		VehiculoEntidad vehiculoEntidad = vehiculoRepositorio.save(vehiculoMapeo.mapearAEntidad(vehiculo));
		//AQUI RETORNAR OBJETO DE ENTIDAD con datos adicionales, PARA LUEGO EN EL DTO OMITIR EL ID
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
