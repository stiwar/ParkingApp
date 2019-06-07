package com.ceiba.parkingApp.parkingApp.infraestructura.mapeo;

import org.springframework.stereotype.Component;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.TipoVehiculo;
import com.ceiba.parkingApp.parkingApp.infraestructura.entidad.TipoVehiculoEntidad;

@Component
public class TipoVehiculoMapeo {

	public TipoVehiculo mapToDomain(TipoVehiculoEntidad tipoEntidad) {
		return new TipoVehiculo(tipoEntidad.getId(), tipoEntidad.getNombre());
	}

}
