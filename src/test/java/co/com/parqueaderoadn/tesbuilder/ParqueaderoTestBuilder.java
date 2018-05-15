package co.com.parqueaderoadn.tesbuilder;

import java.util.Date;

import co.com.parqueadero.dominio.Parqueadero;
import co.com.parqueadero.dominio.Vehiculo;

public class ParqueaderoTestBuilder {
	private Vehiculo vehiculo;
	private Date fechaIngreso;
	private Date fechaSalida;

	
	public ParqueaderoTestBuilder conVehiculo(Vehiculo vehiculo) {
		this.vehiculo=vehiculo;
		return this;
	}
	
	public ParqueaderoTestBuilder conFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso=fechaIngreso;
		return this;
	}
	
	public ParqueaderoTestBuilder conFechaSalida(Date fechaSalida) {
		this.fechaSalida=fechaSalida;
		return this;
	}
	
	public Parqueadero build() {
		return new Parqueadero(this.vehiculo, this.fechaIngreso, this.fechaSalida);
	}
	
}
