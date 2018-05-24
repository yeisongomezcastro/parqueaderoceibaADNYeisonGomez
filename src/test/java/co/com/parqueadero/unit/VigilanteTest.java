package co.com.parqueadero.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.Calendar;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;

import co.com.parqueadero.dao.IVigilanteDAO;
import co.com.parqueadero.dao.imp.VigilanteDAOImp;
import co.com.parqueadero.dominio.ICalendario;
import co.com.parqueadero.dominio.IReloj;
import co.com.parqueadero.dominio.imp.Calendario;
import co.com.parqueadero.dominio.imp.Vigilante;
import co.com.parqueadero.dominio.imp.Reloj;
import co.com.parqueadero.model.Vehiculo;
import co.com.parqueadero.repositorio.IVigilanteRespositorio;
import co.com.parqueaderoadn.tesbuilder.VehiculoTestBuilder;

public class VigilanteTest {
	private static final String VEHICULO_MOTO = "Moto";
	private static final String VEHICULO_CARRO = "Carro";
	public static final Integer VALOR_PAGO_CARRO_TEST1 = 11000;
	public static final Integer VALOR_PAGO_MOTO_TEST1_TEST2 = 6000;
	public static final Integer VALOR_PAGO_MOTO_TEST1_TEST3 = 6500;
	public static final Integer VALOR_PAGO_CARRO_TEST2 = 16000;
	public static final Integer VALOR_PAGO_CARRO_TEST3 = 18000;
	
	@Qualifier("IOperadorRespositorio")
	IVigilanteRespositorio vigilanteRespositorio;

	@Test
	public void cobroMotoTest1() {
		// arrange
		Calendar calendar = Calendar.getInstance();
		Vigilante vigilante = mock(Vigilante.class);
		Vehiculo vehiculo = new VehiculoTestBuilder().conTipoVehiculo(VEHICULO_MOTO).build();
		Mockito.when(vigilante.cobrar(calendar.getTime(), vehiculo.getTipoVehiculo(),vehiculo.getCilindraje())).thenReturn(6000);

		// act
		Integer valorPagar = vigilante.cobrar(calendar.getTime(), vehiculo.getTipoVehiculo(),vehiculo.getCilindraje());

		// assert
		assertEquals(VALOR_PAGO_MOTO_TEST1_TEST2, valorPagar);
	}
	
	@Test
	public void cobroMotoTest2() {
		// arrange
		Calendar calendar = Calendar.getInstance();
		ICalendario calendario = mock(Calendario.class);
		Vehiculo vehiculo = new VehiculoTestBuilder().conTipoVehiculo(VEHICULO_MOTO).conPlaca("AXY123").conCilindraje(660).build();
		Reloj reloj = mock(Reloj.class);
		IVigilanteDAO vigilanteDAO = new VigilanteDAOImp();
		Vigilante vigilante = new Vigilante(calendario, vehiculo, reloj, vigilanteDAO);
		Mockito.when(reloj.cantidadMinutos(calendar.getTime())).thenReturn(600);

		// act
		Integer valorPagar = vigilante.cobrar(calendar.getTime(), vehiculo.getTipoVehiculo(),vehiculo.getCilindraje());

		// assert
		assertEquals(VALOR_PAGO_MOTO_TEST1_TEST2, valorPagar);
	}
	
	@Test
	public void cobroMotoTest3() {
		// arrange
		Calendar calendar = Calendar.getInstance();
		ICalendario calendario = mock(Calendario.class);
		Vehiculo vehiculo = new VehiculoTestBuilder().conTipoVehiculo(VEHICULO_MOTO).conPlaca("AXY123").conCilindraje(660).build();
		Reloj reloj = mock(Reloj.class);
		IVigilanteDAO vigilanteDAO = new VigilanteDAOImp();
		Vigilante vigilante = new Vigilante(calendario, vehiculo, reloj, vigilanteDAO);
		Mockito.when(reloj.cantidadMinutos(calendar.getTime())).thenReturn(601);

		// act
		Integer valorPagar = vigilante.cobrar(calendar.getTime(), vehiculo.getTipoVehiculo(),vehiculo.getCilindraje());

		// assert
		assertEquals(VALOR_PAGO_MOTO_TEST1_TEST3, valorPagar);
	}
	
	@Test
	public void cobroCarroTest1() {
		// arrange
		Calendar calendar = Calendar.getInstance();
		ICalendario calendario = mock(Calendario.class);
		Vehiculo vehiculo = new VehiculoTestBuilder().conTipoVehiculo(VEHICULO_CARRO).build();
		Reloj reloj = mock(Reloj.class);
		IVigilanteDAO vigilanteDAO = new VigilanteDAOImp();
		Vigilante vigilante = new Vigilante(calendario, vehiculo, reloj, vigilanteDAO);
		Mockito.when(reloj.cantidadMinutos(calendar.getTime())).thenReturn(1620);

		// act
		Integer valorPagar = vigilante.cobrar(calendar.getTime(), vehiculo.getTipoVehiculo(),vehiculo.getCilindraje());

		// assert
		assertEquals(VALOR_PAGO_CARRO_TEST1, valorPagar);
	}
	
	@Test
	public void cobroCarroTest2() {
		// arrange
		Calendar calendar = Calendar.getInstance();
		ICalendario calendario = mock(Calendario.class);
		Vehiculo vehiculo = new VehiculoTestBuilder().conTipoVehiculo(VEHICULO_CARRO).build();
		Reloj reloj = mock(Reloj.class);
		IVigilanteDAO vigilanteDAO = new VigilanteDAOImp();
		Vigilante vigilante = new Vigilante(calendario, vehiculo, reloj, vigilanteDAO);
		Mockito.when(reloj.cantidadMinutos(calendar.getTime())).thenReturn(1920);

		// act
		Integer valorPagar = vigilante.cobrar(calendar.getTime(), vehiculo.getTipoVehiculo(),vehiculo.getCilindraje());

		// assert
		assertEquals(VALOR_PAGO_CARRO_TEST2, valorPagar);
	}
	
	@Test
	public void cobroCarroTest3() {
		// arrange
		Calendar calendar = Calendar.getInstance();
		ICalendario calendario = mock(Calendario.class);
		Vehiculo vehiculo = new VehiculoTestBuilder().conTipoVehiculo(VEHICULO_CARRO).build();
		Reloj reloj = mock(Reloj.class);
		IVigilanteDAO vigilanteDAO = new VigilanteDAOImp();
		Vigilante vigilante = new Vigilante(calendario, vehiculo, reloj, vigilanteDAO);
		Mockito.when(reloj.cantidadMinutos(calendar.getTime())).thenReturn(3000);

		// act
		Integer valorPagar = vigilante.cobrar(calendar.getTime(), vehiculo.getTipoVehiculo(),vehiculo.getCilindraje());

		// assert
		assertEquals(VALOR_PAGO_CARRO_TEST3, valorPagar);
	}


	@Test
	public void ingresoCarroParqueaderoLleno() {
		// arrange
		Vigilante vigilante = mock(Vigilante.class);
		Vehiculo vehiculo = new VehiculoTestBuilder().conTipoVehiculo(VEHICULO_CARRO).build();
		Mockito.when(vigilante.validarCeldasDisponibles(vehiculo.getTipoVehiculo())).thenReturn(true);

		// act
		boolean validarCeldas = vigilante.validarCeldasDisponibles(vehiculo.getTipoVehiculo());

		// assert
		assertTrue(validarCeldas);

	}

	@Test
	public void ingresoMotoParqueaderoLleno() {
		// arrange
		Vigilante vigilante = mock(Vigilante.class);
		Vehiculo vehiculo = new VehiculoTestBuilder().conTipoVehiculo(VEHICULO_MOTO).build();
		Mockito.when(vigilante.validarCeldasDisponibles(vehiculo.getTipoVehiculo())).thenReturn(true);

		// act
		boolean validarCeldas = vigilante.validarCeldasDisponibles(vehiculo.getTipoVehiculo());

		// assert
		assertTrue(validarCeldas);
	}

	@Test
	public void ingresoCarroConPlacaADiaRestringido() {

		// arrange
		ICalendario calendario = mock(Calendario.class);
		Vehiculo vehiculo = new VehiculoTestBuilder().conTipoVehiculo(VEHICULO_CARRO).conPlaca("AXY123").build();
		IReloj reloj = new Reloj();
		IVigilanteDAO vigilanteDAO = new VigilanteDAOImp();
		Vigilante vigilante = new Vigilante(calendario, vehiculo, reloj, vigilanteDAO);

		Mockito.when(calendario.esDiaHabilParaPlacaQueIniciaPorA()).thenReturn(true);

		// act
		boolean ingresoParqueadero = vigilante.validarIngreso(vehiculo.getPlaca());

		// assert
		assertFalse(ingresoParqueadero);

	}

	@Test
	public void ingresoCarroConPlacaADiaPermitido() {


		// arrange
		ICalendario calendario = mock(Calendario.class);
		Vehiculo vehiculo = new VehiculoTestBuilder().conTipoVehiculo(VEHICULO_CARRO).conPlaca("AXY123").build();
		IReloj reloj = new Reloj();
		IVigilanteDAO vigilanteDAO = new VigilanteDAOImp();
		Vigilante vigilante = new Vigilante(calendario, vehiculo, reloj, vigilanteDAO);

		Mockito.when(calendario.esDiaHabilParaPlacaQueIniciaPorA()).thenReturn(false);

		// act
		boolean ingresoParqueadero = vigilante.validarIngreso(vehiculo.getPlaca());

		// assert
		assertTrue(ingresoParqueadero);

	}

}
