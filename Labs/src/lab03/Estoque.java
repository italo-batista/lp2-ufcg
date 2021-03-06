package lab03;

/* 114210196
 * Ítalo Héctor de Medeiros Batista: LAB 03
 * Turma 03 */

import java.util.Scanner;

public class Estoque {

	private Scanner leitor = new Scanner(System.in);

	private static final byte N_TEM_PRODUTO = 0;
	private static final byte TEM_PRODUTO = 1;

	private static final byte TAM_INICIAL_LISTA = 2;

	public Produto[] produtos = new Produto[TAM_INICIAL_LISTA];

	private double totalArrecadado = 0;
	private int indexProdutoAtual = 0;

	public Caixa caixa = new Caixa(); 
	public Tela tela = new Tela();
	
	
	public Estoque() {

		iniciaArrays(this.produtos);

	}

	public void estaEstoqueCheio() {

		String vazio = "";
		int indexUltiProduto = this.produtos.length - 1;
		String nomeProduto = this.produtos[indexUltiProduto].getName();

		if (!nomeProduto.equals(vazio)) {
			aumentaEstoque();
		}
	}

	public void aumentaEstoque() {

		int novoTamanho = this.produtos.length + 5;
		Produto[] novaArray = new Produto[novoTamanho];
		iniciaArrays(novaArray);

		for (int i = 0; i < novaArray.length; i++) {

			if (i < this.produtos.length) {
				novaArray[i] = this.produtos[i];
			}
		}

		this.produtos = novaArray;
	}

	public void iniciaArrays(Produto[] array) {

		String nomeDefault = "";
		double precoDefault = 0.0;
		String tipoDefault = "";
		int quantidadeDefault = 0;

		Produto produto = new Produto(nomeDefault, precoDefault, tipoDefault,
				quantidadeDefault);

		for (int i = 0; i < array.length; i++) {
			array[i] = produto;
		}
	} // encerra metodo

	
	// METODOS PARA CADASTRO

	public void cadastroProduto() {

		System.out.println("\n= = = = Cadastro de Produtos = = = =");

		String nomeProduto = caixa.cadastraNome();
		double precoProduto = caixa.cadastraPreco();
		String tipoProduto = caixa.cadastraTipo();
		int quantidadeProduto = caixa.cadastraQuantidade();

		Produto produto = new Produto(nomeProduto, precoProduto, tipoProduto,
				quantidadeProduto);

		guardaProduto(produto);

	} // encerra metodo

	public void guardaProduto(Produto produto) {

		estaEstoqueCheio();

		this.produtos[indexProdutoAtual] = produto;
		indexProdutoAtual++;

		String nomeProduto = produto.getName(); 
		int quantidadeProduto = produto.getQuant();
		
		System.out.println("\n" + quantidadeProduto + " " + nomeProduto 
				+ "(s) cadastrado(s) com sucesso.\n");

	} // encerra metodo

	public void moduloCadastro() {

		String opcao = "Sim";

		while (!opcao.equals("Nao")) {

			if (opcao.equals("Sim")) {
				cadastroProduto();
			} else {
				System.out.println("Digite 'Sim' ou 'Nao'");
			}

			opcao = caixa.cadastraNovamente();

		} // encerra loop

	} // encerra metodo

	
	// METODOS PARA VENDA

	public void pesquisaEmEstoque(String nameProduto) {

		String nomeProduto = nameProduto;
		byte estoque = 0;
		int indice = 0;
		int quantidade = 0;

		for (int i = 0; i < this.produtos.length; i++) {

			if ((nomeProduto).equals(this.produtos[i].getName())) {
				estoque = 1;
				indice = i;
			}
		}

		switch (estoque) {
		case TEM_PRODUTO:
			tela.printTemNoEstoque(indice, this.produtos);
			quantidade = caixa.insereQuantidade(leitor);
			alteraQuantProduto(indice, quantidade);
			break;
		case N_TEM_PRODUTO:
			tela.printNaoTemNoEstoque(nomeProduto);
			break;
		}
	} // encerra metodo

	public void alteraQuantProduto(int indice, int quantComprada) {

		if (temQuantSuficiente(indice, quantComprada)) {

			this.produtos[indice].setNewQuantity(quantComprada);
			totalCompra(indice, quantComprada);

		} else {
			System.out.println("Nao e possivel vender pois nao ha "
					+ this.produtos[indice].getName() + " suficiente.");
		}
	}

	public boolean temQuantSuficiente(int indice, int quantComprada) {

		boolean retorno = true;

		if (quantComprada > this.produtos[indice].getQuant()) {
			retorno = false;
		}

		return retorno;
	}

	public double getPriceProduct(String nomeProduto) {

		double preco = 0;

		for (int i = 0; i < this.produtos.length; i++) {

			if (nomeProduto.equals(this.produtos[i].getName())) {
				preco = this.produtos[i].getPrice();
			} // encerra if

		} // encerra for

		return preco;
	}

	public double calculaSaldo(String nomeProduto, int quantidade) {

		double preco = getPriceProduct(nomeProduto);
		double totalCompra = preco * quantidade;

		calculaTotalArrecadado(totalCompra);

		return totalCompra;

	} // encerra metodo

	public void totalCompra(int indice, int quantidade) {

		double totalCompra;
		String nomeProduto = this.produtos[indice].getName();

		totalCompra = calculaSaldo(nomeProduto, quantidade);
		tela.imprimeTotalCompra(totalCompra);

	}

	public void moduloVenda() {

		String nomeProduto = "";
		String opcao = "Sim";

		while (!opcao.equals("Nao")) {

			if (opcao.equals("Sim")) {
				tela.imprimePainel();
				nomeProduto = caixa.buscaNome();
				pesquisaEmEstoque(nomeProduto);
			} else {
				System.out.println("Digite 'Sim' ou 'Nao'");
			}

			opcao = caixa.vendeProdutoNovamente();

		} // encerra loop

	} // encerra metodo

	
	// METODOS PARA BALANAÇO

	public void calculaTotalArrecadado(double totalCompra) {
		totalArrecadado += totalCompra;
	}

	public double calculaLucroPossivel() {

		double lucroPossivel = 0.0;
		int produtosRestantes;
		double precoProduto;

		for (int i = 0; i < this.produtos.length; i++) {
			produtosRestantes = this.produtos[i].getQuant();
			precoProduto = this.produtos[i].getPrice();
			lucroPossivel += (produtosRestantes * precoProduto);
		}

		return lucroPossivel;
	}

	public void moduloBalanco() {

		System.out.println("\n= = = = Impressao de Balanco = = = = ");
		tela.imprimeProdutos(this.produtos);
		tela.imprimeTotalArrecadado(this.totalArrecadado);
		
		double lucroPossivel = calculaLucroPossivel();
		tela.imprimeLucroPossivel(lucroPossivel);
		
	}

} // encerra classe