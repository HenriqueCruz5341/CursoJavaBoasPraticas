package com.henrique;

import java.math.BigDecimal;

import com.henrique.http.JavaHttpClient;
import com.henrique.orcamento.ItemOrcamento;
import com.henrique.orcamento.Orcamento;
import com.henrique.orcamento.RegistroDeOrcamento;

public class TestesAdapter {

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(BigDecimal.TEN));
        orcamento.aprovar();
        orcamento.finalizar();

        RegistroDeOrcamento registro = new RegistroDeOrcamento(new JavaHttpClient());
        registro.registrar(orcamento);
    }

}