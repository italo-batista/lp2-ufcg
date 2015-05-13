package lab04;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class TestAlbum {

	@Test
	public void testCriaAlbum() {
		try {
			Album cantoLivre = new Album("O Canto Livre", "Nara Leao", 1962);
			Assert.assertEquals("O Canto Livre", cantoLivre.getTitulo());
			Assert.assertEquals("Nara Leao", cantoLivre.getArtista());
			Assert.assertEquals(1962, cantoLivre.getAnoLancamento());
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testAddMusica() {
		try {
			Album cenaMuda = new Album("A cena Muda", "Maria Bethania", 1974);
			Musica demoniaca = new Musica("Demoniaca", 3, "MPB");
			cenaMuda.addMusica(demoniaca);
		 	
			Musica ultimaMusica = cenaMuda.getAlbum().get(-1);
			Assert.assertEquals(demoniaca, ultimaMusica);
			Assert.assertEquals(3, cenaMuda.getDuracaoTotal());
		
		} catch (Exception e) {
			Assert.fail();
		}
		
		try {
			Album medulla = new Album("Medulla", "Bjork", 2004);
			Musica oceania = new Musica("Oceania", 4, "Indie");
			medulla.addMusica(oceania);
			
			Musica submarine = new Musica("Submarine", 4, "Indie");
			medulla.addMusica(submarine);
			
			Musica mouthsCradle = new Musica("Mouths Cradle", 5, "Indie");
			medulla.addMusica(mouthsCradle);			
			
			Assert.assertEquals(medulla.getAlbum().get(0).getNome(), "Oceania");
			Assert.assertEquals(medulla.getAlbum().get(1).getNome(), "Submarine");
			Assert.assertEquals(medulla.getAlbum().get(2).getNome(), "Mouths Cradle");

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testAlbunsIguais(){
		try {
			Album cenaMuda = new Album("A cena Muda", "Maria Bethania", 1974);
			Album aCenaMuda = new Album("A cena Muda", "Maria Bethania", 1974);
			
			Assert.assertTrue(cenaMuda.equals(aCenaMuda));
		} catch (Exception e) {
			Assert.fail();
		}	
	}
	
}