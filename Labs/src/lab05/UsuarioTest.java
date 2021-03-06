package lab05;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class UsuarioTest {

	Usuario italoM;
	List<Jogo> jogosComprados;
	
	HashSet jogabilidadesI;
	HashSet jogabilidadesII;
	Jogo zombieEx;
	Jogo topGear;
	
	@Before
	public void setUp() throws Exception {
		
		jogabilidadesI = new HashSet<Jogabilidade>();
		jogabilidadesI.add(Jogabilidade.OFFLINE);
		zombieEx = new Jogo("Zombie Exterminator", 30, jogabilidadesI);
		
		jogabilidadesII = new HashSet<Jogabilidade>();
		jogabilidadesII.add(Jogabilidade.COMPETITIVO);
		jogabilidadesII.add(Jogabilidade.MULTIPLAYER);
		jogabilidadesII.add(Jogabilidade.OFFLINE);
		topGear = new Jogo("Top Gear", 100, jogabilidadesII);  
		
		jogosComprados = new ArrayList<Jogo>();
		
		italoM = new Usuario("Italo Medeiros", "italo-medeiros", jogosComprados, 200);
		
		Assert.assertEquals("Italo Medeiros", italoM.getNome());
		Assert.assertEquals(200, italoM.getDinheiro(), 0);
		Assert.assertEquals("italo-medeiros", italoM.getLogin());
		Assert.assertEquals(jogosComprados, italoM.getJogosComprados());
		Assert.assertEquals(0, italoM.getX2p(), 0);	
	} 

	@Test
	public void testUsuarioInvalido() throws EntradaException {
				
		try {
			italoM = new Usuario("", null, jogosComprados, -10);
		} catch (StringInvalidaException e) {
			Assert.assertEquals("Insira um nome valido.", e.getMessage());
		} catch (DadoInvalidoException e) {
			Assert.assertEquals("Dinheiro de usuario nao pode ser negativo.", e.getMessage());
		}
		
		try {
			italoM = new Usuario("Italo Medeiros", null, jogosComprados, -10);
		} catch (StringInvalidaException e) {
			Assert.assertEquals("Insira um login valido.", e.getMessage());
		}
	}
	
	@Test
	public void testCompraJogo() throws SaldoInsuficienteException, EntradaException {
		
		italoM.compraJogo(topGear);
		italoM.compraJogo(zombieEx);
		Assert.assertEquals(2, jogosComprados.size(), 0.1);
		Assert.assertEquals(70, italoM.getDinheiro(), 0);
	}
	
	@Test
	public void testCompraJogoInvalido() throws SaldoInsuficienteException, EntradaException {
		try {
			topGear.setPreco(1000);
			italoM.compraJogo(topGear);
			italoM.compraJogo(zombieEx);
		} catch (SaldoInsuficienteException e) {
			Assert.assertEquals("Voce nao tem saldo suficiente", e.getMessage());
		}	
	}
	
	@Test
	public void testCalculaX2pCompra() throws EntradaException {
		
		italoM.calculaX2pCompra(topGear);
		int novo2xp = 10 * (int) topGear.getPreco();
		
		Assert.assertEquals(1000, italoM.getX2p());
		
	}
	
	public void testRecompensa() throws DadoInvalidoException {
		italoM.recompensar("Top Gear", 1000, false);
		Assert.assertEquals(0, italoM.getX2p(), 0);		
	}
	
	public void testPunir() throws DadoInvalidoException {
		italoM.punir("Top Gear", 1000, false);
		Assert.assertEquals(0, italoM.getX2p(), 0);	
		
	}
	
	
	
}