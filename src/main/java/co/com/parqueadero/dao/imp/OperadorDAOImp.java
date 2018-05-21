package co.com.parqueadero.dao.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.parqueadero.dao.IOperadorDAO;
import co.com.parqueadero.entidad.MovimientoParqueaderoEntidad;
import co.com.parqueadero.model.Vehiculo;
import co.com.parqueadero.repositorio.IOperadorRespositorio;

@Service
public class OperadorDAOImp implements IOperadorDAO {

	@Autowired 
	IOperadorRespositorio operadorRespositorio;
	
	@Override
	public void guardar(Vehiculo vehiculo) {
		MovimientoParqueaderoEntidad movimientoParqueaderoEntidad; 
		movimientoParqueaderoEntidad = new MovimientoParqueaderoEntidad(vehiculo.getPlaca(), vehiculo.getTipoVehiculo(), vehiculo.getCilindraje(),new Date());
		operadorRespositorio.save(movimientoParqueaderoEntidad);
		
	}

	@Override
	public List<MovimientoParqueaderoEntidad> listar() {
		return operadorRespositorio.findAll();
	}

	
	@Override
	public MovimientoParqueaderoEntidad consultarPorPlaca(String placa) {
		return operadorRespositorio.consultarVehiculoPorPlaca(placa);
	}

}
