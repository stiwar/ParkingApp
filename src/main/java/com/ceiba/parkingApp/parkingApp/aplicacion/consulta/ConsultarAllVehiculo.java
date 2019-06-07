package com.ceiba.parkingApp.parkingApp.aplicacion.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.parkingApp.parkingApp.dominio.VehiculosParqueados;
import com.ceiba.parkingApp.parkingApp.dominio.entidad.Cobro;


@Service
@Transactional
public class ConsultarAllVehiculo {
	
	@Autowired
    VehiculosParqueados vehiculosParqueados;
	
	public List<Cobro> execute() {
		return vehiculosParqueados.listaVehiculos();
	}
}
