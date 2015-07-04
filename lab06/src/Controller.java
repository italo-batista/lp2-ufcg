import java.util.HashSet;
import java.util.List;
import exceptions.*;

public class Controller {

	private Loja loja;
	private JogoFactory fabricaJogo;
	private UsuarioFactory fabricaUsuario;
	
	public Controller() {
		fabricaJogo = new JogoFactory();
		fabricaUsuario = new UsuarioFactory();
		loja = new Loja();
	}
	
	public void novoUsuario(String nome, String login, List jogosComprados, double dinheiro, String tipo) throws EntradaException, TipoUsuarioException {
			Usuario novoUsuario = fabricaUsuario.criaUsuario(nome, login, jogosComprados, dinheiro, tipo);
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

	public void upgrade(String login) throws LogicaExcpetion, EntradaException, UpgradeInvalidoException {
		
		for (Usuario usuario: loja.getUsuarios() ) {
			
			if (usuario.getLogin().equals(login)){
			
				if (usuario instanceof Veterano) {
					throw new UpgradeInvalidoException(usuario.getNome());
					
				} else if (usuario.getX2p() < 1000) {
					throw new UpgradeInvalidoException();
					
				} else {
					String nomeUsuario = usuario.getNome();
					String loginUsuario = usuario.getLogin();
					double dinheiroUsuario = usuario.getDinheiro();
					List<Jogo> jogosUsuario = usuario.getJogosComprados();
					int x2pUsuario = usuario.getX2p();
					
					Usuario novoUsuario = fabricaUsuario.criaUsuarioVeterano(nomeUsuario, loginUsuario, jogosUsuario, dinheiroUsuario);
					novoUsuario.setX2p(x2pUsuario);
					
					loja.removeUsuario(usuario);
					loja.armazenaUsuario(novoUsuario);
				}
			} else {
				throw new UsuarioInexistenteException();
			}
		} // encerra loop	
	}
	
	public void downgrade(String login) throws  DowngradeInvalidoException, EntradaException, UsuarioInexistenteException {
		
		for (Usuario usuario: loja.getUsuarios() ) {
			if (usuario.getLogin().equals(login)){
			
				if (usuario instanceof Noob) {
					throw new DowngradeInvalidoException(usuario.getNome());
				} else if (usuario.getX2p() >= 1000) {
					throw new DowngradeInvalidoException();
				} else {
					String nomeUsuario = usuario.getNome();
					String loginUsuario = usuario.getLogin();
					double dinheiroUsuario = usuario.getDinheiro();
					List<Jogo> jogosUsuario = usuario.getJogosComprados();
					int x2pUsuario = usuario.getX2p();
					
					Usuario novoUsuario = fabricaUsuario.criaUsuarioNoob(nomeUsuario, loginUsuario, jogosUsuario, dinheiroUsuario);

					novoUsuario.setX2p(x2pUsuario);
				
					loja.removeUsuario(usuario);
					loja.armazenaUsuario(novoUsuario);
				}
				
			} else {
				throw new UsuarioInexistenteException();
			}
		} // encerra loop	
	}	
	
}