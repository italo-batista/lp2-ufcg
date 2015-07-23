/* 114210196 - Italo Hector de Medeiros Batista: LAB 4 - Turma 3 */

package lab04;

public class Musica {

	private String nome;
	private int duracao;
	private String genero;

	public Musica(String nome, int duracao, String genero) throws Exception {

		if (nome.equals("") || nome == null) {
			throw new Exception("Nao e possivel cadastrar musica sem nome.");
		} else {
			this.nome = nome;
		}

		if (duracao < 0) {
			throw new Exception("Nao e possivel cadastrar musica sem duracao.");
		} else {
			this.duracao = duracao;
		}
		
		if (genero.equals("") || genero == null) {
			throw new Exception("Nao e possivel cadastrar musica sem genero.");
		} else {
			this.genero = genero;
		}
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

