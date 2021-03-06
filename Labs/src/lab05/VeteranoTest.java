package lab05;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VeteranoTest {

	Veterano italoM;
	List<Jogo> jogosComprados;
	
	HashSet jogabilidadesI;
	HashSet jogabilidadesII;
	Jogo zombieEx;
	Jogo topGear;
	
	@Before
	public void setUp() throws Exception {
		
		jogabilidadesI = new HashSet<Jogabilidade>();
		jogabilidadesI.add(Jogabilidade.OFFLINE);
		zombieEx = new Jogo("Zombie Exterminator", 22.99, jogabilidadesI);
		
		jogabilidadesII = new HashSet<Jogabilidade>();
		jogabilidadesII.add(Jogabilidade.COMPETITIVO);
		jogabilidadesII.add(Jogabilidade.MULTIPLAYER);
		jogabilidadesII.add(Jogabilidade.OFFLINE);
		topGear = new Jogo("Top Gear", 100, jogabilidadesII);  
		
		jogosComprados = new ArrayList<Jogo>();
		
		italoM = new Veterano("Italo Medeiros", "italo-medeiros", jogosComprados, 200);
		
		Assert.assertEquals("Italo Medeiros", italoM.getNome());
		Assert.assertEquals(200, italoM.getDinheiro(), 0);
		Assert.assertEquals("italo-medeiros", italoM.getLogin());
		Assert.assertEquals(jogosComprados, italoM.getJogosComprados());
		Assert.assertEquals(0, italoM.getX2p(), 0);	
	} 
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
