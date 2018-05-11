package co.com.parqueaderoadn.tesbuilder;

import co.com.parqueaderoadn.dominio.Vehiculo;

public class VehiculoTestBuilder {
	private Integer id;
	private String tipoVehiculo;
	private String cilindraje;
	private String placa;
	
	public VehiculoTestBuilder() {
		this.id=1;
		this.tipoVehiculo = "moto";
		this.cilindraje = "150cc";
		this.placa = "QKV15E";
	}
	
	public VehiculoTestBuilder conTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo=tipoVehiculo;
		return this;
	}
	
	public VehiculoTestBuilder conCilindraje(String cilindraje) {
		this.cilindraje=cilindraje;
		return this;
	}
	
	public VehiculoTestBuilder conPlaca(String placa) {
		this.placa=placa;
		return this;
	}
	
	
	public Vehiculo build() {
		return new Vehiculo(this.id,this.tipoVehiculo,this.cilindraje,this.placa);
	}

}