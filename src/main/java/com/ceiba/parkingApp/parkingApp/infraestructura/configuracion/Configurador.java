package com.ceiba.parkingApp.parkingApp.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.parkingApp.parkingApp.aplicacion.comando.RegistrarVehiculoComandoManejador;
import com.ceiba.parkingApp.parkingApp.aplicacion.comando.RetirarVehiculoComandoManejador;
import com.ceiba.parkingApp.parkingApp.aplicacion.consulta.ConsultarListaVehiculoConsultaManejador;
import com.ceiba.parkingApp.parkingApp.dominio.puerto.IVehiculoRepositorioPort;
import com.ceiba.parkingApp.parkingApp.dominio.servicio.ServicioConsultaVehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.servicio.ServicioRegistroVehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.servicio.ServicioRetiroVehiculo;

@Configuration
public class Configurador {
	
	@Bean
	public RegistrarVehiculoComandoManejador registrarVehiculoComandoManejador(ServicioRegistroVehiculo servicioRegistroVehiculo) {
		return new RegistrarVehiculoComandoManejador(servicioRegistroVehiculo);
	}
	
	@Bean
	public RetirarVehiculoComandoManejador retirarVehiculoComandoManejador(ServicioRetiroVehiculo servicioRetiroVehiculo) {
		return new RetirarVehiculoComandoManejador(servicioRetiroVehiculo); 
	}
	
	@Bean
	public ConsultarListaVehiculoConsultaManejador consultarListaVehiculoConsultaManejador(ServicioConsultaVehiculo servicioConsultaVehiculo) {
		return new ConsultarListaVehiculoConsultaManejador(servicioConsultaVehiculo);
	}
	
	@Bean
	public ServicioRegistroVehiculo servicioRegistroVehiculo(IVehiculoRepositorioPort vehiculoRepositorioPort) {
		return new ServicioRegistroVehiculo(vehiculoRepositorioPort);
	}
	
	@Bean
	public ServicioRetiroVehiculo servicioRetiroVehiculo(IVehiculoRepositorioPort vehiculoRepositorioPort) {
		return new ServicioRetiroVehiculo(vehiculoRepositorioPort);
	}
	
	@Bean
	public ServicioConsultaVehiculo servicioConsultaVehiculo(IVehiculoRepositorioPort vehiculoRepositorioPort) {
		return new ServicioConsultaVehiculo(vehiculoRepositorioPort);
	}

}
