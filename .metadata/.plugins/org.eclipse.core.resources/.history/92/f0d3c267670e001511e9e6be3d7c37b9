package lab05;

import java.util.HashSet;


public class Plataforma extends Jogo {
	
	public Plataforma(String nome, double preco, HashSet<Jogabilidade> jogabilidades){
		super(nome, preco, jogabilidades);
	}

	@Override
	public int joga(int score, boolean zerou) {

		int x2p = (Integer) null;
		
		int vezesJogadas = super.getVezesJogadas() + 1;
		super.setVezesJogadas(vezesJogadas);
		
		if (score > super.getMaiorScore()) {
			
			if (score > 100000) {
				score = 100000;
			}
		}
		
		if (zerou) {
			int vezesZeradas = super.getVezesZeradas() + 1;
			super.setVezesZeradas(vezesZeradas);
			x2p = vezesZeradas * 20;
		}
		
		return x2p; 
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Plataforma) {

			Jogo outroJogo = (Plataforma) obj;
			if ( super.getNome().equals( outroJogo.getNome() ) 
				&& super.getPreco() == outroJogo.getPreco() ) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {

		StringBuffer sb = new StringBuffer();
		final String endOfLine = System.getProperty("line.separator");		
	
		sb.append(endOfLine);
		sb.append("+ "+ super.getNome()+" - Plataforma:");
		sb.append(endOfLine);
		sb.append("==> Jogou "+ super.getVezesJogadas() +" vez(es)");
		sb.append(endOfLine);
		sb.append("==> Zerou "+ super.getVezesZeradas() +" vez(es)");
		sb.append(endOfLine);
		sb.append("==> Maior score: "+ super.getMaiorScore());
		sb.append(endOfLine);
		return sb.toString();
	}
}
