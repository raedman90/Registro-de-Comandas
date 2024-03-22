package com.registrodecomanda;

import com.registrodecomanda.dao.ClienteDAOImpl;
import com.registrodecomanda.model.Cliente;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClienteDAOImpl clienteDao = new ClienteDAOImpl();

        Cliente novoCliente = new Cliente(0, "Carlos Silva", "carlos.silva@email.com");
        clienteDao.adicionar(novoCliente);
        System.out.println("Cliente adicionado.");

        List<Cliente> clientes = clienteDao.listar();
        System.out.println("Listagem de clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getId() + " - " + cliente.getNome() + " - " + cliente.getEmail());
        }
    }
}
