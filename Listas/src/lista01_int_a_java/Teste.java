package lista01_int_a_java;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class Teste {

	ContaBancaria conta1;
	ContaBancaria conta2;
	ContaBancaria conta3;
	
	@Test
	public void test() {
		ContaBancaria conta1 = new ContaBancaria("Italo", 0.0);
		ContaBancaria conta2 = new ContaBancaria("Italo", 0.0);
		ContaBancaria conta3 = new ContaBancaria("Italo", 100.0);
		
		Assert.assertTrue(conta1.equals(conta2));
		Assert.assertTrue(!conta2.equals(conta3));
		Assert.assertTrue(!conta1.equals(conta3));	
		
		try {
			conta1.depositar(100);
			Assert.assertEquals(100.00, conta1.getSaldo(), 0);
		} catch (Exception e) {
			Assert.fail();
		}
		
		try {
			conta2.depositar(-100);
			Assert.fail();
		} catch (Exception e){
			Assert.assertEquals("Nao e possivel depositar quantia negativa.", e.getMessage());
		}
		
	}

}
