package lab05;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LojaTest {

	HashSet jogabilidadesI;
	HashSet jogabilidadesII;
	Plataforma zombieEx;
	Jogo topGear;
	
	Noob italoM;
	List<Jogo> jogosComprados;
	
	ArrayList<Usuario> usuarios;
	JogoFactory fabricaJogo;
	UsuarioFactory fabricaUsuario;
	double totalArrecadado;

	Loja loja;
	
	@Before
	public void setUp() throws EntradaException, TipoUsuarioException {
		
		jogabilidadesI = new HashSet<Jogabilidade>();
		jogabilidadesI.add(Jogabilidade.OFFLINE);
		
		jogabilidadesII = new HashSet<Jogabilidade>();
		jogabilidadesII.add(Jogabilidade.COMPETITIVO);
		jogabilidadesII.add(Jogabilidade.MULTIPLAYER);
		jogabilidadesII.add(Jogabilidade.OFFLINE);

		zombieEx = new Plataforma("Zombie Exterminator", 30, jogabilidadesI);
		topGear = new Jogo("Top Gear", 100, jogabilidadesII);  
		
		jogosComprados = new ArrayList<Jogo>();
		
		italoM = new Noob("Italo Medeiros", "italo-medeiros", jogosComprados, 500);
		
		usuarios = new ArrayList<Usuario>();
		fabricaJogo = new JogoFactory();
		fabricaUsuario = new UsuarioFactory();
		totalArrecadado = 0;
		
		loja = new Loja();
		
		
		loja.novoUsuario("Italo Medeiros", "italo-medeiros", jogosComprados, 500, "Noob");
			
		Assert.assertEquals("Italo Medeiros", italoM.getNome());
		Assert.assertEquals(500, italoM.getDinheiro(), 0);
		Assert.assertEquals("italo-medeiros", italoM.getLogin());
		Assert.assertEquals(jogosComprados, italoM.getJogosComprados());
		Assert.assertEquals(0, italoM.getX2p(), 0);
	}
	
	@Test
	public void testNovoUsuario() throws TipoUsuarioException, EntradaException {
		loja.novoUsuario("Dandara", "dandara", jogosComprados, 300, "Noob");
		Assert.assertEquals("Dandara", usuarios.get(0).getNome());
	}
	
	@Test
	public void testAddDinheiro() {
		loja.addDinheiro(italoM, 500);
		Assert.assertEquals(1000, italoM.getDinheiro(), 0);
		
	}

}
