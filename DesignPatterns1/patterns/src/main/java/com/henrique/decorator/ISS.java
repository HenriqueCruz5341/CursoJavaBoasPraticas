package com.henrique.decorator;

public class ISS extends Imposto {

    public ISS(Imposto outroImposto) {
        super(outroImposto);
    }

    public ISS() {
        super();
    }

    public double calcula(Orcamento orcamento) {
        return orcamento.getValor() * 0.06 + calculoDoOutroImposto(orcamento);
    }

}