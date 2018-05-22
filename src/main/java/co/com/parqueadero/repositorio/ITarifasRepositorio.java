package co.com.parqueadero.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.parqueadero.entidad.TarifasEntidad;


@Repository("ITarifasRepositorio")
public interface ITarifasRepositorio extends JpaRepository<TarifasEntidad, Serializable> {

}
