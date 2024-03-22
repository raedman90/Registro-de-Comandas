package com.registrodecomanda;

import com.registrodecomanda.dao.ClienteDAOImpl;
import com.registrodecomanda.dao.GarcomDAOImpl;
import com.registrodecomanda.dao.ComandaDAOImpl;
import com.registrodecomanda.model.Cliente;
import com.registrodecomanda.model.Garcom;
import com.registrodecomanda.model.Comanda;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ClienteDAOImpl clienteDao = new ClienteDAOImpl();
    private static final GarcomDAOImpl garcomDao = new GarcomDAOImpl();
    private static final ComandaDAOImpl comandaDao = new ComandaDAOImpl();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Sistema de Registro de Comanda ---");
            System.out.println("1. Gerenciar Clientes");
            System.out.println("2. Gerenciar Garçons");
            System.out.println("3. Gerenciar Comandas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma categoria: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    gerenciarClientes();
                    break;
                case 2:
                    gerenciarGarcons();
                    break;
                case 3:
                    gerenciarComandas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static void gerenciarClientes() {
        while (true) {
            System.out.println("\n--- Gerenciamento de Clientes ---");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Excluir Cliente");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    adicionarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    atualizarCliente();
                    break;
                case 4:
                    excluirCliente();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static void adicionarCliente() {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Email do Cliente: ");
        String email = scanner.nextLine();

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setEmail(email);
        clienteDao.adicionar(cliente);
        System.out.println("Cliente adicionado com sucesso.");
    }

    private static void listarClientes() {
        List<Cliente> clientes = clienteDao.listar();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente encontrado.");
            return;
        }
        System.out.println("\nClientes:");
        clientes.forEach(c -> System.out.println("ID: " + c.getId() + ", Nome: " + c.getNome() + ", Email: " + c.getEmail()));
    }

    private static void atualizarCliente() {
        System.out.print("ID do Cliente para atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Email do Cliente: ");
        String email = scanner.nextLine();

        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setEmail(email);
        clienteDao.atualizar(cliente);
        System.out.println("Cliente atualizado com sucesso.");
    }

    private static void excluirCliente() {
        System.out.print("ID do Cliente para excluir: ");
        int id = scanner.nextInt();
        clienteDao.excluir(id);
        System.out.println("Cliente excluído com sucesso.");
    }

    private static void gerenciarGarcons() {
        while (true) {
            System.out.println("\n--- Gerenciamento de Garçons ---");
            System.out.println("1. Adicionar Garçom");
            System.out.println("2. Listar Garçons");
            System.out.println("3. Atualizar Garçom");
            System.out.println("4. Excluir Garçom");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    adicionarGarcom();
                    break;
                case 2:
                    listarGarcons();
                    break;
                case 3:
                    atualizarGarcom();
                    break;
                case 4:
                    excluirGarcom();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static void adicionarGarcom() {
        System.out.print("Nome do Garçom: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do Garçom: ");
        String cpf = scanner.nextLine();

        Garcom garcom = new Garcom(0, nome, cpf);
        garcomDao.adicionar(garcom);
        System.out.println("Garçom adicionado com sucesso.");
    }

    private static void listarGarcons() {
        List<Garcom> garcons = garcomDao.listar();
        if (garcons.isEmpty()) {
            System.out.println("Nenhum garçom encontrado.");
        } else {
            System.out.println("\nGarçons:");
            garcons.forEach(g -> System.out.println("ID: " + g.getId() + ", Nome: " + g.getNome() + ", CPF: " + g.getCpf()));
        }
    }

    private static void atualizarGarcom() {
        System.out.print("ID do Garçom para atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo Nome do Garçom: ");
        String nome = scanner.nextLine();
        System.out.print("Novo CPF do Garçom: ");
        String cpf = scanner.nextLine();

        Garcom garcom = new Garcom(id, nome, cpf);
        garcomDao.atualizar(garcom);
        System.out.println("Garçom atualizado com sucesso.");
    }

    private static void excluirGarcom() {
        System.out.print("ID do Garçom para excluir: ");
        int id = scanner.nextInt();

        garcomDao.excluir(id);
        System.out.println("Garçom excluído com sucesso.");
    }

    private static void gerenciarComandas() {
        while (true) {
            System.out.println("\n--- Gerenciamento de Comandas ---");
            System.out.println("1. Adicionar Comanda");
            System.out.println("2. Listar Comandas");
            System.out.println("3. Atualizar Comanda");
            System.out.println("4. Excluir Comanda");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    adicionarComanda();
                    break;
                case 2:
                    listarComandas();
                    break;
                case 3:
                    atualizarComanda();
                    break;
                case 4:
                    excluirComanda();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static void adicionarComanda() {
        System.out.print("ID do Garçom responsável pela comanda: ");
        int garcomId = scanner.nextInt();
        System.out.print("Valor Total da Comanda: ");
        BigDecimal valorTotal = scanner.nextBigDecimal();

        Comanda comanda = new Comanda(0, garcomId, valorTotal);
        comandaDao.adicionar(comanda);
        System.out.println("Comanda adicionada com sucesso.");
    }

    private static void listarComandas() {
        List<Comanda> comandas = comandaDao.listar();
        if (comandas.isEmpty()) {
            System.out.println("Nenhuma comanda encontrada.");
        } else {
            System.out.println("\nComandas:");
            comandas.forEach(c -> System.out.println("ID: " + c.getId() + ", Garçom ID: " + c.getGarcomId() + ", Valor Total: " + c.getValorTotal()));
        }
    }

    private static void atualizarComanda() {
        System.out.print("ID da Comanda para atualizar: ");
        int id = scanner.nextInt();
        System.out.print("Novo ID do Garçom responsável pela comanda: ");
        int garcomId = scanner.nextInt();
        System.out.print("Novo Valor Total da Comanda: ");
        BigDecimal valorTotal = scanner.nextBigDecimal();

        Comanda comanda = new Comanda(id, garcomId, valorTotal);
        comandaDao.atualizar(comanda);
        System.out.println("Comanda atualizada com sucesso.");
    }

    private static void excluirComanda() {
        System.out.print("ID da Comanda para excluir: ");
        int id = scanner.nextInt();

        comandaDao.excluir(id);
        System.out.println("Comanda excluída com sucesso.");
    }
}
