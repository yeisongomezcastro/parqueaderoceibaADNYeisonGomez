package co.com.parqueadero.entidad;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Parqueadero")
public class ParqueaderoEntidad  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "ID_VEHICULO", referencedColumnName = "placa")
	private VehiculoEntidad vehiculoEntidad;

	@Column(nullable = false)
	private LocalDateTime fechaIngreso;

	@Column(nullable = false)
	private LocalDateTime fechaSalida;

	public ParqueaderoEntidad() {

	}

	public ParqueaderoEntidad(VehiculoEntidad vehiculoEntidad, LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
		super();
		this.vehiculoEntidad = vehiculoEntidad;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}

	public VehiculoEntidad getVehiculoEntidad() {
		return vehiculoEntidad;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

}
