package lab06;
/* 114210196 - Italo Hector de Medeiros Batista: LAB 06 - Turma 03 */



public class EntradaException extends Exception {
	
	public EntradaException() {
		super("Ofereca uma informacao valida.");
	}
	
	public EntradaException(String msg) {
		super(msg);
	}
	
}
