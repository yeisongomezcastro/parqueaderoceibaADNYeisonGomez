package co.com.parqueadero.dominio;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service
public class Calendario {
	static final int NRO_DIA_DOMINGO_RESTRINGIDO = 1;
	static final int NRO_DIA_LUNES_RESTRINGIDO = 2;

	public boolean esDiaHabilParaPlacaQueIniciaPorA() {
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK) > 2;
	}

}
