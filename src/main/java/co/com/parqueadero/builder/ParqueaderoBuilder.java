package co.com.parqueadero.builder;

import co.com.parqueadero.dominio.Parqueadero;
import co.com.parqueadero.entidad.ParqueaderoEntidad;


public class ParqueaderoBuilder {
	
	private ParqueaderoBuilder() {}
	
	public static Parqueadero ensamblarDominio(ParqueaderoEntidad parqueaderoEntidad) {
		Parqueadero parqueadero = null;
		if (parqueaderoEntidad!=null) {
			parqueadero = new Parqueadero(VehiculoBuilder.ensamblarDominio(parqueaderoEntidad.getVehiculoEntidad()), parqueaderoEntidad.getFechaIngreso(), parqueaderoEntidad.getFechaSalida());
		}
		return parqueadero;
	}
	
	public static ParqueaderoEntidad ensamblarEntidad(Parqueadero parqueadero) {
		ParqueaderoEntidad parqueaderoEntidad = null;
		if (parqueadero!=null) {
			parqueaderoEntidad = new ParqueaderoEntidad(VehiculoBuilder.ensamblarEntidad(parqueadero.getVehiculo()), parqueadero.getFechaIngreso(), parqueadero.getFechaSalida());
		}
		return parqueaderoEntidad;
	}

}
