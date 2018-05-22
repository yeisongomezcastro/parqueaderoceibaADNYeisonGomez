package co.com.parqueadero.mensajes;

public class Mensajes {
	private Mensajes() {
	}

	public static final String MENSAJE_INGRESO_NO_AUTORIZADO_POR_RESTRICCIONES_DEL_PARQUEADERO = "No puede ingresar al parqueadero,debido a restricciones del parqueadero";
	public static final String MENSAJE_PARQUEADERO_LLENO_CARROS = "No puede ingresar al parqueadero, no hay celdas disponibles para carros.";
	public static final String MENSAJE_PARQUEADERO_LLENO_MOTOS = "No puede ingresar al parqueadero, no hay celdas disponibles para motos.";
	public static final String MENSAJE_PARQUEADERO_SIN_CELDAS_DISPONIBLES = "No puede ingresar al parqueadero, no hay celdas disponibles para este vehiculo.";
	public static final String MENSAJE_INGRESO_VEHICULO_DIFERENTE_A_CARRO_O_MOTO = "Este tipo de vehiculo no puede ingresar al parqueadero.";
	public static final String MENSAJE_INGRESO_VEHICULO_CON_LA_MISMA_PLACA = "El vehiculo ya se encuentra dentro del parqueadero.";
	public static final String MENSAJE_NO_SE_ENCUENTRA_EL_VEHICULO_BUSCADO = "El vehiculo no se encuentra en el parqueadero, favor verificar.";
}
