package prova02;

public class CursoInvalidoException extends EntradaInvalidaException{

	public CursoInvalidoException(String curso) {
		super("HelloWorld nao ensina "+ curso);
	}
}
