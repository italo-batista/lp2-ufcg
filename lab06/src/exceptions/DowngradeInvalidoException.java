package exceptions;


public class DowngradeInvalidoException extends Exception {

	public DowngradeInvalidoException(String nome) {
		super("Downgrade invalido: "+ nome +" ja eh do tipo Noob");
	}
	
	public DowngradeInvalidoException() {
		super("Downgrade invalido: usuario nao possue x2p acima de 10000.");
	}
	
}
