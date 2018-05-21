package co.com.parqueadero.servicio;

import java.util.List;

import co.com.parqueadero.entidad.MovimientoParqueaderoEntidad;
import co.com.parqueadero.model.Vehiculo;

public interface IOperadorServicio {

	public MovimientoParqueaderoEntidad consultarVehiculoPorPlaca(String placa);
	public void save(Vehiculo vehiculo);
	public void borrar(MovimientoParqueaderoEntidad parqueaderoEntidad);
	public void actualizar(MovimientoParqueaderoEntidad parqueaderoEntidad);
	public List<MovimientoParqueaderoEntidad> listar();

}
