package lab05;

public class TipoObjetoInexistenteException extends LogicaExcpetion {

	public TipoObjetoInexistenteException() {
		super("Nao existe este tipo para objeto. Insira um tipo valido.");
	}
	
	public TipoObjetoInexistenteException(String tipo) {
		super(tipo);
	}
}
