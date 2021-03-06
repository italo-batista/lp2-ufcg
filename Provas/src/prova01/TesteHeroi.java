package prova01;

import org.junit.Test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TesteHeroi {
	
	private Heroi kratos;
	private Heroi samusAran;
	private Heroi sylvanas;
	private Heroi mario;
	
	@Before
	public void setUp(){
		mario = new Heroi("Mario", 40.0);
		kratos = new Heroi("Kratos", 100.0);
		samusAran = new Heroi("Samus", 90.0);
		sylvanas = new Heroi("Sylvanas",50);
		
		//Mario causa:
		//   dano total de: 30
		//   cura total de: 20
		Assert.assertTrue(mario.criaPocao("Pocao Cogumelo", 10.0, 20)); 
		Assert.assertTrue(mario.criaArma("Sapato", 30.0, 30));
		Assert.assertFalse(mario.criaPocao("Espada", 50.0, 15));
		
		//Kratos causa:
		//   dano total de: 90
		//   cura total de: 25
		Assert.assertTrue(kratos.criaArma("Corrente", 40.0, 50));
		Assert.assertTrue(kratos.criaArma("Espada", 50.0, 40));
		Assert.assertTrue(kratos.criaPocao("Pocao dos Deuses", 10.0, 25));
		
		//Sylvanas causa: 
		//   dano total de: 30 + 5 = 35
		//   cura total de: 100
		Assert.assertTrue(sylvanas.criaArma("Arco e Flecha", 30.0, 40));
		Assert.assertTrue(sylvanas.criaArma("Pocao Venenosa", 5.0, 10));
		Assert.assertTrue(sylvanas.criaPocao("Pocao Milagrosa", 5.0, 100));
		
		//Samus causa:
		//   dano total: 50 + 30 = 80
		//   cura total: 40
		Assert.assertTrue(samusAran.criaArma("Canhao de Plasma", 50.0, 30));
		Assert.assertFalse(samusAran.criaArma("Missil Nuclear", 100.0, 900));
		Assert.assertTrue(samusAran.criaArma("Missil de Gelo", 30.0, 50));
		Assert.assertTrue(samusAran.criaPocao("Vacina", 10.0, 40));

	}
	
	@Test
	public void testValoresBatalha(){
		kratos.ataca(mario);//mario = 10
		mario.ataca(kratos);//kratos = 70
		
		Assert.assertEquals(10, mario.getHP());
		Assert.assertEquals(70, kratos.getHP());
		
		kratos.cura();//kratos = 95;
		Assert.assertEquals(95, kratos.getHP());
		
		kratos.ataca(mario); //mario = -80; "Mario desmaiou sem chances de voltar com pocao."
		Assert.assertEquals(95, kratos.getHP());
		Assert.assertEquals(-80, mario.getHP());
		
		Assert.assertFalse(mario.cura()); //mario = -80
		
		kratos.ataca(sylvanas);//sylvanas = 10;
		Assert.assertEquals(10, sylvanas.getHP());
		
		Assert.assertTrue(sylvanas.cura()); // sylavas = 100;
		Assert.assertEquals(100, sylvanas.getHP());
		
		sylvanas.ataca(kratos);//kratos = 45;
		sylvanas.ataca(kratos);//kratos = 0; "Kratos desmaiou, mas ainda pode ser curado"
		Assert.assertEquals(-5, kratos.getHP());
		
		Assert.assertTrue(kratos.cura()); //kratos = 20
		Assert.assertEquals(20, kratos.getHP());
		kratos.ataca(sylvanas); //sylvanas = 10;
		Assert.assertEquals(10, sylvanas.getHP());
		
		samusAran.ataca(sylvanas); //sylvanas = -70;
		Assert.assertEquals(-70, sylvanas.getHP());
		samusAran.ataca(kratos); //kratos = -60
		Assert.assertEquals(-60, kratos.getHP());
		Assert.assertFalse(kratos.cura());

	}	
	
	@Test
	public void testMensagemBatalha(){		
		//kratos.ataca(mario);//mario = 10
		//mario.ataca(kratos);//kratos = 70
		
		Assert.assertEquals("Mario ainda tem 10 de vida.", kratos.ataca(mario));
		Assert.assertEquals("Kratos ainda tem 70 de vida.", mario.ataca(kratos));
		
		kratos.cura();//kratos = 95;
		Assert.assertEquals(95, kratos.getHP());
		
		Assert.assertEquals("Mario desmaiou sem chances de voltar com pocao.", kratos.ataca(mario)); //mario = -80		
		Assert.assertFalse(mario.cura()); 
		
		Assert.assertEquals("Sylvanas ainda tem 10 de vida.",kratos.ataca(sylvanas));//sylvanas = 10;
		Assert.assertTrue(sylvanas.cura()); // sylavas = 100;
		Assert.assertEquals(100, sylvanas.getHP());
		
		Assert.assertEquals("Kratos ainda tem 45 de vida.", sylvanas.ataca(kratos));//kratos = 45;
		Assert.assertEquals("Kratos desmaiou, mas ainda pode ser curado.", sylvanas.ataca(kratos));//kratos = -5; "Kratos desmaiou, mas ainda pode ser curado"
		Assert.assertTrue(kratos.cura()); //kratos = 20
		Assert.assertEquals(20, kratos.getHP());
		Assert.assertEquals("Sylvanas ainda tem 10 de vida.", kratos.ataca(sylvanas)); //sylvanas = 10;
		
		Assert.assertEquals("Sylvanas desmaiou sem chances de voltar com pocao.", samusAran.ataca(sylvanas)); //sylvanas = -70;
		Assert.assertEquals("Kratos desmaiou sem chances de voltar com pocao.", samusAran.ataca(kratos)); //kratos = -60
	}
	
}