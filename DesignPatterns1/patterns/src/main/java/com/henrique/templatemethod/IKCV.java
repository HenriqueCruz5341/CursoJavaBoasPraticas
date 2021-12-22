package com.henrique.templatemethod;

public class IKCV extends TemplateDeImpostoCondicional {

    private boolean temItemMaiorQue100Reais(Orcamento orcamento) {
        return orcamento.getItens().stream().anyMatch(item -> item.getValor() > 100);
    }

    @Override
    public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
        return orcamento.getValor() > 500 && temItemMaiorQue100Reais(orcamento);
    }

    @Override
    public double maximaTaxacao(Orcamento orcamento) {
        return orcamento.getValor() * 0.10;
    }

    @Override
    public double minimaTaxacao(Orcamento orcamento) {
        return orcamento.getValor() * 0.06;
    }
}
