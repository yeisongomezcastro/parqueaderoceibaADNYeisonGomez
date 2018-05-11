package co.com.parqueaderoadn.repositorio;


import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.parqueaderoadn.entidad.VehiculoEntidad;

@Repository("VehiculoRepositorio")
public interface VehiculoRepositorio extends JpaRepository<VehiculoEntidad, Serializable> {

}
