package lab05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Loja {
	
	private List usuarios;
	private List catalogoDeJogos;
	private JogoFactory fabricaJogo;
	private UsuarioFactory fabricaUsuario;
	private double totalArrecadado;
	
	public Loja(){
		usuarios = new ArrayList<Usuario>();
		catalogoDeJogos = new ArrayList<Jogo>();
		fabricaJogo = new JogoFactory();
		fabricaUsuario = new UsuarioFactory();
		totalArrecadado = 0;
	}
	
	public void novoUsuario(String nome, String login, List jogosComprados, double dinheiro, String tipo){
		Usuario novoUsuario = fabricaUsuario.criaUsuario(nome, login, jogosComprados, dinheiro, tipo);
		usuarios.add(novoUsuario);
	}
	
	public void novoJogo(String nome, double preco, HashSet<Jogabilidade> jogabilidades, String tipo){
		Jogo novoJogo = fabricaJogo.criaJogo(nome, preco, jogabilidades, tipo);
		catalogoDeJogos.add(novoJogo);
	}

	public void addDinheiro(Usuario usuario, double dinheiroAdicional){
		usuario.setDinheiro( usuario.getDinheiro() + dinheiroAdicional );
	}
	
	public void vendeJogo(Usuario usuario, Jogo jogo) throws Exception {
	
		double jogoPreco = jogo.getPreco();
		
		if (jogoPreco > usuario.getDinheiro()) {
			throw new Exception("Voce nao tem saldo suficiente");
		} else {
			Jogo copiaDoUsuario = copiaJogo(jogo);
			usuario.compraJogo(copiaDoUsuario);
			
			double valorVenda = usuario.calculaDesconto(jogoPreco);
			calcTotalArrecadado(valorVenda);
		}
	}

	public Jogo copiaJogo(Jogo jogo) throws Exception{
		
		Jogo copiaDeJogo;
		
		String copiaNome = jogo.getNome();
		double copiaPreco = jogo.getPreco();
		HashSet copiaJogabilidades = jogo.getJogabilidades();
		
		copiaDeJogo = new Jogo(copiaNome, copiaPreco, copiaJogabilidades);
		return copiaDeJogo;
	}
	
	public void calcTotalArrecadado(double valorVenda){
		this.totalArrecadado = this.totalArrecadado + valorVenda;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		final String endOfLine = System.getProperty("line.separator");		
		
		sb.append("=== Central P2-CG ===");
		sb.append(endOfLine);
		sb.append(endOfLine);
		
		Iterator<Usuario> iterator = this.usuarios.iterator();
		while (iterator.hasNext()) {	
			Usuario usuario = iterator.next();
			sb.append(usuario);
			sb.append(endOfLine);
			sb.append(endOfLine);
		}

		sb.append(endOfLine);
		sb.append("--------------------------------");
		sb.append("Total arrecadado com vendas de jogos: R$ ");
		sb.append(totalArrecadado);
		return sb.toString();
	}
}