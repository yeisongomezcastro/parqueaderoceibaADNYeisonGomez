package co.com.parqueadero.dominio;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class Reloj {
	private static final Integer MILI_SEGUNDOS = 1000 * 60 * 60;
	public Reloj(){}

	public Integer cantidadDiasHoras(Date fechaIngreso,Calendar calendar) {
		Date fechaSalida = calendar.getTime();
		return (int) ((fechaSalida.getTime() - fechaIngreso.getTime()) / MILI_SEGUNDOS);

	}

}
