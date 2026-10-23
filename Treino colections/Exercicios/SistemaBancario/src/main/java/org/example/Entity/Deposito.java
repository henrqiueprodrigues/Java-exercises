package org.example.Entity;

import java.math.BigDecimal;

public class Deposito extends Operacao{
    private Conta destino;

    public Deposito(BigDecimal valor, String data, Conta destino) {
        super(valor, data);
        this.destino = destino;
        realizaOperacão(valor);
    }

    public Conta getDestino() {
        return destino;
    }

    public void setDestino(Conta destino) {
        this.destino = destino;
    }

    @Override
    public void realizaOperacão(BigDecimal valor) {
        this.destino.setSaldo(this.destino.getSaldo().add(valor));
        System.out.println("Operação realizada saldo em conta: " + this.destino.getSaldo());
        this.destino.addOperacao(this);
    }
}
