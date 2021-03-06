package lista03_her_comp;

import lista01_int_a_java.*;

public class Heroi {

	String nome;
	double vida;
	int energia;
	int destreza;
	Raca raca;
	Papel papel;
	
	public Heroi(Papel papel, String nome, int destreza, Raca raca) throws Exception {
		
		this.papel = papel;
		this.nome = nome;
		this.energia = 100;
		
		if (raca.equals("Elfo")) { this.vida = 130; } else { this.vida = 100; }
		
		if (destreza < 1 || destreza > 100) {
			throw new Exception("Informe um valor entre 1 e 100.");
		} else {
			this.destreza = destreza;
		}
	}
	
	public void ataca(Heroi outroHeroi){ 
		this.energia = raca.ataca(outroHeroi, this.energia, this.papel);
	}
	
	public void recebeDano(double  dano){
		this.vida = raca.recebeDano(dano, this.vida, this.papel);
	}
	
	public void cura(Heroi outroHeroi){
		this.energia = raca.cura(outroHeroi, energia, this.papel);
	}
	
	public void recuperaEnergia(){
		this.energia = raca.recuperaEnergia(energia, papel);
	}

	public void transformaEmProtetor(){
		int poder = papel.getPoder();
		int defesa = papel.getDefesa();
		this.papel = new Protetor(poder, defesa);
	}
	
	public void transformaEmCurandeiro(){
		int poder = papel.getPoder();
		int defesa = papel.getDefesa();
		this.papel = new Curandeiro(poder, defesa);
	}
	
	public void transformaEmAssassino(){
		int poder = papel.getPoder();
		int defesa = papel.getDefesa();
		this.papel = new Assassino(poder, defesa);
	}	
}