package co.com.parqueadero.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Movimiento_Parqueadero")
public class MovimientoParqueaderoEntidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private String placa;

	@Column(nullable = false)
	private String tipoVehiculo;

	@Column(nullable = true)
	private Integer cilindraje;

	@Column(nullable = false)
	private Date fechaIngreso;

	@Column(nullable = true)
	private Date fechaSalida;

	@Column(nullable = true)
	private Integer valorPago;

	public MovimientoParqueaderoEntidad() {
	}

	public MovimientoParqueaderoEntidad(String placa, String tipoVehiculo, Integer cilindraje, Date fechaIngreso) {
		super();
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
		this.fechaIngreso = fechaIngreso;
	}

	public String getPlaca() {
		return placa;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public Integer getCilindraje() {
		return cilindraje;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public Integer getValorPago() {
		return valorPago;
	}
	
	public MovimientoParqueaderoEntidad setFechaSalida(Date fechaSalida) {
		this.fechaSalida=fechaSalida;
		return this;
	}
	
	public MovimientoParqueaderoEntidad setValorPago(Integer valorPago) {
		this.valorPago=valorPago;
		return this;
	}

}
