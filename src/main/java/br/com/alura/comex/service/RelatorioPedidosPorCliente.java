package br.com.alura.comex.service;

public class RelatorioPedidosPorCliente {

    private String nomeCliente;
    private Long quantidadePedidos;

    public RelatorioPedidosPorCliente(String nomeCliente, Long quantidadePedidos) {
        this.nomeCliente = nomeCliente;
        this.quantidadePedidos = quantidadePedidos;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public Long getQuantidadePedidos() {
        return quantidadePedidos;
    }

    @Override
    public String toString() {
        return "O cliente: " + nomeCliente + " fez " + quantidadePedidos + " pedidos";
    }
}
