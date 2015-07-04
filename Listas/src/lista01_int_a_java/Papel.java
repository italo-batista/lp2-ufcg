package lista01_int_a_java;

public class Papel {

	int poder;
	int defesa;
	
	public Papel(int defesa, int poder) {
		this.defesa = defesa;
		this.poder = poder;
		
	}
	
	public double ataca(){
		return this.poder * (-1);
	}
	
	public double defende(){
		return this.defesa;
	}

	public double cura(){
		return this.poder;
	}

	public int getPoder() {
		return poder;
	}

	public void setPoder(int poder) {
		this.poder = poder;
	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}
	
}
