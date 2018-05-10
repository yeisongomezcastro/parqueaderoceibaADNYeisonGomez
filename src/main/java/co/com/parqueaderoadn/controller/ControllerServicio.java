package co.com.parqueaderoadn.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.parqueaderoadn.services.VehiculoServicio;

@RestController
public class ControllerServicio {
	@Autowired
	private VehiculoServicio vehiculoServices;
	
	public ControllerServicio(VehiculoServicio vehiculoServices) {
		this.vehiculoServices=vehiculoServices;
	}
	
	@GET
	@RequestMapping(value ="/saludar")
	@Produces(MediaType.APPLICATION_JSON)
	public String saludar() {
		return vehiculoServices.welcome();
	}
	

}
