package prova01;

public class Item {

	private String nome;
	private double peso;
	protected int efeito;
	
	public Item(String nome, double peso, int efeito) {
		this.nome = nome;
		this.peso = peso;
		this.efeito = efeito;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
		
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public int getEfeito() {
		return efeito;
	}
	
	public void setEfeito(int efeito) {
		this.efeito = efeito;
	}
	
}
