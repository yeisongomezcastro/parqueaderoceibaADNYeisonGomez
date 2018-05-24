package co.com.parqueadero.servicio.imp;

import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.com.parqueadero.dao.IVigilanteDAO;
import co.com.parqueadero.dominio.IVigilante;
import co.com.parqueadero.entidad.MovimientoParqueaderoEntidad;
import co.com.parqueadero.excepcion.ParqueaderoExcepcion;
import co.com.parqueadero.mensajes.Mensajes;
import co.com.parqueadero.model.Vehiculo;
import co.com.parqueadero.repositorio.IVigilanteRespositorio;
import co.com.parqueadero.servicio.IVigilanteServicio;

@Service
@Transactional
public class VigilanteServicio implements IVigilanteServicio {

	@Autowired
	@Qualifier("IOperadorRespositorio")
	IVigilanteRespositorio vigilanteRepositorio;
	@Autowired
	IVigilante vigilante;
	@Autowired
	Vehiculo vehiculo;
	@Autowired
	IVigilanteDAO vigilanteDAO;

	public MovimientoParqueaderoEntidad registraSalidaVehiculo(String placa) {
		try {
			Calendar calendar = Calendar.getInstance();
			MovimientoParqueaderoEntidad mvtoParEnt;
			mvtoParEnt = vigilanteDAO.registraSalidaVehiculo(placa);
			if (mvtoParEnt == null) {
				throw new ParqueaderoExcepcion(Mensajes.MENSAJE_NO_SE_ENCUENTRA_EL_VEHICULO_BUSCADO);
			}
			mvtoParEnt.setFechaSalida(calendar.getTime());
			mvtoParEnt.setValorPago(vigilante.cobrar(mvtoParEnt.getFechaIngreso(), mvtoParEnt.getTipoVehiculo(),
					mvtoParEnt.getCilindraje()));
			return mvtoParEnt;
		} catch (ParqueaderoExcepcion excepcion) {
			throw new ParqueaderoExcepcion(excepcion.getMessage());
		}
	}

	public void registraringresoVehiculoParqueadero(Vehiculo vehiculo) {
		try {
			if (vigilanteRepositorio.vehiculoParqueado(vehiculo.getPlaca()) != null) {
				throw new ParqueaderoExcepcion(Mensajes.MENSAJE_INGRESO_VEHICULO_CON_LA_MISMA_PLACA);
			}
			if (!vehiculo.esCarro(vehiculo.getTipoVehiculo()) && !vehiculo.esMoto(vehiculo.getTipoVehiculo())) {
				throw new ParqueaderoExcepcion(Mensajes.MENSAJE_INGRESO_VEHICULO_DIFERENTE_A_CARRO_O_MOTO);
			}
			if (vigilante.validarCeldasDisponibles(vehiculo.getTipoVehiculo())) {
				throw new ParqueaderoExcepcion(Mensajes.MENSAJE_PARQUEADERO_SIN_CELDAS_DISPONIBLES);
			}
			if (vigilante.validarIngreso(vehiculo.getPlaca())) {
				throw new ParqueaderoExcepcion(
						Mensajes.MENSAJE_INGRESO_NO_AUTORIZADO_POR_RESTRICCIONES_DEL_PARQUEADERO);
			}
			vigilanteDAO.registraringresoVehiculoParqueadero(vehiculo);
		} catch (ParqueaderoExcepcion excepcion) {
			throw new ParqueaderoExcepcion(excepcion.getMessage());
		}

	}

	@Override
	public List<MovimientoParqueaderoEntidad> consultarVehiculosParqueados() {
		List<MovimientoParqueaderoEntidad> movimientoParqueadero;
		try {
			movimientoParqueadero = vigilanteDAO.consultarVehiculosParqueados();
			if (movimientoParqueadero.isEmpty()) {
				throw new ParqueaderoExcepcion(Mensajes.MENSAJE_PARQUEADERO_SIN_VEHICULOS);
			}
			return movimientoParqueadero;
		} catch (ParqueaderoExcepcion excepcion) {
			throw new ParqueaderoExcepcion(excepcion.getMessage());
		}
	}

}
