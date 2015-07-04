package prova02;

public class ProficienciaInvalidaException extends EntradaInvalidaException{

	public ProficienciaInvalidaException(){
		super("Nivel de proficiencia invalido. Deve ser entre 0 e 10.");
	}
}
