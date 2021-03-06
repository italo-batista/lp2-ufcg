package lab06;
/* 114210196 - Italo Hector de Medeiros Batista: LAB 06 - Turma 03 */

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class Usuario implements Comparable<Usuario>{

	private String nome;
	private String login;
	private CatalogoJogos jogosComprados;
	private double dinheiro;
	public int x2p;
	private Jogador jogador; 
	
	public Usuario(String nome, String login, CatalogoJogos jogosComprados, double dinheiro)
			throws EntradaException {
		
		if (nome == null || nome.length() == 0) {
			throw new StringInvalidaException("nome");
		} else {
			this.nome = nome;
		}
		if (login == null || login.length() == 0) {
			throw new StringInvalidaException("login");
		} else {
			this.login = login;
		}
		
		if (dinheiro < 0) {
			throw new DadoInvalidoException("Dinheiro de usuario");
		} else {
			this.dinheiro = dinheiro;
		}

		this.jogosComprados = jogosComprados;
		this.x2p = 0;
		this.jogador = new Noob();
	}

	public void compraJogo(Jogo jogo) throws SaldoInsuficienteException {
		this.dinheiro = this.jogador.compraJogo(jogo, this.dinheiro, this.jogosComprados, this.x2p);
	}
	
	public double calculaDesconto(double jogoPreco){
		return this.jogador.calculaDesconto(jogoPreco);
	}
	
	public void calculaX2pCompra(Jogo jogo){
		this.x2p = this.jogador.calculaX2pCompra(jogo, x2p);
	}
		
	public void ganhouPartida(String nomeJogo, int scoreObtido, boolean zerou) throws DadoInvalidoException {
		this.x2p = this.jogador.ganhouPartida(nomeJogo, scoreObtido, zerou, this.jogosComprados, scoreObtido);
	}
	
	public void perdeuPartida(String nomeJogo, int scoreObtido, boolean zerou) throws DadoInvalidoException {
		this.x2p = this.jogador.perdeuPartida(nomeJogo, scoreObtido, zerou, this.jogosComprados, this.x2p);
	}
	
	public void ordenaJogos(){
		Collections.sort(jogosComprados.getJogos());
	}
	
	public void ordenaJogos(List<Jogo> jogosDoUsuario, TipoOrdenacao tipoOrdenacao){
		if (tipoOrdenacao.equals(TipoOrdenacao.VICIO)){
			Comparator<Jogo> comparator = new comparaPorVicio();
			Collections.sort(jogosDoUsuario, comparator);
		} else if (tipoOrdenacao.equals(TipoOrdenacao.DESEMPENHO)) {
			Comparator<Jogo> comparator = new comparaPorDesempenho();
			Collections.sort(jogosDoUsuario, comparator);
		} else {//(tipoOrdenacao.equals(TipoOrdenacao.EXPERIENCIA))
			Comparator<Jogo> comparator = new comparaPorExperciencia();
			Collections.sort(jogosDoUsuario, comparator);
		}		
	}
	
	public void atualizaTipoJogador() throws EntradaException{
		if (x2p > 1000 & this.jogador instanceof Noob) {
			this.jogador = new Veterano();
		} else if (x2p <= 1000 & this.jogador instanceof Veterano){
			this.jogador = new Noob();
		}
	}
	
		
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			Usuario outroUsuario = (Usuario) obj;
			
			if (this.login.equals(outroUsuario.login)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString(){

		StringBuffer sb = new StringBuffer();
		final String endOfLine = System.getProperty("line.separator");		
		
		sb.append(this.login);
		sb.append(endOfLine);
		sb.append(this.nome);
		sb.append(endOfLine);
		sb.append("Lista de Jogos:");
		sb.append(endOfLine);
		
		double gastoComJogos = 0;
		
		Iterator<Jogo> iterator = this.jogosComprados.getJogos().iterator();
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
	
	// getters and setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public List<Jogo> getJogosComprados() {
		return jogosComprados.getJogos();
	}

	public void setJogosComprados(List<Jogo> jogosComprados) {
		this.jogosComprados.setJogos(jogosComprados);
	}

	public double getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}
	
	public void setX2p(double novoX2p){
		this.x2p = (int) novoX2p;
	}
	
	public int getX2p(){
		return this.x2p;
	}

	public Jogador getJogador(){
		return this.jogador;
	}
	
	@Override
	public int compareTo(Usuario outroUsuario) {
		if (this.x2p > outroUsuario.getX2p()) {
			return 1;
		} else if (this.x2p == outroUsuario.getX2p()){
			return 0;
		} else {// (this.x2p < outroUsuario.getX2p()) 
			return -1;
		}
	}
	
}