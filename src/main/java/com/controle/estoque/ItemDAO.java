package com.controle.estoque;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    public static boolean salvar(Item item) {
        String sql = "INSERT INTO itens (nome, tipo, quantidade, local, data_entrada) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, item.getNome());
            pstmt.setString(2, item.getTipo());
            pstmt.setInt(3, item.getQuantidade());
            pstmt.setString(4, item.getLocal());
            pstmt.setString(5, item.getDataEntrada());
            pstmt.executeUpdate();

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                item.setId(generatedKeys.getInt(1));
            }

            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar item: " + e.getMessage());
            return false;
        }
    }

    public static List<Item> listarTodos() {
        List<Item> itens = new ArrayList<>();
        String sql = "SELECT * FROM itens";

        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String tipo = rs.getString("tipo");
                int quantidade = rs.getInt("quantidade");
                String local = rs.getString("local");
                String dataEntrada = rs.getString("data_entrada");

                Item item = new Item(id, nome, tipo, quantidade, local, dataEntrada);
                itens.add(item);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar itens: " + e.getMessage());
        }

        return itens;
    }

    public static void excluir(Item item) {
        String sql = "DELETE FROM itens WHERE id = ?";

        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, item.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
    }

    public static void atualizar(Item item) {
        String sql = "UPDATE itens SET nome = ?, tipo = ?, quantidade = ?, local = ?, data_entrada = ? WHERE id = ?";
        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, item.getNome());
            stmt.setString(2, item.getTipo());
            stmt.setInt(3, item.getQuantidade());
            stmt.setString(4, item.getLocal());
            stmt.setString(5, item.getDataEntrada());
            stmt.setInt(6, item.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }
}
