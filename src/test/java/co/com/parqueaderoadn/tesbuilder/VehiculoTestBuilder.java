package co.com.parqueaderoadn.tesbuilder;

import co.com.parqueadero.model.Vehiculo;

public class VehiculoTestBuilder {
	private String tipoVehiculo;
	private Integer cilindraje;
	private String placa;
	
	public VehiculoTestBuilder() {
		this.tipoVehiculo = "moto";
		this.cilindraje = 150;
		this.placa = "QKV15E";
	}
	
	public VehiculoTestBuilder conTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo=tipoVehiculo;
		return this;
	}
	
	public VehiculoTestBuilder conCilindraje(Integer cilindraje) {
		this.cilindraje=cilindraje;
		return this;
	}
	
	public VehiculoTestBuilder conPlaca(String placa) {
		this.placa=placa;
		return this;
	}
	
	
	public Vehiculo build() {
		return new Vehiculo(this.placa,this.cilindraje,this.tipoVehiculo);
	}

}
