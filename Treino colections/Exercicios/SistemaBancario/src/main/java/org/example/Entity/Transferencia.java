package org.example.Entity;

import java.math.BigDecimal;

public class Transferencia extends Operacao{
    private Conta origem;
    private Conta destino;

    public Transferencia(BigDecimal valor, String data, Conta origem, Conta destino) {
        super(valor, data);
        this.origem = origem;
        this.destino = destino;
        realizaOperacão(valor);
    }

    public Conta getOrigem() {
        return origem;
    }

    public void setOrigem(Conta origem) {
        this.origem = origem;
    }

    public Conta getDestino() {
        return destino;
    }

    public void setDestino(Conta destino) {
        this.destino = destino;
    }

    @Override
    public void realizaOperacão(BigDecimal valor) {
        this.origem.setSaldo(this.origem.getSaldo().subtract(valor));
        this.destino.setSaldo(this.destino.getSaldo().add(valor));
        this.origem.addOperacao(this);
        this.destino.addOperacao(this);
        System.out.println("Operação realizada saldo em conta: \nDestino:" + this.destino.getSaldo() + "\nOrigem: " + this.origem.getSaldo());
    }
}