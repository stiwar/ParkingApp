package com.ceiba.parkingApp.parkingApp.dominio.entidad;

public class TipoVehiculo {
	
	private Integer id;
	private String nombre;
	
	public TipoVehiculo() {
	}
	
	public TipoVehiculo(Integer id) {
		this.id = id;
	}

	public TipoVehiculo(String nombre) {
		super();
		this.nombre = nombre;
	}

	public TipoVehiculo(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
