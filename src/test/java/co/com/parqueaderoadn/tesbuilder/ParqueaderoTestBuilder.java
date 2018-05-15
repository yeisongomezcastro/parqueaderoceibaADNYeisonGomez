package co.com.parqueaderoadn.tesbuilder;

import java.time.LocalDateTime;

import co.com.parqueadero.dominio.Parqueadero;
import co.com.parqueadero.dominio.Vehiculo;

public class ParqueaderoTestBuilder {
	private Vehiculo vehiculo;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;

	
	public ParqueaderoTestBuilder conVehiculo(Vehiculo vehiculo) {
		this.vehiculo=vehiculo;
		return this;
	}
	
	public ParqueaderoTestBuilder conFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso=fechaIngreso;
		return this;
	}
	
	public ParqueaderoTestBuilder conFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida=fechaSalida;
		return this;
	}
	
	public Parqueadero build() {
		return new Parqueadero(this.vehiculo, this.fechaIngreso, this.fechaSalida);
	}
	
}
