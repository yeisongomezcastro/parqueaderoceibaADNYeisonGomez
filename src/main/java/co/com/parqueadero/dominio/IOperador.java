package co.com.parqueadero.dominio;

import java.util.Date;

public interface IOperador {

	public Integer cobrar(Date fechaIngreso,String tipoVehiculo);

	public Integer obtenerValorPago(Date fechaIngreso, Integer valorHora, Integer valorDia);

	public boolean validarIngreso(String placa);

	public boolean validarCeldasDisponibles(String tipoVehiculo) ;

	public boolean paqueaderoLleno(String tipoVehiculo);

}
