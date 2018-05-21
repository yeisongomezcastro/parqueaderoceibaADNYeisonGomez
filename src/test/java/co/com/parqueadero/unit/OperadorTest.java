package co.com.parqueadero.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.Calendar;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;

import co.com.parqueadero.dao.IOperadorDAO;
import co.com.parqueadero.dao.imp.OperadorDAOImp;
import co.com.parqueadero.dominio.ICalendario;
import co.com.parqueadero.dominio.IReloj;
import co.com.parqueadero.dominio.imp.Calendario;
import co.com.parqueadero.dominio.imp.Operador;
import co.com.parqueadero.dominio.imp.Reloj;
import co.com.parqueadero.model.Vehiculo;
import co.com.parqueadero.repositorio.IOperadorRespositorio;
import co.com.parqueaderoadn.tesbuilder.VehiculoTestBuilder;

public class OperadorTest {
	private static final String VEHICULO_MOTO = "Moto";
	private static final String VEHICULO_CARRO = "Carro";
	public static final Integer VALOR_PAGO_CARRO_TEST1 = 11000;
	public static final Integer VALOR_PAGO_MOTO_TEST1_TEST2 = 6000;
	public static final Integer VALOR_PAGO_CARRO_TEST2 = 16000;
	public static final Integer VALOR_PAGO_CARRO_TEST3 = 18000;
	
	@Qualifier("IOperadorRespositorio")
	IOperadorRespositorio operadorRespositorio;

	@Test
	public void cobroMotoTest1() {
		// arrange
		Calendar calendar = Calendar.getInstance();
		Operador operador = mock(Operador.class);
		Vehiculo vehiculo = new VehiculoTestBuilder().conTipoVehiculo(VEHICULO_MOTO).build();
		Mockito.when(operador.cobrar(calendar.getTime(), vehiculo.getTipoVehiculo())).thenReturn(6000);

		// act
		Integer valorPagar = operador.cobrar(calendar.getTime(), vehiculo.getTipoVehiculo());

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
		IOperadorDAO operadorDAO = new OperadorDAOImp();
		Operador operador = new Operador(calendario, vehiculo, reloj, operadorDAO);
		Mockito.when(reloj.cantidadHoras(calendar.getTime())).thenReturn(10);

		// act
		Integer valorPagar = operador.cobrar(calendar.getTime(), vehiculo.getTipoVehiculo());

		// assert
		assertEquals(VALOR_PAGO_MOTO_TEST1_TEST2, valorPagar);
	}
	
	@Test
	public void cobroCarroTest1() {
		// arrange
		Calendar calendar = Calendar.getInstance();
		ICalendario calendario = mock(Calendario.class);
		Vehiculo vehiculo = new VehiculoTestBuilder().conTipoVehiculo(VEHICULO_CARRO).build();
		Reloj reloj = mock(Reloj.class);
		IOperadorDAO operadorDAO = new OperadorDAOImp();
		Operador operador = new Operador(calendario, vehiculo, reloj, operadorDAO);
		Mockito.when(reloj.cantidadHoras(calendar.getTime())).thenReturn(27);

		// act
		Integer valorPagar = operador.cobrar(calendar.getTime(), vehiculo.getTipoVehiculo());

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
		IOperadorDAO operadorDAO = new OperadorDAOImp();
		Operador operador = new Operador(calendario, vehiculo, reloj, operadorDAO);
		Mockito.when(reloj.cantidadHoras(calendar.getTime())).thenReturn(32);

		// act
		Integer valorPagar = operador.cobrar(calendar.getTime(), vehiculo.getTipoVehiculo());

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
		IOperadorDAO operadorDAO = new OperadorDAOImp();
		Operador operador = new Operador(calendario, vehiculo, reloj, operadorDAO);
		Mockito.when(reloj.cantidadHoras(calendar.getTime())).thenReturn(50);

		// act
		Integer valorPagar = operador.cobrar(calendar.getTime(), vehiculo.getTipoVehiculo());

		// assert
		assertEquals(VALOR_PAGO_CARRO_TEST3, valorPagar);
	}


	@Test
	public void ingresoCarroParqueaderoLleno() {
		// arrange
		Operador operador = mock(Operador.class);
		Vehiculo vehiculo = new VehiculoTestBuilder().conTipoVehiculo(VEHICULO_CARRO).build();
		Mockito.when(operador.validarCeldasDisponibles(vehiculo.getTipoVehiculo())).thenReturn(true);

		// act
		boolean validarCeldas = operador.validarCeldasDisponibles(vehiculo.getTipoVehiculo());

		// assert
		assertTrue(validarCeldas);

	}

	@Test
	public void ingresoMotoParqueaderoLleno() {
		// arrange
		Operador operador = mock(Operador.class);
		Vehiculo vehiculo = new VehiculoTestBuilder().conTipoVehiculo(VEHICULO_MOTO).build();
		Mockito.when(operador.validarCeldasDisponibles(vehiculo.getTipoVehiculo())).thenReturn(true);

		// act
		boolean validarCeldas = operador.validarCeldasDisponibles(vehiculo.getTipoVehiculo());

		// assert
		assertTrue(validarCeldas);
	}

	@Test
	public void ingresoCarroConPlacaADiaRestringido() {

		// arrange
		ICalendario calendario = mock(Calendario.class);
		Vehiculo vehiculo = new VehiculoTestBuilder().conTipoVehiculo(VEHICULO_CARRO).conPlaca("AXY123").build();
		IReloj reloj = new Reloj();
		IOperadorDAO operadorDAO = new OperadorDAOImp();
		Operador operador = new Operador(calendario, vehiculo, reloj, operadorDAO);

		Mockito.when(calendario.esDiaHabilParaPlacaQueIniciaPorA()).thenReturn(true);

		// act
		boolean ingresoParqueadero = operador.validarIngreso(vehiculo.getPlaca());

		// assert
		assertFalse(ingresoParqueadero);

	}

	@Test
	public void ingresoCarroConPlacaADiaPermitido() {


		// arrange
		ICalendario calendario = mock(Calendario.class);
		Vehiculo vehiculo = new VehiculoTestBuilder().conTipoVehiculo(VEHICULO_CARRO).conPlaca("AXY123").build();
		IReloj reloj = new Reloj();
		IOperadorDAO operadorDAO = new OperadorDAOImp();
		Operador operador = new Operador(calendario, vehiculo, reloj, operadorDAO);

		Mockito.when(calendario.esDiaHabilParaPlacaQueIniciaPorA()).thenReturn(false);

		// act
		boolean ingresoParqueadero = operador.validarIngreso(vehiculo.getPlaca());

		// assert
		assertTrue(ingresoParqueadero);

	}

}
