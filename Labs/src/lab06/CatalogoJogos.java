package lab06;
/* 114210196 - Italo Hector de Medeiros Batista: LAB 06 - Turma 03 */

import java.util.ArrayList;
import java.util.List;

public class CatalogoJogos {

	private List<Jogo> jogos;
	
	public CatalogoJogos() {
		jogos = new ArrayList<Jogo>(); 
	}
	
	
	
	public void adicionaJogo(Jogo jogo){
		jogos.add(jogo);
	}
	
	public void removeJogo(Jogo jogo){
		jogos.remove(jogo);
	}
	
	public Jogo pesquisaJogo(String jogoPesquisado){
		Jogo jogoRetornado = null;
		
		for (Jogo jogo : jogos) {
			if (jogoPesquisado.equals( jogo.getNome() )) {
				jogoRetornado = jogo;
			} }	
		return jogoRetornado;
	}
	
	public List<Jogo> getJogosJogabilidadeEsp(Jogabilidade jogabilidadeEsp){
		
		List<Jogo> jogosJogabilidadeEsp = new ArrayList<Jogo>();
		for (Jogo jogo : jogos) {									//	for (Jogabilidade jogabilidade : jogo.getJogabilidades() ) {
			if (jogo.getJogabilidades().contains(jogabilidadeEsp))	//		if (jogabilidade.equals(jogabilidadeEsp)){
				jogosJogabilidadeEsp.add(jogo);						//			jogosJogabilidadeEsp.add(jogo)
			}														//		}
																	//	}
		return jogosJogabilidadeEsp;
							
	} 
	
	public Jogo getJogoMaiorScore(){
		Jogo jogoMaiorScore = null;
		double maiorScore = 0;
		
		for (Jogo jogo : jogos) {
			if (jogo.getMaiorScore() >= maiorScore ) {
				jogoMaiorScore = jogo;
			} }	
		return jogoMaiorScore;
	}
	
	public Jogo getJogoMaiosJogado(){
		Jogo jogoMaisJogado = null;
		double maiorQuantVezJogada = 0;
		
		for (Jogo jogo : jogos ) {
			if (jogo.getVezesJogadas() >= maiorQuantVezJogada ) {
				jogoMaisJogado = jogo;
			} }	
		return jogoMaisJogado;
	}

	public Jogo getJogoMaiosZerado(){
		Jogo jogoMaisZerado = null;
		double maiorQuantVezZerada = 0;
		
		for (Jogo jogo : jogos ) {
			if (jogo.getVezesZeradas() >= maiorQuantVezZerada ) {
				jogoMaisZerado = jogo;
			} }	
		return jogoMaisZerado;
	}
	
	public List<Jogo> getJogos(){
		return this.jogos;
	}
	
	public void setJogos(List<Jogo> novosJogos){
		this.jogos = novosJogos;
	}
				
}
