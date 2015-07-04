package lista03_her_comp;

import lista01_int_a_java.Papel;

public class Humano extends Raca {

	public Humano() {
		super();
	}
	
	public int ataca(Heroi outroHeroi, int energia, Papel papel){
		energia = energia - 10;
		double dano = papel.ataca();
		outroHeroi.recebeDano(dano);
		if (outroHeroi.vida > 0) { outroHeroi.papel.defende(); }
		return energia;
	}
	
	public double recebeDano(double dano, double vida, Papel papel){
		vida = vida - (dano / 2);
		return vida;
	}
	
	public int cura(Heroi outroHeroi, int energia, Papel papel){
		energia = energia - 10;
		outroHeroi.vida = papel.cura();
		return energia;
	}
		
}
