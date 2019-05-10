package modelo;

public class Livro {
	
	private Integer id;
	
	private String titulo;
	
	private String isbn;
	
	private String autor;
	
	public Livro() {}

	public Livro(Integer id, String titulo, String isbn, String autor) {
		this.id = id;
		this.titulo = titulo;
		this.isbn = isbn;
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Livro{" +
				"id=" + id +
				", titulo='" + titulo + '\'' +
				", isbn='" + isbn + '\'' +
				", autor='" + autor + '\'' +
				'}';
	}
}
