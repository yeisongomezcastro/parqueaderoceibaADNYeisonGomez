package co.com.parqueadero.dao;


import java.util.List;

import co.com.parqueadero.entidad.MovimientoParqueaderoEntidad;
import co.com.parqueadero.model.Vehiculo;




public interface IVigilanteDAO {

	public void registraringresoVehiculoParqueadero(Vehiculo vehiculo);
	
	public  List<MovimientoParqueaderoEntidad> consultarVehiculosParqueados();
	
	public MovimientoParqueaderoEntidad registraSalidaVehiculo(String placa);

}
