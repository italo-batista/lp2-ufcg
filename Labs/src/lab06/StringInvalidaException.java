package lab06;
/* 114210196 - Italo Hector de Medeiros Batista: LAB 06 - Turma 03 */



public class StringInvalidaException extends EntradaException {

	public StringInvalidaException(String tipo) {
		super("Insira um "+ tipo +" valido.");
	}
	
	public StringInvalidaException() {
		super("Insira termos validos.");
	}
}