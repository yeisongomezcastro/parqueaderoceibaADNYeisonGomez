package co.com.parqueadero.dominio;



public class Vehiculo {
	private static final String CARRO = "carro";
	private static final String MOTO = "moto";
	private String placa;
	private Integer cilindraje;
	private String tipoVehiculo;

	
	public Vehiculo() {
		
	}
	public Vehiculo(String placa, Integer cilindraje, String tipoVehiculo) {
		super();
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public Integer getCilindraje() {
		return cilindraje;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	
	public String inicialPlaca() {
		return this.getPlaca().substring(0,1);
	}
	
	public boolean esMoto() {
		return MOTO.equalsIgnoreCase(this.getTipoVehiculo());
	}
	
	public boolean esCarro() {
		return CARRO.equalsIgnoreCase(this.getTipoVehiculo());
	}

}
