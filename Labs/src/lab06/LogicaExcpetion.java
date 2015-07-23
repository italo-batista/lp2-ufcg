package lab06;
/* 114210196 - Italo Hector de Medeiros Batista: LAB 06 - Turma 03 */



public class LogicaExcpetion extends Exception{

	public LogicaExcpetion() {
		super("Objeto nao corresponde as especificacoes do sistema.");
	}
	
	public LogicaExcpetion(String tipo) {
		super(tipo +" nao corresponde as especificacoes do sistema.");
	}
}
