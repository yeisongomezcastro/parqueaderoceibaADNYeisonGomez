package co.com.parqueadero.dominio.imp;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import co.com.parqueadero.dominio.IReloj;

@Service
@Component
public class Reloj implements IReloj {
	private static final Integer MILI_SEGUNDOS = 1000 * 60;
	public Integer cantidadMinutos(Date fechaIngreso) {
		Date fechaSalida = Calendar.getInstance().getTime();
		return (int) ((fechaSalida.getTime() - fechaIngreso.getTime()) / MILI_SEGUNDOS);

	}

}
