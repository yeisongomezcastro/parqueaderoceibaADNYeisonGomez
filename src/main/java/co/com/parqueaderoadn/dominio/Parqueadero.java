package co.com.parqueaderoadn.dominio;

import java.time.LocalDateTime;

import co.com.parqueaderoadn.excepcion.ParqueaderoExcepcion;
import co.com.parqueaderoadn.mensajes.Mensajes;

public class Parqueadero {
	private static final String INICIAL_PLACA_RESTRINGIDA = "a";
	private static final String CARRO = "carro";
	private static final String MOTO = "moto";

	private Vehiculo vehiculo;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;

	public Parqueadero() {
		super();
	}

	public Parqueadero(Vehiculo vehiculo, LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
		super();
		this.vehiculo = vehiculo;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}

	public double cobrar() {
		if (esMoto()) {
			return 6.000;
		}
		if (esCarro()) {
			return 11.000;
		}
		return 0;
	}

	private boolean esMoto() {
		return MOTO.equalsIgnoreCase(this.getVehiculo().getTipoVehiculo());
	}

	private boolean esCarro() {
		return CARRO.equalsIgnoreCase(this.getVehiculo().getTipoVehiculo());
	}

	public boolean validarIngreso() {
		if (INICIAL_PLACA_RESTRINGIDA.equalsIgnoreCase(obtenerInicialPlaca())) {
			int diaSemana = this.fechaIngreso.getDayOfWeek().ordinal();
			if (diaSemana == 0 || diaSemana == 6) {
				return true;
			} else {
				throw new ParqueaderoExcepcion(Mensajes.INGRESO_NO_AUTORIZADO);
			}
		}
		return true;
	}

	private String obtenerInicialPlaca() {
		return this.getVehiculo().getPlaca().substring(0, 1);
	}

	public boolean validarCeldasDisponibles() {
		if (esCarro() && paqueaderoLleno()) {
			throw new ParqueaderoExcepcion(Mensajes.PARQUEADERO_LLENO_CARROS);
		}
		if (esMoto() && paqueaderoLleno()) {
			throw new ParqueaderoExcepcion(Mensajes.PARQUEADERO_LLENO_MOTOS);
		}
		return true;
	}
	

	public boolean paqueaderoLleno() {
		return true;
	}

	public Vehiculo getVehiculo() {
		if (vehiculo == null) {
			vehiculo = new Vehiculo();
		}
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

}
