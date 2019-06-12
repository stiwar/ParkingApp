package com.ceiba.parkingApp.parkingApp.infraestructura.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.parkingApp.parkingApp.aplicacion.comando.RegistrarVehiculoComandoManejador;
import com.ceiba.parkingApp.parkingApp.aplicacion.comando.RetirarVehiculoComandoManejador;
import com.ceiba.parkingApp.parkingApp.aplicacion.comando.VehiculoComando;

@RestController
@RequestMapping(value = "/servicio")
@CrossOrigin(origins = "http://localhost:4200")
public class VehiculoControlador {
/*
	@Autowired
	private ConsultarListaVehiculoConsultaManejador consultarListaVehiculoConsultaManejador;
*/
	@Autowired
	private RegistrarVehiculoComandoManejador registrarVehiculoComandoManejador;
	@Autowired
	private RetirarVehiculoComandoManejador retirarVehiculoComandoManejador;
/*
	@GetMapping("/vehiculos")
	public List<Vehiculo> listar() {
		return consultarListaVehiculoConsultaManejador.consultarVehiculos();
	}
*/
	@PostMapping("/vehiculo")
	public boolean registrarVehiculo(@RequestBody VehiculoComando vehiculoComando) {
		return registrarVehiculoComandoManejador.guardarVehiculo(vehiculoComando);
	}
	
	@DeleteMapping("/vehiculo/{id}")
	public double retirarVehiculo(@PathVariable("id") int id) {
		return retirarVehiculoComandoManejador.eliminarVehiculo(id);
	}
}
