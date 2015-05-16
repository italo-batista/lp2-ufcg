package lab04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Perfil {

	private String usuario;
	private List<Album> seusAlbuns;
	private List<Album> albunsFavoritos;
	private Map<String, Album> suasPlaylists;

	public Perfil(String nomeUsuario) throws Exception {
		this.usuario = nomeUsuario;		
		this.seusAlbuns = new ArrayList<Album>();
		this.albunsFavoritos = new ArrayList<Album>();
		this.suasPlaylists = new HashMap<String, Album>();
	}

	public void adicionaAlbum(Album album) {
			seusAlbuns.add(album);
	}

	public void adicionaAosFavoritos(Album album) {
		albunsFavoritos.add(album);
	}	
	
	public List<Album> getSeusAlbuns() {
		return this.seusAlbuns;
	}
	
	public List<Album> getAlbunsFavoritos() {
		return this.albunsFavoritos;
	}
	
}