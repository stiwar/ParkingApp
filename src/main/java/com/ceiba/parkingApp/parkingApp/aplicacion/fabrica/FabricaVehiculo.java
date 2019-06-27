package com.ceiba.parkingApp.parkingApp.aplicacion.fabrica;

import com.ceiba.parkingApp.parkingApp.aplicacion.comando.VehiculoComando;
import com.ceiba.parkingApp.parkingApp.dominio.modelo.TipoVehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.modelo.Vehiculo;

public class FabricaVehiculo {

	private static final int ID_CARRO = 1;
	private static final int ID_MOTO = 2;
	private static final String CADENA_CARRO = "Carro";
	private static final String CADENA_MOTO = "Moto";
	
	private FabricaVehiculo() {
		
	}

	public static Vehiculo crearVehiculo(VehiculoComando vehiculoComando) {

		Vehiculo vehiculo = null;
		TipoVehiculo tipoVehiculo = new TipoVehiculo();
		tipoVehiculo.setId(vehiculoComando.getTipoVehiculo());

		if (vehiculoComando.getTipoVehiculo() == ID_CARRO) {
			
			tipoVehiculo.setNombre(CADENA_CARRO);
			vehiculo = new Vehiculo(tipoVehiculo, vehiculoComando.getPlaca(), vehiculoComando.getCilindraje());
			
		} else if (vehiculoComando.getTipoVehiculo() == ID_MOTO) {
			tipoVehiculo.setNombre(CADENA_MOTO);
			vehiculo = new Vehiculo(tipoVehiculo, vehiculoComando.getPlaca(), vehiculoComando.getCilindraje());
		}
		
		return vehiculo;
		
	}
	
	public static VehiculoComando crearVehiculoComando(Vehiculo vehiculo) {
		
		return new VehiculoComando(vehiculo.getId(), vehiculo.getTipoVehiculo().getId(), vehiculo.getPlaca(), vehiculo.getCilindraje(), vehiculo.getFechaEntrada(), vehiculo.getFechaSalida());
		
	}

}
