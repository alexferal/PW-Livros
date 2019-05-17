package modelo;

import java.util.List;

public class Album {

	private String titulo;

	private String autor;

	private boolean publicado;

	private List<String> fotos;

	//todo: criar propriedade tipo List<String> e seus get e set

    public List<String> getFotos() {
        return fotos;
    }

    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }

    public Album() {
	}

	public Album(String titulo, String autor, boolean publicado) {
		this.titulo = titulo;
		this.autor = autor;
		this.publicado = publicado;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public boolean isPublicado() {
		return publicado;
	}

	public void setPublicado(boolean publicado) {
		this.publicado = publicado;
	}

}
