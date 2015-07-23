package lab06;
/* 114210196 - Italo Hector de Medeiros Batista: LAB 06 - Turma 03 */


public class UsuarioFactory {

	public Usuario criaUsuario(String nome, String login, CatalogoJogos jogosComprados, double dinheiro) throws EntradaException {
		Usuario usuario = new Usuario(nome, login, jogosComprados, dinheiro);		
		return usuario;
	}

}
