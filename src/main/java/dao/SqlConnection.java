package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {

	private static SqlConnection sqlConnection;
	private Connection connection;
	// private static final String urlConexao =
	// "jdbc:sqlite:/Users/wesleyestevao/meu_banco.db";
	private static final String urlConexao = "jdbc:postgresql://db:5432/testdb";
	private static final String usuario = "testdb";
	private static final String senha = "testdb";

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
