

import java.util.HashSet;

import exceptions.EntradaException;
import exceptions.TipoJogoException;

public class JogoFactory {
	
	public Jogo criaJogoRPG(String nome, double preco, HashSet<Jogabilidade> jogabilidades) throws EntradaException{
		Jogo novoJogo = new RPG(nome, preco, jogabilidades);
		return novoJogo;
	}
	
	public Jogo criaJogoLuta(String nome, double preco, HashSet<Jogabilidade> jogabilidades) throws EntradaException{
		Jogo novoJogo = new Luta(nome, preco, jogabilidades);
		return novoJogo;
	}
	
	public Jogo criaJogoPlataforma(String nome, double preco, HashSet<Jogabilidade> jogabilidades) throws EntradaException{
		Jogo novoJogo = new Plataforma(nome, preco, jogabilidades);
		return novoJogo;
	}
	
	public Jogo criaJogo(String nome, double preco, HashSet<Jogabilidade> jogabilidades, String tipo) throws EntradaException, TipoJogoException {
		Jogo novoJogo = null;
		
		if(tipo.equals("RPG")){
			novoJogo = this.criaJogoRPG(nome, preco, jogabilidades);	
		} else if(tipo.equals("Luta")){
			novoJogo = this.criaJogoLuta(nome, preco, jogabilidades);
		} else if(tipo.equals("Plataforma")){
			novoJogo = this.criaJogoPlataforma(nome, preco, jogabilidades);
		} else {
			throw new TipoJogoException();
		}
		
		return novoJogo;
	}
}
