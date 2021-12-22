package com.henrique.chainofresponsibility;

public interface Desconto {
    double desconto(Orcamento orcamento);

    void setProximo(Desconto proximo);
}
