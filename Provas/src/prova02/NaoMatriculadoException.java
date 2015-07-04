package prova02;

public class NaoMatriculadoException extends LogicaException {

	public NaoMatriculadoException(String nome) {
		super(nome +" ainda nao esta matriculado em nenhum curso.");
	}
}
