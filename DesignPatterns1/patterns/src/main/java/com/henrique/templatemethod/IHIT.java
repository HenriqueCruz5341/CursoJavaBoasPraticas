package com.henrique.templatemethod;

public class IHIT extends TemplateDeImpostoCondicional {

    @Override
    public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
        return temDoisItensIguais(orcamento);
    }

    @Override
    public double maximaTaxacao(Orcamento orcamento) {
        return orcamento.getValor() * 0.13 + 100;
    }

    @Override
    public double minimaTaxacao(Orcamento orcamento) {
        return orcamento.getValor() * 0.01 * numeroDeItens(orcamento);
    }

    private int numeroDeItens(Orcamento orcamento) {
        return orcamento.getItens().size();
    }

    private boolean temDoisItensIguais(Orcamento orcamento) {
        return orcamento.getItens().stream().distinct().count() != orcamento.getItens().size();
    }

}
