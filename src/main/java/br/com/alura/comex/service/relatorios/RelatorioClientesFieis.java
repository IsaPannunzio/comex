package br.com.alura.comex.service.relatorios;

import br.com.alura.comex.model.entities.Pedido;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RelatorioClientesFieis extends Relatorio {

    private Map<String, Long> clientesFieis;

    public RelatorioClientesFieis(List<Pedido> listaDePedidos) {
        super(listaDePedidos);
    }

    @Override
    public void filtrarRelatorio() {
        clientesFieis = getListaDePedidos().stream()
                .collect(Collectors.groupingBy(Pedido::getCliente, Collectors.counting()));
    }

    @Override
    public void imprimirRelatorio() {
        System.out.println("\n#### RELATÓRIO DE CLIENTES FIÉIS");
        clientesFieis.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(cliente -> System.out.println("NOME: " + cliente.getKey() + "\nNº DE PEDIDOS: " + cliente.getValue() + "\n"));
    }
}
