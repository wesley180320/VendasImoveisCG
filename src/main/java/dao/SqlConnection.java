package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {

	private static SqlConnection sqlConnection;
	private Connection connection;
	private static final String urlConexao = System.getenv("POSTGRES_URL");
	private static final String usuario = System.getenv("POSTGRES_USER"); 
	private static final String senha = System.getenv("POSTGRES_PASSWORD"); 

	private SqlConnection() throws ClassNotFoundException {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(urlConexao, usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage().toString());
		}
	}

	public static synchronized SqlConnection getInstance() throws ClassNotFoundException {
		if (sqlConnection == null) {
			sqlConnection = new SqlConnection();
		}
		return sqlConnection;
	}

	public Connection getConnection() {
		try {
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(urlConexao);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao obter conexão", e);
		}

		return connection;
	}

	public void closeConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao fechar conexão", e);
		}
	}
}
