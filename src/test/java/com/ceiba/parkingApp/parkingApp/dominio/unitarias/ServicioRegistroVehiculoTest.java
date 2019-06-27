package com.ceiba.parkingApp.parkingApp.dominio.unitarias;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.parkingApp.parkingApp.builder.VehiculoTestBuilder;
import com.ceiba.parkingApp.parkingApp.dominio.excepcion.VehiculoExcepcion;
import com.ceiba.parkingApp.parkingApp.dominio.modelo.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.puerto.VehiculoRepositorioPort;
import com.ceiba.parkingApp.parkingApp.dominio.servicio.ServicioRegistroVehiculo;

//@SpringBootTest
@RunWith(SpringRunner.class)
public class ServicioRegistroVehiculoTest {

	private static final int ID_TIPO_VEHICULO_CARRO = 1;
	private static final String NOMBRE_TIPO_CARRO = "Carro";
	private static final int ID_TIPO_VEHICULO_MOTO = 2;
	private static final String NOMBRE_TIPO_MOTO = "Moto";
	private static final int CANTIDAD_CARROS_PERMITIDOS = 2;
	private static final int MAXIMA_CANTIDAD_CARROS_PERMITIDOS = 20;
	private static final int MAXIMA_CANTIDAD_MOTOS_PERMITIDAS = 20;
	private static final String LETRA_A = "A";
	private static final String PLACA_CON_LETRA_INICIAL_A = "ABC125";
	private static final String PLACA_SIN_LETRA_A = "PQR112";
	private static final int DIA_VIERNES = 6;
	private static final int DIA_LUNES = 2;
	private static final int DIA_MARTES = 3;
	private static final int DIA_MIERCOLES = 4;
	private static final int DIA_JUEVES = 5;

	private VehiculoTestBuilder vehiculoBuilder;

	private Vehiculo vehiculo;

	@Mock
	private VehiculoRepositorioPort vehiculoRepositorioPort;

	@InjectMocks
	private ServicioRegistroVehiculo servicioRegistroVehiculo;

	@Before
	public void setUp() {
		vehiculoBuilder = new VehiculoTestBuilder();
	}

	@Test
	public void siHayEspacioParaCarroTest() {
		// arrange
		vehiculo = vehiculoBuilder.conTipoVehiculo(ID_TIPO_VEHICULO_CARRO, NOMBRE_TIPO_CARRO).build();
		when(vehiculoRepositorioPort.obtenerTotalVehiculoPorIdTipoVehiculo(vehiculo.getTipoVehiculo().getId()))
				.thenReturn(CANTIDAD_CARROS_PERMITIDOS);

		// act
		int totalCarros = servicioRegistroVehiculo.obtenerCantidadVehiculos(vehiculo.getTipoVehiculo().getId());
		// assert
		assertEquals(CANTIDAD_CARROS_PERMITIDOS, totalCarros, 0);
	}

	@Test
	public void obtenerLetraAdePlacaTest() {
		
		// arrange
		vehiculoBuilder = new VehiculoTestBuilder();
		vehiculo = vehiculoBuilder.conTipoVehiculo(ID_TIPO_VEHICULO_CARRO, NOMBRE_TIPO_CARRO).conPlaca(PLACA_CON_LETRA_INICIAL_A).build();
		
		// act
		String letraObtenida = servicioRegistroVehiculo.obtenerLetraInicialPlaca(vehiculo.getPlaca());
		
		// assert
		assertEquals(LETRA_A, letraObtenida);
		
	}

	@Test
	public void obtenerDiaSemanaTest() {
		
		// act
		int diaObtenido = servicioRegistroVehiculo.obtenerDiaSemana();
		
		// assert
		assertEquals(DIA_JUEVES, diaObtenido);
	}

	@Test(expected = VehiculoExcepcion.class)
	public void excepcionEspacioCarrosTest() {
		// arrange
		vehiculoBuilder = new VehiculoTestBuilder();
		vehiculo = vehiculoBuilder.conTipoVehiculo(ID_TIPO_VEHICULO_CARRO, NOMBRE_TIPO_CARRO)
				.conPlaca(PLACA_SIN_LETRA_A).build();
		when(vehiculoRepositorioPort.obtenerTotalVehiculoPorIdTipoVehiculo(vehiculo.getTipoVehiculo().getId()))
				.thenReturn(MAXIMA_CANTIDAD_CARROS_PERMITIDOS);
		// act
		servicioRegistroVehiculo.guardarRegistroVehiculo(vehiculo);
	}

	@Test(expected = VehiculoExcepcion.class)
	public void excepcionEspacioMotosTest() {
		// arrange
		vehiculoBuilder = new VehiculoTestBuilder();
		vehiculo = vehiculoBuilder.conTipoVehiculo(ID_TIPO_VEHICULO_MOTO, NOMBRE_TIPO_MOTO).conPlaca(PLACA_SIN_LETRA_A)
				.build();
		when(vehiculoRepositorioPort.obtenerTotalVehiculoPorIdTipoVehiculo(vehiculo.getTipoVehiculo().getId()))
				.thenReturn(MAXIMA_CANTIDAD_MOTOS_PERMITIDAS);
		// act
		servicioRegistroVehiculo.guardarRegistroVehiculo(vehiculo);
	}

	@Test(expected = VehiculoExcepcion.class)
	public void excepcionPlacaLetraAdiaLunesTest() {
		// arrange
		vehiculoBuilder = new VehiculoTestBuilder();
		vehiculo = vehiculoBuilder.conTipoVehiculo(ID_TIPO_VEHICULO_CARRO, NOMBRE_TIPO_CARRO)
				.conPlaca(PLACA_CON_LETRA_INICIAL_A).build();
		when(servicioRegistroVehiculo.obtenerDiaSemana()).thenReturn(DIA_LUNES);
		servicioRegistroVehiculo.guardarRegistroVehiculo(vehiculo);
	}

}
