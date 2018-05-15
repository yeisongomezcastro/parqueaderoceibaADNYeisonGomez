package co.com.parqueadero.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Vehiculo")
public class VehiculoEntidad  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	private String tipoVehiculo;
	
	@Column(nullable = true)
	private Integer cilindraje;
	
	@Column(nullable = false)
	private String placa;
	
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
