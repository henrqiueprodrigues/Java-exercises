package org.example.MapList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainList {
    static void main(String[] args) {
        Departamento departamento = new Departamento("Finaças", null);
        Departamento departamento2 = new Departamento("TI", null);
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("João", departamento, 5000.0));
        funcionarios.add(new Funcionario("Maria", departamento2, 6000.0));
        funcionarios.add(new Funcionario("Pedro", departamento, 6000.0));
        funcionarios.add(new Funcionario("Jose", departamento, 8000.0));
        funcionarios.add(new Funcionario("Ana", departamento, 10000.0));
        addFuncionariosDepartamento(funcionarios);

        System.out.println("\nDepartamento 1: " + departamento.getNome());
        printFuncionariosDepartamento(departamento);
        System.out.println("\nDepartamento 2: " + departamento2.getNome());
        printFuncionariosDepartamento(departamento2);

        System.out.println("\nTotal salrio departamento 1 = " + salarioDepartamento(departamento));
        System.out.println("\nTotal salrio medio departamento 1 = " + salarioMedioDepartamento(departamento));

        System.out.println("\nFuncionario com maior salario: " + funcionarioComMaiorSalario(departamento));
        List<Departamento> departamentos = new ArrayList<>();
        departamentos.add(departamento);
        departamentos.add(departamento2);
        System.out.println("\nDepartamento com maior salario medio: " + departamentoMaiorSalMedio(departamentos).getNome());
    }

    public static void addFuncionariosDepartamento(List<Funcionario> funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            funcionario.getDepartamento().addFuncionario(funcionario);
        }
    }

    public static void printFuncionariosDepartamento(Departamento departamento) {
        for (Funcionario funcionario : departamento.getFuncionarios()) {
            System.out.println("\nNome: " + funcionario.getNome() + "\nSalario: " + funcionario.getSalario());
        }
    }

    public static Double salarioDepartamento(Departamento departamento) {
        Double total = 0.0;
        for (Funcionario funcionario : departamento.getFuncionarios()) {
            total += funcionario.getSalario();
        }
        return total;
    }

    public static Double salarioMedioDepartamento(Departamento departamento) {
        return salarioDepartamento(departamento)/departamento.getFuncionarios().size();
    }

    public static Funcionario funcionarioComMaiorSalario(Departamento departamento) {
        return departamento.getFuncionarios().stream().reduce((func1, func2) -> func1.getSalario() > func2.getSalario() ? func1 : func2).orElse(null);
    }

    public static Departamento departamentoMaiorSalMedio(List<Departamento> departamentos) {
        return departamentos.stream().reduce((dep1, dep2) -> salarioMedioDepartamento(dep1) > salarioMedioDepartamento(dep2) ? dep1 : dep2).orElse(null);
    }
}