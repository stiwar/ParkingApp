package com.ceiba.parkingApp.parkingApp.dominio.modelo;

import java.util.Date;

public class Vehiculo {

	private final String TIPO_VEHICULO_OBLIGATORIO = "El tipo de vehiculo es obligatorio";
	private final String PLACA_OBLIGATORIO = "La placa del vehiculo es obligatoria";
	private static double MILISEGUNDOS_A_SEGUNDOS = 1000;
	private static double SEGUNDOS_A_MINUTOS = 60;
	private static double MINUTOS_A_HORAS = 60;
	private static final int LIMITE_TIEMPO_PARA_VALOR_HORA = 9;
	private static final double LIMITE_CILINDRAJE_MOTO = 500;
	private static final double EXCEDENTE_CILINDRAJE_MOTO = 2000;
	private static final double VALOR_HORA_CARRO = 1000;
	private static final double VALOR_HORA_MOTO = 500;
	private static final int VALOR_DIA_CARRO = 8000;
	private static final int VALOR_DIA_MOTO = 4000;
	private static final int TOTAL_HORAS_DIA = 24;
	private static final String CARRO = "Carro";
	private static final String MOTO = "Moto";

	private Integer id;
	private TipoVehiculo tipoVehiculo;
	private String placa;
	private Double cilindraje;
	private Date fechaEntrada;
	private Date fechaSalida;
	private Double totalCobro;

	public Vehiculo() {

	}

	public Vehiculo(TipoVehiculo tipoVehiculo, String placa, Double cilindraje) {
		ValidadorArgumento.validarCamposRequeridos(tipoVehiculo, TIPO_VEHICULO_OBLIGATORIO);
		ValidadorArgumento.validarCamposRequeridos(placa, PLACA_OBLIGATORIO);
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindraje = cilindraje;
	}

	public Vehiculo(Integer id, TipoVehiculo tipoVehiculo, String placa, Double cilindraje, Date fechaEntrada,
			Date fechaSalida, Double totalCobro) {
		this.id = id;
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.totalCobro = totalCobro;
	}

	public void establecerCobro() {
		int totalHoras = this.calcularHorasEntreFechas();
		if (totalHoras >= LIMITE_TIEMPO_PARA_VALOR_HORA)
			calcularCobroDias(totalHoras);
		else
			calcularCobroPorHora(totalHoras);
	}

	private void calcularCobroPorHora(int totalHoras) {

		if (this.tipoVehiculo.getNombre().equalsIgnoreCase(CARRO)) {
			this.totalCobro = totalHoras * VALOR_HORA_CARRO;
		}

		if (this.tipoVehiculo.getNombre().equalsIgnoreCase(MOTO)) {

			if (this.cilindraje > LIMITE_CILINDRAJE_MOTO)
				this.totalCobro = (totalHoras * VALOR_HORA_MOTO) + EXCEDENTE_CILINDRAJE_MOTO;
			else
				this.totalCobro = totalHoras * VALOR_HORA_MOTO;
		}

	}

	private void calcularCobroDias(int totalHoras) {
		
		if(totalHoras < TOTAL_HORAS_DIA)
			
			this.totalCobro = (double) (this.tipoVehiculo.getNombre().equalsIgnoreCase(CARRO) ? VALOR_DIA_CARRO : VALOR_DIA_MOTO);
		
		else {

			int dias = totalHoras/TOTAL_HORAS_DIA;
			int residuoHoras = totalHoras % TOTAL_HORAS_DIA;

			if(this.tipoVehiculo.getNombre().equalsIgnoreCase(CARRO)) {
				this.establecerCobroCarro(residuoHoras,dias);
			}
			
			if(this.tipoVehiculo.getNombre().equalsIgnoreCase(MOTO)) {
				establecerCobroMoto(residuoHoras,dias);
			}

		}

	}
	
	private void establecerCobroCarro(int horasResiduo, int dias) {
		if(horasResiduo > LIMITE_TIEMPO_PARA_VALOR_HORA )
			this.totalCobro = (double) ((++dias)*VALOR_DIA_CARRO);
		else
			this.totalCobro = (dias*VALOR_DIA_CARRO) + (horasResiduo*VALOR_HORA_CARRO);
	}
	
	private void establecerCobroMoto(int horasResiduo, int dias) {
		if(horasResiduo > LIMITE_TIEMPO_PARA_VALOR_HORA )
			this.totalCobro = (double) ((++dias)*VALOR_DIA_MOTO);
		else
			this.totalCobro = (dias*VALOR_DIA_MOTO) + (horasResiduo*VALOR_HORA_MOTO);
		
		if(this.cilindraje > LIMITE_CILINDRAJE_MOTO)
			this.totalCobro += EXCEDENTE_CILINDRAJE_MOTO;
	}

	private int calcularHorasEntreFechas() {
		long diferenciaMilisegundos = this.fechaSalida.getTime() - this.fechaEntrada.getTime();
		double horas = diferenciaMilisegundos / (MILISEGUNDOS_A_SEGUNDOS * SEGUNDOS_A_MINUTOS * MINUTOS_A_HORAS);
		return (int) Math.ceil(horas);
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

	public Double getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(Double cilindraje) {
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
