package lista01_int_a_java;

public class ContaBancaria {

	private String nomeTitular;
	private double saldo;

	Tela tela = new Tela();

	public ContaBancaria(String nomeTitular, double saldo) {
		this.nomeTitular = nomeTitular;
		this.saldo = saldo;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void depositar(double quantia) throws Exception {
		if (quantia >= 0) {
			this.saldo = this.saldo + quantiaTarifada(quantia);
		} else {
			throw new Exception("Nao e possivel depositar quantia negativa.");
		}
	}

	public double quantiaTarifada(double quantia) {
		if (this.saldo < 0) {
			return (quantia * 0.9);
		}
		return quantia;
	}

	public void sacar(double quantia) {

		if (quantia <= this.saldo) {
			this.saldo = this.saldo - quantia;
		} else {
			emprestimo(quantia);
			tela.fezEmprestimo();
		}
	}

	public void emprestimo(double quantia) {
		this.saldo = this.saldo - quantia;
	}

	@Override
	public String toString() {
		String toString = "Esta conta, cujo titular e " + getNomeTitular()
				+ " possui saldo de " + getSaldo() + ".";
		return toString;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomeTitular == null) ? 0 : nomeTitular.hashCode());
		long temp;
		temp = Double.doubleToLongBits(saldo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		} if (obj instanceof ContaBancaria) {
			
			ContaBancaria otherCount = (ContaBancaria) obj;
			String outroTitular = otherCount.getNomeTitular();
			double outroSaldo = otherCount.getSaldo();
			
			if (this.getNomeTitular().equals(outroTitular)
					&& this.getSaldo() == (outroSaldo)) {
					return true;
			}
		}  
		
		return false;
		
	} // encerra metodo equals
	
}
