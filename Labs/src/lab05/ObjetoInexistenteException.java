package lab05;

public class ObjetoInexistenteException extends LogicaExcpetion {

	public ObjetoInexistenteException() {
		super("Este objeto nao foi cadastrado em loja.");
	}
	
	public ObjetoInexistenteException(String tipo) {
		super(tipo);
	}
}
