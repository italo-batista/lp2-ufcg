package lab06;
/* 114210196 - Italo Hector de Medeiros Batista: LAB 06 - Turma 03 */



public class ObjetoInexistenteException extends LogicaExcpetion {

	public ObjetoInexistenteException() {
		super("Este objeto nao foi cadastrado em loja.");
	}
	
	public ObjetoInexistenteException(String tipo) {
		super(tipo);
	}
}
