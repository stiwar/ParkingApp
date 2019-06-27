package com.ceiba.parkingApp.parkingApp.aplicacion.consulta;

import java.util.ArrayList;
import java.util.List;

import com.ceiba.parkingApp.parkingApp.aplicacion.comando.VehiculoComando;
import com.ceiba.parkingApp.parkingApp.aplicacion.fabrica.FabricaVehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.modelo.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.servicio.ServicioConsultaVehiculo;

public class ConsultarListaVehiculoConsultaManejador {
	
	ServicioConsultaVehiculo servicioConsultaVehiculo;
	
	public ConsultarListaVehiculoConsultaManejador(ServicioConsultaVehiculo servicioConsultaVehiculo) {
		this.servicioConsultaVehiculo = servicioConsultaVehiculo;
	}
	
	public List<VehiculoComando> obtenerVehiculos(){
		List<VehiculoComando> vehiculosComando = new ArrayList<>();
		List<Vehiculo> listaVehiculos = servicioConsultaVehiculo.obtenerListaVehiculos();
		for(Vehiculo vehiculo : listaVehiculos) {
			vehiculosComando.add(FabricaVehiculo.crearVehiculoComando(vehiculo));
			//vehiculosComando.add(new VehiculoComando(vehiculo.getId(), vehiculo.getTipoVehiculo(), vehiculo.getPlaca(), vehiculo.getCilindraje(), vehiculo.getFechaEntrada(), vehiculo.getFechaSalida(), vehiculo.getEstado(), vehiculo.getTotalCobro()));
		}
		
		return vehiculosComando;
	}
	
	public VehiculoComando obtenerVehiculo(int idVehiculo){
		Vehiculo vehiculo = servicioConsultaVehiculo.consultarVehiculo(idVehiculo);
		return  FabricaVehiculo.crearVehiculoComando(vehiculo);
		//return new VehiculoComando(vehiculo.getId(), vehiculo.getTipoVehiculo(), vehiculo.getPlaca(), vehiculo.getCilindraje(), vehiculo.getFechaEntrada(), vehiculo.getFechaSalida(), vehiculo.getEstado(), vehiculo.getTotalCobro());
	}
}