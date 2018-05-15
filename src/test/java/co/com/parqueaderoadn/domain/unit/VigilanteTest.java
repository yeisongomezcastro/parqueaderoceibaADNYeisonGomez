package co.com.parqueaderoadn.domain.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import java.util.Calendar;

import org.junit.Test;
import org.mockito.Mockito;

import co.com.parqueadero.dominio.Calendario;
import co.com.parqueadero.dominio.Parqueadero;
import co.com.parqueadero.dominio.Reloj;
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
		Reloj reloj = new Reloj(parqueadero.getFechaIngreso(), parqueadero.getFechaSalida());
		Vigilante vigilante = new Vigilante(calendario, parqueadero,reloj);

		Integer valorPagar = vigilante.cobrar();

		assertEquals(VALORCOBROTEST1, valorPagar);

	}

	@Test
	public void cobroMotoTest1() {
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conTipoVehiculo("moto").conCilindraje(650);
		Vehiculo vehiculo = vehiculoTestBuilder.build();
		ParqueaderoTestBuilder parqueaderoTestBuilder = new ParqueaderoTestBuilder().conVehiculo(vehiculo);
		Parqueadero parqueadero = parqueaderoTestBuilder.build();
		Calendario calendario = new Calendario();
		Reloj reloj = new Reloj(parqueadero.getFechaIngreso(), parqueadero.getFechaSalida());
		Vigilante vigilante = new Vigilante(calendario, parqueadero,reloj);

		Integer valorPagar = vigilante.cobrar();

		assertEquals(VALORCOBROTEST2, valorPagar);
	}

	@Test
	public void ingresoCarroParqueaderoLleno() {

		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conTipoVehiculo("carro");
		Vehiculo vehiculo = vehiculoTestBuilder.build();
		Parqueadero parqueadero = new ParqueaderoTestBuilder().conVehiculo(vehiculo).build();
		Reloj reloj = new Reloj(parqueadero.getFechaIngreso(), parqueadero.getFechaSalida());
		Vigilante vigilante = new Vigilante(new Calendario(), parqueadero,reloj);
		vigilante.validarCeldasDisponibles();
		assertTrue(vigilante.validarCeldasDisponibles());
	}

	@Test
	public void ingresoMotoParqueaderoLleno() {
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conTipoVehiculo("moto");
		Vehiculo vehiculo = vehiculoTestBuilder.build();
		Parqueadero parqueadero = new ParqueaderoTestBuilder().conVehiculo(vehiculo).build();
		Reloj reloj = new Reloj(parqueadero.getFechaIngreso(), parqueadero.getFechaSalida());
		Vigilante vigilante = new Vigilante(new Calendario(), parqueadero,reloj);

		assertTrue(vigilante.validarCeldasDisponibles());

	}

	@Test
	public void ingresoCarroConPlacaADiaDiaPermitido() {

		try {
			Calendar calendar = Calendar.getInstance();
			calendar.set(2018, 05, 14, 9, 05);
			VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conPlaca("AXD123");
			Vehiculo vehiculo = vehiculoTestBuilder.build();
			ParqueaderoTestBuilder parqueaderoTestBuilder = new ParqueaderoTestBuilder().conVehiculo(vehiculo).conFechaIngreso(calendar.getTime());
					//.conFechaIngreso(LocalDateTime.of(2018, 5, 14, 9, 05));
			Parqueadero parqueadero = parqueaderoTestBuilder.build();
			Calendario calendario = mock(Calendario.class);
			Mockito.when(calendario.esDiaHabilParaPlacaQueIniciaPorA()).thenReturn(true);
			Reloj reloj = new Reloj(parqueadero.getFechaIngreso(), parqueadero.getFechaSalida());
			Vigilante vigilante = new Vigilante(calendario, parqueadero,reloj);
			vigilante.validarIngreso();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail();

		}

	}

}
