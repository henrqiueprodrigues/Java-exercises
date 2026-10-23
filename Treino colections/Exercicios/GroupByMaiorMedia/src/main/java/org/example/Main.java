package org.example;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main {
    static void main() {
        Funcionario func1 = new Funcionario("Joao", 10000,Departamento.RH);
        Funcionario func2 = new Funcionario("Carlos", 50000,Departamento.RH);
        Funcionario func3 = new Funcionario("Ana", 5000,Departamento.TI);
        Funcionario func4 = new Funcionario("Silvia", 1000,Departamento.TI);
        Funcionario func5 = new Funcionario("Felipe", 18000,Departamento.RH);
        Funcionario func6 = new Funcionario("Jose", 15000,Departamento.VENDAS);
        Funcionario func7 = new Funcionario("Amanda", 2000,Departamento.VENDAS);
        Funcionario func8 = new Funcionario("Cecilia", 90000,Departamento.TI);

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(func1);
        funcionarios.add(func2);
        funcionarios.add(func3);
        funcionarios.add(func4);
        funcionarios.add(func5);
        funcionarios.add(func6);
        funcionarios.add(func7);
        funcionarios.add(func8);

        mediaPorDepartamento(funcionarios);
        melhoresFuncPorDep(funcionarios);
    }

    private static void mediaPorDepartamento(List<Funcionario> funcionarios) {
        Map<Departamento, Double> mediaSalarioDepartamento = funcionarios.stream().collect(groupingBy(Funcionario::getDepartamento, averagingDouble(Funcionario::getSalario)));

        mediaSalarioDepartamento.forEach((m, s) -> System.out.println("\nDepartamento: " + m + "\nSalario medio: " + s));

        System.out.println("Departamento com media mais alta -> " + Collections.max(mediaSalarioDepartamento.entrySet(), Map.Entry.comparingByValue()));
    }

    private static void melhoresFuncPorDep(List<Funcionario> funcionarios) {
        Map<Departamento, List<Funcionario> > mapa = funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getDepartamento, Collectors.collectingAndThen(Collectors.toList(), lista -> lista.stream().sorted(Comparator.comparing(Funcionario::getSalario).reversed()).limit(3).toList())));

        mapa.forEach((m, s) -> { System.out.println("\nDepartamento: " + m); s.forEach(f -> System.out.println("Funcionario: " + f.getNome()));});
    }
}
