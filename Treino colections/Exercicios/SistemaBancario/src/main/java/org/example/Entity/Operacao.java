package org.example.Entity;

import java.math.BigDecimal;

public abstract class Operacao {
    private BigDecimal valor;
    private String data;

    public Operacao(BigDecimal valor, String data) {
        this.valor = valor;
        this.data = data;
    }

    public Operacao() {

    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public abstract void realizaOperacão(BigDecimal valor);
}
