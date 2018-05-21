package co.com.parqueadero.servicio.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.com.parqueadero.dao.IOperadorDAO;
import co.com.parqueadero.dominio.IOperador;
import co.com.parqueadero.entidad.MovimientoParqueaderoEntidad;
import co.com.parqueadero.excepcion.ParqueaderoExcepcion;
import co.com.parqueadero.mensajes.Mensajes;
import co.com.parqueadero.model.Vehiculo;
import co.com.parqueadero.repositorio.IOperadorRespositorio;
import co.com.parqueadero.servicio.IOperadorServicio;

@Service
@Transactional
public class OperadorServicio implements IOperadorServicio {
	
	@Autowired
	@Qualifier("IOperadorRespositorio")
	IOperadorRespositorio vigilanteRepositorio;
	@Autowired
	IOperador operador;
	@Autowired
	Vehiculo vehiculo;
	@Autowired
	IOperadorDAO operadorDAO;

	public MovimientoParqueaderoEntidad consultarVehiculoPorPlaca(String placa) {
		return vigilanteRepositorio.consultarVehiculoPorPlaca(placa);
	}

	public void save(Vehiculo vehiculo) {
		try {
			if(vigilanteRepositorio.vehiculoParqueado(vehiculo.getPlaca()) != null) {
				throw new ParqueaderoExcepcion(Mensajes.MENSAJE_INGRESO_VEHICULO_CON_LA_MISMA_PLACA);
			}
			if (!vehiculo.esCarro(vehiculo.getTipoVehiculo()) && !vehiculo.esMoto(vehiculo.getTipoVehiculo())) {
				throw new ParqueaderoExcepcion(Mensajes.MENSAJE_INGRESO_VEHICULO_DIFERENTE_A_CARRO_O_MOTO);
			} 
			if (operador.validarCeldasDisponibles(vehiculo.getTipoVehiculo())) {
				throw new ParqueaderoExcepcion(Mensajes.MENSAJE_PARQUEADERO_SIN_CELDAS_DISPONIBLES);
			}
			if(operador.validarIngreso(vehiculo.getPlaca())) {
				throw new ParqueaderoExcepcion(Mensajes.MENSAJE_INGRESO_NO_AUTORIZADO_POR_RESTRICCIONES_DEL_PARQUEADERO);
			}
			operadorDAO.guardar(vehiculo);
		} catch (ParqueaderoExcepcion excepcion) {
			throw new ParqueaderoExcepcion(excepcion.getMessage());
		}
		
	}

	@Override
	public void borrar(MovimientoParqueaderoEntidad parqueaderoEntidad) {
		vigilanteRepositorio.delete(parqueaderoEntidad);
		
	}

	@Override
	public void actualizar(MovimientoParqueaderoEntidad parqueaderoEntidad) {
		vigilanteRepositorio.save(parqueaderoEntidad);
		
	}

	@Override
	public List<MovimientoParqueaderoEntidad> listar() {
		return operadorDAO.listar();
	}

	 

}
