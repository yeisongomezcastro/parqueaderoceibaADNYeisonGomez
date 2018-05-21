package co.com.parqueadero.dao;


import java.util.List;

import co.com.parqueadero.entidad.MovimientoParqueaderoEntidad;
import co.com.parqueadero.model.Vehiculo;




public interface IOperadorDAO {

	public void guardar(Vehiculo vehiculo);
	
	public  List<MovimientoParqueaderoEntidad> listar();
	
	public MovimientoParqueaderoEntidad consultarPorPlaca(String placa);

}
