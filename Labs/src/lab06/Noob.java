package lab06;
/* 114210196 - Italo Hector de Medeiros Batista: LAB 06 - Turma 03 */

import java.util.Iterator;


public class Noob implements Jogador {
	
	public Noob() throws EntradaException{
		
	}
	
	@Override
	public int ganhouPartida(String nomeJogo, int scoreObtido, boolean zerou,
	CatalogoJogos jogosComprados, int x2p) throws DadoInvalidoException{
				
		int novoX2p = 0;
		int x2pExtra = 0;
		
		for (Jogo jogo : jogosComprados.getJogos() ) {
			
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
			
				int recompensa = calculaRecompensa(jogo);
				novoX2p = x2p + x2pExtra + recompensa;
			}
		}
		return novoX2p;
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
	public int perdeuPartida(String nomeJogo, int scoreObtido, boolean zerou,
			CatalogoJogos jogosComprados, int x2p) throws DadoInvalidoException {

		int novoX2p = 0;
		
		for (Jogo jogo : jogosComprados.getJogos()) {
			if (jogo.getNome().equals(nomeJogo)){
				int x2pExtra = jogo.joga(scoreObtido, zerou);
				int punicao = calculaPunicao(jogo);
				
				novoX2p = x2p + x2pExtra - punicao;
			}
		}
		return novoX2p;
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
	public double compraJogo(Jogo jogo, double dinheiro,
			CatalogoJogos jogosComprados, int x2p)
			throws SaldoInsuficienteException {

		if (dinheiro > jogo.getPreco()) {
			double desconto = calculaDesconto(jogo.getPreco());
			double valorCompra = jogo.getPreco() - desconto;
			dinheiro = dinheiro - valorCompra;

			jogosComprados.adicionaJogo(jogo);
			calculaX2pCompra(jogo, x2p);

			return dinheiro;
		} else {
			throw new SaldoInsuficienteException();
		}
	}

	@Override
	public int calculaX2pCompra(Jogo jogo, int x2p) {
		x2p = x2p + (10 * (int) jogo.getPreco());
		return x2p;
	}

}
