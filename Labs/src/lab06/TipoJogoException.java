package lab06;
/* 114210196 - Italo Hector de Medeiros Batista: LAB 06 - Turma 03 */




public class TipoJogoException extends TipoObjetoInexistenteException {

	public TipoJogoException() {
		super("Nao existe este tipo de jogo.");
	}
	
	public TipoJogoException(String tipo) {
		super(tipo);
	}
	
}
