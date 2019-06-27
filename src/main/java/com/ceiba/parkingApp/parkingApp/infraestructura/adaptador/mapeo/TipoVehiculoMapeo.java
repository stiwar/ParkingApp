package com.ceiba.parkingApp.parkingApp.infraestructura.adaptador.mapeo;

import org.springframework.stereotype.Component;

import com.ceiba.parkingApp.parkingApp.dominio.modelo.TipoVehiculo;
import com.ceiba.parkingApp.parkingApp.infraestructura.adaptador.entidad.TipoVehiculoEntidad;


@Component
public class TipoVehiculoMapeo {

	public TipoVehiculo mapearADominio(TipoVehiculoEntidad tipoVehiculoEntidad) {
		TipoVehiculo tipoVehiculo = null;
		
		if( tipoVehiculoEntidad != null ) {
			tipoVehiculo = new TipoVehiculo(tipoVehiculoEntidad.getId(), tipoVehiculoEntidad.getNombre());
		}
		return tipoVehiculo;
		
	}
	
	public TipoVehiculoEntidad mapearAEntidad(TipoVehiculo tipoVehiculo) {
		TipoVehiculoEntidad tipoVehiculoEntidad = null;
		
		if( tipoVehiculo != null ) {
			tipoVehiculoEntidad = new TipoVehiculoEntidad(tipoVehiculo.getId(), tipoVehiculo.getNombre());
		}

		return tipoVehiculoEntidad;
		
	}
}
