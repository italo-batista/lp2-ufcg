package lista03_her_comp;

public class Limpeza extends Produto {

	public Limpeza(String nome, int quant, double precoBase){
		super(nome, quant, precoBase);
	}
	
	public double compraProduto(int quantComprada){
		double valorCompra = 0;
		if (quantComprada > 4) {
			valorCompra = super.precoBase * quantComprada * 0.9;
		} else {
			valorCompra = quantComprada * super.precoBase;
		}
		return valorCompra;
	}
	
}
