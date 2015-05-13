package lab03;

/* 114210196
 * Ítalo Héctor de Medeiros Batista: LAB 03
 * Turma 03 */

public class Produto {

	private String nome = "";
	private double preco = 0.0;
	private String tipo = "";
	private int quantidade = 0;

	public Produto(String nome, double preco, String tipo, int quantidade) {

		this.nome = nome;
		this.preco = preco;
		this.tipo = tipo;
		this.quantidade = quantidade;

	}

	public String getName() {
		return nome;
	}

	public double getPrice() {
		return preco;
	}

	public String getType() {
		return tipo;
	}

	public int getQuant() {
		return quantidade;
	}

	public void setNewQuantity(int quantComprada) {
		this.quantidade -= quantComprada;
	}

} // encerra classe