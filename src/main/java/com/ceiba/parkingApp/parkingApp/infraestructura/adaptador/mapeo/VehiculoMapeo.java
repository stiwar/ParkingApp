package com.ceiba.parkingApp.parkingApp.infraestructura.adaptador.mapeo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.Vehiculo;
import com.ceiba.parkingApp.parkingApp.infraestructura.adaptador.entidad.VehiculoEntidad;

@Component
public class VehiculoMapeo {

	@Autowired
	private TipoVehiculoMapeo tipoVehiculoMapeo;

	public List<Vehiculo> mapearADominio(List<VehiculoEntidad> listaVehiculoEntidad) {
		List<Vehiculo> vehiculos = new ArrayList<>();
		for (VehiculoEntidad vehiculoEntidad : listaVehiculoEntidad) {
			Vehiculo vehiculo = new Vehiculo(vehiculoEntidad.getId(),
					tipoVehiculoMapeo.mapearADominio(vehiculoEntidad.getTipoVehiculoEntidad()),
					vehiculoEntidad.getPlaca(), vehiculoEntidad.getCilindraje(), vehiculoEntidad.getFechaEntrada(),
					vehiculoEntidad.getFechaSalida(), vehiculoEntidad.getTotalCobro(), vehiculoEntidad.getEstado());
			vehiculos.add(vehiculo);

		}
		return vehiculos;

	}

	public VehiculoEntidad mapearAEntidad(Vehiculo vehiculo) {
		VehiculoEntidad vehiculoEntidad = null;
		vehiculoEntidad = new VehiculoEntidad(vehiculo.getId(),
				tipoVehiculoMapeo.mapearAEntidad(vehiculo.getTipoVehiculo()), vehiculo.getPlaca(),
				vehiculo.getCilindraje(), vehiculo.getFechaEntrada(), vehiculo.getFechaSalida(),
				vehiculo.getTotalCobro(), vehiculo.getEstado());
		return vehiculoEntidad;
	}

	public Vehiculo mapearEntidadADominio(VehiculoEntidad vehiculoEntidad) {
		return new Vehiculo(vehiculoEntidad.getId(),
				tipoVehiculoMapeo.mapearADominio(vehiculoEntidad.getTipoVehiculoEntidad()), vehiculoEntidad.getPlaca(),
				vehiculoEntidad.getCilindraje(), vehiculoEntidad.getFechaEntrada(), vehiculoEntidad.getFechaSalida(),
				vehiculoEntidad.getTotalCobro(), vehiculoEntidad.getEstado());
	}

}
