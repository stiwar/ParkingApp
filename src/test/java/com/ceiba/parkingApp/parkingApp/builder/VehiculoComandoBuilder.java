package com.ceiba.parkingApp.parkingApp.builder;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ceiba.parkingApp.parkingApp.aplicacion.comando.VehiculoComando;
import com.ceiba.parkingApp.parkingApp.dominio.entidad.TipoVehiculo;

public class VehiculoComandoBuilder {
	
	private static final int ID_VEHICULO = 1;
	private static final int ID_TIPO_VEHICULO_CARRO = 1;
	private static final String NOMBRE_TIPO_VEHICULO_CARRO = "Carro";
	private static final String PLACA_VEHICULO = "XYZ12C";
	private static final Double CILINDRAJE_VEHICULO = 200.0;
	private static final Date FECHA_INGRESO_VEHICULO = new GregorianCalendar(2019, Calendar.JUNE, 13, 8, 21, 33).getTime();
	private static final Date FECHA_RETIRO_VEHICULO = new GregorianCalendar(2019, Calendar.JUNE, 13, 10, 13, 15).getTime();
	private static final double COBRO_SALIDA_VEHICULO = 0;
	private static final int ESTADO_INACTIVO_VEHICULO = 0;
	
	private int id;
	private TipoVehiculo tipoVehiculo;
	private String placa;
	private Double cilindraje;
	private Date fechaIngreso;
	private Date fechaSalida;
	private Double totalCobro;
	private int estado;
	
	public VehiculoComandoBuilder() {
		
	}
	
	/*public VehiculoComandoBuilder() {
		this.id = ID_VEHICULO;
		this.tipoVehiculo = new TipoVehiculo(ID_TIPO_VEHICULO_CARRO,NOMBRE_TIPO_VEHICULO_CARRO);
		this.placa = PLACA_VEHICULO;
		this.cilindraje = CILINDRAJE_VEHICULO;
		this.fechaIngreso = FECHA_INGRESO_VEHICULO;
		this.fechaSalida = FECHA_RETIRO_VEHICULO;
		this.totalCobro = COBRO_SALIDA_VEHICULO;
		this.estado = ESTADO_INACTIVO_VEHICULO;
	}*/
	
	public VehiculoComandoBuilder conId(int id) {
		this.id = id;
		return this;
	}
	
	public VehiculoComandoBuilder conTipoVehiculo(int idTipoVehiculo,String nombreTipoVehiculo) {
		this.tipoVehiculo = new TipoVehiculo(idTipoVehiculo, nombreTipoVehiculo);
		return this;
	}
	
	public VehiculoComandoBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public VehiculoComandoBuilder conCilindraje(Double cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public VehiculoComandoBuilder conFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}
	
	public VehiculoComandoBuilder conFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
		return this;
	}
	
	public VehiculoComandoBuilder conTotalCobro(Double totalCobro) {
		this.totalCobro = totalCobro;
		return this;
	}
	
	public VehiculoComandoBuilder conEstado(int estado) {
		this.estado = estado;
		return this;
	}

	public VehiculoComando build() {
		return new VehiculoComando(this.id, this.tipoVehiculo, this.placa, this.cilindraje, this.fechaIngreso, this.fechaSalida, this.estado, this.totalCobro);
	}
}
