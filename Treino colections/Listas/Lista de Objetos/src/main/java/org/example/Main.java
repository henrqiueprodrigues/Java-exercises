package org.example;

import org.example.Entities.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void main() {
        //Cria lista imutavel com list.of
        List<Cliente> valoresIniciais = List.of(new Cliente(1, "Jose", 32), new Cliente(2, "Maria", 65), new Cliente(3, "Pedro", 20));
        ArrayList<Cliente> clientes = new ArrayList<>(valoresIniciais);

        System.out.println("ADD:");
        addCliente(clientes, new Cliente(4, "Silvia", 10));
        printClientes(clientes);

        System.out.println("\nREMOVE:");
        clientes.remove(getClienteById(clientes, 1));
        printClientes(clientes);

        System.out.println("\nCONTAINS:");
        System.out.println("Cleinte " + getClienteById(clientes, 2).getNome() + " está na lista?\n" + clientes.contains(getClienteById(clientes, 2)));

        System.out.println("Quantidade de clientes: " + clientes.size());
        clientes.clear();
        System.out.println("Limpa lista: " + clientes.size() + " Clientes");

    }

    public static void printClientes(List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            System.out.println("\nID: " + cliente.getId() + "\nNome: " + cliente.getNome() + "\nIdade: " + cliente.getIdade());
        }
    }

    public static Cliente getClienteById(List<Cliente> clientes, Integer id) {
        return clientes.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public static void addCliente(List<Cliente> clientes, Cliente cliente) {
        if (cliente != null && getClienteById(clientes, cliente.getId()) == null) {
            clientes.add(cliente);
        } else {
            throw new IllegalArgumentException("Cliente inválido ou já existe na lista.");
        }
    }
}
