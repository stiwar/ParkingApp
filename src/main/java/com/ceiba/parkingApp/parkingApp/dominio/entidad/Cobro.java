package com.ceiba.parkingApp.parkingApp.dominio.entidad;

import java.util.Date;

public class Cobro {
	private Integer id;
	private TipoVehiculo idTipoVehiculo;
	private String placa;
	private Date fechaEntrada;
	private Date fechaSalida;
	private Double totalCobro;

	public Cobro(Integer id, TipoVehiculo idTipoVehiculo, String placa, Date fechaEntrada, Date fechaSalida,
			Double totalCobro) {
		this.id = id;
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

	public TipoVehiculo getIdTipoVehiculo() {
		return idTipoVehiculo;
	}

	public void setIdTipoVehiculo(TipoVehiculo idTipoVehiculo) {
		this.idTipoVehiculo = idTipoVehiculo;
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
