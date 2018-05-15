package co.com.parqueadero.dominio;

import java.time.LocalDateTime;

public class Calendario {
	static final int NRO_DIA_DOMINGO_RESTRINGIDO = 1;
	static final int NRO_DIA_LUNES_RESTRINGIDO = 2;
	
	private LocalDateTime fechaIngreso;

	public Calendario() {
		this.fechaIngreso = LocalDateTime.now();
	}

	public boolean esDiaHabilParaPlacaQueIniciaPorA() {
		return this.fechaIngreso.getDayOfWeek().getValue() > 2 ? true : false;
	}

}
