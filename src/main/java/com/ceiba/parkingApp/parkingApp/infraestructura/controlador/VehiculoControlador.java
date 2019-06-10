package com.ceiba.parkingApp.parkingApp.infraestructura.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.parkingApp.parkingApp.aplicacion.consulta.ConsultarAllVehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.entidad.Vehiculo;


@RestController
@RequestMapping(value="vehiculo")
@CrossOrigin(origins = "http://localhost:4200")
public class VehiculoControlador {
	
	
	@Autowired
	private ConsultarAllVehiculo consultarAllVehiculos;
	
	@GetMapping
	public List<Vehiculo> listar() {
		return consultarAllVehiculos.execute();
	}
}
