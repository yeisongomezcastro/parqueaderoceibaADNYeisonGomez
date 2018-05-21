package co.com.parqueadero.dominio.imp;

import java.util.Calendar;

import org.springframework.stereotype.Service;

import co.com.parqueadero.dominio.ICalendario;

@Service
public class Calendario implements ICalendario {
	static final int NRO_DIA_DOMINGO_RESTRINGIDO = 1;
	static final int NRO_DIA_LUNES_RESTRINGIDO = 2;

	public boolean esDiaHabilParaPlacaQueIniciaPorA() {
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK) > 2;
	}

}
