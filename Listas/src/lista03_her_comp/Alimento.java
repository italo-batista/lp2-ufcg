package lista03_her_comp;

public class Alimento extends Produto {

	boolean contemGluten;
	
	public Alimento(String nome, int quant, double precoBase, boolean contemGluten) {
		super(nome, quant, precoBase);
		this.contemGluten = contemGluten;
	}
	
	public double compraProduto(int quantComprada){
		double valorCompra = 0;
		if (this.contemGluten) {
			valorCompra = super.precoBase * quantComprada * 0.5;
		} else {
			valorCompra = super.precoBase * quantComprada;
		}
		return valorCompra;
	}
	
}
