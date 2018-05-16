package co.com.parqueadero.servicio.imp;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.com.parqueadero.builder.ParqueaderoBuilder;
import co.com.parqueadero.dominio.Parqueadero;
import co.com.parqueadero.dominio.Vigilante;
import co.com.parqueadero.entidad.ParqueaderoEntidad;
import co.com.parqueadero.excepcion.ParqueaderoExcepcion;
import co.com.parqueadero.mensajes.Mensajes;
import co.com.parqueadero.repositorio.IVigilanteRepositorio;
import co.com.parqueadero.servicio.IVigilanteServicio;

@Service
@Transactional
public class VigilanteServicio implements IVigilanteServicio {
	
	@Autowired
	@Qualifier("IVigilanteRepositorio")
	IVigilanteRepositorio vigilanteRepositorio;
	@Autowired
	Vigilante vigilante;

	@Override
	public Optional<ParqueaderoEntidad> findById(Integer id) {
		return vigilanteRepositorio.findById(id);
	}

	public void save(ParqueaderoEntidad parqueaderoEntidad) {
		try {
			Parqueadero parqueadero = ParqueaderoBuilder.ensamblarDominio(parqueaderoEntidad);
			vigilante.setParqueadero(parqueadero);
			if (!vigilante.getParqueadero().getVehiculo().esCarro() && !vigilante.getParqueadero().getVehiculo().esMoto()) {
				throw new ParqueaderoExcepcion(Mensajes.MENSAJE_INGRESO_VEHICULO_DIFERENTE_A_CARRO_O_MOTO);
			} 
			if (vigilante.validarCeldasDisponibles()) {
				throw new ParqueaderoExcepcion(Mensajes.MENSAJE_PARQUEADERO_SIN_CELDAS_DISPONIBLES);
			}
			if(vigilante.validarIngreso()) {
				throw new ParqueaderoExcepcion(Mensajes.MENSAJE_INGRESO_NO_AUTORIZADO_POR_RESTRICCIONES_DEL_PARQUEADERO);
			}
			vigilanteRepositorio.save(parqueaderoEntidad);
		} catch (ParqueaderoExcepcion excepcion) {
			Logger.getLogger(excepcion.getMessage());
		}
		
	}

	@Override
	public void borrar(ParqueaderoEntidad parqueaderoEntidad) {
		vigilanteRepositorio.delete(parqueaderoEntidad);
		
	}

	@Override
	public void actualizar(ParqueaderoEntidad parqueaderoEntidad) {
		vigilanteRepositorio.save(parqueaderoEntidad);
		
	}

	@Override
	public List<ParqueaderoEntidad> listar() {
		return vigilanteRepositorio.findAll();
	}
	 

}
