package lab06;
/* 114210196 - Italo Hector de Medeiros Batista: LAB 06 - Turma 03 */

import java.util.Comparator;

public class comparaPorDesempenho implements Comparator<Jogo>{

	@Override
	public int compare(Jogo jogoUm, Jogo jogoDois) {
		if (jogoUm.getMaiorScore() < jogoDois.getMaiorScore()) {
			return -1;
		} else if (jogoUm.getMaiorScore() == jogoDois.getMaiorScore()) {
			return 0;
		} else {//jogoUm.getMaiorScore() > jogoDois.getMaiorScore()
			return 1;
		}
	}
	

}
