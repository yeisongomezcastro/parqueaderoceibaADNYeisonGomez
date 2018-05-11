package co.com.parqueaderoadn.dominio;

public class Tarifa {
	
	private String tipoVehiculo;
	private double valorHora;
	private double valorDia;

	public Tarifa() {
		super();
	}
	
	public Tarifa(String tipoVehiculo, double valorHora, double valorDia) {
		super();
		this.tipoVehiculo = tipoVehiculo;
		this.valorHora = valorHora;
		this.valorDia = valorDia;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public double getValorDia() {
		return valorDia;
	}

	public void setValorDia(double valorDia) {
		this.valorDia = valorDia;
	}
}
