package lab05;

import java.util.Iterator;
import java.util.List;

public class Noob extends Usuario {
	
	public Noob(String nome, String login, List jogosComprados, double dinheiro) throws EntradaException{
		super(nome, login, jogosComprados, dinheiro);
	}
	
	@Override
	public void recompensar(String nomeJogo, int scoreObtido, boolean zerou) throws DadoInvalidoException {

		int novoX2p;
		int x2pExtra = 0;
		
		for (Jogo jogo : super.getJogosComprados()) {
			
			if (jogo.getNome().equals(nomeJogo)){
				
				if (jogo instanceof Plataforma){
					jogo = (Plataforma) jogo;
					x2pExtra = jogo.joga(scoreObtido, zerou);
				} if (jogo instanceof RPG){
					jogo = (RPG) jogo;
					x2pExtra = jogo.joga(scoreObtido, zerou);
				} if (jogo instanceof Luta){
					jogo = (Luta) jogo;
					x2pExtra = jogo.joga(scoreObtido, zerou);
				}
				
				int x2pAtual = super.getX2p();
				int recompensa = calculaRecompensa(jogo);
				
				novoX2p = x2pAtual + x2pExtra + recompensa;
				//super.setX2p(novoX2p);
				super.setX2p(30);
			}
		}
	}
	
	public int calculaRecompensa(Jogo jogo){
		int recompensa = 0;
		
		Iterator<Jogabilidade> iterator = jogo.getJogabilidades().iterator();
		while (iterator.hasNext()){
			Jogabilidade jogabilidade = iterator.next();
			
			if (jogabilidade == Jogabilidade.OFFLINE){
				recompensa = recompensa + 30; 
			} else if (jogabilidade == Jogabilidade.MULTIPLAYER){
				recompensa = recompensa + 10;
			}
		}
		
		return recompensa;
	}
	
	@Override
	public void punir(String nomeJogo, int scoreObtido, boolean zerou) throws DadoInvalidoException {

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
		int punicao = 0;
	
		
		Iterator<Jogabilidade> iterator = jogo.getJogabilidades().iterator();
		while (iterator.hasNext()){
			Jogabilidade jogabilidade = iterator.next();
			
			if (jogabilidade == Jogabilidade.ONLINE){ 
				punicao = punicao + 10;
			} if (jogabilidade == Jogabilidade.COMPETITIVO){
				punicao = punicao + 20;
			} if (jogabilidade == Jogabilidade.COOPERATIVO) {
				punicao = punicao + 50;
			}	
		}
		
		return punicao;
	}
	
	@Override
	public double calculaDesconto(double jogoPreco){
		double valorCompra = jogoPreco * (1 - 0.1);
		return valorCompra;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Noob) {

			Usuario outroUsuario = (Noob) obj;
			if ( super.getLogin().equals( outroUsuario.getLogin() ) ){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString(){

		StringBuffer sb = new StringBuffer();
		final String endOfLine = System.getProperty("line.separator");		
		
		sb.append(super.getLogin());
		sb.append(endOfLine);
		sb.append(endOfLine);
		sb.append(super.getNome());
		sb.append("Jogador Noob : "+ super.getX2p() +" x2p");
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
