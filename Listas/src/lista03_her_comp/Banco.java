package lista03_her_comp;

import java.util.ArrayList;
import java.util.List;

import lista01_int_a_java.ContaBancaria;

public class Banco {

	List<ContaBancaria> agencia;
	
	public Banco() {
		agencia = new ArrayList<ContaBancaria>();
	}
	
	public void criaConta(String nomeTitular, double saldoInicial) {
		ContaBancaria novaConta = new ContaBancaria(nomeTitular, saldoInicial);
		armazenaConta(novaConta);
	}
	
	public void armazenaConta(ContaBancaria novaConta){
		agencia.add(novaConta);
	}
	
	public void fechaConta(ContaBancaria contaFechada){
		agencia.remove(contaFechada);
	}
	/*​
	Crie   a   classe   Banco   que   pode   criar,   armazenar   e   fechar   contas.
	Além   disso   o   banco   pode fornecer   o   financiamento   e   projeção   de   lucro   de   qualquer   conta,
	por   meio   do   nome   do   titular   da conta.   Além   disso,   o   banco   pode   também   calcular
	o   total   de   dinheiro   necessário   para   fornecer   o financiamento a todos os seus clientes
	(cada cliente possui apenas uma conta no banco). 
	 */
	
	
	
}
