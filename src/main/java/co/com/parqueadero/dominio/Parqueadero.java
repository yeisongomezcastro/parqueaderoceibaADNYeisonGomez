package co.com.parqueadero.dominio;

import java.util.Date;

public class Parqueadero {
	private Vehiculo vehiculo;
	private Date fechaIngreso;
	private Date fechaSalida;

	public Parqueadero(Vehiculo vehiculo, Date fechaIngreso, Date fechaSalida) {
		super();
		this.vehiculo = vehiculo;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}


}
