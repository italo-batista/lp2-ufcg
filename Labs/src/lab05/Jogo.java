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

	public Jogo(String nome, double preco, HashSet<Jogabilidade> jogabilidades)
			throws EntradaException {

		if (nome.length() == 0) {
			throw new StringInvalidaException("nome");
		} else {
			this.nome = nome;
		}
		
		if (preco < 0) {
			throw new DadoInvalidoException("Preco");
		} else {
			this.preco = preco;
		} 
		
		this.jogabilidades = jogabilidades;
		
		this.maiorScore = 0;
		this.vezesJogadas = 0;
		this.vezesZeradas = 0;
	}

	public int joga(int score, boolean zerou) throws DadoInvalidoException {

		if (score < 0){
			throw new DadoInvalidoException("Score");
		} else {

			this.vezesJogadas = vezesJogadas + 1;
			
			if (score > this.maiorScore) {
				this.maiorScore = score;
			} if (zerou) {
				this.vezesZeradas = vezesZeradas + 1;
			}
		}
           //  (Interger) null
		return 0; 
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

	@Override
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

	public int getVezesJogadas() {
		return vezesJogadas;
	}

	public void setVezesJogadas(int vezesJogada) {
		this.vezesJogadas = vezesJogada;
	}

	public int getVezesZeradas() {
		return vezesZeradas;
	}

	public void setVezesZeradas(int vezesZerada) {
		this.vezesZeradas = vezesZerada;
	}

	public HashSet getJogabilidades() {
		return jogabilidades;
	}

	public void setJogabilidades(List jogabadilidades) {
		this.jogabilidades = jogabilidades;
	}
}