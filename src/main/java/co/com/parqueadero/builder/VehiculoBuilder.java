package co.com.parqueadero.builder;

import co.com.parqueadero.dominio.Vehiculo;
import co.com.parqueadero.entidad.VehiculoEntidad;

public class VehiculoBuilder {
	private VehiculoBuilder() {}
	
	public static Vehiculo ensamblarDominio(VehiculoEntidad vehiculoEntity) {
		Vehiculo vehiculo = null;
		if (vehiculoEntity!=null) {
			vehiculo = new Vehiculo(vehiculoEntity.getTipoVehiculo(), vehiculoEntity.getCilindraje(), vehiculoEntity.getPlaca());
		}
		return vehiculo;
	}
	
	public static VehiculoEntidad ensamblarEntidad(Vehiculo vehiculo) {
		VehiculoEntidad vehiculoEntity = null;
		if (vehiculo!=null) {
			vehiculoEntity = new VehiculoEntidad(vehiculo.getTipoVehiculo(),vehiculo.getCilindraje(),vehiculo.getPlaca());
		}
		return vehiculoEntity;
	}

}
