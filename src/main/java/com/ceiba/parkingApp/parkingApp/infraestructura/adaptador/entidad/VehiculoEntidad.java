package com.ceiba.parkingApp.parkingApp.infraestructura.adaptador.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class VehiculoEntidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	//@OneToOne(optional = false, fetch = FetchType.EAGER)
	@ManyToOne(optional = false)
	@JoinColumn(name = "tipovehiculo")
	private TipoVehiculoEntidad tipoVehiculoEntidad;

	@Column(nullable = false)
	private String placa;

	@Column(nullable = false)
	private double cilindraje;

	@Column(nullable = false)
	private Date fechaEntrada;

	@Column(nullable = true)
	private Date fechaSalida;

	@Column(nullable = true)
	private Double totalCobro;

	public VehiculoEntidad() {
	}

	public VehiculoEntidad(Integer id, TipoVehiculoEntidad tipoVehiculoEntidad, String placa, double cilindraje,
			Date fechaEntrada, Date fechaSalida, Double totalCobro) {
		super();
		this.id = id;
		this.tipoVehiculoEntidad = tipoVehiculoEntidad;
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

	public TipoVehiculoEntidad getTipoVehiculoEntidad() {
		return tipoVehiculoEntidad;
	}

	public void setTipoVehiculoEntidad(TipoVehiculoEntidad tipoVehiculoEntidad) {
		this.tipoVehiculoEntidad = tipoVehiculoEntidad;
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
