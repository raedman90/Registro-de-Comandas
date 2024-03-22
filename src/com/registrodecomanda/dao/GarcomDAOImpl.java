package com.registrodecomanda.dao;

import com.registrodecomanda.model.Garcom;
import com.registrodecomanda.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GarcomDAOImpl implements GarcomDAO {
    @Override
    public void adicionar(Garcom garcom) {
        String sql = "INSERT INTO garcons (nome, cpf) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, garcom.getNome());
            stmt.setString(2, garcom.getCpf());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Garcom> listar() {
        List<Garcom> garcons = new ArrayList<>();
        String sql = "SELECT * FROM garcons";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Garcom garcom = new Garcom();
                garcom.setId(rs.getInt("id"));
                garcom.setNome(rs.getString("nome"));
                garcom.setCpf(rs.getString("cpf"));
                garcons.add(garcom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return garcons;
    }

    @Override
    public void atualizar(Garcom garcom) {
        String sql = "UPDATE garcons SET nome = ?, cpf = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, garcom.getNome());
            stmt.setString(2, garcom.getCpf());
            stmt.setInt(3, garcom.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM garcons WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
