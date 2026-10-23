package org.example;

import org.example.Entity.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static void main() {
        Conta conta1 = new Conta("1", BigDecimal.valueOf(500));
        Conta conta2 = new Conta("2", BigDecimal.valueOf(100000));

        List<Operacao> operacoes = createList(conta1, conta2);

        System.out.println("\nValor por tipo operação: \n");

        for (Map.Entry<Class <? extends Operacao>, BigDecimal> m : valorPorTipoOperacao(operacoes).entrySet()) {
            System.out.println(m.getKey() + " -> " + m.getValue());
        }
    }

    private static List<Operacao> createList(Conta conta1, Conta conta2) {
        Saque saque1 = new Saque(BigDecimal.valueOf(50), "Hoje" , conta1);
        Saque saque2 = new Saque(BigDecimal.valueOf(5000), "Hoje" , conta2);

        Deposito deposito = new Deposito(BigDecimal.valueOf(300), "Hoje" , conta1);

        Transferencia transf = new Transferencia(BigDecimal.valueOf(33333), "Hoje" , conta2, conta1);

        List<Operacao> operacoes = new ArrayList();
        operacoes.add(saque1);
        operacoes.add(saque2);
        operacoes.add(deposito);
        operacoes.add(transf);
        return operacoes;
    }

    public static Map<Class <? extends Operacao>, BigDecimal> valorPorTipoOperacao(List<Operacao> operacoes) {
        Map<Class <? extends Operacao>, BigDecimal> mapa = new HashMap();
        for (Operacao op : operacoes) {
            switch (op) {
                case Saque s -> mapa.put(s.getClass(), mapa.getOrDefault(s.getClass(), BigDecimal.valueOf(0)).add(s.getValor()));

                case Deposito d -> mapa.put(d.getClass(), mapa.getOrDefault(d.getClass(), BigDecimal.valueOf(0)).add(d.getValor()));

                case Transferencia t -> mapa.put(t.getClass(), mapa.getOrDefault(t.getClass(), BigDecimal.valueOf(0)).add(t.getValor().multiply(BigDecimal.valueOf(2))));

                default -> System.out.println("Tipo de operação nao suprotada");

            }
        }
        return mapa;
    }
}
