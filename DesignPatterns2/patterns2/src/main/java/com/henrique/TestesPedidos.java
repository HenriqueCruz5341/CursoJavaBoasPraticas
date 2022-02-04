package com.henrique;

import java.math.BigDecimal;
import java.util.Arrays;

import com.henrique.pedido.GeraPedido;
import com.henrique.pedido.GeraPedidoHandler;
import com.henrique.pedido.acoes.CriarPedidoNoBanco;
import com.henrique.pedido.acoes.EnviarPedidoPorEmail;
import com.henrique.pedido.acoes.LogDePedido;

public class TestesPedidos {

	public static void main(String[] args) {
		String cliente = "Ana da Silva";
		BigDecimal valorOrcamento = new BigDecimal("745.99");
		int quantidadeItens = 3;

		GeraPedido gerador = new GeraPedido(cliente, valorOrcamento, quantidadeItens);
		GeraPedidoHandler handler = new GeraPedidoHandler(Arrays.asList(
				new EnviarPedidoPorEmail(),
				new CriarPedidoNoBanco(),
				new LogDePedido()));
		handler.executar(gerador);
	}

}
