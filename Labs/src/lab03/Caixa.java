package lab03;

/* 114210196
 * Ítalo Héctor de Medeiros Batista: LAB 03
 * Turma 03 */

import java.util.Scanner;

public class Caixa {

	public Caixa () {
		
	}

	private Scanner leitor = new Scanner(System.in);
	
	
	// CADASTRA
	
	public String cadastraNome() {
		System.out.print("Digite o nome do produto: ​");
		String produto = this.leitor.next();
		return produto;
	}

	public double cadastraPreco() {
		System.out.print("Digite o preço unitário do produto: ​");
		double preco = this.leitor.nextDouble();
		return preco;
	}

	public String cadastraTipo() {
		System.out.print("Digite o tipo do produto: ​");
		String tipo = this.leitor.next();
		return tipo;
	}

	public int cadastraQuantidade() {
		System.out.print("Digite a quantidade no estoque: ");
		int quantidade = this.leitor.nextInt();
		return quantidade;
	}

	public String cadastraNovamente() {

		String opcao = "";

		System.out.println("Deseja cadastrar outro produto? ");

		opcao = this.leitor.next();

		return opcao;

	} // encerra metodo

	
	// VENDE
	
	public String vendeProdutoNovamente() {

		String opcao = "";

		System.out.print("Deseja vender outro produto? ");
		opcao = this.leitor.next();

		System.out.println("");

		return opcao;

	} // encerra metodo

	public String buscaNome() {
		System.out.print("Digite o nome do produto: ");
		String nomeProduto = this.leitor.next();
		return nomeProduto;
	}
	
	public int insereQuantidade(Scanner scanner) {

		int quantidade;

		System.out.print("\nDigite a quantidade que deseja vender: ");
		quantidade = this.leitor.nextInt();
		this.leitor.nextLine();

		return quantidade;
	}
	
	
} // encerra classe
