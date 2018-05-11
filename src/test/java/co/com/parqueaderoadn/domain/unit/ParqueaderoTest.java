package co.com.parqueaderoadn.domain.unit;


import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;

import co.com.parqueaderoadn.dominio.Parqueadero;
import co.com.parqueaderoadn.dominio.Vehiculo;
import co.com.parqueaderoadn.tesbuilder.ParqueaderoTestBuilder;
import co.com.parqueaderoadn.tesbuilder.VehiculoTestBuilder;

public class ParqueaderoTest {
	public static final double VALORCOBROTEST1 = 11.000;
	public static final double VALORCOBROTEST2 = 6.000;

	@Test
	public void cobroCarroTest1() {
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conTipoVehiculo("carro");
		Vehiculo vehiculo = vehiculoTestBuilder.build();
		ParqueaderoTestBuilder parqueaderoTestBuilder = new ParqueaderoTestBuilder().conVehiculo(vehiculo).
				conFechaIngreso(LocalDateTime.of(2018,5,10,9,05)).conFechaSalida(LocalDateTime.of(2018,5,11,12,05));
		Parqueadero parqueadero = parqueaderoTestBuilder.build();

		double valorPagar = parqueadero.cobrar();
		boolean resultadoTest = VALORCOBROTEST1 == valorPagar;

		assertTrue(resultadoTest);
	}

	@Test
	public void cobroMotoTest1() {
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conTipoVehiculo("moto").conCilindraje("650cc");
		Vehiculo vehiculo = vehiculoTestBuilder.build();
		ParqueaderoTestBuilder parqueaderoTestBuilder = new ParqueaderoTestBuilder().conVehiculo(vehiculo).
				conFechaIngreso(LocalDateTime.of(2018,5,10,9,05)).conFechaSalida(LocalDateTime.of(2018,5,11,20,05));
		Parqueadero parqueadero = parqueaderoTestBuilder.build();
		double valorPagar = parqueadero.cobrar();
		boolean resultadoTest = VALORCOBROTEST2 == valorPagar;
		assertTrue(resultadoTest);
	}

	@Test
	public void ingresoCarroPlacaADiaNoPermitido() {
		try {
			VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conPlaca("AAA123");
			Vehiculo vehiculo = vehiculoTestBuilder.build();
			ParqueaderoTestBuilder parqueaderoTestBuilder = new ParqueaderoTestBuilder().conVehiculo(vehiculo).
					conFechaIngreso(LocalDateTime.of(2018,5,15,9,05));
			Parqueadero parqueadero = parqueaderoTestBuilder.build();
			parqueadero.validarIngreso();
			fail();
		} catch (Exception e) {
			assertEquals("No puede ingresar al parqueadero", e.getMessage());

		}
	}
	
	@Test
	public void ingresoCarroPlacaADiaDomingo() {
			VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conPlaca("AAA123");
			Vehiculo vehiculo = vehiculoTestBuilder.build();
			ParqueaderoTestBuilder parqueaderoTestBuilder = new ParqueaderoTestBuilder().conVehiculo(vehiculo).
					conFechaIngreso(LocalDateTime.of(2018,5,13,9,05));
			Parqueadero parqueadero = parqueaderoTestBuilder.build();
			assertTrue(parqueadero.validarIngreso());
	}
	
	@Test
	public void ingresoCarroPlacaDiferenteDeADiaDomingo() {
			VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conPlaca("BAA123");
			Vehiculo vehiculo = vehiculoTestBuilder.build();
			ParqueaderoTestBuilder parqueaderoTestBuilder = new ParqueaderoTestBuilder().conVehiculo(vehiculo).
					conFechaIngreso(LocalDateTime.of(2018,5,13,9,05));
			Parqueadero parqueadero = parqueaderoTestBuilder.build();
			assertTrue(parqueadero.validarIngreso());
	}
	
	@Test
	public void ingresoCarroPlacaDiferenteDeADiaMartes() {
			VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conPlaca("BAA123");
			Vehiculo vehiculo = vehiculoTestBuilder.build();
			ParqueaderoTestBuilder parqueaderoTestBuilder = new ParqueaderoTestBuilder().conVehiculo(vehiculo).
					conFechaIngreso(LocalDateTime.of(2018,5,22,9,05));
			Parqueadero parqueadero = parqueaderoTestBuilder.build();
			assertTrue(parqueadero.validarIngreso());
	}
	
	@Test
	public void ingresoCarroPlacaADiaLunes() {
			VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conPlaca("AXD123");
			Vehiculo vehiculo = vehiculoTestBuilder.build();
			ParqueaderoTestBuilder parqueaderoTestBuilder = new ParqueaderoTestBuilder().conVehiculo(vehiculo).
					conFechaIngreso(LocalDateTime.of(2018,5,14,9,05));
			Parqueadero parqueadero = parqueaderoTestBuilder.build();
			assertTrue(parqueadero.validarIngreso());
	}
	
	@Test
	public void ingresoCarroParqueaderoLleno() {
		try {
			VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conTipoVehiculo("carro");
			Vehiculo vehiculo = vehiculoTestBuilder.build();
			Parqueadero parqueadero = new ParqueaderoTestBuilder().conVehiculo(vehiculo).build();
			parqueadero.validarCeldasDisponibles();
			fail();
		} catch (Exception e) {
			assertEquals("No puede ingresar al parqueadero, no hay celdas disponibles para carros.", e.getMessage());

		}
	}
	
	@Test
	public void ingresoMotoParqueaderoLleno() {
		try {
			VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conTipoVehiculo("moto");
			Vehiculo vehiculo = vehiculoTestBuilder.build();
			Parqueadero parqueadero = new ParqueaderoTestBuilder().conVehiculo(vehiculo).build();
			parqueadero.validarCeldasDisponibles();
			fail();
		} catch (Exception e) {
			assertEquals("No puede ingresar al parqueadero, no hay celdas disponibles para motos.", e.getMessage());

		}
	}
	
}
