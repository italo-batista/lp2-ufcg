/* 114210196 - Italo Hector de Medeiros Batista: LAB 4 - Turma 3 */

package lab04;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaPerfilPlaylist {

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
		
		italoMedeiros.adicionaAlbum(xx);
		italoMedeiros.adicionaAlbum(caravana);
		
	}

	@Test
	public void testCriaPlaylist() throws Exception {
		
		Assert.assertEquals(xx, italoMedeiros.retornaAlbum("XX"));
		Assert.assertEquals(faltaDeAr, italoMedeiros.retornaMusica("Caravana Sereia Bloom", 0));
		
		try {
			Assert.assertEquals(xx, italoMedeiros.retornaAlbum("xxx"));
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Album nao pertence ao Perfil especificado.");
		}
		
		try {
			Assert.assertEquals(fffree, italoMedeiros.retornaMusica("LeGal", 2));
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Album nao pertence ao Perfil especificado.");
		}
		
		italoMedeiros.adicionaPlaylist("Gotico cansado", "XX", 4);
		Assert.assertEquals(shelter, italoMedeiros.getSuasPlaylist().get("Gotico cansado").getAlbum().get(0));
		
		italoMedeiros.adicionaPlaylist("Gotico cansado", "Caravana Sereia Bloom", 4);
		Assert.assertEquals(shelter, italoMedeiros.getSuasPlaylist().get("Gotico cansado").getAlbum().get(0));
		Assert.assertEquals(streetsBloom, italoMedeiros.getSuasPlaylist().get("Gotico cansado").getAlbum().get(1));
		
		// testa se add musicas numa playlist exclui a playlist anterior
		italoMedeiros.adicionaPlaylist("Faixas Favoritas", "XX", 5);
		Assert.assertEquals(infinity, italoMedeiros.getSuasPlaylist().get("Faixas Favoritas").getAlbum().get(0));
	
		Assert.assertEquals(shelter, italoMedeiros.getSuasPlaylist().get("Gotico cansado").getAlbum().get(0));
		
		// testa se playlist add musicas iguais
		
		try {
			italoMedeiros.adicionaPlaylist("Gotico cansado", "XX", 4);
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Essa musica ja estava na playlist.");
		}
		
		italoMedeiros.adicionaPlaylist("Gotico cansado", "Caravana Sereia Bloom", 2);
		Assert.assertEquals(retrovisor, italoMedeiros.getSuasPlaylist().get("Gotico cansado").getAlbum().get(2));
			
	}

}
