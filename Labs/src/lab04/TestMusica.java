/* 114210196 - Italo Hector de Medeiros Batista: LAB 4 - Turma 3 */

package lab04;

import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.Assert;

public class TestMusica {

	@Test
	public void testMusica(){
		try{
			Musica chandelier = new Musica("Chandelier",3,"Pop");
			Musica elasticHeart = new Musica("Elastic Heart",3,"Pop");
			Musica cellophane = new Musica("Cellophane",4,"Pop");
			
			Assert.assertEquals("Chandelier", chandelier.getNome());
			Assert.assertEquals(3, chandelier.getDuracao());
			Assert.assertEquals("Pop", chandelier.getGenero());

			Assert.assertEquals("Elastic Heart", elasticHeart.getNome());
			Assert.assertEquals(3, elasticHeart.getDuracao());
			Assert.assertEquals("Pop", elasticHeart.getGenero());
			
			Assert.assertEquals("Cellophane", cellophane.getNome());
			Assert.assertEquals(4, cellophane.getDuracao());
			Assert.assertEquals("Pop", cellophane.getGenero());
			
			Musica chandelierRemix = new Musica("Chandelier",3,"Pop");
			Assert.assertEquals(chandelier, chandelierRemix);
			Assert.assertFalse(chandelier.equals(cellophane));

		}catch(Exception e){
			Assert.fail();//nao deveria ter lancado nenhuma Exception nesse teste.
		}
	}
	
	@Test
	public void testMusicasIguais() {
		try {
			Musica chandelier = new Musica("Chandelier",3,"Pop");
			Musica cellophane = new Musica("Chandelier",3,"Pop");
			
			Assert.assertTrue(chandelier.equals(cellophane));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testMusicaInvalida(){

		try {
			Musica tituloInvalido = new Musica("",3,"Pop");
			Assert.fail(); //se chegar aqui da erro, pois deveria lancar exception.
		} catch (Exception e) {
			Assert.assertEquals("Titulo da musica nao pode ser vazio.", e.getMessage());
		}

		try {
			Musica duracaoInvalida = new Musica("Elastic Heart",-5,"Pop");
			Assert.fail(); //se chegar aqui da erro, pois deveria lancar exception.
		} catch (Exception e) {
			Assert.assertEquals("Duracao da musica nao pode ser negativa.", e.getMessage());
		}
		
		
		try {
			Musica tipoInvalido = new Musica("Cellophane",4,"");
			Assert.fail(); //se chegar aqui da erro, pois deveria lancar exception.
		} catch (Exception e) {
			Assert.assertEquals("Genero da musica nao pode ser vazio.", e.getMessage());
		}
		
	}
}