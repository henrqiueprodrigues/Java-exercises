package org.example.Entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Conta {
    private String numero;
    private BigDecimal saldo;
    private List<Operacao> operacoes;

    public Conta(String numero, BigDecimal saldo) {
        this.numero = numero;
        this.saldo = saldo;
        this.operacoes = new ArrayList();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public List<Operacao> getOperacoes() {
        return operacoes;
    }

    public void setOperacoes(List<Operacao> operacoes) {
        this.operacoes = operacoes;
    }

    public void addOperacao(Operacao operacao) {
        this.operacoes.add(operacao);
    }
}
