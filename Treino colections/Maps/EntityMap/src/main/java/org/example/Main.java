package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Integer, Produto> produtos = new HashMap<>();;

    static void main() {
        produtos.put(1, new Produto(1, "Notebook", java.math.BigInteger.valueOf(100), 10));
        produtos.put(2, new Produto(2, "Celular", java.math.BigInteger.valueOf(200), 20));
        produtos.put(3, new Produto(3, "Computador", java.math.BigInteger.valueOf(300), 30));
        printMap(produtos);

        produtos.remove(1);
        System.out.println("\nRemove produto 1: ");
        printMap(produtos);

        System.out.println("\nBuscar produto com id 2:");
        printProduto(getProduto(2));

        System.out.println("\nBuscar produto com nome Computador:");
        printProduto(getByName(produtos, "Computador"));

        System.out.println("\nAdicionar 10 a quantidade de celulares:");
        addEstoque(getByName(produtos, "Celular"), 10);
        printProduto(getByName(produtos, "Celular"));

        System.out.println("\nRemover 10 a quantidade de Computadores:");
        removeEstoque(getByName(produtos, "Computador"), 10);
        printProduto(getByName(produtos, "Computador"));

        System.out.println("\nRemover 1000 a quantidade de Computadores:");
        removeEstoque(getByName(produtos, "Computador"), 1000);
        printProduto(getByName(produtos, "Computador"));
    }

    public static void printMap(Map<Integer, Produto> map) {
        for (Map.Entry<Integer, Produto> entry : map.entrySet()) {
            printProduto(entry.getValue());
        }
    }

    private static void printProduto(Produto produto) {
        System.out.println("\nID: " + produto.getId() + "\nNome: " + produto.getNome() + "\nPreço: " + produto.getPreco() + " R$\nQuantidade: " + produto.getQuantidade());
    }

    public static Produto getProduto(Integer id) {
        return produtos.get(id);
    }

    public static void addEstoque(Produto produto, int quantidade) {
        produto.setQuantidade(produto.getQuantidade() + quantidade);
    }

    public static void removeEstoque(Produto produto, int quantidade) {
        if ((produto.getQuantidade() - quantidade) >= 0) {
            produto.setQuantidade(produto.getQuantidade() - quantidade);
        }
        else {
            System.out.println("\nO estoque não pode ser negativo." + "\nEStoque atual: " + produto.getQuantidade());
        }
    }

    public static Produto getByName(Map<Integer, Produto> map, String name) {
        for (Map.Entry<Integer, Produto> entry : map.entrySet()) {
            if (entry.getValue().getNome().equals(name)) {
                return entry.getValue();
            }
        }
        return null;
    }

}
