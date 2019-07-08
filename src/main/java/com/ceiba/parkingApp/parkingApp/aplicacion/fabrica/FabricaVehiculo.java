package com.ceiba.parkingApp.parkingApp.aplicacion.fabrica;

import com.ceiba.parkingApp.parkingApp.aplicacion.comando.VehiculoComando;
import com.ceiba.parkingApp.parkingApp.dominio.excepcion.VehiculoExcepcion;
import com.ceiba.parkingApp.parkingApp.dominio.modelo.TipoVehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.modelo.Vehiculo;

public class FabricaVehiculo {

	private static final int ID_CARRO = 1;
	private static final int ID_MOTO = 2;
	private static final String CADENA_CARRO = "Carro";
	private static final String CADENA_MOTO = "Moto";
	private static final String ID_TIPO_VEHICULO_OBLIGATORIO = "El Id del tipo de vehiculo es obligatorio";
	
	private FabricaVehiculo() {
		
	}

	public static Vehiculo crearVehiculo(VehiculoComando vehiculoComando) {

		Vehiculo vehiculo = null;
		TipoVehiculo tipoVehiculo = null;

		if (vehiculoComando.getTipoVehiculo() == ID_CARRO) {
			
			tipoVehiculo = new TipoVehiculo(vehiculoComando.getTipoVehiculo(), CADENA_CARRO);
			vehiculo = new Vehiculo(tipoVehiculo, vehiculoComando.getPlaca(), vehiculoComando.getCilindraje());
			
		} else if (vehiculoComando.getTipoVehiculo() == ID_MOTO) {
			tipoVehiculo = new TipoVehiculo(vehiculoComando.getTipoVehiculo(), CADENA_MOTO);
			vehiculo = new Vehiculo(tipoVehiculo, vehiculoComando.getPlaca(), vehiculoComando.getCilindraje());
		}else {
			throw new VehiculoExcepcion(ID_TIPO_VEHICULO_OBLIGATORIO);
		}
		
		return vehiculo;
		
	}
	
	public static VehiculoComando crearVehiculoComando(Vehiculo vehiculo) {
		
		return new VehiculoComando(vehiculo.getId(), vehiculo.getTipoVehiculo().getId(), vehiculo.getPlaca(), vehiculo.getCilindraje(), vehiculo.getFechaEntrada(), vehiculo.getFechaSalida());
		
	}

}
