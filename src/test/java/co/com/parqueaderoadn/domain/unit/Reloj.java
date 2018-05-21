package co.com.parqueaderoadn.domain.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Calendar;

import org.junit.Test;
import org.mockito.Mockito;

import co.com.parqueadero.dominio.IReloj;

public class Reloj {
	
	
	private static final Integer VALOR_ESPERADO_HORAS = 10;

	@Test
	public void validarCantidadHoras() {
		//Arrange
		Calendar calendar = Calendar.getInstance();
		IReloj reloj = mock(IReloj.class);
		Mockito.when(reloj.cantidadHoras(calendar.getTime())).thenReturn(VALOR_ESPERADO_HORAS);
		
		//Act
		Integer horas = reloj.cantidadHoras(calendar.getTime());
		
		//Assert 
		
		assertEquals(VALOR_ESPERADO_HORAS,horas);
	}

}
