package co.com.parqueadero.integracion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.parqueadero.entidad.MovimientoParqueaderoEntidad;
import co.com.parqueadero.model.Vehiculo;
import co.com.parqueaderoadn.tesbuilder.VehiculoTestBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OperadorServices {
	
	private static final String TIPO_VEHICULO = "Moto";

	private static final int CILINDRAJE = 180;

	private static final String PLACA = "XCD123";

	private TestRestTemplate restTemplate = new TestRestTemplate();

	@LocalServerPort
	private int localServerPort; 

	@Test
	public void registrarIngreso() {
	Vehiculo vehiculo = new VehiculoTestBuilder().conPlaca(PLACA).conCilindraje(CILINDRAJE).conTipoVehiculo(TIPO_VEHICULO).build();
	ResponseEntity<MovimientoParqueaderoEntidad> movimientoParqueaderoEntidad = restTemplate.postForEntity("http://localhost:"+localServerPort+"/servicio/guardar", vehiculo,MovimientoParqueaderoEntidad.class);
	System.out.println("puerto" + localServerPort);
	assertEquals(HttpStatus.OK, movimientoParqueaderoEntidad.getStatusCode());
	}
	
	

}



