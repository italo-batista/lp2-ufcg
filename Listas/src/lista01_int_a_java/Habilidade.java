package lista01_int_a_java;

public class Habilidade {
	
	String nome;
	int dano;
	int mana;
	
	public Habilidade(String nome, int dano, int mana) {
		this.dano = dano;
		this.mana = mana;
		this.nome = nome;
	}

	public String toString(){
		return this.nome;	
	}
	
}
