package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Venda {
    private String vendedor;
    private String produto;
    private BigDecimal valor;


    public Venda(String vendedor, String produto, BigDecimal valor) {
        this.vendedor = vendedor;
        this.produto = produto;
        this.valor = valor;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
