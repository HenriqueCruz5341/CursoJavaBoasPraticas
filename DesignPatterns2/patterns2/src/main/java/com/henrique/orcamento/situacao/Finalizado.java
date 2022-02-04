package com.henrique.orcamento.situacao;

import java.math.BigDecimal;

import com.henrique.DomainException;
import com.henrique.orcamento.Orcamento;

public class Finalizado extends SituacaoOrcamento {

	@Override
	public BigDecimal calcularDescontoExtra(Orcamento orcamento) {
		throw new DomainException("Orcamento finalizado nao pode ter desconto extra!");
	}

}
