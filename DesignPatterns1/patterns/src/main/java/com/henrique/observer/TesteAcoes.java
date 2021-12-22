package com.henrique.observer;

public class TesteAcoes {
    public static void main(String[] args) {
        NotaFiscalBuilder builder = new NotaFiscalBuilder();
        NotaFiscal nf = builder.paraEmpresa("Caelum Ensino e Inovação")
                .comCnpj("123.456.789/0001-12")
                .comItem(new ItemDaNota("Item 1", 100.0))
                .comItem(new ItemDaNota("Item 2", 200.0))
                .comItem(new ItemDaNota("Item 3", 300.0))
                .comObservacoes("Observações da nota fiscal")
                .naDataAtual()
                .adicionaAcao(new EnviadorDeEmail())
                .adicionaAcao(new NotaFiscalDao())
                .adicionaAcao(new EnviadorDeSms())
                .adicionaAcao(new Impressora())
                .constroi();

        System.out.println(nf);
    }
}
