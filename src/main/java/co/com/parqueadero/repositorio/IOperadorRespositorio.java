package co.com.parqueadero.repositorio;


import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.parqueadero.entidad.MovimientoParqueaderoEntidad;


@Repository("IOperadorRespositorio")
public interface IOperadorRespositorio extends JpaRepository<MovimientoParqueaderoEntidad, Serializable> {
	
	@Query("From Movimiento_Parqueadero P where P.placa = :placa")
	MovimientoParqueaderoEntidad vehiculoParqueado(@Param("placa") String placa);
	
	@Query("From Movimiento_Parqueadero P where P.placa = :placa")
	MovimientoParqueaderoEntidad consultarVehiculoPorPlaca(@Param("placa") String placa);
	
}
