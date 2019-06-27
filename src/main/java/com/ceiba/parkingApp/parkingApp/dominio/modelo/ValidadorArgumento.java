package com.ceiba.parkingApp.parkingApp.dominio.modelo;

import com.ceiba.parkingApp.parkingApp.dominio.excepcion.VehiculoExcepcion;

public class ValidadorArgumento {
		
	public static void validarCamposRequeridos(Object objeto, String mensaje) {
		if(objeto == null)
			throw new VehiculoExcepcion(mensaje);
	}
}
