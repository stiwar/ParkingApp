package com.ceiba.parkingApp.parkingApp.aplicacion.comando;

import java.io.Serializable;
import java.util.Date;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.TipoVehiculo;

public class VehiculoComando implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private TipoVehiculo tipoVehiculo;
	private String placa;
	private double cilindraje;
	private Date fechaIngreso;
	private Date fechaSalida;
	private int estado;

	public VehiculoComando() {

	}

	public VehiculoComando(int id, TipoVehiculo tipoVehiculo, String placa, double cilindraje, Date fechaIngreso,
			int estado) {
		this.id = id;
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.fechaIngreso = fechaIngreso;
		this.estado = estado;
	}
	
	public VehiculoComando(int id, TipoVehiculo tipoVehiculo, String placa, double cilindraje, Date fechaIngreso, Date fechaSalida,
			int estado) {
		this.id = id;
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
