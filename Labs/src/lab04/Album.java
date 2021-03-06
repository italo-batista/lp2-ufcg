/* 114210196 - Italo Hector de Medeiros Batista: LAB 4 - Turma 3 */

package lab04;

import java.util.ArrayList;
import java.util.List;

public class Album {

	private String titulo;
	private String artista;
	private int duracaoTotal;
	private int anoLancamento;
	private List<Musica> album;
	
	public Album (String titulo, String artista, int anoLancamento) throws Exception {
		
		if (titulo.equals("") || titulo == null) {
			throw new Exception("Nao e possivel cadastrar album sem titulo.");
		} else {
			this.titulo = titulo;
		}
	
		if (artista.equals("") || artista == null) {
			throw new Exception("Nao e possivel cadastrar album sem artista.");
		} else {
			this.artista = artista;
		}
	
		if (anoLancamento < 0) {
			throw new Exception("Nao e possivel cadastrar album sem artista.");
		} else {
			this.anoLancamento = anoLancamento;
		}
		
			this.duracaoTotal = 0;
			this.album = new ArrayList<Musica>();
	}
	
	public void addMusica (Musica musica) {
		this.duracaoTotal = this.duracaoTotal + musica.getDuracao();
		this.album.add(musica);
	}

	public void removeMusica(Musica musica) throws Exception {
		if (album.contains(musica)){
			album.remove(musica);
		}
		
		throw new Exception("Essa musica ja nao estava inclusa no album.");
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Album) {
			
			Album outroAlbum = (Album) object;
			String artistaOutroArtista = outroAlbum.getArtista();
			String tituloOutroAlbum = outroAlbum.getTitulo();		
			
			if (this.artista.equals(artistaOutroArtista)
				&& this.titulo.equals(tituloOutroAlbum)) {
				return true;
			}
		}
		return false;
	}
	
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public int getDuracaoTotal() {
		return duracaoTotal;
	}

	public void setDuracaoTotal(int duracaoTotal) {
		this.duracaoTotal = duracaoTotal;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public List<Musica> getAlbum() {
		return album;
	}

	public void setAlbum(List<Musica> album) {
		this.album = album;
	}
	
}
