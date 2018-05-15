package co.com.parqueadero.dominio;

import java.util.Calendar;


public class Calendario {
	static final int NRO_DIA_DOMINGO_RESTRINGIDO = 1;
	static final int NRO_DIA_LUNES_RESTRINGIDO = 2;
	Calendar  calendar;
	
	public Calendario() {
		this.calendar = Calendar.getInstance();
	}

	public boolean esDiaHabilParaPlacaQueIniciaPorA() {
		return calendar.get(Calendar.DAY_OF_WEEK)  > 2;
	}

}
