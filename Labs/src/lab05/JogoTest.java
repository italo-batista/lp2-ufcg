package lab05;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JogoTest {

	HashSet jogabilidades;
	Jogo zombieEx;
	
	@Before
	public void setUp() throws Exception {
	
		jogabilidades = new HashSet<Jogabilidade>();
		jogabilidades.add(Jogabilidade.OFFLINE);
		
		zombieEx = new Jogo("Zombie Exterminator", 22.99, jogabilidades);  
		
		Assert.assertEquals("Zombie Exterminator", zombieEx.getNome());
		Assert.assertEquals(22.99, zombieEx.getPreco(), 0);
		Assert.assertEquals(jogabilidades, zombieEx.getJogabilidades());
		Assert.assertEquals(0, zombieEx.getVezesJogadas(), 0);
		Assert.assertEquals(0, zombieEx.getVezesZeradas(), 0);
		Assert.assertEquals(0, zombieEx.getMaiorScore(), 0);
	}

	@Test
	public void testJogosInvalidos() throws EntradaException {
		
		try {
			Jogo zombieEx = new Jogo("", -10, jogabilidades);
			Assert.fail();
		} catch (StringInvalidaException e) {
			Assert.assertEquals("Insira um nome valido.", e.getMessage());
		} catch (DadoInvalidoException e) {
			Assert.assertEquals("Preco nao pode ser negativo.", e.getMessage());
		}
	}
	
	
	@Test
	public void testJogarInvalido() throws EntradaException {
		try {
			zombieEx.joga(-100, false);
			Assert.fail();
		} catch (DadoInvalidoException e){
			Assert.assertEquals("Score nao pode ser negativo.", e.getMessage());
		}
	}
	
	
}
