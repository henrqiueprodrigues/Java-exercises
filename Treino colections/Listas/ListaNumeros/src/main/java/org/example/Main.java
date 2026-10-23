package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(2);
        list.add(5);
        list.add(5);
        printList(list);

        System.out.println("Remove index 2:");
        list.remove(2);
        printList(list);

        System.out.println("Maior valor = " + list.stream().max(Integer::compareTo).get());
        System.out.println("Menor valor = " + list.stream().min(Integer::compareTo).get());
        System.out.println("Soma = " + list.stream().mapToInt(Integer::intValue).sum());
        System.out.println("Média dos valores = " + String.format("%.2f", (double) list.stream().mapToInt(Integer::intValue).sum() / list.size()));
        System.out.println("Quantidade de números pares = " + getNumPares(list));
        System.out.println("Quantidade de numeros Impares = " + (list.size() - getNumPares(list)));
        System.out.println("Lista sem duplicados = " + removeDuplicados(list));
    }

    public static void printList(List<Integer> list) {
        for (Integer num : list) {
            System.out.println(num);
        }
    }

    public static Integer getNumPares(List<Integer> list) {
        return  (int) list.stream().filter(n -> n % 2 == 0).count();
    }

    //Set não pode ter duplicados, então basta converter as lista para um set. Pode ser feito tbm com Strem.distinct()
    public static HashSet<Integer> removeDuplicados(List<Integer> list) {
        return new HashSet<>(list);
    }
}
