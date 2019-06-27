package com.ceiba.parkingApp.parkingApp.dominio.unitarias;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.parkingApp.parkingApp.builder.VehiculoTestBuilder;
import com.ceiba.parkingApp.parkingApp.dominio.modelo.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.puerto.VehiculoRepositorioPort;
import com.ceiba.parkingApp.parkingApp.dominio.servicio.ServicioRetiroVehiculo;

@RunWith(SpringRunner.class)
public class ServicioRetiroVehiculoTest {
	
	private VehiculoTestBuilder vehiculoBuilder;
	
	private Vehiculo vehiculo;
	private static final Date FECHA_INGRESO_UN_DIA_TRES_HORAS_CARRO = new GregorianCalendar(2019, Calendar.JUNE, 19, 11, 20, 00).getTime();//h,m,s
	private static final Date FECHA_RETIRO_UN_DIA_TRES_HORAS_CARRO = new GregorianCalendar(2019, Calendar.JUNE, 20, 14, 10, 00).getTime();
	
	private static final Date FECHA_INGRESO_MOTO_ALTO_CILINDRAJE = new GregorianCalendar(2019, Calendar.JUNE, 19, 11, 20, 00).getTime();
	private static final Date FECHA_RETIRO_MOTO_ALTO_CILINDRAJE = new GregorianCalendar(2019, Calendar.JUNE, 19, 14, 10, 00).getTime();
	private static final int VEINTISIETE_HORAS = 27;
	private static final int ID_VEHICULO_UN_DIA_TRES_HORAS_CARRO = 5;
	private static final double COBRO_UN_DIA_TRES_HORAS_CARRO = 11000;
	
	private static final int ID_TIPO_VEHICULO_CARRO = 1;
	private static final String NOMBRE_TIPO_CARRO = "Carro";
	private static final int ID_TIPO_VEHICULO_MOTO = 2;
	private static final String NOMBRE_TIPO_MOTO = "Moto";
	private static final double CILINDRAJE_ALTO_MOTO = 700;
	private static final double TOTAL_COBRO_TRES_HORAS_MOTO = 700;
	private static final int ID_MOTO = 6;
	
	@Mock
	private VehiculoRepositorioPort vehiculoRepositorioPort;
	
	@InjectMocks
	ServicioRetiroVehiculo servicioRetiroVehiculo;
	
	@Before
	public void setUp() {
		vehiculoBuilder = new VehiculoTestBuilder();
	}
	
	@Test
	public void totalCobroCarroUnDiaTresHorasTest() {
		
		// arrange
		vehiculo = vehiculoBuilder.conId(ID_VEHICULO_UN_DIA_TRES_HORAS_CARRO)
								  .conFechaEntrada(FECHA_INGRESO_UN_DIA_TRES_HORAS_CARRO)
								  .conTipoVehiculo(ID_TIPO_VEHICULO_CARRO, NOMBRE_TIPO_CARRO)
								  .conFechaSalida(FECHA_RETIRO_UN_DIA_TRES_HORAS_CARRO)
								  .build();
		when(vehiculoRepositorioPort.obtenerVehiculoPorId(vehiculo.getId())).thenReturn(vehiculo);
		when(vehiculoRepositorioPort.retirarVehiculo(vehiculo)).thenReturn(vehiculo);
		
		//act
		Double totalCobro = servicioRetiroVehiculo.cobrarSalidaVehiculo(vehiculo.getId()).getTotalCobro();
		
		// assert
		assertEquals(COBRO_UN_DIA_TRES_HORAS_CARRO, totalCobro, 0);
		
	}
	
	public void totalCobroTresHorasMotoAltoCilindraje() {
		// arrange
		vehiculo = vehiculoBuilder.conId(ID_MOTO)
								  .conFechaEntrada(FECHA_INGRESO_MOTO_ALTO_CILINDRAJE)
								  .conTipoVehiculo(ID_TIPO_VEHICULO_MOTO, NOMBRE_TIPO_MOTO)
								  .conCilindraje(CILINDRAJE_ALTO_MOTO)
								  .conFechaSalida(FECHA_RETIRO_MOTO_ALTO_CILINDRAJE)
								  .build();
		when(vehiculoRepositorioPort.obtenerVehiculoPorId(vehiculo.getId())).thenReturn(vehiculo);
		when(vehiculoRepositorioPort.retirarVehiculo(vehiculo)).thenReturn(vehiculo);
		
		//act
		Double totalCobro = servicioRetiroVehiculo.cobrarSalidaVehiculo(vehiculo.getId()).getTotalCobro();
		
		// assert
		assertEquals(TOTAL_COBRO_TRES_HORAS_MOTO, totalCobro, 0);
	}
	
}
