package lab06;
/* 114210196 - Italo Hector de Medeiros Batista: LAB 06 - Turma 03 */


public interface Jogador {

	public double compraJogo(Jogo jogo, double dinheiro,
			CatalogoJogos jogosComprados, int x2p) throws SaldoInsuficienteException; 
	
	public double calculaDesconto(double jogoPreco); 
	
	public int calculaX2pCompra(Jogo jogo, int x2p); 
	
	public int ganhouPartida(String nomeJogo, int scoreObtido, boolean zerou,
			CatalogoJogos jogosComprados, int x2p) throws DadoInvalidoException; 
	
	public int perdeuPartida(String nomeJogo, int scoreObtido, boolean zerou,
			CatalogoJogos jogosComprados, int x2p) throws DadoInvalidoException;
	
}
