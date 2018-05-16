package co.com.parqueaderoadn.tesbuilder;


import co.com.parqueadero.dominio.Parqueadero;
import co.com.parqueadero.dominio.Vehiculo;

public class ParqueaderoTestBuilder {
	private Vehiculo vehiculo;
	
	public ParqueaderoTestBuilder conVehiculo(Vehiculo vehiculo) {
		this.vehiculo=vehiculo;
		return this;
	}
	
	public Parqueadero build() {
		return new Parqueadero(this.vehiculo);
	}
	
}
