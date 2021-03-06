package lab05;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class UsuarioFactoryTest {

	ArrayList jogosComprados;
	Usuario novoUsuario;
	UsuarioFactory fabricaUsuario= new UsuarioFactory();
	
	@Test
	public void testCriaJogos() throws TipoJogoException, EntradaException, TipoUsuarioException {
		
		jogosComprados = new ArrayList<Jogo>();
	
		novoUsuario = fabricaUsuario.criaUsuario("Italo Medeiros", "italo-medeiros", jogosComprados, 200, "Veterano");
		
		Assert.assertEquals("Italo Medeiros", novoUsuario.getNome());
		Assert.assertEquals("italo-medeiros", novoUsuario.getLogin());
		Assert.assertEquals(200, novoUsuario.getDinheiro(), 0);
		Assert.assertEquals(jogosComprados, novoUsuario.getJogosComprados());
		Assert.assertTrue(novoUsuario instanceof Veterano);
		
		novoUsuario = fabricaUsuario.criaUsuario("Italo Medeiros", "italo-medeiros", jogosComprados, 200, "Noob");
		Assert.assertTrue(novoUsuario instanceof Noob);

	}
}
