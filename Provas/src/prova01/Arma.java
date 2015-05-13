package prova01;

public class Arma extends Item {

	public Arma (String nome, double peso, int efeito) {
		super(nome, peso, efeito);
	}
	
	@Override
	public int getEfeito() {
		return -1 * this.efeito;
		
	}
	
}