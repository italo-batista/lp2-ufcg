package lab03;

import java.text.DecimalFormat;

/* 114210196
 * Ítalo Héctor de Medeiros Batista: LAB 03
 * Turma 03 */

public class Tela {

	public Tela () {
		
	}
	
	public void imprimeMenu() {

		System.out.println("\n= = = = Bem­vindo(a) ao EconomizaP2 = = = =");
		System.out.println("Digite a opção desejada:");
		System.out.println("1 - Cadastrar um Produto");
		System.out.println("2 - Vender um Produto");
		System.out.println("3 - Imprimir Balanço");
		System.out.println("4 - Sair\n");
		System.out.print("Opção: ");
	}
	
	public void imprimePainel() {
		System.out.println("\n= = = = Venda de Produtos = = = = ");
	}
	
	public void printNaoTemNoEstoque(String nomeProduto) {
		System.out.print("==> " + nomeProduto + " nao cadastrada no sistema.");
	}
	
	public void printTemNoEstoque(int indice, Produto[] produtos) {

		Produto produto = produtos[indice];
		imprimeProduto(produto);
	}
	
	public void imprimeProduto(Produto produto) {

		String nomeProduto = produto.getName();
		String tipoProduto = produto.getType();
		double precoProduto = produto.getPrice();

		System.out.print("==> " + nomeProduto + "(" + tipoProduto + "). R$ "
				+ precoProduto + "\n");
	}

	public void imprimeTotalCompra(double totalCompra) {
		DecimalFormat formatador = new DecimalFormat("#0.00");
		System.out.println("==> Total arrecadado: " + "R$ " + formatador.format(totalCompra));
	}
	
	public void imprimeTotalArrecadado(double totalArrecadado) {
		DecimalFormat formatador = new DecimalFormat("#0.00");
		System.out.println("\nTotal arrecadado em vendas: R$ "
				+ formatador.format(totalArrecadado));
	}

	public void imprimeLucroPossivel(double lucroPossivel) {
		DecimalFormat formatador = new DecimalFormat("#0.00");
		System.out.println("Total que pode ser arrecadado: " + formatador.format(lucroPossivel));
	}

	public void imprimeProdutos(Produto[] produtos) {

		System.out.println("Produtos cadastrados: ");

		for (int i = 0; i < produtos.length; i++) {

			if (produtoFoiCadastrado(i, produtos)) {

				String nomeProduto = produtos[i].getName();
				String tipoProduto = produtos[i].getType();
				double precoProduto =produtos[i].getPrice();
				int restante = produtos[i].getQuant();

				System.out.print((i + 1) + ") " + nomeProduto + "("
						+ tipoProduto + "). R$ " + precoProduto
						+ ". Restante: " + restante + "\n");
			} // encerra if
		
		} // encerra loop
	
	} // encerra metodo
	
	public boolean produtoFoiCadastrado(int indice, Produto[] produtos) {

		boolean retorno = true;

		if (produtos[indice].getName().equals("")) {
			retorno = false;
		}

		return retorno;
	}
	
}
