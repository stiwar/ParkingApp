package com.ceiba.parkingApp.parkingApp.infraestructura.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "cobro")
public class CobroEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "tipovehiculo")
	private TipoVehiculoEntidad2 idTipoVehiculo;

	@Column(nullable = false)
	private String placa;

	@Column(nullable = false)
	private Date fechaEntrada;

	@Column
	private Date fechaSalida;

	@Column
	private Double totalCobro;

	public Integer getId() {
		return id;
	}

	public CobroEntidad() {
	}

	public CobroEntidad(Integer id, TipoVehiculoEntidad2 idTipoVehiculo, String placa, Date fechaEntrada,
			Date fechaSalida, Double totalCobro) {
		super();
		this.id = id;
		this.idTipoVehiculo = idTipoVehiculo;
		this.placa = placa;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.totalCobro = totalCobro;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoVehiculoEntidad2 getIdTipoVehiculo() {
		return idTipoVehiculo;
	}

	public void setIdTipoVehiculo(TipoVehiculoEntidad2 idTipoVehiculo) {
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
