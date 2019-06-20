package com.ceiba.parkingApp.parkingApp.infraestructura;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ceiba.parkingApp.parkingApp.ApplicationMock;
import com.ceiba.parkingApp.parkingApp.ParkingAppApplication;
import com.ceiba.parkingApp.parkingApp.aplicacion.comando.VehiculoComando;
import com.ceiba.parkingApp.parkingApp.builder.VehiculoComandoBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@SpringBootTest(classes = ParkingAppApplication.class)
@AutoConfigureMockMvc
public class VehiculoControladorTest {
	
	private static final String URL_POST ="/servicio/vehiculo";
	private static final String URL_PUT ="/servicio/vehiculo/";
	private static final int ID_TIPO_VEHICULO_CARRO = 1;
	private static final String NOMBRE_TIPO_VEHICULO_CARRO = "Carro";
	private static final int ID_TIPO_VEHICULO_MOTO = 2;
	private static final String NOMBRE_TIPO_VEHICULO_MOTO = "Moto";
	private static final double CILINDRAJE_MOTO = 200.0; 
	private static final String PLACA_VEHICULO = "PQR12F";
	private static final int ID_REGISTRO_MOTO = 2;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private MockMvc mvc;
	
	private VehiculoComandoBuilder vehiculoComandoBuilder;
	
	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();
		vehiculoComandoBuilder = new VehiculoComandoBuilder();
	}
	
	@Test
	public void registrarCarroTest() throws Exception{
		// Arrange
		VehiculoComando vehiculoComando = vehiculoComandoBuilder.conTipoVehiculo(ID_TIPO_VEHICULO_CARRO, NOMBRE_TIPO_VEHICULO_CARRO)
																.conPlaca(PLACA_VEHICULO)
																.build();
		// act
		// assert
		mvc.perform(post(URL_POST).content(objectMapper.writeValueAsString(vehiculoComando)).contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}
	
	@Test
	public void registrarMotoTest() throws Exception{
		// Arrange
		VehiculoComando vehiculoComando = vehiculoComandoBuilder.conTipoVehiculo(ID_TIPO_VEHICULO_MOTO, NOMBRE_TIPO_VEHICULO_MOTO)
																.conPlaca(PLACA_VEHICULO)
																.conCilindraje(CILINDRAJE_MOTO)
																.build();
		// act
		// assert
		mvc.perform(post(URL_POST).content(objectMapper.writeValueAsString(vehiculoComando)).contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}
	
	@Test
	public void retirarVehiculoTest() throws Exception {
				
		// Act y Assert
		mvc.perform( put(URL_PUT + ID_REGISTRO_MOTO).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
	}
}
