package com.ceiba.parkingApp.parkingApp.aplicacion.comando;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.TipoVehiculo;

public class VehiculoComando {
	
	private TipoVehiculo tipoVehiculo;
	private String placa;
	private double cilindraje;

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public double getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(double cilindraje) {
		this.cilindraje = cilindraje;
	}

}
