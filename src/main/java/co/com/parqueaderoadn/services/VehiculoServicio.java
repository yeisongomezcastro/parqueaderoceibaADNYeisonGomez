package co.com.parqueaderoadn.services;

import org.springframework.stereotype.Service;


@Service
public class VehiculoServicio {
	
	private static final String RETORNO = "Hola";

	public String welcome() {
		return  RETORNO;
	}

}
