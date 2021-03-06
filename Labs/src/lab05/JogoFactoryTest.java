package lab05;

import static org.junit.Assert.*;

import java.util.HashSet;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JogoFactoryTest {

	HashSet jogabilidades;
	Jogo novoJogo;
	JogoFactory fabricaJogo = new JogoFactory();
	
	@Test
	public void testCriaJogos() throws TipoJogoException, EntradaException {
		
		jogabilidades = new HashSet<Jogabilidade>();
		jogabilidades.add(Jogabilidade.OFFLINE);
		
		novoJogo = fabricaJogo.criaJogo("Zombie Exterminator", 20, jogabilidades, "RPG");
		
		Assert.assertEquals("Zombie Exterminator", novoJogo.getNome());
		Assert.assertEquals(20, novoJogo.getPreco(), 0);
		Assert.assertEquals(jogabilidades, novoJogo.getJogabilidades());
		Assert.assertEquals(0, novoJogo.getVezesJogadas(), 0);
		Assert.assertEquals(0, novoJogo.getVezesZeradas(), 0);
		Assert.assertEquals(0, novoJogo.getMaiorScore(), 0);
		
		Assert.assertTrue(novoJogo instanceof RPG);
		
		novoJogo = fabricaJogo.criaJogo("Zombie Exterminator", 20, jogabilidades, "Plataforma");
		Assert.assertTrue(novoJogo instanceof Plataforma);
		
		novoJogo = fabricaJogo.criaJogo("Zombie Exterminator", 20, jogabilidades, "Luta");
		Assert.assertTrue(novoJogo instanceof Luta);
		
	}



}
