package lab05;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class NoobTest {

	Noob italoM;
	List<Jogo> jogosComprados;
	
	HashSet jogabilidadesI;
	HashSet jogabilidadesII;
	Plataforma zombieEx;
	Jogo topGear;
	
	@Before
	public void setUp() throws Exception {
		
		jogabilidadesI = new HashSet<Jogabilidade>();
		jogabilidadesI.add(Jogabilidade.OFFLINE);
		
		jogabilidadesII = new HashSet<Jogabilidade>();
		jogabilidadesII.add(Jogabilidade.COMPETITIVO);
		jogabilidadesII.add(Jogabilidade.MULTIPLAYER);
		jogabilidadesII.add(Jogabilidade.OFFLINE);

		zombieEx = new Plataforma("Zombie Exterminator", 30, jogabilidadesI);
		topGear = new Jogo("Top Gear", 100, jogabilidadesII);  
		
		jogosComprados = new ArrayList<Jogo>();
		
		italoM = new Noob("Italo Medeiros", "italo-medeiros", jogosComprados, 200);
		
		Assert.assertEquals("Italo Medeiros", italoM.getNome());
		Assert.assertEquals(200, italoM.getDinheiro(), 0);
		Assert.assertEquals("italo-medeiros", italoM.getLogin());
		Assert.assertEquals(jogosComprados, italoM.getJogosComprados());
		Assert.assertEquals(0, italoM.getX2p(), 0);
	} 

	@Test
	public void testCalcRecompensa() throws SaldoInsuficienteException {
		int recompensa = italoM.calculaRecompensa(topGear);
		Assert.assertTrue(recompensa == 40);
		
		recompensa = italoM.calculaRecompensa(zombieEx);
		Assert.assertTrue(recompensa == 30);		
	}
	
	@Test
	public void testCalcPunicao() {
		int punicao = italoM.calculaPunicao(topGear);
		Assert.assertTrue(punicao == 20);		
	}
		
	@Test
	public void testCalcDesconto() {
		double desconto = italoM.calculaDesconto(30);
		Assert.assertTrue(desconto == 27);
	}
}
