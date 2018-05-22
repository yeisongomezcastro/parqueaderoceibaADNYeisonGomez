package co.com.parqueadero.dominio.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.com.parqueadero.dao.IOperadorDAO;
import co.com.parqueadero.dominio.ICalendario;
import co.com.parqueadero.dominio.IOperador;
import co.com.parqueadero.dominio.IReloj;
import co.com.parqueadero.entidad.MovimientoParqueaderoEntidad;
import co.com.parqueadero.model.Vehiculo;

@Component
public class Operador implements IOperador {
	private static final int VALOR_DIA_CARRO = 8000;
	private static final int VALOR_HORA_CARRO = 1000;
	private static final int VALOR_DIA_MOTO = 4000;
	private static final int VALOR_HORA_MOTO = 500;
	private static final int MINIMA_HORA = 0;
	private static final int CILINDRAJE_QUE_PAGA_RECARGO = 500;
	private static final int VALOR_RECARGO_MOTO_CILINDRAJE_MAYOR_150CC = 2000;
	private static final int CANTIDAD_MAXIMA_CARROS_PERMITIDOS = 20;
	private static final int CANTIDAD_MAXIMA_MOTOS_PERMITIDOS = 10;

	@Qualifier
	private IOperadorDAO operadorDAO;
	private ICalendario calendario;
	private Vehiculo vehiculo;
	private IReloj reloj;

	@Autowired
	public Operador(ICalendario calendario, Vehiculo vehiculo, IReloj reloj,
			IOperadorDAO operadorDAO) {
		this.calendario = calendario;
		this.vehiculo = vehiculo;
		this.reloj = reloj;
		this.operadorDAO = operadorDAO;
	}
	public Operador() {
	}


	public Integer cobrar(Date fechaIngreso,String tipoVehiculo,Integer cilindraje) {
		Integer valorAPagar = 0;
		if (this.vehiculo.esMoto(tipoVehiculo)) {
			valorAPagar = obtenerValorPago(fechaIngreso, VALOR_HORA_MOTO, VALOR_DIA_MOTO);
			valorAPagar += cilindraje > CILINDRAJE_QUE_PAGA_RECARGO
					? VALOR_RECARGO_MOTO_CILINDRAJE_MAYOR_150CC
					: 0;
		}
		if (this.vehiculo.esCarro(tipoVehiculo)) {
			valorAPagar = obtenerValorPago(fechaIngreso, VALOR_HORA_CARRO, VALOR_DIA_CARRO);
		}
		return valorAPagar;
	}

	public Integer obtenerValorPago(Date fechaIngreso, Integer valorHora, Integer valorDia) {
		Integer valorMinutosServicio;
		Integer numeroDias;
		Integer numeroHoras;
		Integer numeroMinutos;
		Integer valorAPagar = 0;
		valorMinutosServicio = reloj.cantidadMinutos(fechaIngreso);
		numeroDias = (valorMinutosServicio / 60) / 24;
		numeroHoras = (valorMinutosServicio / 60) % 24;
		numeroMinutos = valorMinutosServicio % 60;
		if (numeroHoras > 9) {
			numeroDias++;
			numeroHoras = 0;
		}
		if(numeroMinutos>0) {
			numeroHoras++;
		}
		valorAPagar += (numeroDias * valorDia) + (numeroHoras  * valorHora);
		return valorAPagar;
	}

	public boolean validarIngreso(String placa) {
		return placaIniciaPorA(placa) && !calendario.esDiaHabilParaPlacaQueIniciaPorA();
	}

	private boolean placaIniciaPorA(String placa) {
		return vehiculo.inicialPlaca(placa);
	}

	public boolean validarCeldasDisponibles(String tipoVehiculo) {
		if (this.vehiculo.esCarro(tipoVehiculo)) {
			return this.paqueaderoLleno(tipoVehiculo);
		}
		if (this.vehiculo.esMoto(tipoVehiculo)) {
			return this.paqueaderoLleno(tipoVehiculo);
		}
		return true;
	}

	public boolean paqueaderoLleno(String tipoVehiculo) {
		Integer cantidaMaximaVehiculoPermitidoSegunTipo;
		List<MovimientoParqueaderoEntidad> estadoParqueadero;
		Integer cantidaVehiculos = 0;
		estadoParqueadero = operadorDAO.listar();
	
		for (MovimientoParqueaderoEntidad movimientoParqueaderoEntidad : estadoParqueadero) {
			if (tipoVehiculo.equalsIgnoreCase(movimientoParqueaderoEntidad.getTipoVehiculo()) && movimientoParqueaderoEntidad.getValorPago()==null) {
				cantidaVehiculos++;
			}
		}
		
		cantidaMaximaVehiculoPermitidoSegunTipo = "moto".equalsIgnoreCase(tipoVehiculo)
				? CANTIDAD_MAXIMA_MOTOS_PERMITIDOS
				: CANTIDAD_MAXIMA_CARROS_PERMITIDOS;
		return cantidaVehiculos >= cantidaMaximaVehiculoPermitidoSegunTipo;
	}

}
