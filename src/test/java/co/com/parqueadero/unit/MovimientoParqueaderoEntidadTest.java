package co.com.parqueadero.unit;


import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import co.com.parqueadero.entidad.MovimientoParqueaderoEntidad;

public class MovimientoParqueaderoEntidadTest {
	private static final Integer VALOR_PAGO_SALIDA = 50000;

	@Test
	public void setFechaSalidaTest() {
		//Arrange
		MovimientoParqueaderoEntidad movimientoParqueaderoEntidad = new MovimientoParqueaderoEntidad();
		Calendar calendar = Calendar.getInstance();
		
		//Act
		Date valorEsperado = calendar.getTime();
		movimientoParqueaderoEntidad.setFechaSalida(calendar.getTime());
		Date valorRetornado = movimientoParqueaderoEntidad.getFechaSalida();
		
		//Asser
		assertEquals(valorEsperado, valorRetornado);
		
		
	}
	
	@Test
	public void setValorPagoSalidaVehiculoTest() {
		//Arrange
		MovimientoParqueaderoEntidad movimientoParqueaderoEntidad = new MovimientoParqueaderoEntidad();
		
		//Act
		movimientoParqueaderoEntidad.setValorPago(VALOR_PAGO_SALIDA);
		Integer valorRetornado = movimientoParqueaderoEntidad.getValorPago();
	
		
		//Asser
		assertEquals(VALOR_PAGO_SALIDA, valorRetornado);
		
		
	}

}
