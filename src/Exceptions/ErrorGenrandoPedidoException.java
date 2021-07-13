package Exceptions;

public class ErrorGenrandoPedidoException extends Exception {

	public ErrorGenrandoPedidoException() {
		System.err.println("Cobertura no valida para el servicio que desea solicitar");
	}

	private static final long serialVersionUID = 1L;

}
