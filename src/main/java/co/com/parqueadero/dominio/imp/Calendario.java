package co.com.parqueadero.dominio.imp;

import java.util.Calendar;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import co.com.parqueadero.dominio.ICalendario;

@Service
@Component
public class Calendario implements ICalendario {
	public boolean esDiaHabilParaPlacaQueIniciaPorA() {
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK) > 2;
	}

}
