import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CatalogoJogos {

	private List<Jogo> jogos;
	
	public CatalogoJogos() {
		jogos = new ArrayList(); 
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

	
	public List<Jogo> getJogosOnline(){
		
		List<Jogo> jogosOnline = new ArrayList();
		
		for (Jogo jogo : jogos ) {
			
			Iterator iter = jogo.getJogabilidades().iterator();
			while (iter.hasNext()) {
				 Object jogabilidade = iter.next();
				if ( jogabilidade.equals(1) ) {
					
				}
			}
			
			HashSet jogabilidades = jogo.getJogabilidades();
			
							
			} 	
		return null;
	} 
	
	public List<Jogo> getJogos(){
		return this.jogos;
	}
	
	public void setJogos(List<Jogo> novosJogos){
		this.jogos = novosJogos;
	}
			
	
}
