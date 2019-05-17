package modelo;

import java.util.List;

public interface AlbumDAO {

	public Album criarAlbum(Album album);
	
	public List<Album> listarAlbuns();

}
