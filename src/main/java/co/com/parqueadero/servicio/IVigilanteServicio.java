package co.com.parqueadero.servicio;

import java.util.List;

import co.com.parqueadero.entidad.MovimientoParqueaderoEntidad;
import co.com.parqueadero.model.Vehiculo;

public interface IVigilanteServicio {

	public MovimientoParqueaderoEntidad registraSalidaVehiculo(String placa);
	public void registraringresoVehiculoParqueadero(Vehiculo vehiculo);
	public List<MovimientoParqueaderoEntidad> consultarVehiculosParqueados();

}
