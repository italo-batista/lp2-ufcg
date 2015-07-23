
public class Jogo {
	
	private String nome;
	
	public Jogo(String nome) {
		this.nome = nome;
	}
	
	public double jogar(double dinheiro){
		dinheiro = dinheiro - 5;
		return dinheiro;
	}
	
	public String getNome(){
		return this.nome;
	}
		
}