package co.com.parqueadero.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Tarifas")
public class TarifasEntidad {
	
	@Id
	@Column(nullable = false)
	private String id;
	
	@Column(nullable = false)
	private Integer tarifa;
	
	@Column(nullable = false)
	private String tipoTarifa;
	
	@Column(nullable = true)
	private Integer valorHora;
	
	@Column(nullable = true)
	private Integer valorDia;
	
	@Column(nullable = true)
	private Integer valorMes;
	
	@Column(nullable = true)
	private Integer recargo;

	public TarifasEntidad(Integer tarifa,String tipoTarifa, Integer valorHora, Integer valorDia, Integer valorMes, Integer recargo) {
		super();
		this.tarifa = tarifa;
		this.tipoTarifa = tipoTarifa;
		this.valorHora = valorHora;
		this.valorDia = valorDia;
		this.valorMes = valorMes;
		this.recargo = recargo;
	}
	
	public TarifasEntidad() {
	}

	public Integer getTarifa() {
		return tarifa;
	}
	
	public String getTipoTarifa() {
		return tipoTarifa;
	}

	public Integer getValorHora() {
		return valorHora;
	}

	public Integer getValorDia() {
		return valorDia;
	}

	public Integer getValorMes() {
		return valorMes;
	}

	public Integer getRecargo() {
		return recargo;
	}
	
}
