package co.com.parqueadero;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.parqueadero.entidad.EstadoParqueaderoEntidad;
import co.com.parqueadero.entidad.TarifasEntidad;
import co.com.parqueadero.repositorio.IEstadoParqueaderoEntidad;
import co.com.parqueadero.repositorio.ITarifasRepositorio;

@Service
@Transactional
public class InsertarTarifasEstado {
	@Autowired
	static ITarifasRepositorio tarifasRepositorio;
	@Autowired
	static IEstadoParqueaderoEntidad estadoParqueaderoEntidad;

	public static void init() {
		List<TarifasEntidad> tarifas= new ArrayList<>();
		tarifas.add(new TarifasEntidad(1,"Carros",1000,8000,0,0));
		tarifas.add(new TarifasEntidad(2,"Motos Cilindraje Menor a 500",500,4000,0,0));
		tarifas.add(new TarifasEntidad(2,"Motos Cilindraje Mayor a 500",500,4000,0,2000));
		tarifasRepositorio.saveAll(tarifas);
		List<EstadoParqueaderoEntidad> estado= new ArrayList<>();
		estado.add(new EstadoParqueaderoEntidad("Moto", "Cantidad dentro del parqueadero", 0));
		estado.add(new EstadoParqueaderoEntidad("Carro", "Cantidad dentro del parqueadero", 0));
		estadoParqueaderoEntidad.saveAll(estado);
	}

}
