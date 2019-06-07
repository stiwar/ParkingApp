package com.ceiba.parkingApp.parkingApp.infraestructura.mapeo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.Cobro;
import com.ceiba.parkingApp.parkingApp.infraestructura.entidad.CobroEntidad;

@Component
public class CobroMapeo {

	@Autowired
	private TipoVehiculoMapeo tipoVehiculoMapeo;

	public List<Cobro> mapToDomain(Iterable<CobroEntidad> listaEntidad) {
		List<Cobro> listaRegistro = new ArrayList<>();
		listaEntidad.forEach(cobroEntidad -> {
			Cobro cobro = new Cobro(cobroEntidad.getId(),tipoVehiculoMapeo.mapToDomain(cobroEntidad.getIdTipoVehiculo()), cobroEntidad.getPlaca(),cobroEntidad.getFechaEntrada(),
					cobroEntidad.getFechaSalida(), cobroEntidad.getTotalCobro());
			listaRegistro.add(cobro);
		});
		return listaRegistro;
	}
}
