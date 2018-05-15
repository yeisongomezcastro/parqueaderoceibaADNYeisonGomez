package co.com.parqueadero.serviciorest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.parqueadero.entidad.ParqueaderoEntidad;
import co.com.parqueadero.entidad.VehiculoEntidad;
import co.com.parqueadero.servicio.imp.VigilanteServicio;

@RestController
@RequestMapping("/servicio")
public class VigilanteRest {
	@Autowired
	VigilanteServicio vigilanteServicio;
	
	@RequestMapping("/buscar/{id}")
	public Optional<ParqueaderoEntidad> findById(@PathVariable("id") Integer id) {
		return vigilanteServicio.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value = "/guardar")
	public void save(@RequestBody VehiculoEntidad vehiculoEntidad) {
		ParqueaderoEntidad parqueaderoEntidad;
		parqueaderoEntidad = new ParqueaderoEntidad(vehiculoEntidad,LocalDateTime.now(),LocalDateTime.now());
		vigilanteServicio.save(parqueaderoEntidad);
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@RequestMapping(method=RequestMethod.GET,value = "/listar")
	public List<ParqueaderoEntidad> listar() {
		return vigilanteServicio.listar();
	}

}
