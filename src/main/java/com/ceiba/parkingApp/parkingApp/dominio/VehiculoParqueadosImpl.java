package com.ceiba.parkingApp.parkingApp.dominio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.puerto.ICobroPuerto;

@Service
public class VehiculoParqueadosImpl implements VehiculosParqueados {

	@Autowired
	@Lazy
	private ICobroPuerto cobropuerto;

	@Override
	public List<Vehiculo> listaVehiculos() {
		return cobropuerto.listaVehiculos();
	}

}
