package prova01;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Mochila {

	List<Item> itensNaMochila;
	private double pesoMax;
	private double peso;

	public Mochila(double pesoMax) {
		this.itensNaMochila = new ArrayList<Item>();
		this.pesoMax = pesoMax;
		this.peso = 0;
	}

	public int getTotalDano() {

		int totalDano = 0;

		Iterator<Item> iterator = this.itensNaMochila.iterator();
		while (iterator.hasNext()) {
			
			Item item = iterator.next();
			
			if (item instanceof Arma) {
				Arma arma = (Arma) item;
				totalDano = totalDano + arma.getEfeito();
			}
		}
		
		return totalDano;
	}

	public int getTotalCura() {

		int totalCura = 0;

		Iterator<Item> iterator = this.itensNaMochila.iterator();
		while (iterator.hasNext()) {
			
			Item item = iterator.next();
			
			if (item instanceof Pocao) {
				Pocao pocao = (Pocao) item;
				totalCura = totalCura + pocao.getEfeito();
			}
		}

		return totalCura;
		
	}
	
	public boolean addItem(Item item) {
		
		double futuroPeso = this.getPeso() + item.getPeso();
		
		if (futuroPeso > this.pesoMax) {
			return false;
		} else {
			itensNaMochila.add(item);
			setPeso(futuroPeso);
			return true;
		}
		
	}

	public double getPesoMax() {
		return pesoMax;
	}

	public void setPesoMax(double pesoMax) {
		this.pesoMax = pesoMax;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	
}
