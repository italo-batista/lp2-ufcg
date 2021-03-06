package lista01_int_a_java;

import java.awt.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class CaixaEletronico {

	public static void main(String[] args) {
		
		HashSet<ContaBancaria> contas = new HashSet<ContaBancaria>();
		Map<String, Double> titularDeposito = new HashMap();
		
		ContaBancaria conta1 = new ContaBancaria("Italo", 0.0);
		ContaBancaria conta2 = new ContaBancaria("Eu", 0.0);
		ContaBancaria conta3 = new ContaBancaria("Oi", 100.0);
		
		contas.add(conta3);
		contas.add(conta2);
		contas.add(conta1);
	
		Iterator<ContaBancaria> iterator = contas.iterator();
		while (iterator.hasNext()) {
			ContaBancaria conta = iterator.next();
			System.out.println(conta);		
		}
		
		
		
		
	}

}
