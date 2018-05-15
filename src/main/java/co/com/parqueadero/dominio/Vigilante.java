package co.com.parqueadero.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import co.com.parqueadero.excepcion.ParqueaderoExcepcion;
import co.com.parqueadero.mensajes.Mensajes;

public class Vigilante {
	private static final int CILINDRAJE_QUE_PAGA_RECARGO = 500;
	private static final int VALOR_RECARGO_MOTO_CILINDRAJE_MAYOR_150CC = 2000;
	private static final String INICIAL_PLACA_RESTRINGIDA_PARA_INGRESO = "a";
	private static final Integer VALOR_HORA_MOTO = 500;
	private static final Integer VALOR_HORA_CARRO = 1000;
	private static final Integer VALOR_DIA_MOTO = 500;
	private static final Integer VALOR_DIA_CARRO = 1000;
	
	private Calendario calendario;
	private Parqueadero parqueadero;

	@Autowired
	public Vigilante(Calendario calendario, Parqueadero parqueadero) {
		this.calendario = calendario;
		this.parqueadero = parqueadero;
	}

	public Calendario getCalendario() {
		return calendario;
	}


	public Parqueadero getParqueadero() {
		return parqueadero;
	}

	public Integer cobrar() {
		Integer valorAPagar=0;
		if (this.parqueadero.getVehiculo().esMoto()) {
			if(this.parqueadero.getVehiculo().getCilindraje()>=CILINDRAJE_QUE_PAGA_RECARGO) {
				valorAPagar+=VALOR_RECARGO_MOTO_CILINDRAJE_MAYOR_150CC;
			}
			return 6000;
		}
		if (this.parqueadero.getVehiculo().esCarro()) {
			return 11000;
		}
		return valorAPagar;
	}
	
	
	public void validarIngreso() {
		if (placaIniciaPorA() && !calendario.esDiaHabilParaPlacaQueIniciaPorA()) {
			throw new ParqueaderoExcepcion(Mensajes.MENSAJE_INGRESO_NO_AUTORIZADO);
		}
	}

	private boolean placaIniciaPorA() {
		return INICIAL_PLACA_RESTRINGIDA_PARA_INGRESO.equalsIgnoreCase(this.parqueadero.getVehiculo().inicialPlaca());
	}

	public boolean validarCeldasDisponibles() {
		if (this.parqueadero.getVehiculo().esCarro() && this.paqueaderoLleno()) {
			throw new ParqueaderoExcepcion(Mensajes.MENSAJE_PARQUEADERO_LLENO_CARROS);
		}
		if (this.parqueadero.getVehiculo().esMoto() && this.paqueaderoLleno()) {
			throw new ParqueaderoExcepcion(Mensajes.MENSAJE_PARQUEADERO_LLENO_MOTOS);
		}
		return true;
	}
	
	public boolean paqueaderoLleno() {
		return true;
	}

}
