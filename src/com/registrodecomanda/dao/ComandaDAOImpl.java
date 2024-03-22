package com.registrodecomanda.dao;

import com.registrodecomanda.model.Comanda;
import com.registrodecomanda.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComandaDAOImpl implements ComandaDAO {
    @Override
    public void adicionar(Comanda comanda) {
        String sql = "INSERT INTO comandas (garcom_id, valor_total) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, comanda.getGarcomId());
            stmt.setBigDecimal(2, comanda.getValorTotal());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comanda> listar() {
        List<Comanda> comandas = new ArrayList<>();
        String sql = "SELECT * FROM comandas";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Comanda comanda = new Comanda();
                comanda.setId(rs.getInt("id"));
                comanda.setGarcomId(rs.getInt("garcom_id"));
                comanda.setValorTotal(rs.getBigDecimal("valor_total"));
                comandas.add(comanda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comandas;
    }

    @Override
    public void atualizar(Comanda comanda) {
        String sql = "UPDATE comandas SET garcom_id = ?, valor_total = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, comanda.getGarcomId());
            stmt.setBigDecimal(2, comanda.getValorTotal());
            stmt.setInt(3, comanda.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM comandas WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
