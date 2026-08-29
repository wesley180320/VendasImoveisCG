package Util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import dao.SqlConnection;

public class SqlUtil {

	private static SqlUtil sqlUtil;

	public static SqlUtil getInstance() {
		if (sqlUtil == null) {
			sqlUtil = new SqlUtil();
		}
		return sqlUtil;
	}

	public <T> List<T> executeQuery(String sql, Class<T> dto) throws SQLException {

		List<T> lista = new ArrayList<>();

		try {
			Connection connection = SqlConnection.getInstance().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);

			ResultSetMetaData meta = resultSet.getMetaData();
			int colCount = meta.getColumnCount();

			while (resultSet.next()) {

				T objeto = dto.getDeclaredConstructor().newInstance();

				for (int i = 1; i <= colCount; i++) {

					String coluna = meta.getColumnName(i);
					Object valor = resultSet.getObject(i);

					try {
						Field field = dto.getDeclaredField(coluna);
						field.setAccessible(true);

						if (field.getType().isEnum() && valor != null) {
							@SuppressWarnings("unchecked")
							Class<? extends Enum> enumType = (Class<? extends Enum>) field.getType();

							valor = Enum.valueOf(enumType, valor.toString());
						}

						field.set(objeto, valor);

					} catch (NoSuchFieldException e) {
						// ignora colunas que não existem no DTO
					}
				}
				lista.add(objeto);
			}
			resultSet.close();
			stmt.close();

		} catch (Exception e) {
	        Logger.getLogger(e.getMessage());
			throw new SQLException(e.getMessage().toString(), e);
		}

		return lista;
	}

	public void executeUpdate(String sql) throws ClassNotFoundException, SQLException {
		try {
			Connection connection = SqlConnection.getInstance().getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
	        Logger.getLogger(e.getMessage());
			throw new SQLException("Erro ao executar consulta no banco de dados.", e.getMessage().toString(), e);
		}
	}

	public void executeDelete(String sql) throws ClassNotFoundException, SQLException {
		try {
			Connection connection = SqlConnection.getInstance().getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			throw new SQLException("Erro ao executar consulta no banco de dados.", e.getMessage().toString(), e);
		}
	}

	public <T> T executeQueryPorParametros(String sql, Class<T> dto, Object... params) throws SQLException {

		T objeto = null;

		try {
			Connection connection = SqlConnection.getInstance().getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);

			for (int i = 0; i < params.length; i++) {
				stmt.setObject(i + 1, params[i]);
			}

			ResultSet resultSet = stmt.executeQuery();

			ResultSetMetaData meta = resultSet.getMetaData();
			int colCount = meta.getColumnCount();

			if (resultSet.next()) {

				objeto = dto.getDeclaredConstructor().newInstance();

				for (int i = 1; i <= colCount; i++) {

					String coluna = meta.getColumnName(i);
					Object valor = resultSet.getObject(i);

					try {
						Field field = dto.getDeclaredField(coluna);
						field.setAccessible(true);
						field.set(objeto, valor);

					} catch (NoSuchFieldException e) {
						// ignora colunas que não existem no DTO
					}
				}
			}

			resultSet.close();
			stmt.close();

		} catch (Exception e) {
			throw new SQLException("Erro ao executar consulta no banco de dados.", e.getMessage().toString(), e);
		}

		return objeto;
	}

	public <T> List<T> executeQueryListaPorParametros(String sql, Class<T> dto, Object... params) throws SQLException {

		List<T> lista = new ArrayList<>();

		try {
			Connection connection = SqlConnection.getInstance().getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);

			for (int i = 0; i < params.length; i++) {
				stmt.setObject(i + 1, params[i]);
			}

			ResultSet resultSet = stmt.executeQuery();
			ResultSetMetaData meta = resultSet.getMetaData();
			int colCount = meta.getColumnCount();

			while (resultSet.next()) {

				T objeto = dto.getDeclaredConstructor().newInstance();

				for (int i = 1; i <= colCount; i++) {

					String coluna = meta.getColumnName(i);
					Object valor = resultSet.getObject(i);

					try {
						Field field = dto.getDeclaredField(coluna);
						field.setAccessible(true);

						if (field.getType().isEnum() && valor != null) {
							@SuppressWarnings("unchecked")
							Class<? extends Enum> enumType = (Class<? extends Enum>) field.getType();

							valor = Enum.valueOf(enumType, valor.toString());
						}
						field.set(objeto, valor);
					} catch (NoSuchFieldException e) {
						// Ignora colunas que não existem no DTO
					}
				}

				lista.add(objeto);
			}

			resultSet.close();
			stmt.close();

		} catch (Exception e) {
			throw new SQLException("Erro ao executar consulta no banco de dados.", e.getMessage().toString(), e);
		}

		return lista;
	}

}
