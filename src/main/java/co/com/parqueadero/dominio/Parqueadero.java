package co.com.parqueadero.dominio;

import java.time.LocalDateTime;

public class Parqueadero {
	private Vehiculo vehiculo;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;

	public Parqueadero(Vehiculo vehiculo, LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
		super();
		this.vehiculo = vehiculo;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}


}
