package lab06;
/* 114210196 - Italo Hector de Medeiros Batista: LAB 06 - Turma 03 */



public class TipoObjetoInexistenteException extends LogicaExcpetion {

	public TipoObjetoInexistenteException() {
		super("Nao existe este tipo para objeto. Insira um tipo valido.");
	}
	
	public TipoObjetoInexistenteException(String tipo) {
		super(tipo);
	}
}
