package co.com.parqueadero.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Parqueadero {
	private Vehiculo vehiculo;


	public Parqueadero() {	
	}
	@Autowired
	public Parqueadero(Vehiculo vehiculo) {
		super();
		this.vehiculo = vehiculo;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}
