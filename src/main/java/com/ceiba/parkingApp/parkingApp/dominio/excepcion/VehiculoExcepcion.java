package com.ceiba.parkingApp.parkingApp.dominio.excepcion;

public class VehiculoExcepcion extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public VehiculoExcepcion(String mensaje) {
		super(mensaje);
	}

	

}
