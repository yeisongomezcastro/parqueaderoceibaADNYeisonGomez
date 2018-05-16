package co.com.parqueaderoadn.domain.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import java.util.Calendar;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;

import co.com.parqueadero.dominio.Calendario;
import co.com.parqueadero.dominio.Parqueadero;
import co.com.parqueadero.dominio.Reloj;
import co.com.parqueadero.dominio.Vehiculo;
import co.com.parqueadero.dominio.Vigilante;
import co.com.parqueadero.repositorio.IVigilanteRepositorio;
import co.com.parqueaderoadn.tesbuilder.ParqueaderoTestBuilder;
import co.com.parqueaderoadn.tesbuilder.VehiculoTestBuilder;

public class VigilanteTest {
	@Qualifier("IVigilanteRepositorio")
	IVigilanteRepositorio vigilanteRepositorio;
	public static final Integer VALORCOBROTEST1 = 11000;
	public static final Integer VALORCOBROTEST2 = 6000;

	@Test
	public void cobroCarroTest1() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 04, 16, 1 ,50);
		Vigilante vigilante = mock(Vigilante.class);
		Mockito.when(vigilante.cobrar(calendar.getTime())).thenReturn(11000);
		Integer valorPagar = vigilante.cobrar(calendar.getTime());
		assertEquals(VALORCOBROTEST1, valorPagar);

	}

	@Test
	public void cobroMotoTest1() {
		
	Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 04, 16, 1 ,50);
		Vigilante vigilante = mock(Vigilante.class);
		Mockito.when(vigilante.cobrar(calendar.getTime())).thenReturn(6000);
		Integer valorPagar = vigilante.cobrar(calendar.getTime());

		assertEquals(VALORCOBROTEST2, valorPagar);
	}

	@Test
	public void ingresoCarroParqueaderoLleno() {
		Vigilante vigilante = mock(Vigilante.class);
		Mockito.when(vigilante.validarCeldasDisponibles()).thenReturn(true);
		assertTrue(vigilante.validarCeldasDisponibles());

	}

	@Test
	public void ingresoMotoParqueaderoLleno() {
		Vigilante vigilante = mock(Vigilante.class);
		Mockito.when(vigilante.validarCeldasDisponibles()).thenReturn(true);
		assertTrue(vigilante.validarCeldasDisponibles());
	}

	@Test
	public void ingresoCarroConPlacaADiaPermitido() {

		try {
			Calendar calendar = Calendar.getInstance();
			calendar.set(2018, 05, 14, 9, 05);
			VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conPlaca("AXD123");
			Vehiculo vehiculo = vehiculoTestBuilder.build();
			ParqueaderoTestBuilder parqueaderoTestBuilder = new ParqueaderoTestBuilder().conVehiculo(vehiculo);
			// .conFechaIngreso(LocalDateTime.of(2018, 5, 14, 9, 05));
			Parqueadero parqueadero = parqueaderoTestBuilder.build();
			Calendario calendario = mock(Calendario.class);
			Mockito.when(calendario.esDiaHabilParaPlacaQueIniciaPorA()).thenReturn(true);
			Reloj reloj = new Reloj();
			Vigilante vigilante = new Vigilante(calendario, parqueadero, reloj, vigilanteRepositorio);
			vigilante.validarIngreso();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail();

		}

	}
	
	@Test
	public void ingresoCarroConPlacaADiaNoPermitido() {

		try {
			Calendar calendar = Calendar.getInstance();
			calendar.set(2018, 05, 14, 9, 05);
			VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conPlaca("AXD123");
			Vehiculo vehiculo = vehiculoTestBuilder.build();
			ParqueaderoTestBuilder parqueaderoTestBuilder = new ParqueaderoTestBuilder().conVehiculo(vehiculo);
			// .conFechaIngreso(LocalDateTime.of(2018, 5, 14, 9, 05));
			Parqueadero parqueadero = parqueaderoTestBuilder.build();
			Calendario calendario = mock(Calendario.class);
			Mockito.when(calendario.esDiaHabilParaPlacaQueIniciaPorA()).thenReturn(false);
			Reloj reloj = new Reloj();
			Vigilante vigilante = new Vigilante(calendario, parqueadero, reloj, vigilanteRepositorio);
			vigilante.validarIngreso();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail();

		}

	}

}
