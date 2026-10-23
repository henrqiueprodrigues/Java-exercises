package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    static void main() {
        Funcionario func1 = new Funcionario("Joa", "TI", BigDecimal.valueOf(5000));
        Funcionario func2 = new Funcionario("Maria", "TI", BigDecimal.valueOf(7000));
        Funcionario func3 = new Funcionario("Carlos", "RH", BigDecimal.valueOf(4500));
        Funcionario func4 = new Funcionario("Ana", "RH", BigDecimal.valueOf(6000));
        Funcionario func5 = new Funcionario("Pedro", "TI", BigDecimal.valueOf(7000));

        List<Funcionario> lista = new ArrayList<>();
        lista.add(func1);
        lista.add(func2);
        lista.add(func3);
        lista.add(func4);
        lista.add(func5);

        for (Map.Entry<String, Funcionario> entry : findMaiorSalario(lista).entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue().getNome());
        }

    }

    public static Map<String, Funcionario> findMaiorSalario(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .collect(Collectors.toMap(
                        Funcionario::getDepartamento,
                        funcionario -> funcionario,
                        (f1, f2) -> f1.getSalario().compareTo(f2.getSalario()) >= 0 ? f1 : f2));
    }
}
