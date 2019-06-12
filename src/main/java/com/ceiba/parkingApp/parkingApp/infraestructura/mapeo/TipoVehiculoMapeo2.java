package com.ceiba.parkingApp.parkingApp.infraestructura.mapeo;

import org.springframework.stereotype.Component;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.TipoVehiculo;
import com.ceiba.parkingApp.parkingApp.infraestructura.entidad.TipoVehiculoEntidad2;

@Component
public class TipoVehiculoMapeo2 {

	public TipoVehiculo mapToDomain(TipoVehiculoEntidad2 tipoEntidad) {
		return new TipoVehiculo(tipoEntidad.getId(), tipoEntidad.getNombre());
	}

}
