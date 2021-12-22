package com.henrique.chainofresponsibility;

public class TesteDeDescontos {
    public static void main(String[] args) {
        CalculadorDeDescontos calculador = new CalculadorDeDescontos();

        Orcamento orcamento = new Orcamento(750.0);
        orcamento.adicionaItem(new Item("CANETA", 250.0));
        orcamento.adicionaItem(new Item("LAPIS", 250.0));
        orcamento.adicionaItem(new Item("CADERNO", 250.0));

        double desconto = calculador.calcula(orcamento);

        System.out.println(desconto);
    }
}
