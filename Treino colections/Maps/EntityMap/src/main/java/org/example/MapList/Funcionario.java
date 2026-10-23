package org.example.MapList;

import java.util.stream.IntStream;

public class Funcionario {
    private String nome;
    private Departamento departamento;
    private double salario;

    public Funcionario(String nome, Departamento departamento, double salario) {
        this.nome = nome;
        this.departamento = departamento;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return  "\nnome =" + nome +
                "\ndepartamento=" + departamento.getNome() +
                "\nsalario=" + salario;
    }
}
