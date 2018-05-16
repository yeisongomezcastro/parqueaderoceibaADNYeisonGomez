package co.com.parqueadero.servicio;

import java.util.List;
import java.util.Optional;

import co.com.parqueadero.entidad.ParqueaderoEntidad;

public interface IVigilanteServicio {

	public Optional<ParqueaderoEntidad> findById(Integer id);
	public void save(ParqueaderoEntidad parqueaderoEntidad);
	public void borrar(ParqueaderoEntidad parqueaderoEntidad);
	public void actualizar(ParqueaderoEntidad parqueaderoEntidad);
	public List<ParqueaderoEntidad> listar();

}
