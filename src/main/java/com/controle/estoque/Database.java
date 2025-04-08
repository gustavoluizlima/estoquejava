package com.controle.estoque;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	public static final String DB_URL = "jdbc:sqlite:estoque.db";
	
	public static Connection connect() {
		try {
			return DriverManager.getConnection(DB_URL);
		} catch (SQLException e) {
			System.out.println("Erro ao conectar ao banco de dados " + e.getMessage());
			return null;
		}
	}

	public static void initDatabase() {
	    String sql = "CREATE TABLE IF NOT EXISTS itens (" +
	                 "id INTEGER PRIMARY KEY AUTOINCREMENT," +
	                 "nome TEXT," +
	                 "tipo TEXT," +
	                 "quantidade INTEGER," +
	                 "local TEXT," +
	                 "data_entrada TEXT)";

	    try (Connection conn = connect();
	         Statement stmt = conn.createStatement()) {
	        stmt.execute(sql);
	    } catch (SQLException e) {
	        System.out.println("Erro ao criar tabela: " + e.getMessage());
	    }
	}
}
