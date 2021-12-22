package com.henrique.observer;

public class EnviadorDeEmail implements AcaoAposGerarNota {

    public void executa(NotaFiscal nf) {
        System.out.println("Enviando por email...");
    }
}
