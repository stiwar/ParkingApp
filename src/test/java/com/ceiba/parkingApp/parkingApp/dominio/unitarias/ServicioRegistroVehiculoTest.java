package com.ceiba.parkingApp.parkingApp.dominio.unitarias;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.parkingApp.parkingApp.builder.VehiculoTestBuilder;
import com.ceiba.parkingApp.parkingApp.dominio.entidad.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.puerto.IVehiculoRepositorioPort;
import com.ceiba.parkingApp.parkingApp.dominio.servicio.ServicioRegistroVehiculo;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class ServicioRegistroVehiculoTest {
	private static final int ID_TIPO_VEHICULO_CARRO = 1;
	private static final String NOMBRE_TIPO_CARRO = "Carro";
	private static final int CANTIDAD_CARROS = 2;
		
	private VehiculoTestBuilder vehiculoBuilder;
	private Vehiculo vehiculoCarro;
	
	private IVehiculoRepositorioPort vehiculoRepositorioPort;
	@InjectMocks
	private ServicioRegistroVehiculo servicioRegistroVehiculo;
	
	

	@Before
	public void setUp() {
		//MockitoAnnotations.initMocks(ServicioRegistroVehiculoTest.class);
		vehiculoBuilder = new VehiculoTestBuilder();
		vehiculoCarro = vehiculoBuilder.conTipoVehiculo(ID_TIPO_VEHICULO_CARRO,NOMBRE_TIPO_CARRO).build();
		vehiculoRepositorioPort = mock(IVehiculoRepositorioPort.class);
		servicioRegistroVehiculo = new ServicioRegistroVehiculo();
	}
	
	@Test
	public void siHayEspacioParaCarroTest() {
		//arrange
		when( vehiculoRepositorioPort.obtenerTotalVehiculoPorIdTipoVehiculo(vehiculoCarro.getTipoVehiculo().getId()) ).thenReturn(CANTIDAD_CARROS);
		
		//act
		int totalCarros = servicioRegistroVehiculo.obtenerCantidadVehiculos(vehiculoCarro.getTipoVehiculo().getId());
		//assert
		assertEquals(CANTIDAD_CARROS,totalCarros,0);
	}

}
