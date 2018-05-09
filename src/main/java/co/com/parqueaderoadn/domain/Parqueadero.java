package co.com.parqueaderoadn.domain;

public class Parqueadero {

	public double cobrar(Vehiculo vehiculo){
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

}
