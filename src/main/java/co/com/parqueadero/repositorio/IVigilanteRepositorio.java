package co.com.parqueadero.repositorio;


import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.parqueadero.entidad.ParqueaderoEntidad;
import co.com.parqueadero.entidad.VehiculoEntidad;

@Repository("IVigilanteRepositorio")
public interface IVigilanteRepositorio extends JpaRepository<ParqueaderoEntidad, Serializable> {
	
	@Query("select vehiculoEntidad from Parqueadero P where P.vehiculoEntidad.placa = :placa")
	VehiculoEntidad vehiculoParqueado(@Param("placa") String placa);
	
	@Query("From Parqueadero P where P.vehiculoEntidad.placa = :placa")
	ParqueaderoEntidad consultarVehiculoPorPlaca(@Param("placa") String placa);

}
