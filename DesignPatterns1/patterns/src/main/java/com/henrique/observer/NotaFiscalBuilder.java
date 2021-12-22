package com.henrique.observer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NotaFiscalBuilder {
    private String razaoSocial;
    private String cnpj;
    private List<ItemDaNota> todosItens = new ArrayList<>();
    private double valorBruto = 0;
    private double impostos = 0;
    private String observacoes;
    private Calendar dataDeEmissao;

    private List<AcaoAposGerarNota> todasAcoesASeremExecutadas;

    public NotaFiscalBuilder() {
        this.todasAcoesASeremExecutadas = new ArrayList<>();
    }

    public NotaFiscalBuilder paraEmpresa(String razaoSocial) {
        this.razaoSocial = razaoSocial;
        return this;
    }

    public NotaFiscalBuilder comCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public NotaFiscalBuilder comItem(ItemDaNota item) {
        this.todosItens.add(item);
        this.valorBruto += item.getValor();
        this.impostos += item.getValor() * 0.05;
        return this;
    }

    public NotaFiscalBuilder comObservacoes(String observacoes) {
        this.observacoes = observacoes;
        return this;
    }

    public NotaFiscalBuilder naDataAtual() {
        this.dataDeEmissao = Calendar.getInstance();
        return this;
    }

    public NotaFiscalBuilder adicionaAcao(AcaoAposGerarNota acao) {
        this.todasAcoesASeremExecutadas.add(acao);
        return this;
    }

    public NotaFiscal constroi() {
        NotaFiscal nf = new NotaFiscal(razaoSocial, cnpj, dataDeEmissao, valorBruto, impostos, todosItens, observacoes);

        todasAcoesASeremExecutadas.forEach(acao -> acao.executa(nf));

        return nf;
    }

}
