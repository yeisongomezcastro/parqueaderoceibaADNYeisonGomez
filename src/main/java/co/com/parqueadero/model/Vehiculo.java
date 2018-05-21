package co.com.parqueadero.model;

import org.springframework.stereotype.Service;

@Service
public class Vehiculo {
	private static final String CARRO = "Carro";
	private static final String MOTO = "Moto";
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
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Integer getCilindraje() {
		return cilindraje;
	}
	public void setCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
	}
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	public boolean inicialPlaca(String placa) { 
		return placa.startsWith("A") || placa.startsWith("a");
	}
	
	public boolean esMoto(String tipoVehiculo) {
		return MOTO.equalsIgnoreCase(tipoVehiculo);
	}
	
	public boolean esCarro(String tipoVehiculo) {
		return CARRO.equalsIgnoreCase(tipoVehiculo);
	}

}
