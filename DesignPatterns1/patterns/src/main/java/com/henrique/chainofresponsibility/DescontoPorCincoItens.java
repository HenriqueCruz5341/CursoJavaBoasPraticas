package com.henrique.chainofresponsibility;

public class DescontoPorCincoItens implements Desconto {
    private Desconto proximo;

    public DescontoPorCincoItens(Desconto proximo) {
        this.proximo = proximo;
    }

    public double desconto(Orcamento orcamento) {
        if (orcamento.getItens().size() > 5)
            return orcamento.getValor() * 0.1;

        return this.proximo.desconto(orcamento);
    }

    @Override
    public void setProximo(Desconto proximo) {
        this.proximo = proximo;
    }
}
