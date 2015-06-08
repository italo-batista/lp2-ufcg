package lab05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Loja {
	
	private List<Usuario> usuarios;
	private JogoFactory fabricaJogo;
	private UsuarioFactory fabricaUsuario;
	private double totalArrecadado;
	
	public Loja(){
		usuarios = new ArrayList<Usuario>();
		fabricaJogo = new JogoFactory();
		fabricaUsuario = new UsuarioFactory();
		totalArrecadado = 0;
	}
	
	public void novoUsuario(String nome, String login, List jogosComprados, double dinheiro, String tipo){
		Usuario novoUsuario = fabricaUsuario.criaUsuario(nome, login, jogosComprados, dinheiro, tipo);
		usuarios.add(novoUsuario);
	}
	
	public void addDinheiro(Usuario usuario, double dinheiroAdicional){
		usuario.setDinheiro( usuario.getDinheiro() + dinheiroAdicional );
	}
	
	public void criaJogo(Usuario usuario, String nomeJogo, double precoJogo, HashSet<Jogabilidade> jogabilidades, String tipoJogo) throws Exception {
		
		if (precoJogo > usuario.getDinheiro()) {
			throw new Exception("Voce nao tem saldo suficiente");
		} else {
			Jogo novoJogo = fabricaJogo.criaJogo(nomeJogo, precoJogo, jogabilidades, tipoJogo);
			usuario.compraJogo(novoJogo);
			
			double valorVenda = usuario.calculaDesconto(precoJogo);
			calcTotalArrecadado(valorVenda);
		}
	}
	
	public void calcTotalArrecadado(double valorVenda){
		this.totalArrecadado = this.totalArrecadado + valorVenda;
	}
	
	public void upgrade(String login) throws Exception {
		
		for (Usuario usuario: usuarios) {
			if (usuario.getLogin().equals("login")){
			
				if (usuario instanceof Veterano) {
					throw new Exception("Usuario ja eh Veterano!");
				} else if (usuario.getX2p() >= 1000) {
			
					String nomeUsuario = usuario.getNome();
					String loginUsuario = usuario.getLogin();
					double dinheiroUsuario = usuario.getDinheiro();
					List<Jogo> jogosUsuario = usuario.getJogosComprados();
					int x2pUsuario = usuario.getX2p();
					
					Usuario novoUsuario = new Veterano(nomeUsuario, loginUsuario, jogosUsuario, dinheiroUsuario);
					novoUsuario.setX2p(x2pUsuario);
				
					usuarios.remove(usuario);
					usuarios.add(novoUsuario);
				}
			}
		} // encerra loop	
	}
	
	public void downgrade(String login) throws Exception{
		
		for (Usuario usuario: usuarios) {
			if (usuario.getLogin().equals("login")){
			
				if (usuario instanceof Noob) {
					throw new Exception("Usuario ja eh Noob!");
				} else if (usuario.getX2p() < 1000) {
			
					String nomeUsuario = usuario.getNome();
					String loginUsuario = usuario.getLogin();
					double dinheiroUsuario = usuario.getDinheiro();
					List<Jogo> jogosUsuario = usuario.getJogosComprados();
					int x2pUsuario = usuario.getX2p();
					
					Usuario novoUsuario = new Noob(nomeUsuario, loginUsuario, jogosUsuario, dinheiroUsuario);
					novoUsuario.setX2p(x2pUsuario);
				
					usuarios.remove(usuario);
					usuarios.add(novoUsuario);
				}
			}
		} // encerra loop	
	}	
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		final String endOfLine = System.getProperty("line.separator");		
		
		sb.append("=== Central P2-CG ===");
		sb.append(endOfLine);
		sb.append(endOfLine);
		
		for (Usuario usuario : usuarios) {
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