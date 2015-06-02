package lab04;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class TestAlbum {
    
	Album medulla;
	
	Musica submarine;
	Musica mouthsCradle;
	Musica oceania;
	Musica ancestors;
	
	@Before
	public void setUp() throws Exception {
		
		medulla = new Album("Medulla", "Bjork", 2004);
		
		submarine = new Musica("Submarine", 4, "Indie");
		mouthsCradle = new Musica("Mouths Cradle", 5, "Indie");
		oceania = new Musica("Oceania", 4, "Indie");
		ancestors = new Musica("Ancestors", 5, "Indie");

		Assert.assertEquals("Medulla", medulla.getTitulo());
		Assert.assertEquals("Bjork", medulla.getArtista());
		Assert.assertEquals(2004, medulla.getAnoLancamento());
		//Album cantoLivre = new Album("O Canto Livre", "Nara Leao", 1962);
	}
	
	@Test
	public void testAlbumInvalido() {
			
		try {
			Album cantoLivre = new Album("", "Nara Leao", 1962);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Nao e possivel cadastrar album sem titulo.", e.getMessage());
		}
		
		try {
			Album cantoLivre = new Album("O Canto Livre", "", 1962);
		} catch (Exception e) {
			Assert.assertEquals("Nao e possivel cadastrar album sem artista.", e.getMessage());
		}

		try {
			Album cantoLivre = new Album("O Canto Livre", "Nara Leao", -24);
		} catch (Exception e) {
			Assert.assertEquals("Nao e possivel cadastrar album sem artista.", e.getMessage());
		}
	}
	
	@Test
	public void testAddMusica() throws Exception{
		
		medulla.addMusica(oceania);
		medulla.addMusica(submarine);
		medulla.addMusica(mouthsCradle);			
			
		Assert.assertEquals(medulla.getAlbum().get(0).getNome(), "Oceania");
		Assert.assertEquals(medulla.getAlbum().get(1).getNome(), "Submarine");
		Assert.assertEquals(medulla.getAlbum().get(2).getNome(), "Mouths Cradle");
			
		Assert.assertEquals(13, medulla.getDuracaoTotal(), 0);
	}
	
	@Test
	public void testRemoveMusica() throws Exception {
		
		medulla.addMusica(oceania);
		medulla.addMusica(submarine);
		medulla.addMusica(mouthsCradle);
		medulla.addMusica(ancestors);
		
		Assert.assertEquals(medulla.getAlbum().get(3).getNome() , "Ancestors");
		
		medulla.removeMusica(ancestors);
		Assert.assertEquals(mouthsCradle, medulla.getAlbum().get(2));
		
		
		try {
			medulla.removeMusica(ancestors);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Essa musica ja nao estava inclusa no album.");
		}

	}

	@Test
	public void testAlbunsIguais(){
		try {
			Album drama = new Album("Drama - Anjo Exterminado", "Maria Bethania", 1972);
			Album anjoExterminado = new Album("Drama - Anjo Exterminado", "Maria Bethania", 1972);
			
			Assert.assertTrue(drama.equals(anjoExterminado));
		} catch (Exception e) {
			Assert.fail();
		}	
	}
	
}
