package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import modelo.conexao.ConnectionFactory;

public class LivroDAOBD implements LivroDAO {

	private List<Livro> livros = new ArrayList();
	
	private Connection conexao;
	
	public LivroDAOBD() {
		ConnectionFactory factory = new ConnectionFactory();
		this.conexao = factory.getConnection();
	}

	@Override
	public List<String> recuperarISBNs() {
		List<String> isbns = new ArrayList();

		try {
			PreparedStatement statement = this.conexao.prepareStatement("SELECT isbn FROM livro");
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				isbns.add(resultSet.getString("isbn"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isbns;

	}

	@Override
	public List<String> recuperarISBNs(String autor) {

		List<String> isbns = new ArrayList<String>();

		try {
			PreparedStatement statement = this.conexao.prepareStatement("SELECT isbn FROM livro WHERE autor=?");
			statement.setString(1, autor);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				isbns.add(resultSet.getString("isbn"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isbns;
	}

	@Override
	public List<Livro> buscarPorAutor(String autor) {
		List<Livro> livro = new ArrayList<Livro>();
		try {
			PreparedStatement statement = this.conexao.prepareStatement("SELECT * FROM livro WHERE autor = ?");
			statement.setString(1, autor);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				livro.add(new Livro(
						resultSet.getInt("id"),
						resultSet.getString("livro"),
						resultSet.getString("isbn"),
						resultSet.getString("autor")
				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(livro);
		return livro;
	}

	public List<Livro> listarLivros() {
		List<Livro> livros = new ArrayList();
		try {
			Statement statement = this.conexao.createStatement();
			statement.execute("SELECT * FROM livro");
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				livros.add(new Livro(resultSet.getInt("id"),
						resultSet.getString("livro"),
						resultSet.getString("isbn"),
						resultSet.getString("autor")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livros;
	}

	public Optional<Livro> recuperarPorId(Long id) {
		Optional<Livro> livro = Optional.empty();
		try {
			PreparedStatement statement = this.conexao.prepareStatement("SELECT * FROM livro WHERE id = ?");
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				livro = livro.of(new Livro(
						resultSet.getInt("id"),
						resultSet.getString("livro"),
						resultSet.getString("isbn"),
						resultSet.getString("autor")
				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livro;
	}

	public Livro criarLivro(Livro livro) {
		try {
			PreparedStatement statement = this.conexao.prepareStatement("INSERT INTO livros (id, livro, isbn, autor) VALUES (?,?,?,?) ");
			statement.setLong(1, livro.getId());
			statement.setString(2, livro.getTitulo());
			statement.setString(3, livro.getIsbn());
			statement.setString(4, livro.getAutor());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livro;
	}

	public Livro atualizarLivro(Livro livro) {
		try {
			PreparedStatement statement = this.conexao.prepareStatement("UPDATE livros SET livro = ?, isbn = ?, autor = ? WHERE id = ?");
			statement.setString(1, livro.getTitulo());
			statement.setString(2, livro.getIsbn());
			statement.setString(3, livro.getAutor());
			statement.setLong(4, livro.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livro;
	}

	public void removerLivro(Long id) {
		try {
			PreparedStatement statement = this.conexao.prepareStatement("DELETE FROM livro WHERE id = ?");
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
