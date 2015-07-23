package lab06;
/* 114210196 - Italo Hector de Medeiros Batista: LAB 06 - Turma 03 */

import java.util.HashSet;

public class Controller {

	private Loja loja;
	private JogoFactory fabricaJogo;
	private UsuarioFactory fabricaUsuario;
	
	public Controller() {
		fabricaJogo = new JogoFactory();
		fabricaUsuario = new UsuarioFactory();
		loja = new Loja();
	}

	public void novoUsuario(String nome, String login, CatalogoJogos jogosComprados, double dinheiro, String tipo) throws EntradaException {
			Usuario novoUsuario = fabricaUsuario.criaUsuario(nome, login, jogosComprados, dinheiro);
			loja.armazenaUsuario(novoUsuario);
	}
	
	public void criaJogo(Usuario usuario, String nomeJogo, double precoJogo, HashSet<Jogabilidade> jogabilidades, String tipoJogo)
			throws EntradaException, SaldoInsuficienteException, TipoJogoException {
		
		try {
			Jogo novoJogo = fabricaJogo.criaJogo(nomeJogo, precoJogo, jogabilidades, tipoJogo);
			usuario.compraJogo(novoJogo);
		} catch (StringInvalidaException e) {
			System.out.println(e.getMessage());
		} catch (DadoInvalidoException e) {
			System.out.println(e.getMessage());
		} 
		
		double valorVenda = usuario.calculaDesconto(precoJogo);
		loja.calcTotalArrecadado(valorVenda);
	}
	
	public void addDinheiro(Usuario usuario, double dinheiroAdicional){
		usuario.setDinheiro( usuario.getDinheiro() + dinheiroAdicional );
	}

	public void imprimeTop5Usuarios(){
		loja.ordenaUsuarios();
		
		for (int i = 0; i < loja.getUsuarios().size(); i++) {
			if (i <= 4) {
				System.out.println( loja.getUsuarios().get(i) );
			}
		}
	}
	
}