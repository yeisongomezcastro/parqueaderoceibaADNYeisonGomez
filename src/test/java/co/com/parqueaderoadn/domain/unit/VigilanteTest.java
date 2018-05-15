package co.com.parqueaderoadn.domain.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import java.time.LocalDateTime;

import org.junit.Test;
import org.mockito.Mockito;

import co.com.parqueadero.dominio.Calendario;
import co.com.parqueadero.dominio.Parqueadero;
import co.com.parqueadero.dominio.Vehiculo;
import co.com.parqueadero.dominio.Vigilante;
import co.com.parqueaderoadn.tesbuilder.ParqueaderoTestBuilder;
import co.com.parqueaderoadn.tesbuilder.VehiculoTestBuilder;


public class VigilanteTest {
	public static final Integer VALORCOBROTEST1 = 11000;
	public static final Integer VALORCOBROTEST2 = 6000;
	

	@Test
	public void cobroCarroTest1() {
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conTipoVehiculo("carro");
		Vehiculo vehiculo = vehiculoTestBuilder.build();
		ParqueaderoTestBuilder parqueaderoTestBuilder = new ParqueaderoTestBuilder().conVehiculo(vehiculo);
		Parqueadero parqueadero = parqueaderoTestBuilder.build();
		Calendario calendario = new Calendario();
		Vigilante vigilante = new Vigilante(calendario, parqueadero);

		Integer valorPagar = vigilante.cobrar();

		assertEquals(VALORCOBROTEST1, valorPagar);

	}

	@Test
	public void cobroMotoTest1() {
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conTipoVehiculo("moto")
				.conCilindraje(650);
		Vehiculo vehiculo = vehiculoTestBuilder.build();
		ParqueaderoTestBuilder parqueaderoTestBuilder = new ParqueaderoTestBuilder().conVehiculo(vehiculo);
		Parqueadero parqueadero = parqueaderoTestBuilder.build();
		Calendario calendario = new Calendario();
		Vigilante vigilante = new Vigilante(calendario, parqueadero);

		Integer valorPagar = vigilante.cobrar();

		assertEquals(VALORCOBROTEST2, valorPagar);
	}
	
	@Test
	public void ingresoCarroParqueaderoLleno() {
		try {
			VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conTipoVehiculo("carro");
			Vehiculo vehiculo = vehiculoTestBuilder.build();
			Parqueadero parqueadero = new ParqueaderoTestBuilder().conVehiculo(vehiculo).build();
			Vigilante vigilante = new Vigilante(new Calendario(), parqueadero);
			vigilante.validarCeldasDisponibles();
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
			Vigilante vigilante = new Vigilante(new Calendario(), parqueadero);
			vigilante.validarCeldasDisponibles();
			fail();
		} catch (Exception e) {
			assertEquals("No puede ingresar al parqueadero, no hay celdas disponibles para motos.", e.getMessage());

		}
	}
	
	@Test
	public void ingresoCarroConPlacaADiaDiaPermitido() {
		
		try {
			VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conPlaca("AXD123");
			Vehiculo vehiculo = vehiculoTestBuilder.build();
			ParqueaderoTestBuilder parqueaderoTestBuilder = new ParqueaderoTestBuilder().conVehiculo(vehiculo).
					conFechaIngreso(LocalDateTime.of(2018,5,14,9,05));
			Parqueadero parqueadero = parqueaderoTestBuilder.build();
			Calendario calendario = mock(Calendario.class);
			Mockito.when(calendario.esDiaHabilParaPlacaQueIniciaPorA()).thenReturn(true);
			Vigilante vigilante = new Vigilante(calendario, parqueadero);
			vigilante.validarIngreso();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail();
			
		}
			
	}

}
