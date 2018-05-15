package co.com.parqueadero.repositorio;


import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.parqueadero.entidad.ParqueaderoEntidad;

@Repository("IVigilanteRepositorio")
public interface IVigilanteRepositorio extends JpaRepository<ParqueaderoEntidad, Serializable> {

}
