package co.com.parqueaderoadn.builder;

import co.com.parqueaderoadn.dominio.Vehiculo;
import co.com.parqueaderoadn.entidad.VehiculoEntidad;

public class VehiculoBuilder {
	private VehiculoBuilder() {}
	
	public static Vehiculo ensamblarDominio(VehiculoEntidad vehiculoEntity) {
		Vehiculo vehiculo = null;
		if (vehiculoEntity!=null) {
			vehiculo = new Vehiculo(vehiculoEntity.getId(),vehiculoEntity.getTipoVehiculo(), vehiculoEntity.getCilindraje(), vehiculoEntity.getPlaca());
		}
		return vehiculo;
	}
	
	public static VehiculoEntidad ensamblarEntidad(Vehiculo vehiculo) {
		VehiculoEntidad vehiculoEntity = null;
		if (vehiculo!=null) {
			vehiculoEntity = new VehiculoEntidad();
			vehiculoEntity.setId(vehiculo.getId());
			vehiculoEntity.setTipoVehiculo(vehiculo.getTipoVehiculo());
			vehiculoEntity.setCilindraje(vehiculo.getCilindraje());
			vehiculoEntity.setPlaca(vehiculo.getPlaca());
		}
		
		return vehiculoEntity;
	}

}
