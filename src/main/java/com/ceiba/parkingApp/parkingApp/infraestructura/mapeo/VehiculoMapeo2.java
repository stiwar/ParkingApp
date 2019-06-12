package com.ceiba.parkingApp.parkingApp.infraestructura.mapeo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.Vehiculo;
import com.ceiba.parkingApp.parkingApp.infraestructura.entidad.CobroEntidad;

@Component
public class VehiculoMapeo2 {

	@Autowired
	private TipoVehiculoMapeo2 tipoVehiculoMapeo;

	/*public List<Vehiculo> mapToDomain(Iterable<CobroEntidad> listaEntidad) {
		List<Vehiculo> listaRegistro = new ArrayList<>();
		listaEntidad.forEach(cobroEntidad -> {
			Vehiculo cobro = new Vehiculo(cobroEntidad.getId(),tipoVehiculoMapeo.mapToDomain(cobroEntidad.getIdTipoVehiculo()), cobroEntidad.getPlaca(),cobroEntidad.getFechaEntrada(),
					cobroEntidad.getFechaSalida(), cobroEntidad.getTotalCobro());
			listaRegistro.add(cobro);
		});
		return listaRegistro;
	}*/
}
