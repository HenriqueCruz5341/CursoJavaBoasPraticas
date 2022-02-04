package com.henrique.orcamento;

import java.util.Map;

import com.henrique.DomainException;
import com.henrique.http.HttpAdapter;

public class RegistroDeOrcamento {

    private HttpAdapter httpAdapter;

    public RegistroDeOrcamento(HttpAdapter httpAdapter) {
        this.httpAdapter = httpAdapter;
    }

    public void registrar(Orcamento orcamento) {
        if (!orcamento.isFinalizado()) {
            throw new DomainException("Orcamento não finalizado");
        }

        String url = "http://localhost:8080/orcamento";
        Map<String, Object> dados = Map.of("valor", orcamento.getValor(), "quantidadeItens",
                orcamento.getQuantidadeItens());

        httpAdapter.post(url, dados);
    }
}
