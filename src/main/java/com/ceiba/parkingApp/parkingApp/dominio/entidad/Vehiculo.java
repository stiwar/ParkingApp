package com.ceiba.parkingApp.parkingApp.dominio.entidad;

import java.util.Date;

public class Vehiculo {
	private Integer id;
	private TipoVehiculo tipoVehiculo;
	private String placa;
	private Date fechaEntrada;
	private Date fechaSalida;
	private Double totalCobro;

	public Vehiculo(Integer id, TipoVehiculo tipoVehiculo, String placa, Date fechaEntrada, Date fechaSalida,
			Double totalCobro) {
		super();
		this.id = id;
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.totalCobro = totalCobro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
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
