package co.com.parqueaderoadn.domain.unit;


import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import co.com.parqueaderoadn.domain.Parqueadero;
import co.com.parqueaderoadn.domain.Vehiculo;
import co.com.parqueaderoadn.tesbuilder.VehiculoTestBuilder;

public class TarifasTest {
	public static final double VALORCOBROTEST1=11.000;
	public static final double VALORCOBROTEST2=6.000;

	@Test
	public void cobroCarroTest1() {
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conTipoVehiculo("carro");
		Vehiculo vehiculo = vehiculoTestBuilder.build();
		Parqueadero parqueadero = new Parqueadero();
		
		double valorPagar = parqueadero.cobrar(vehiculo);
		boolean resultadoTest =  VALORCOBROTEST1==valorPagar;
		
		assertTrue(resultadoTest);
	}
	
	@Test
	public void cobroMotoTest1() {
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conTipoVehiculo("moto");
		Vehiculo vehiculo = vehiculoTestBuilder.build();
		Parqueadero parqueadero = new Parqueadero();
		
		double valorPagar = parqueadero.cobrar(vehiculo);
		boolean resultadoTest =  VALORCOBROTEST2==valorPagar;
		
		assertTrue(resultadoTest);
	}

}
