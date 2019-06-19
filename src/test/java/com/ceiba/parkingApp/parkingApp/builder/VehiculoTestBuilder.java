package com.ceiba.parkingApp.parkingApp.builder;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.TipoVehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.entidad.Vehiculo;

public class VehiculoTestBuilder {
	
	private static final int ID_TIPO_VEHICULO_AUTO = 1;
	private static final int ID_TIPO_VEHICULO_MOTO = 2;
	private static final int ID_VEHICULO = 1;
	private static final Double CILINDRAJE_VEHICULO = 200.0;
	private static final String NOMBRE_TIPO_VEHICULO_CARRO = "Carro";
	private static final String NOMBRE_TIPO_VEHICULO_MOTO = "Moto";
	private static final String PLACA_VEHICULO = "XYZ12C";
	private static final Date FECHA_INGRESO_VEHICULO = new GregorianCalendar(2019, Calendar.JUNE, 13, 8, 21, 33).getTime();
	private static final Date FECHA_RETIRO_VEHICULO = new GregorianCalendar(2019, Calendar.JUNE, 13, 10, 13, 15).getTime();
	private static final double COBRO_SALIDA_VEHICULO = 0;
	private static final int ESTADO_INACTIVO_VEHICULO = 0;
	
	private int id;
	private TipoVehiculo tipoVehiculo;
	private String placa;
	private Double cilindraje;
	private Date fechaEntrada;
	private Date fechaSalida;
	private Double totalCobro;
	private int estado;
	
	
	public VehiculoTestBuilder() {
		this.tipoVehiculo = new TipoVehiculo(ID_TIPO_VEHICULO_AUTO,NOMBRE_TIPO_VEHICULO_CARRO);
		this.id = ID_VEHICULO;
		this.placa = PLACA_VEHICULO;
		this.cilindraje = CILINDRAJE_VEHICULO;
		this.fechaEntrada = FECHA_INGRESO_VEHICULO;
		this.fechaSalida = FECHA_RETIRO_VEHICULO;
		this.totalCobro = COBRO_SALIDA_VEHICULO;
		this.estado = ESTADO_INACTIVO_VEHICULO;
	}
	
	public VehiculoTestBuilder conId(int id) {
		this.id = id;
		return this;
	}
	
	public VehiculoTestBuilder conTipoVehiculo(int idTipoVehiculo,String nombreTipoVehiculo) {
		//this.tipoVehiculo.setId(idTipoVehiculo);
		//this.tipoVehiculo.setNombre(nombreTipoVehiculo);
		this.tipoVehiculo = new TipoVehiculo(idTipoVehiculo, nombreTipoVehiculo);
		return this;
	}
	
	public VehiculoTestBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public VehiculoTestBuilder conCilindraje(Double cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public VehiculoTestBuilder conFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
		return this;
	}
	
	public VehiculoTestBuilder conFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
		return this;
	}
	
	public Vehiculo build() {
		return new Vehiculo(this.id, this.tipoVehiculo, this.placa, this.cilindraje, this.fechaEntrada, this.fechaSalida, this.totalCobro, this.estado);
	}
	
}
