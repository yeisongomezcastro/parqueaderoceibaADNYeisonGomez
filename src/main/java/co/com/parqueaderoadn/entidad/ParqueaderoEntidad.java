package co.com.parqueaderoadn.entidad;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Parqueadero")
public class ParqueaderoEntidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String vehiculo;
	
	@Column(nullable = false)
	private String carro;
	
	

}
