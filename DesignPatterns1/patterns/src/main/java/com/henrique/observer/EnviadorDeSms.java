package com.henrique.observer;

public class EnviadorDeSms implements AcaoAposGerarNota {
    public void executa(NotaFiscal nf) {
        System.out.println("Enviando por sms...");
    }

}
