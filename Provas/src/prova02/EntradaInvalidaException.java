package prova02;

public class EntradaInvalidaException extends Exception {

	public EntradaInvalidaException(String msg) {
		super(msg);
	}
	
	public EntradaInvalidaException() {
		super("Entrada invalida.");
	}
	
	
	
}
