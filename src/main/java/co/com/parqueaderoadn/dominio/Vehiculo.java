package co.com.parqueaderoadn.dominio;

public class Vehiculo {
	private Integer id;
	private String tipoVehiculo;
	private String cilindraje;
	private String placa;
	
	
	public Vehiculo() {
		super();
	}
	
	
	public Vehiculo(Integer id,String tipoVehiculo, String cilindraje, String placa) {
		super();
		this.id=id;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
		this.placa = placa;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
