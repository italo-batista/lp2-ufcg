package lab06;
/* 114210196 - Italo Hector de Medeiros Batista: LAB 06 - Turma 03 */

import java.util.Comparator;

public class comparaPorExperciencia implements Comparator<Jogo>{

	@Override
	public int compare(Jogo jogoUm, Jogo jogoDois) {
		if (jogoUm.getVezesJogadas() > jogoDois.getVezesJogadas()) {
			return -1;
		} else if (jogoUm.getVezesJogadas() == jogoDois.getVezesJogadas()) {
			return 0;
		} else {//jogoUm.getVezesJogadas() < jogoDois.getVezesJogadas()
			return 1;
		}
	}

	
	
}
