package co.com.parqueaderoadn.serviciorest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.parqueaderoadn.entidad.VehiculoEntidad;
import co.com.parqueaderoadn.services.imp.VehiculoServicio;

@RestController
@RequestMapping("/servicio")
public class VehiculoRest {
	@Autowired
	VehiculoServicio vehiculoServicio;
	
	@RequestMapping("/buscar/{id}")
	public Optional<VehiculoEntidad> findById(@PathVariable("id") Integer id) {
		return vehiculoServicio.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value = "/guardar")
	public void save(@RequestBody VehiculoEntidad vehiculoEntidad) {
		 vehiculoServicio.save(vehiculoEntidad);
	}

}
