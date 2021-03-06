package lista03_her_comp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.StyledEditorKit.ItalicAction;

public class Carrinho {

	List<Produto> produtos;
	
	public Carrinho() {
		produtos = new ArrayList<Produto>();
	}
	
	public void addNoCarrinho(Produto produto) {
		produtos.add(produto);
	}
	
	public void removerDoCarrinho(Produto produto){
		produtos.remove(produto);
	}
	
	public Produto consultar(String nomeProduto){
		Produto produtoConsultado = null;
		Iterator<Produto> iterator = produtos.iterator();
		while (iterator.hasNext()) {
			Produto outroProduto = iterator.next();
			if ( outroProduto.getNome().equals(nomeProduto) ) {
				produtoConsultado = outroProduto;
			}
		}
		return produtoConsultado;
	}
	
	public double precoTotal(){

		double precoTotal = 0;
		
		Iterator<Produto> iterator = produtos.iterator();
		while (iterator.hasNext()){
			precoTotal = precoTotal + iterator.next().getPrecoBase();
		}
		
		return precoTotal;
			
		}
			
}
