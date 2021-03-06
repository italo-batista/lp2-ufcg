package lab03;

/* 114210196
 * Ítalo Héctor de Medeiros Batista: LAB 03
 * Turma 03 */

import java.util.Scanner;

public class Supermercado {

	private static final byte CADASTRA = 1;
	private static final byte VENDE = 2;
	private static final byte IMPRIME = 3;

	public Supermercado () {
		
	}

	public void iniciar() {

		Estoque estoque = new Estoque();
		Tela tela = new Tela();
		Scanner leitor = new Scanner(System.in);
		
		
		int opcao = 0;

		while (opcao != 4) {

			tela.imprimeMenu();

			opcao = leitor.nextInt();

			switch (opcao) {
			case CADASTRA:
				estoque.moduloCadastro();
				break;
			case VENDE:
				estoque.moduloVenda();
				break;
			case IMPRIME:
				estoque.moduloBalanco();
				break;
			} // encerra switch

		} // encerre loop

		leitor.close();

	} // encerra main

} // encerra classe