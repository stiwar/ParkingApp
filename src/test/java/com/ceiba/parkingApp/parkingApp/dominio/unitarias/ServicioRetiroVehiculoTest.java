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
import com.ceiba.parkingApp.parkingApp.dominio.entidad.Vehiculo;
import com.ceiba.parkingApp.parkingApp.dominio.puerto.IVehiculoRepositorioPort;
import com.ceiba.parkingApp.parkingApp.dominio.servicio.ServicioRetiroVehiculo;

@RunWith(SpringRunner.class)
public class ServicioRetiroVehiculoTest {
	
	private VehiculoTestBuilder vehiculoBuilder;
	private Vehiculo vehiculo;
	private static final Date FECHA_INGRESO_UN_DIA_TRES_HORAS_CARRO = new GregorianCalendar(2019, Calendar.JUNE, 12, 8, 13, 33).getTime();//h,m,s
	private static final Date FECHA_RETIRO_UN_DIA_TRES_HORAS_CARRO = new GregorianCalendar(2019, Calendar.JUNE, 13, 11, 13, 33).getTime();
	private static final int VEINTISIETE_HORAS = 27;
	private static final int ID_VEHICULO_UN_DIA_TRES_HORAS_CARRO = 5;
	private static final double COBRO_UN_DIA_TRES_HORAS_CARRO = 11000;
	
	private static final int ID_TIPO_VEHICULO_CARRO = 1;
	private static final String NOMBRE_TIPO_CARRO = "Carro";
	
	//@Mock
	//private IVehiculoRepositorioPort vehiculoRepositorioPort;
	
	//@InjectMocks
	@Mock
	ServicioRetiroVehiculo servicioRetiroVehiculo;
	
	@Before
	public void setUp() {
		vehiculoBuilder = new VehiculoTestBuilder();
	}
	
	@Test
	public void cobroCarroUnDiaTresHorasTest() {
		// arrange
	   vehiculo = vehiculoBuilder.conId(ID_VEHICULO_UN_DIA_TRES_HORAS_CARRO).conTipoVehiculo(ID_TIPO_VEHICULO_CARRO, NOMBRE_TIPO_CARRO).conFechaEntrada(FECHA_INGRESO_UN_DIA_TRES_HORAS_CARRO).build();
	   //when(vehiculoRepositorioPort.obtenerVehiculoPorId(vehiculo.getId())).thenReturn(vehiculo);
	   when(servicioRetiroVehiculo.recuperarVehiculo(vehiculo.getId())).thenReturn(vehiculo);
	   when(servicioRetiroVehiculo.obtenerHoras(vehiculo.getFechaEntrada(), FECHA_RETIRO_UN_DIA_TRES_HORAS_CARRO)).thenReturn(VEINTISIETE_HORAS);
	   when(servicioRetiroVehiculo.obtenerCobroPorDias(VEINTISIETE_HORAS, vehiculo)).thenReturn(COBRO_UN_DIA_TRES_HORAS_CARRO);
	   // act
	   vehiculo = servicioRetiroVehiculo.cobrarSalidaVehiculo(vehiculo.getId());
	   
	   // assert
	   /*double totalCobro = vehiculo.getTotalCobro();
	   assertEquals(COBRO_UN_DIA_TRES_HORAS_CARRO, totalCobro, 0);*/
	}
}
