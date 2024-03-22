package com.registrodecomanda.dao;

import com.registrodecomanda.model.Cliente;
import java.util.List;

public interface ClienteDAO {
    void adicionar(Cliente cliente);
    List<Cliente> listar();
    void atualizar(Cliente cliente);
    void excluir(int id);
}
