package co.com.parqueadero.dominio;

import java.util.Date;

public class Reloj {
	private static final Integer MILI_SEGUNDOS = 1000*60*60;
	private Date fechaIngreso;
	private Date fechaSalida;
	
	public Reloj(Date fechaIngreso,Date fechaSalida) {
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}
	
	public Integer cantidadDiasHoras() {
		return (int) ((fechaSalida.getTime() - fechaIngreso.getTime())/MILI_SEGUNDOS);
		
	}

}
