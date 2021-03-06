/* 114210196 - Italo Hector de Medeiros Batista: LAB 4 - Turma 3 */

package lab04;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaPerfilSimples {

	Musica intro;
	Musica vcr;
	Musica islands;
	Musica fantasy;
	Musica shelter;
	Musica infinity;
	
	Album xx;
	
	Musica faltaDeAr;
	Musica amorDeAntigos;
	Musica retrovisor;
	Musica fffree;
	Musica streetsBloom;
	Musica chegarEmMim;
	
	Album caravana;
	
	Perfil italoMedeiros;
	
	@Before
	public void setUp() throws Exception {
		
		this.intro = new Musica("Intro", 2, "Indie");
		this.vcr = new Musica("VCR", 4, "Indie");
		this.islands = new Musica("Islands", 4, "Indie");
		this.fantasy = new Musica("Fantasy", 4, "Indie");
		this.shelter = new Musica("Shelter", 5, "Indie");
		this.infinity = new Musica("Infinity", 3, "Indie");
		
		this.faltaDeAr = new Musica("Falta de Ar", 4, "Indie");
		this.amorDeAntigos = new Musica("Amor de Antigos", 3, "Indie");
		this.retrovisor = new Musica("Retrovisor", 2, "Indie");
		this.fffree = new Musica("Fffree", 1, "Indie");
		this.streetsBloom = new Musica("Streets Bloom", 3, "Indie");
		this.chegarEmMim = new Musica("Chegar em mim", 3, "Indie");
		
		this.xx = new Album("XX", "The XX", 2009);
		this.caravana = new Album("Caravana Sereia Bloom", "Ceu", 2012);
		
		this.xx.addMusica(intro);
		this.xx.addMusica(vcr);
		this.xx.addMusica(islands);
		this.xx.addMusica(fantasy);
		this.xx.addMusica(shelter);
		this.xx.addMusica(infinity);
		
		this.caravana.addMusica(faltaDeAr);
		this.caravana.addMusica(amorDeAntigos);
		this.caravana.addMusica(retrovisor);
		this.caravana.addMusica(fffree);
		this.caravana.addMusica(streetsBloom);
		this.caravana.addMusica(chegarEmMim);
		
		this.italoMedeiros = new Perfil("italo-medeiros");
	}
	
	@Test
	public void testAddAlbum() {
		
		italoMedeiros.adicionaAlbum(xx);
		italoMedeiros.adicionaAlbum(caravana);
		
		Assert.assertEquals(italoMedeiros.getSeusAlbuns().get(0), xx);
		Assert.assertEquals(italoMedeiros.getSeusAlbuns().get(1), caravana);
	}

	@Test
	public void testAddFavoritos() {
		italoMedeiros.adicionaAosFavoritos(caravana);
		Assert.assertEquals(italoMedeiros.getAlbunsFavoritos().get(0), caravana);
	}
	
	
}
