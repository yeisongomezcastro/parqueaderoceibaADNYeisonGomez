package co.com.parqueadero.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Estado_Parqueadero")
public class EstadoParqueaderoEntidad {
	@Id
	@Column(nullable = false)
	private String id;

	@Column(nullable = false)
	private String tipoVehiculo;

	@Column(nullable = false)
	private String descripcion;

	@Column(nullable = true)
	private Integer valor;

	public EstadoParqueaderoEntidad() {
	}

	public EstadoParqueaderoEntidad(String tipoVehiculo, String descripcion, Integer valor) {
		super();
		this.tipoVehiculo = tipoVehiculo;
		this.descripcion = descripcion;
		this.valor = valor;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Integer getValor() {
		return valor;
	}
	
}
