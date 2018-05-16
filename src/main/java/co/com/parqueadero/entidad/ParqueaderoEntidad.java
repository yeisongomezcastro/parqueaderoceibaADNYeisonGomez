package co.com.parqueadero.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Parqueadero")
public class ParqueaderoEntidad  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL,targetEntity=VehiculoEntidad.class)
	@JoinColumn(name = "ID_VEHICULO", referencedColumnName = "placa")
	private VehiculoEntidad vehiculoEntidad;

	@Column(nullable = false)
	private Date fechaIngreso;

	@Column(nullable = true)
	private Date fechaSalida;

	public ParqueaderoEntidad() {

	}

	public ParqueaderoEntidad(VehiculoEntidad vehiculoEntidad, Date fechaIngreso, Date fechaSalida) {
		super();
		this.vehiculoEntidad = vehiculoEntidad;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}

	public VehiculoEntidad getVehiculoEntidad() {
		return vehiculoEntidad;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

}
