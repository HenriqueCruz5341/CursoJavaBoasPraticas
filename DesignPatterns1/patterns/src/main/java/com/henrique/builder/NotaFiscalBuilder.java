package com.henrique.builder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NotaFiscalBuilder {
    private String razaoSocial;
    private String cnpj;
    private List<ItemDaNota> todosItens = new ArrayList<ItemDaNota>();
    private double valorBruto = 0;
    private double impostos = 0;
    private String observacoes;
    private Calendar dataDeEmissao;

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

    public NotaFiscal constroi() {
        return new NotaFiscal(razaoSocial, cnpj, dataDeEmissao, valorBruto, impostos, todosItens, observacoes);
    }
}
