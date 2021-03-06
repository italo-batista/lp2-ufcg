package lab05;

import java.util.Iterator;
import java.util.List;

public class Veterano extends Usuario {

	public Veterano(String nome, String login, List jogosComprados, double dinheiro) throws EntradaException{
		super(nome, login, jogosComprados, dinheiro);
	}
	
	@Override
	public void recompensar(String nomeJogo, int scoreObtido, boolean zerou) throws DadoInvalidoException {

		int novoX2p; 
		
		for (Jogo jogo : super.getJogosComprados()) {
			
			if (jogo.getNome().equals(nomeJogo)){
				int x2pExtra = jogo.joga(scoreObtido, zerou);
				int x2pAtual = super.getX2p();
				int recompensa = calculaRecompensa(jogo);
				
				novoX2p = x2pAtual + x2pExtra + recompensa;
				super.setX2p(novoX2p);
			}
		}
	}
	
	public int calculaRecompensa(Jogo jogo){
		int recompensa = (Integer) null;
		
		Iterator<Jogabilidade> iterator = jogo.getJogabilidades().iterator();
		while (iterator.hasNext()){
			Jogabilidade jogabilidade = iterator.next();
			
			if (jogabilidade == Jogabilidade.OFFLINE){
				recompensa = recompensa + 10; 
			} else if (jogabilidade == Jogabilidade.MULTIPLAYER){
				recompensa = recompensa + 20;
			}
		}
		
		return recompensa;
	}
	
	@Override
	public void punir(String nomeJogo, int scoreObtido, boolean zerou) throws DadoInvalidoException{

		int novoX2p;
		
		for (Jogo jogo : super.getJogosComprados()) {
			if (jogo.getNome().equals(nomeJogo)){
				int x2pExtra = jogo.joga(scoreObtido, zerou);
				int x2pAtual = super.getX2p();
				int punicao = calculaPunicao(jogo);
				
				novoX2p = x2pAtual + x2pExtra - punicao;
				super.setX2p(novoX2p);
			}
		}
	}
	
	public int calculaPunicao(Jogo jogo){
		int punicao = (Integer) null;
	
		
		Iterator<Jogabilidade> iterator = jogo.getJogabilidades().iterator();
		while (iterator.hasNext()){
			Jogabilidade jogabilidade = iterator.next();
			
			if (jogabilidade == Jogabilidade.COMPETITIVO){
				punicao = punicao + 20;
			} if (jogabilidade == Jogabilidade.COOPERATIVO) {
				punicao = punicao + 20;
			}	
		}
		
		return punicao;
	}
	
	@Override
	public double calculaDesconto(double jogoPreco){
		double valorCompra = jogoPreco * (1 - 0.2);
		return valorCompra;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Veterano) {

			Usuario outroUsuario = (Veterano) obj;
			if ( super.getLogin().equals( outroUsuario.getLogin() ) ){
				return true;
			}
		}
		return false;
	}
	
	public String toString(){

		StringBuffer sb = new StringBuffer();
		final String endOfLine = System.getProperty("line.separator");		
		
		sb.append(super.getLogin());
		sb.append(endOfLine);
		sb.append(super.getNome());
		sb.append(endOfLine);
		sb.append("Jogador Veterano : "+ super.getX2p() +" x2p");
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
