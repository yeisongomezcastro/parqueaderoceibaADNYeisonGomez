package co.com.parqueadero.unit;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import co.com.parqueadero.dominio.imp.Calendario;

public class CalendarioTest {
	
	@Test
	public void diaHabilParaPlacaQueIniciaPorA() {
		//Arrange
		Calendario calendario = new Calendario();
	
		
		//Act
		
		boolean diaHabil = calendario.esDiaHabilParaPlacaQueIniciaPorA();
		
		//Assert
		
		assertNotNull(diaHabil);
		
	}
	
	@Test
	public void diaNoHabilParaPlacaQueIniciaPorA() {
		//Arrange
		Calendario calendario = new Calendario();
		
		//Act
		
		boolean diaHabil = calendario.esDiaHabilParaPlacaQueIniciaPorA();
		
		//Assert
		
		assertNotNull(diaHabil);
		
	}


}
