package com.ceiba.parkingApp.parkingApp.aplicacion.comando;

import java.io.Serializable;
import java.util.Date;

public class VehiculoComando implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private int tipoVehiculo;
	private String placa;
	private Double cilindraje;
	private Date fechaIngreso;
	private Date fechaSalida;
	private Double totalCobro;

	public VehiculoComando() {

	}

	public VehiculoComando(Integer id, int tipoVehiculo, String placa, Double cilindraje, Date fechaIngreso,
			Date fechaSalida) {
		this.id = id;
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}
	
	public VehiculoComando(Integer id, int tipoVehiculo, String placa, Double cilindraje, Date fechaIngreso,
			Date fechaSalida,Double totalCobro) {
		this.id = id;
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.totalCobro = totalCobro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(int tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Double getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(Double cilindraje) {
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

	public Double getTotalCobro() {
		return totalCobro;
	}

	public void setTotalCobro(Double totalCobro) {
		this.totalCobro = totalCobro;
	}

}
