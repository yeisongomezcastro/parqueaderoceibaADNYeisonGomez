package co.com.parqueaderoadn.services.imp;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.com.parqueaderoadn.entidad.VehiculoEntidad;
import co.com.parqueaderoadn.repositorio.VehiculoRepositorio;
import co.com.parqueaderoadn.services.IVehiculoServicio;

@Service
public class VehiculoServicio implements IVehiculoServicio {
	
	@Autowired
	@Qualifier("VehiculoRepositorio")
	VehiculoRepositorio vehiculoRepositorio;

	@Override
	public Optional<VehiculoEntidad> findById(Integer id) {
		return vehiculoRepositorio.findById(id);
	}

	public void save(VehiculoEntidad vehiculoEntidad) {
		 vehiculoRepositorio.save(vehiculoEntidad);
	}

}
