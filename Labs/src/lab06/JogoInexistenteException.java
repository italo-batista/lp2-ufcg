package lab06;
/* 114210196 - Italo Hector de Medeiros Batista: LAB 06 - Turma 03 */



public class JogoInexistenteException extends ObjetoInexistenteException {

	public JogoInexistenteException() {
		super("Este jogo não foi cadastrado na loja.");
	}
	
	public JogoInexistenteException(String tipo) {
		super(tipo);
	}
	
}
