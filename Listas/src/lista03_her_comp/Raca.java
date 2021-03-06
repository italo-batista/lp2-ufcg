package lista03_her_comp;

import lista01_int_a_java.Papel;

public class Raca {
	
	public Raca() {
		
	}
	
	public int ataca(Heroi outroHeroi, int energia, Papel papel){
		energia = energia - 20;
		double dano = papel.ataca();
		outroHeroi.recebeDano(dano);
		if (outroHeroi.vida > 0) { outroHeroi.papel.defende(); }
		return energia;
	}
	
	public double recebeDano(double dano, double vida, Papel papel){
		vida = vida - dano;
		return vida;
	}
	
	public int cura(Heroi outroHeroi, int energia, Papel papel){
		energia = energia - 20;
		outroHeroi.vida = papel.cura();
		return energia;
	}
	
	public int recuperaEnergia(int energia, Papel papel){
		energia = energia + 50;
		if (energia > 100) {
			energia = 100;
		}
		return energia;
	}

}
