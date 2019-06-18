package com.ceiba.parkingApp.parkingApp.infraestructura.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.parkingApp.parkingApp.aplicacion.comando.RegistrarVehiculoComandoManejador;
import com.ceiba.parkingApp.parkingApp.aplicacion.comando.RetirarVehiculoComandoManejador;
import com.ceiba.parkingApp.parkingApp.aplicacion.comando.VehiculoComando;
import com.ceiba.parkingApp.parkingApp.aplicacion.consulta.ConsultarListaVehiculoConsultaManejador;

@RestController
@RequestMapping(value = "/servicio")
@CrossOrigin(origins = "http://localhost:4200")
public class VehiculoControlador {

	private RegistrarVehiculoComandoManejador registrarVehiculoComandoManejador;
	private RetirarVehiculoComandoManejador retirarVehiculoComandoManejador;	
	private ConsultarListaVehiculoConsultaManejador consultarListaVehiculoConsultaManejador;
	
	@Autowired
	public VehiculoControlador(RegistrarVehiculoComandoManejador registrarVehiculoComandoManejador, RetirarVehiculoComandoManejador retirarVehiculoComandoManejador, ConsultarListaVehiculoConsultaManejador consultarListaVehiculoConsultaManejador) {
		this.registrarVehiculoComandoManejador = registrarVehiculoComandoManejador;
		this.retirarVehiculoComandoManejador = retirarVehiculoComandoManejador;
		this.consultarListaVehiculoConsultaManejador = consultarListaVehiculoConsultaManejador;
	}
	
	
	@GetMapping("/vehiculos")
	public List<VehiculoComando> solicitarVehiculos(){
		return consultarListaVehiculoConsultaManejador.obtenerVehiculos();
	}
	
	@GetMapping("/vehiculo/{id}")
	public VehiculoComando solicitarVehiculo(@PathVariable("id") int id){
		return consultarListaVehiculoConsultaManejador.obtenerVehiculo(id);
	}

	@PostMapping("/vehiculo")
	public VehiculoComando registrarVehiculo(@RequestBody VehiculoComando vehiculoComando) {
		return registrarVehiculoComandoManejador.guardarVehiculo(vehiculoComando);
	}
	
	@PutMapping("/vehiculo/{id}")
	public VehiculoComando retirarVehiculo(@PathVariable("id") int id) {
		return retirarVehiculoComandoManejador.gestionarRetiroVehiculo(id);
	}
}
