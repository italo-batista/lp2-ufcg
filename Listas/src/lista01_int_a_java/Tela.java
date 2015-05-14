package lista01_int_a_java;

import java.util.Scanner;

public class Tela {

	Scanner leitor = new Scanner(System.in);

	public Tela() {

	}

	public void fezEmprestimo() {
		System.out.println("Voce nao tem saldo suficiente."
				+ " No proximo depositado sera cobrada uma taxa"
				+ " de 10% sobre o valor depositado.");
	}

}
