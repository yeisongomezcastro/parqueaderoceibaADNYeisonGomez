package co.com.parqueaderoadn.services;

import java.util.Optional;

import co.com.parqueaderoadn.entidad.VehiculoEntidad;

public interface IVehiculoServicio {
	
	Optional<VehiculoEntidad> findById(Integer id);

}
