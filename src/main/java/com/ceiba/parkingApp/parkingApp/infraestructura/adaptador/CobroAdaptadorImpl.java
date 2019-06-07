package com.ceiba.parkingApp.parkingApp.infraestructura.adaptador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.Cobro;
import com.ceiba.parkingApp.parkingApp.dominio.puerto.ICobroPuerto;
import com.ceiba.parkingApp.parkingApp.infraestructura.mapeo.CobroMapeo;


@Repository
public class CobroAdaptadorImpl  implements ICobroPuerto {
	
	@Autowired
	@Lazy
	private CobroAdaptador cobroAdaptador;
	
	@Autowired
	private CobroMapeo cobroMapeo;
	
	@Override
	public List<Cobro> listaVehiculos() {
		return cobroMapeo.mapToDomain(cobroAdaptador.findAll());
	}	
}
