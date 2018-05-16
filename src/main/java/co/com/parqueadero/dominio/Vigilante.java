package co.com.parqueadero.dominio;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.com.parqueadero.entidad.ParqueaderoEntidad;
import co.com.parqueadero.repositorio.IVigilanteRepositorio;

@Service
public class Vigilante {
	private static final int CILINDRAJE_QUE_PAGA_RECARGO = 500;
	private static final int VALOR_RECARGO_MOTO_CILINDRAJE_MAYOR_150CC = 2000;
	private static final String INICIAL_PLACA_RESTRINGIDA_PARA_INGRESO = "a";
	private static final int CANTIDAD_MAXIMA_CARROS_PERMITIDOS = 20;
	private static final int CANTIDAD_MAXIMA_MOTOS_PERMITIDOS = 10;
	

	@Qualifier
	private IVigilanteRepositorio vigilanteRepositorio;
	private Calendario calendario;
	private Parqueadero parqueadero;
	private Reloj reloj;
	
	@Autowired
	public Vigilante(Calendario calendario, Parqueadero parqueadero, Reloj reloj,IVigilanteRepositorio vigilanteRepositorio) {
		this.calendario = calendario;
		this.parqueadero = parqueadero;
		this.reloj = reloj;
		this.vigilanteRepositorio = vigilanteRepositorio;
	}


	public Calendario getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}

	public Parqueadero getParqueadero() {
		return parqueadero;
	}

	public void setParqueadero(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}

	public Reloj getReloj() {
		return reloj;
	}


	public void setReloj(Reloj reloj) {
		this.reloj = reloj;
	}


	public Integer cobrar() {
		Integer valorAPagar = 0;
		if (this.parqueadero.getVehiculo().esMoto()) {
			if (this.parqueadero.getVehiculo().getCilindraje() >= CILINDRAJE_QUE_PAGA_RECARGO) {
				valorAPagar += VALOR_RECARGO_MOTO_CILINDRAJE_MAYOR_150CC;
			}
			return 6000;
		}
		if (this.parqueadero.getVehiculo().esCarro()) {
			return 11000;
		}
		return valorAPagar;
	}

	public boolean validarIngreso() {
		return placaIniciaPorA() && !calendario.esDiaHabilParaPlacaQueIniciaPorA();
	}

	private boolean placaIniciaPorA() {
		return INICIAL_PLACA_RESTRINGIDA_PARA_INGRESO.equalsIgnoreCase(this.parqueadero.getVehiculo().inicialPlaca());
	}

	public boolean validarCeldasDisponibles() {
		String tipoVehiculo = parqueadero.getVehiculo().getTipoVehiculo();
		if (this.parqueadero.getVehiculo().esCarro()) {
			return this.paqueaderoLleno(tipoVehiculo);
		}
		if (this.parqueadero.getVehiculo().esMoto()) {
			return this.paqueaderoLleno(tipoVehiculo);
		}
		return true;
	}

	public boolean paqueaderoLleno(String tipoVehiculo) {
		Integer cantidaMaximaVehiculoPermitidoSegunTipo;
		List<ParqueaderoEntidad> estadoParqueadero;
		Integer cantidaVehiculos = 0;
		estadoParqueadero = vigilanteRepositorio.findAll();
		for (ParqueaderoEntidad parqueaderoEntidad : estadoParqueadero) {
			if(tipoVehiculo.equals(parqueaderoEntidad.getVehiculoEntidad().getTipoVehiculo())) {
				cantidaVehiculos++;
			}
		}
		cantidaMaximaVehiculoPermitidoSegunTipo =  "moto".equals(tipoVehiculo) ? CANTIDAD_MAXIMA_MOTOS_PERMITIDOS : CANTIDAD_MAXIMA_CARROS_PERMITIDOS;
		return cantidaVehiculos>=cantidaMaximaVehiculoPermitidoSegunTipo;
	}

}
