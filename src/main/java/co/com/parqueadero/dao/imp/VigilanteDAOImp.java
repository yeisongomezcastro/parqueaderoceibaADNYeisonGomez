package co.com.parqueadero.dao.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.parqueadero.dao.IVigilanteDAO;
import co.com.parqueadero.entidad.MovimientoParqueaderoEntidad;
import co.com.parqueadero.model.Vehiculo;
import co.com.parqueadero.repositorio.IVigilanteRespositorio;

@Service
public class VigilanteDAOImp implements IVigilanteDAO {

	@Autowired 
	IVigilanteRespositorio vigilanteRespositorio;
	
	@Override
	public void registraringresoVehiculoParqueadero(Vehiculo vehiculo) {
		MovimientoParqueaderoEntidad movimientoParqueaderoEntidad; 
		movimientoParqueaderoEntidad = new MovimientoParqueaderoEntidad(vehiculo.getPlaca(), vehiculo.getTipoVehiculo(), vehiculo.getCilindraje(),new Date());
		vigilanteRespositorio.save(movimientoParqueaderoEntidad);
		
	}

	@Override
	public List<MovimientoParqueaderoEntidad> consultarVehiculosParqueados() {
		return vigilanteRespositorio.consultarVehiculosParqueados();
	}

	
	@Override
	public MovimientoParqueaderoEntidad registraSalidaVehiculo(String placa) {
		return vigilanteRespositorio.consultarVehiculoPorPlaca(placa);
	}

}
