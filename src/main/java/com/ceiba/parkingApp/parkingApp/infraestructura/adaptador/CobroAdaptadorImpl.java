package com.ceiba.parkingApp.parkingApp.infraestructura.adaptador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.puerto.ICobroPuerto;
import com.ceiba.parkingApp.parkingApp.infraestructura.mapeo.VehiculoMapeo;


@Repository
public class CobroAdaptadorImpl  implements ICobroPuerto {
	
	@Autowired
	@Lazy
	private CobroAdaptador cobroAdaptador;
	
	@Autowired
	private VehiculoMapeo cobroMapeo;
	
	@Override
	public List<Vehiculo> listaVehiculos() {
		return cobroMapeo.mapToDomain(cobroAdaptador.findAll());
	}	
}
