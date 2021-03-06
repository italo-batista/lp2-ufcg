package lista03_her_comp;

public class Produto {

	String nome;
	int quant;
	double precoBase;
	
	public Produto(String nome, int quant, double precoBase){
		this.nome = nome;
		this.quant = quant;
		this.precoBase = precoBase;
	}
	
	public double compraProduto(int quantComprada){
		return (this.precoBase * quantComprada);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public double getPrecoBase() {
		return precoBase;
	}

	public void setPrecoBase(double precoBase) {
		this.precoBase = precoBase;
	}	
}
