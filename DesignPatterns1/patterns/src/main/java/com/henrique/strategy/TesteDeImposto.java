package com.henrique.strategy;

/**
 * Hello world!
 *
 */
public class TesteDeImposto {
    public static void main(String[] args) {
        Imposto iss = new ISS();
        Imposto icms = new ICMS();
        Imposto iccc = new ICCC();

        Orcamento orcamento = new Orcamento(500.0);

        CalculadorDeImpostos calculador = new CalculadorDeImpostos();

        // Calculando o ISS
        System.out.println(calculador.realizaCalculo(orcamento, iss));

        // Calculando o ICMS
        System.out.println(calculador.realizaCalculo(orcamento, icms));

        // Calculando o ICCC
        System.out.println(calculador.realizaCalculo(orcamento, iccc));
    }
}
