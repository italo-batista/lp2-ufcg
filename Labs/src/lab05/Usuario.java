package lab05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Usuario {

	private String nome;
	private String login;
	private List<Jogo> jogosComprados;
	private double dinheiro;
	public int x2p;
	
	public Usuario(String nome, String login, List<Jogo> jogosComprados, double dinheiro)
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
	}

	public void compraJogo(Jogo jogo) throws SaldoInsuficienteException {
		
		if (this.dinheiro > jogo.getPreco()) {
			double desconto = calculaDesconto(jogo.getPreco());
			double valorCompra = jogo.getPreco() - desconto;
			this.dinheiro = this.dinheiro - valorCompra;
			jogosComprados.add(jogo);
		
			calculaX2pCompra(jogo);
		} else {
			throw new SaldoInsuficienteException();
		}
	}
	
	public double calculaDesconto(double jogoPreco){
		return 0;
	}
	
	public void calculaX2pCompra(Jogo jogo){
		this.x2p = this.x2p + (10 * (int) jogo.getPreco());
	}
		
	public void recompensar(String nomeJogo, int scoreObtido, boolean zerou) throws DadoInvalidoException {
	
		int novoX2p;
		
		for (Jogo jogo : jogosComprados) {
			if (jogo.getNome().equals(nomeJogo)){
				novoX2p = jogo.joga(scoreObtido, zerou);
				this.x2p = this.x2p + novoX2p;
			}
		}
		
	}
	
	public void punir(String nomeJogo, int scoreObtido, boolean zerou) throws DadoInvalidoException {
		
		int novoX2p;
		int punicao = 0;
		
		for (Jogo jogo : jogosComprados) {
			if (jogo.getNome().equals(nomeJogo)){
				novoX2p = jogo.joga(scoreObtido, zerou) - punicao;
				this.x2p = this.x2p + novoX2p;
			}
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
		
		Iterator<Jogo> iterator = this.jogosComprados.iterator();
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
		return jogosComprados;
	}

	public void setJogosComprados(List jogosComprados) {
		this.jogosComprados = jogosComprados;
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
	
}