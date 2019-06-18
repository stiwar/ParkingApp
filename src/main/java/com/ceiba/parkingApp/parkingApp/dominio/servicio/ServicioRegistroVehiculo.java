package com.ceiba.parkingApp.parkingApp.dominio.servicio;

import java.util.Calendar;
import java.util.Date;

import com.ceiba.parkingApp.parkingApp.dominio.entidad.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.excepcion.VehiculoExcepcion;
import com.ceiba.parkingApp.parkingApp.dominio.puerto.IVehiculoRepositorioPort;

public class ServicioRegistroVehiculo {

	private static final String CARRO = "Carro";
	private static final String MOTO = "Moto";
	private static final int LIMITE_MAXIMO_CARROS = 20;
	private static final int LIMITE_MAXIMO_MOTOS = 10;
	private static final String NO_HAY_ESPACIO_PARA_CARROS = "No hay espacio disponible para carros";
	private static final String NO_HAY_ESPACIO_PARA_MOTOS = "No hay espacio disponible para motos";
	private static final int POSICION_LETRA_INICIAL_PLACA_VEHICULO = 0;
	private static final String LETRA_A = "A";
	private static final String ACCESO_DENEGADO = "Las placas que inician con la letra '" + LETRA_A	+ "' solo pueden ingresar los Domingos o Lunes";
	private static int VEHICULO_ESTADO_ACTIVO = 1;

	private IVehiculoRepositorioPort vehiculoRepositorioPort;
	
	public ServicioRegistroVehiculo(IVehiculoRepositorioPort vehiculoRepositorioPort) {
		this.vehiculoRepositorioPort = vehiculoRepositorioPort;
	}

	public Vehiculo guardarRegistroVehiculo(Vehiculo vehiculo) {
		String nombreTipoVehiculo = vehiculo.getTipoVehiculo().getNombre();
		int idTipoVehiculo = vehiculo.getTipoVehiculo().getId();

		if (nombreTipoVehiculo.equalsIgnoreCase(CARRO)
				&& obtenerCantidadVehiculos(idTipoVehiculo) >= LIMITE_MAXIMO_CARROS) {
			throw new VehiculoExcepcion(NO_HAY_ESPACIO_PARA_CARROS);
		}

		if (nombreTipoVehiculo.equalsIgnoreCase(MOTO)
				&& obtenerCantidadVehiculos(idTipoVehiculo) >= LIMITE_MAXIMO_MOTOS) {
			throw new VehiculoExcepcion(NO_HAY_ESPACIO_PARA_MOTOS);
		}

		String letraInicialPlaca = obtenerLetraInicialPlaca(vehiculo.getPlaca());

		int diaSemana = obtenerDiaSemana();
		if (letraInicialPlaca.equalsIgnoreCase(LETRA_A)
				&& (diaSemana != Calendar.SUNDAY && diaSemana != Calendar.MONDAY)) {
			throw new VehiculoExcepcion(ACCESO_DENEGADO);
		}

		vehiculo.setFechaEntrada(new Date());
		vehiculo.setEstado(VEHICULO_ESTADO_ACTIVO);
		return vehiculoRepositorioPort.registrarVehiculo(vehiculo);
	}

	public int obtenerCantidadVehiculos(int idTipoVehiculo) {
		return vehiculoRepositorioPort.obtenerTotalVehiculoPorIdTipoVehiculo(idTipoVehiculo);
	}

	public String obtenerLetraInicialPlaca(String placa) {
		return String.valueOf(placa.charAt(POSICION_LETRA_INICIAL_PLACA_VEHICULO));
	}

	public int obtenerDiaSemana() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

}
