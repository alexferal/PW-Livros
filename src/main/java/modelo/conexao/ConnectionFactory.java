package modelo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static String url = "jdbc:postgresql://localhost:5432/PW";
	
	public static String user = "postgres";
	
	public static String password = "postgres";
	
	public ConnectionFactory() {
	}
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			throw new ConnectionException("Driver não encontrado");
		} catch (SQLException e) {
			throw new ConnectionException("Falha ao conectar ao banco");
		}
		return connection;
	}

}
