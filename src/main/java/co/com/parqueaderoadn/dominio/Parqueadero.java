package co.com.parqueaderoadn.dominio;

import co.com.parqueaderoadn.enumerador.Mensajes;
import co.com.parqueaderoadn.excepcion.ParqueaderoExcepcion;

public class Parqueadero {

	public double cobrar(Vehiculo vehiculo) {
		if (esMoto(vehiculo)) {
			return 6.000;
		}
		if (esCarro(vehiculo)) {
			return 11.000;
		}
		return 0;
	}

	private boolean esMoto(Vehiculo vehiculo) {
		return "moto".equalsIgnoreCase(vehiculo.getTipoVehiculo());
	}

	private boolean esCarro(Vehiculo vehiculo) {
		return "carro".equalsIgnoreCase(vehiculo.getTipoVehiculo());
	}

	public boolean validarIngreso(Vehiculo vehiculo) {
		if ("a".equalsIgnoreCase(vehiculo.getPlaca().substring(0, 1))) {
			throw new ParqueaderoExcepcion(Mensajes.INGRESO_NO_AUTORIZADO);
		} else {
			return true;
		}

	}

	public boolean validarCeldasDisponibles(Vehiculo vehiculo) {
		if (esCarro(vehiculo) && paqueaderoLleno()) {
			throw new ParqueaderoExcepcion(Mensajes.PARQUEADERO_LLENO_CARROS);
		}
		if  (esMoto(vehiculo) && paqueaderoLleno()) {
			throw new ParqueaderoExcepcion(Mensajes.PARQUEADERO_LLENO_MOTOS);
		}
		return true;
	}

	public boolean paqueaderoLleno() {
		return true;
	}

}
