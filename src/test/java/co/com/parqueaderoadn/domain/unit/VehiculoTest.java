package co.com.parqueaderoadn.domain.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import co.com.parqueadero.model.Vehiculo;

public class VehiculoTest {
	private static final String PLACA_VEHICULO_MOTO_O_CARRO = "AAA123";
	private static final String VEHICULO_MOTO = "Moto";
	private static final String VEHICULO_CARRO = "Carro";
	private static final Integer CILINDRAJE_VEHICULO_MOTO = 150;
	
	@Test
	public void validarVehiculoMotoTest() {
		//Arrange
		Vehiculo vehiculo = new Vehiculo(PLACA_VEHICULO_MOTO_O_CARRO,CILINDRAJE_VEHICULO_MOTO,VEHICULO_MOTO);
		
		//Act
		
		String tipoVehiculo = vehiculo.getTipoVehiculo();
		
		//Assert
		assertEquals(VEHICULO_MOTO,tipoVehiculo);
		
	}
	
	@Test
	public void validarVehiculoCarroTest() {
		//Arrange
		Vehiculo vehiculo = new Vehiculo(PLACA_VEHICULO_MOTO_O_CARRO,CILINDRAJE_VEHICULO_MOTO,VEHICULO_CARRO);
		
		//Act
		
		String tipoVehiculo = vehiculo.getTipoVehiculo();
		
		//Assert
		assertEquals(VEHICULO_CARRO,tipoVehiculo);
		
	}
	
	
	@Test
	public void validarCilindrajeTest() {
		//Arrange
		Vehiculo vehiculo = new Vehiculo(PLACA_VEHICULO_MOTO_O_CARRO,CILINDRAJE_VEHICULO_MOTO,VEHICULO_CARRO);
		
		//Act
		
		Integer cilindraje = vehiculo.getCilindraje();
		
		//Assert
		assertEquals(CILINDRAJE_VEHICULO_MOTO,cilindraje);
		
	}
	
	@Test
	public void validarPlacaTest() {
		//Arrange
		Vehiculo vehiculo = new Vehiculo(PLACA_VEHICULO_MOTO_O_CARRO,CILINDRAJE_VEHICULO_MOTO,VEHICULO_CARRO);
		
		//Act
		
		String placa = vehiculo.getPlaca();
		
		//Assert
		assertEquals(PLACA_VEHICULO_MOTO_O_CARRO,placa);
		
	}

}
