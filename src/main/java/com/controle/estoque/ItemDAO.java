package com.controle.estoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemDAO {
	public static boolean salvar(Item item) {
		String sql = "INSERT INTO itens (nome, tipo, quantidade, local, data_entrada) VALUES (?, ?, ?, ?, ?)";
		
		try (Connection conn = Database.connect(); PreparedStatment pstmt = conn.prepareStatement(sql)) {
			pstmt.setString();
			pstmt.setString();
			pstmt.setInt();
			pstmt.setString();
			pstmt.setString();
			pstmt.executeUpdate();
		} catch {
			
		}
	}
}
