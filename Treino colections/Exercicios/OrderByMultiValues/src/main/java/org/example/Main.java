package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;

public class Main {

    static void main(String[] args) {
        Produto produto1 = new Produto ("Agua", "Bebidas", BigDecimal.valueOf(5), 100);
        Produto produto2 = new Produto ("Cerveja", "Bebidas", BigDecimal.valueOf(8), 50);
        Produto produto3 = new Produto ("Carne moida", "Alimento", BigDecimal.valueOf(35), 50);
        Produto produto4 = new Produto ("Chocolate", "Doces", BigDecimal.valueOf(25), 80);
        Produto produto5 = new Produto ("Vinho", "Bebidas", BigDecimal.valueOf(70), 0);
        Produto produto6 = new Produto (null, "Alimento", BigDecimal.valueOf(35), 50);

        List<Produto> produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);
        produtos.add(produto5);
        produtos.add(produto6);

        produtos.sort(Comparator.comparing(Produto::getQuantidadeEstoque).thenComparing(Produto::getPreco).reversed().thenComparing(Produto::getNome, Comparator.nullsLast(String::compareTo)));
        produtos.forEach(p -> System.out.println("\nQuantidade: " + p.getQuantidadeEstoque() + "\nPreço: " + p.getPreco() + "\nNome: " + p.getNome()));
    }
}
