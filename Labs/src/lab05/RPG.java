package lab05;

import java.util.HashSet;


public class RPG extends Jogo {
	
	public RPG(String nome, double preco, HashSet<Jogabilidade> jogabilidades) throws EntradaException {
		super(nome, preco, jogabilidades);
	}

	@Override
	public int joga(int score, boolean zerou) throws DadoInvalidoException {

		if (score < 0){
			throw new DadoInvalidoException("Score");
			
		} else {
		
			int vezesJogadas = super.getVezesJogadas() + 1;
			super.setVezesJogadas(vezesJogadas);
			
			if (score > super.getMaiorScore()) {
				
				if (score > 100000) {
					score = 100000;
				}
				
				super.setMaiorScore(score);
			}
			if (zerou) {
				int vezesZeradas = super.getVezesZeradas() + 1;
				super.setVezesZeradas(vezesZeradas);
			}
			
			int x2p = 10 * super.getVezesJogadas();
			return x2p; 
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RPG) {

			Jogo outroJogo = (RPG) obj;
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
		sb.append("+ "+ super.getNome()+" - RPG :");
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
