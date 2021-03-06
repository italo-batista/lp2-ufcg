package lab06;
/* 114210196 - Italo Hector de Medeiros Batista: LAB 06 - Turma 03 */

import java.util.HashSet;

public class Façade {

	private Controller controller;
	
	public Façade() {
		controller = new Controller();
	}
	
	public void novoUsuario(String nome, String login, CatalogoJogos jogosComprados, double dinheiro, String tipo) throws TipoUsuarioException, EntradaException{
		try {
			controller.novoUsuario(nome, login, jogosComprados, dinheiro, tipo);
		} catch (StringInvalidaException e) {
			System.out.println(e.getMessage());
		} catch (DadoInvalidoException e) {
			System.out.println(e.getMessage());
		} 
	}
	
	public void criaJogo(Usuario usuario, String nomeJogo, double precoJogo, HashSet<Jogabilidade> jogabilidades, String tipoJogo)
			throws EntradaException, SaldoInsuficienteException, TipoJogoException {
		
		try {
			controller.criaJogo(usuario, nomeJogo, precoJogo, jogabilidades, tipoJogo);
		} catch (StringInvalidaException e) {
			System.out.println(e.getMessage());
		} catch (DadoInvalidoException e) {
			System.out.println(e.getMessage());
		} 
	}

	public void addDinheiro(Usuario usuario, double dinheiroAdicional){
		controller.addDinheiro(usuario, dinheiroAdicional);
	}
		
}
