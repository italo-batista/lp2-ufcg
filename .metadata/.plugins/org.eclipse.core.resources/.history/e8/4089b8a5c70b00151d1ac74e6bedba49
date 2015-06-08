package lab05;

import java.util.Iterator;
import java.util.List;

public class Veterano extends Usuario {

	public Veterano(String nome, String login, List jogosComprados, double dinheiro){
		super(nome, login, jogosComprados, dinheiro);
	}
	
	public double calculaDesconto(double jogoPreco){
		double valorCompra = jogoPreco * (1 - 0.2);
		return valorCompra;
	}
	
	public String toString(){

		StringBuffer sb = new StringBuffer();
		final String endOfLine = System.getProperty("line.separator");		
		
		sb.append(super.getLogin());
		sb.append(endOfLine);
		sb.append(super.getNome());
		sb.append(" - Jogador Veterano");
		sb.append(endOfLine);
		sb.append("Lista de Jogos:");
		sb.append(endOfLine);
		
		double gastoComJogos = 0;
		
		Iterator<Jogo> iterator = super.getJogosComprados().iterator();
		while (iterator.hasNext()) {	
			Jogo jogo = iterator.next();
			sb.append(jogo);
			sb.append(endOfLine);
			gastoComJogos = gastoComJogos + jogo.getPreco();
		}		
		
		sb.append("Total de preco dos jogos: R$ ");
		sb.append(gastoComJogos);
		sb.append(endOfLine);
		sb.append(endOfLine);
		
		return sb.toString();
	}
}
