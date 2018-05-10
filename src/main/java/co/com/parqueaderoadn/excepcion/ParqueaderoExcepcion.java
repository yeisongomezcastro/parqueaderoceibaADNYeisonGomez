package co.com.parqueaderoadn.excepcion;

public class ParqueaderoExcepcion extends RuntimeException {
	

	private static final long serialVersionUID = 1L;

	public ParqueaderoExcepcion(String message) {
		super(message);
	}

}
