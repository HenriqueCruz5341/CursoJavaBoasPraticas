package com.henrique.decorator;

public abstract class TemplateDeImpostoCondicional extends Imposto {

    @Override
    public final double calcula(Orcamento orcamento) {
        if (deveUsarMaximaTaxacao(orcamento))
            return maximaTaxacao(orcamento) + outroImposto.calculoDoOutroImposto(orcamento);
        else
            return minimaTaxacao(orcamento) + outroImposto.calculoDoOutroImposto(orcamento);

    }

    protected abstract boolean deveUsarMaximaTaxacao(Orcamento orcamento);

    protected abstract double maximaTaxacao(Orcamento orcamento);

    protected abstract double minimaTaxacao(Orcamento orcamento);

}
