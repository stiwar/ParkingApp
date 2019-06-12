package com.ceiba.parkingApp.parkingApp.dominio.entidad;

import java.util.Date;

public class Vehiculo {
	
	private final String TIPO_VEHICULO_OBLIGATORIO = "El tipo de vehiculo es obligatorio";
	private final String PLACA_OBLIGATORIO = "La placa del vehiculo es obligatoria";
	private final String CILINDRAJE_OBLIGATORIO = "El cilindraje del Vehiculo es obligatorio";
	
	private Integer id;
	private TipoVehiculo tipoVehiculo;
	private String placa;
	private double cilindraje;
	private Date fechaEntrada;
	private Date fechaSalida;
	private Double totalCobro;
	
	public Vehiculo() {
		
	}
	
	public Vehiculo(TipoVehiculo tipoVehiculo, String placa, double cilindraje) {
		ValidadorArgumento.validarCamposRequeridos(tipoVehiculo, TIPO_VEHICULO_OBLIGATORIO);
		ValidadorArgumento.validarCamposRequeridos(placa, PLACA_OBLIGATORIO);
		ValidadorArgumento.validarCamposRequeridos(cilindraje, CILINDRAJE_OBLIGATORIO);
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindraje = cilindraje;
	}

	public Vehiculo(Integer id, TipoVehiculo tipoVehiculo, String placa, double cilindraje, Date fechaEntrada,
			Date fechaSalida, Double totalCobro) {
		this.id = id;
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindraje = cilindraje;
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

	public double getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(double cilindraje) {
		this.cilindraje = cilindraje;
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
