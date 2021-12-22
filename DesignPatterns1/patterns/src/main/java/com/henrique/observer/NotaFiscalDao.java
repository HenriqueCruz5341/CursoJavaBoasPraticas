package com.henrique.observer;

public class NotaFiscalDao implements AcaoAposGerarNota {
    public void executa(NotaFiscal nf) {
        System.out.println("Salvando no banco...");
    }
}
