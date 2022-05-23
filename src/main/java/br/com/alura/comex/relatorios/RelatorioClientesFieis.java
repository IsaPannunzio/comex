package br.com.alura.comex.relatorios;

import br.com.alura.comex.Pedido;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RelatorioClientesFieis implements Relatorio {

    private Map<String, Long> clientesFieis;

    @Override
    public void filtrarRelatorio(List<Pedido> listaDePedidos) {
        clientesFieis = listaDePedidos.stream()
                .collect(Collectors.groupingBy(Pedido::getCliente, Collectors.counting()));
    }

    @Override
    public void imprimirRelatorio() {
        System.out.println("\n#### RELATÓRIO DE CLIENTES FIÉIS");
        clientesFieis.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(cliente -> {
            System.out.println("NOME: " + cliente.getKey() + "\nNº DE PEDIDOS: " + cliente.getValue() + "\n");
        });
    }
}
