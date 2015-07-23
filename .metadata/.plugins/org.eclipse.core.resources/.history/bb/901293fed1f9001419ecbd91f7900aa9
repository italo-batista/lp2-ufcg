package lab04;

public class Musica {

	private String nome;
	private int duracao;
	private String genero;

	public Musica(String nome, int duracao, String genero) {
		this.nome = nome;
		this.duracao = duracao;
		this.genero = genero;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Musica) {
			Musica outraMusica = (Musica) object;
			if (this.nome.equals(outraMusica.nome)
				&& this.duracao == outraMusica.duracao) {
				return true;							}
		}
		return false;
	}

	
	public String getNome() {
		return nome;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public int getDuracao() {
		return duracao;
	}

	
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	
	public String getGenero() {
		return genero;
	}

	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}

