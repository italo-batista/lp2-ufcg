package lab05;

public class EntradaException extends Exception {
	
	public EntradaException() {
		super("Ofereca uma informacao valida.");
	}
	
	public EntradaException(String msg) {
		super(msg);
	}
	
}
