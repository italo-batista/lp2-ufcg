package prova01;

public class Mensagem {

	private String mensagem;
	
	public Mensagem() {
		this.mensagem = "";
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return this.mensagem;
	}
	
	// TRATAR EXCEPTION
	public String estadoAtual(String nomeHeroi, int HP) {
		
		
		if (HP > 0) {
			setMensagem(nomeHeroi + " ainda tem " + HP + " de vida.");
		} if (HP >= -10 && HP <= 0) {
			setMensagem(nomeHeroi + " desmaiou, mas ainda pode ser curado.");
		} if (HP < -10) {
			setMensagem(nomeHeroi + " desmaiou sem chances de voltar com pocao.");
		}
		
		return getMensagem();
	}
	
}
