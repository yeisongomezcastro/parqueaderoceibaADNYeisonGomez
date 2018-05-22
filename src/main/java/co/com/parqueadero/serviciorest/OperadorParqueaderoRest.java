package co.com.parqueadero.serviciorest;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.parqueadero.entidad.MovimientoParqueaderoEntidad;
import co.com.parqueadero.excepcion.ParqueaderoExcepcion;
import co.com.parqueadero.model.Vehiculo;
import co.com.parqueadero.servicio.imp.OperadorServicio;

@CrossOrigin
@RestController
@RequestMapping("/servicio")
public class OperadorParqueaderoRest {
	@Autowired
	OperadorServicio vigilanteServicio;
	

	@RequestMapping("/buscarvehiculo/{placa}")
	public ResponseEntity<Object> buscarPorPlaca(@PathVariable("placa") String placa) {
		MovimientoParqueaderoEntidad movimientoParqueaderoEntidad;
		try {
			movimientoParqueaderoEntidad = vigilanteServicio.consultarVehiculoPorPlaca(placa);
		} catch (ParqueaderoExcepcion e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(movimientoParqueaderoEntidad, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/guardar")
	public ResponseEntity<Object> save(@RequestBody Vehiculo vehiculo) {
		try {
			vigilanteServicio.save(vehiculo);
		} catch (ParqueaderoExcepcion e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(vehiculo, HttpStatus.OK);

	}

	@Produces(MediaType.APPLICATION_JSON)
	@RequestMapping(method = RequestMethod.GET, value = "/listar")
	public ResponseEntity<Object> listar() {
		List<MovimientoParqueaderoEntidad> movimientoParqueadero;
		try {
			movimientoParqueadero = vigilanteServicio.listar();
		} catch (ParqueaderoExcepcion e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(movimientoParqueadero, HttpStatus.OK);
	}

}
