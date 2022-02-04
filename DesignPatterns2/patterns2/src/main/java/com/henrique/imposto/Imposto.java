package com.henrique.imposto;

import java.math.BigDecimal;

import com.henrique.orcamento.Orcamento;

public abstract class Imposto {

	private Imposto outroImposto;

	public Imposto(Imposto outroImposto) {
		this.outroImposto = outroImposto;
	}

	protected abstract BigDecimal realizarCalculo(Orcamento orcamento);

	public BigDecimal calcular(Orcamento orcamento) {
		BigDecimal valor = realizarCalculo(orcamento);
		if (outroImposto != null) {
			valor = valor.add(outroImposto.realizarCalculo(orcamento));
		}

		return valor;
	}
}
