package com.henrique;

import java.math.BigDecimal;

import com.henrique.imposto.ICMS;
import com.henrique.imposto.ISS;
import com.henrique.imposto.Imposto;
import com.henrique.orcamento.ItemOrcamento;
import com.henrique.orcamento.Orcamento;

public class TestesImposto {

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("200")));

        Imposto imposto = new ICMS(new ISS(null));
        System.out.println(imposto.calcular(orcamento));
    }

}