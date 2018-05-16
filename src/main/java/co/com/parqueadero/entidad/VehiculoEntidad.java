package co.com.parqueadero.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Vehiculo")
public class VehiculoEntidad  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false)
	private String placa;
	
	@Column(nullable = false)
	private String tipoVehiculo;
	
	@Column(nullable = true)
	private Integer cilindraje;
	
	public VehiculoEntidad() {
	}
		
	public VehiculoEntidad(String tipoVehiculo, Integer cilindraje, String placa) {
		super();
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
		this.placa = placa;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	
	public Integer getCilindraje() {
		return cilindraje;
	}

	public String getPlaca() {
		return placa;
	}
}
