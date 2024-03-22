package com.registrodecomanda.model;

import java.math.BigDecimal;

public class Comanda {
    private int id;
    private int garcomId;
    private BigDecimal valorTotal;

    public Comanda() {
    }

    public Comanda(int id, int garcomId, BigDecimal valorTotal) {
        this.id = id;
        this.garcomId = garcomId;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGarcomId() {
        return garcomId;
    }

    public void setGarcomId(int garcomId) {
        this.garcomId = garcomId;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
