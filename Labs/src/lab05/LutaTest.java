package lab05;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LutaTest {

	Luta zombieEx;
	HashSet jogabilidades;
	
	@Before
	public void setUp() throws Exception {
		
		jogabilidades = new HashSet<Jogabilidade>();
		jogabilidades.add(Jogabilidade.OFFLINE);
		
		zombieEx = new Luta("Zombie Exterminator", 22.99, jogabilidades);  
		
		Assert.assertEquals("Zombie Exterminator", zombieEx.getNome());
		Assert.assertEquals(22.99, zombieEx.getPreco(), 0);
		Assert.assertEquals(jogabilidades, zombieEx.getJogabilidades());
		Assert.assertEquals(0, zombieEx.getVezesJogadas(), 0);
		Assert.assertEquals(0, zombieEx.getVezesZeradas(), 0);
		Assert.assertEquals(0, zombieEx.getMaiorScore(), 0);
		
	}

	@Test
	public void testJogaSemZerar() throws DadoInvalidoException {
		
		int x2p = zombieEx.joga(1000, false);
		
		Assert.assertEquals(1, x2p, 0);
		
		Assert.assertEquals(1, zombieEx.getVezesJogadas(), 0);
		Assert.assertEquals(0, zombieEx.getVezesZeradas(), 0);
	}

	@Test
	public void testJogaZera() throws DadoInvalidoException {
				
		zombieEx.joga(1000, true);
		
		Assert.assertEquals(1, zombieEx.getVezesJogadas(), 0);
		Assert.assertEquals(1, zombieEx.getVezesZeradas(), 0);	
	}
	
	@Test
	public void testScoreMaiorMil() throws DadoInvalidoException {
		
		int x2p = zombieEx.joga(1200, true);
		Assert.assertEquals(1, x2p, 0);		
	}
	
	@Test
	public void testMaiorScore() throws DadoInvalidoException {
		
		zombieEx.setMaiorScore(200);
		zombieEx.joga(800, false);
		
		Assert.assertEquals(800, zombieEx.getMaiorScore(), 0);
	}
	
	
}
