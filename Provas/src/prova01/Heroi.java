package prova01;

public class Heroi {

	public final static int MAX_PONTOS = 100; 
	
	private int HP;
	private String nome;
	private Mochila mochila;
	
	public Heroi (String nome, double pesoMaxMochila) {
		this.HP = MAX_PONTOS;
		this.nome = nome;
		this.mochila = new Mochila(pesoMaxMochila);
	}
	
	public int getHP() {
		return HP;
	}

	public void setHP(int HP) {
		this.HP = HP;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Mochila getMochila() {
		return mochila;
	}
	
	public boolean criaArma(String nomeItem, double pesoItem, int efeitoItem) {
		Arma arma = new Arma(nomeItem, pesoItem, efeitoItem); 
		return mochila.addItem(arma);
	}
	
	public boolean criaPocao(String nomeItem, double pesoItem, int efeitoItem) {
		Pocao pocao = new Pocao(nomeItem, pesoItem, efeitoItem); 
		return mochila.addItem(pocao);
	}
	
	public String ataca (Heroi outroHeroi) {
		
		String estadoAtual; 
		Mensagem mensagem = new Mensagem();
		String nomeHeroi = outroHeroi.getNome();
		int vidaHeroi = outroHeroi.getHP();
		
		int danoTotal = mochila.getTotalDano();
		outroHeroi.recebeDano(danoTotal);
		
		estadoAtual = mensagem.estadoAtual(nomeHeroi, vidaHeroi);
		return estadoAtual;
	}
	
	public void recebeDano (int danoTotal) {
		int novoHP = this.HP - danoTotal;
		this.setHP(novoHP);
	}
	
	public boolean cura () {
		
		if (getHP() < -10) {
			return false;
		} else {
		
			int curaTotal = this.mochila.getTotalCura();
			int novoHP = curaTotal + getHP();
		
			if (novoHP > MAX_PONTOS) {
				novoHP = MAX_PONTOS;
			}
		
			setHP(novoHP);
			return true;		
		}
	}

}