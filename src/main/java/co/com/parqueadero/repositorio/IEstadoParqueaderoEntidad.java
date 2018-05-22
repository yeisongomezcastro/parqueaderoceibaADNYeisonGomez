package co.com.parqueadero.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.parqueadero.entidad.EstadoParqueaderoEntidad;


@Repository("IEstadoParqueaderoEntidad")
public interface IEstadoParqueaderoEntidad extends JpaRepository<EstadoParqueaderoEntidad, Serializable> {

}
