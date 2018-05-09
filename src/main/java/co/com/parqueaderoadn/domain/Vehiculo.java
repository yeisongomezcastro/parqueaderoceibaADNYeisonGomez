package co.com.parqueaderoadn.domain;

public class Vehiculo {
	private String tipoVehiculo;
	private String cilindraje;
	private String placa;
	
	
	public Vehiculo() {
		super();
	}
	
	
	public Vehiculo(String tipoVehiculo, String cilindraje, String placa) {
		super();
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
		this.placa = placa;
	}
	
	
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	public String getCilindraje() {
		return cilindraje;
	}
	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	

}
