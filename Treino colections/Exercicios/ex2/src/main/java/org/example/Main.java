package org.example;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


public class Main {
    static void main() {
        Venda venda1= new Venda("Joao", "Televisão", BigDecimal.valueOf(10000));
        Venda venda2= new Venda("Joao", "Televisão", BigDecimal.valueOf(16000));
        Venda venda3= new Venda("Maria", "Televisão", BigDecimal.valueOf(600));
        Venda venda4= new Venda("Joao", "Televisão", BigDecimal.valueOf(1000));
        Venda venda5= new Venda("Maria", "Televisão", BigDecimal.valueOf(10000));
        Venda venda6= new Venda("Carlos", "Televisão", BigDecimal.valueOf(222222));

        List<Venda> vendas = new ArrayList<>();
        vendas.add(venda1);
        vendas.add(venda2);
        vendas.add(venda3);
        vendas.add(venda4);
        vendas.add(venda5);
        vendas.add(venda6);

        printMap(somaPorVendedor(vendas));
        printMap(mediaPorVendedor(vendas));
        System.out.println("\nVendas acima de 10000:");
        for (Venda v : vendasAltoValor(vendas)) {
            printVenda(v);
        }
        System.out.println("\nVendedores com total de vencas acima de 20000:");
        printMap(vendedoresAltasVendas(vendas));
    }

    public static Map<String, BigDecimal> somaPorVendedor(List<Venda> vendas) {
        return vendas.stream().collect(groupingBy(Venda::getVendedor, Collectors.reducing(BigDecimal.ZERO, Venda::getValor, BigDecimal::add)));
    }

    public static Map<String, Double> mediaPorVendedor(List<Venda> vendas) {
        return vendas.stream().collect(groupingBy(Venda::getVendedor, averagingDouble(v -> v.getValor().doubleValue())));
    }

    public static void printVenda(Venda venda) {
        System.out.println("Porduto: " + venda.getProduto() + "\nValor = " + venda.getValor());
    }

    public static void printMap(Map<?, ?> map) {
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println("\nVendedor: " + entry.getKey() + "\nValor total = " + entry.getValue());
        }
    }

    public static List<Venda> vendasAltoValor(List<Venda> vendas) {
        return vendas.stream().filter(v -> v.getValor().doubleValue() >= 10000).collect(toList());
    }

    public static Map<String, BigDecimal> vendedoresAltasVendas(List<Venda> vendas) {
        return somaPorVendedor(vendas).entrySet().stream().filter(v -> v.getValue().doubleValue() >= 20000).collect(Collectors.toMap(v -> v.getKey(), v -> v.getValue()));
    }
}
