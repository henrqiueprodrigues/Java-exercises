package org.example.Entity;

import java.math.BigDecimal;

public class Saque extends Operacao {
    private Conta solicitante;

    public Saque(BigDecimal valor, String data, Conta solicitante) {
        super(valor, data);
        this.solicitante = solicitante;
        System.out.println("\nSAQUE\n");
        realizaOperacão(valor);
    }

    public Saque() {
        super();

    }


    public void realizaOperacão(BigDecimal valor) {
        this.solicitante.setSaldo(this.solicitante.getSaldo().subtract(valor));
        System.out.println("Operação realizada saldo em conta: " + this.solicitante.getSaldo());
        this.solicitante.addOperacao(this);
    }

}
