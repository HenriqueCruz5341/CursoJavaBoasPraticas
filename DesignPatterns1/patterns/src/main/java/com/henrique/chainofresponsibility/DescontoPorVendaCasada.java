package com.henrique.chainofresponsibility;

public class DescontoPorVendaCasada implements Desconto {
    private Desconto proximo;

    public DescontoPorVendaCasada(Desconto proximo) {
        this.proximo = proximo;
    }

    public double desconto(Orcamento orcamento) {
        if (existe("LAPIS", orcamento) && existe("CANETA", orcamento))
            return orcamento.getValor() * 0.05;

        return proximo.desconto(orcamento);
    }

    private boolean existe(String nomeDoItem, Orcamento orcamento) {
        return orcamento.getItens().stream().anyMatch(item -> item.getNome().equals(nomeDoItem));
    }

    public void setProximo(Desconto proximo) {
        this.proximo = proximo;
    }
}
