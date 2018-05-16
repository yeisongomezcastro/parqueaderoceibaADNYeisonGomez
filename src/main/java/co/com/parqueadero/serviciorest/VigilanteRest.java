package co.com.parqueadero.serviciorest;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.parqueadero.entidad.ParqueaderoEntidad;
import co.com.parqueadero.entidad.VehiculoEntidad;
import co.com.parqueadero.excepcion.ParqueaderoExcepcion;
import co.com.parqueadero.servicio.imp.VigilanteServicio;

@RestController
@RequestMapping("/servicio")
public class VigilanteRest {
	@Autowired
	VigilanteServicio vigilanteServicio;
	
	@RequestMapping("/buscar/{id}")
	public Optional<ParqueaderoEntidad> findById(@PathVariable("id") Integer id) {
		try {
			return vigilanteServicio.findById(id);
		} catch (ParqueaderoExcepcion e) {
			throw new ParqueaderoExcepcion(e.getMessage());
		}
		
	}
	
	@RequestMapping("/buscarvehiculo/{placa}")
	public ParqueaderoEntidad findById(@PathVariable("placa") String placa) {
		return vigilanteServicio.consultarVehiculoPorPlaca(placa);
	}
	
	@RequestMapping(method=RequestMethod.POST,value = "/guardar")
	public ResponseEntity<String> save(@RequestBody VehiculoEntidad vehiculoEntidad) {
		try {
			ParqueaderoEntidad parqueaderoEntidad;
			Calendar calendar = Calendar.getInstance();
			parqueaderoEntidad = new ParqueaderoEntidad(vehiculoEntidad,calendar.getTime(),null);
			vigilanteServicio.save(parqueaderoEntidad);
			} catch (ParqueaderoExcepcion  e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
			}
			return new ResponseEntity<>("Se realizo el ingreso del vehiculo",HttpStatus.OK);
		
		
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@RequestMapping(method=RequestMethod.GET,value = "/listar")
	public List<ParqueaderoEntidad> listar() {
		return vigilanteServicio.listar();
	}

}
