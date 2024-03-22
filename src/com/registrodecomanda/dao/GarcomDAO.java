package com.registrodecomanda.dao;

import com.registrodecomanda.model.Garcom;
import java.util.List;

public interface GarcomDAO {
    void adicionar(Garcom garcom);
    List<Garcom> listar();
    void atualizar(Garcom garcom);
    void excluir(int id);
}
