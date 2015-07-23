

import java.util.List;

import exceptions.EntradaException;
import exceptions.TipoUsuarioException;

public class UsuarioFactory {

	public Usuario criaUsuarioNoob(String nome, String login, List jogosComprados, double dinheiro) throws EntradaException {
		Usuario usuario = new Noob(nome, login, jogosComprados, dinheiro);
		return usuario;
	}

	public Usuario criaUsuarioVeterano(String nome, String login, List jogosComprados, double dinheiro) throws EntradaException {
		Usuario usuario = new Veterano(nome, login, jogosComprados, dinheiro);
		return usuario;
	}

	public Usuario criaUsuario(String nome, String login, List jogosComprados, double dinheiro, String tipo) throws EntradaException, TipoUsuarioException {
		Usuario usuario = null;

		if (tipo.equals("Noob")) {
			usuario = criaUsuarioNoob(nome, login, jogosComprados, dinheiro);
		} else if (tipo.equals("Veterano")) {
			usuario = criaUsuarioVeterano(nome, login, jogosComprados, dinheiro);
		} else {
			throw new TipoUsuarioException();
		}
		
		return usuario;
	}

}
