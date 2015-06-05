package lab05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Jogo {

	private String nome;
	private double preco;
	private double maiorScore;
	private int vezesJogadas;
	private int vezesZeradas;
	private HashSet jogabilidades;

	public Jogo(String nome, double preco, HashSet<Jogabilidade> jogabilidades) {

		this.nome = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.vezesJogadas = 0;
		this.vezesZeradas = 0;
		this.jogabilidades = jogabilidades;
	}

	public void joga(int score, boolean zerou) {

		this.vezesJogadas = vezesJogadas + 1;

		if (score > this.maiorScore) {
			this.maiorScore = score;
		}
		if (zerou) {
			this.vezesZeradas = vezesZeradas + 1;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Jogo) {

			Jogo outroJogo = (Jogo) obj;
			if (this.nome.equals(outroJogo.nome)
					&& this.preco == outroJogo.preco) {
				return true;
			}
		}

		return false;
	}

	public String toString() {

		StringBuffer sb = new StringBuffer();
		final String endOfLine = System.getProperty("line.separator");		
	
		sb.append(endOfLine);
		sb.append("+ "+ this.nome +":");
		sb.append(endOfLine);
		sb.append("==> Jogou "+ vezesJogadas +" vez(es)");
		sb.append(endOfLine);
		sb.append("==> Zerou "+ vezesZeradas +" vez(es)");
		sb.append(endOfLine);
		sb.append("==> Maior score: "+ maiorScore);
		sb.append(endOfLine);
		return sb.toString();
		
	}

	// gets and setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getMaiorScore() {
		return maiorScore;
	}

	public void setMaiorScore(double maiorScore) {
		this.maiorScore = maiorScore;
	}

	public int getVezesJogada() {
		return vezesJogadas;
	}

	public void setVezesJogada(int vezesJogada) {
		this.vezesJogadas = vezesJogada;
	}

	public int getVezesZerada() {
		return vezesZeradas;
	}

	public void setVezesZerada(int vezesZerada) {
		this.vezesZeradas = vezesZerada;
	}

	public HashSet getJogabilidades() {
		return jogabilidades;
	}

	public void setJogabilidades(List jogabadilidades) {
		this.jogabilidades = jogabilidades;
	}
}