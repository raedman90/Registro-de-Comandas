package com.registrodecomanda.dao;

import com.registrodecomanda.model.Comanda;
import java.util.List;

public interface ComandaDAO {
    void adicionar(Comanda comanda);
    List<Comanda> listar();
    void atualizar(Comanda comanda);
    void excluir(int id);
}
