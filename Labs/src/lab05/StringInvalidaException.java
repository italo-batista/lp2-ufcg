package lab05;

public class StringInvalidaException extends EntradaException {

	public StringInvalidaException(String tipo) {
		super("Insira um "+ tipo +" valido.");
	}
	
	public StringInvalidaException() {
		super("Insira termos validos.");
	}
}