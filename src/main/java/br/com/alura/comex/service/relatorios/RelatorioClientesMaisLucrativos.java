package br.com.alura.comex.service.relatorios;

import br.com.alura.comex.model.entities.Pedido;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class RelatorioClientesMaisLucrativos extends Relatorio {

    private List<ClientesMaisLucrativos> clientesMaisLucrativos;

    public class ClientesMaisLucrativos {
        private final String nome;
        private final Long numPedidos;
        private final BigDecimal montanteGasto;

        public ClientesMaisLucrativos(String nome, Long numPedidos, BigDecimal montanteGasto) {
            this.nome = nome;
            this.numPedidos = numPedidos;
            this.montanteGasto = montanteGasto;
        }

        public String getNome() {
            return nome;
        }

        public Long getNumPedidos() {
            return numPedidos;
        }

        public BigDecimal getMontanteGasto() {
            return montanteGasto;
        }
    }

    public RelatorioClientesMaisLucrativos(List<Pedido> listaDePedidos) {
        super(listaDePedidos);
    }

    @Override
    public void filtrarRelatorio() {
        clientesMaisLucrativos = listaDePedidos.stream().collect(Collectors.groupingBy(Pedido::getCliente))
                .entrySet().stream().sorted(Map.Entry.comparingByKey()).map(cliente -> {
                    String nome = cliente.getKey();
                    Long numPedidos = cliente.getValue().stream().map(Pedido::getQuantidade).count();
                    BigDecimal montanteGasto = getMontanteCliente(cliente);
                    return new ClientesMaisLucrativos(nome, numPedidos, montanteGasto);
                }).toList();
    }

    @Override
    public void imprimirRelatorio() {
        System.out.println("\n#### CLIENTES MAIS LUCRATIVOS");
        clientesMaisLucrativos.stream()
                .sorted(Comparator.comparing(ClientesMaisLucrativos::getMontanteGasto).reversed())
                .limit(2)
                .forEach(cliente -> System.out.println("NOME: " + cliente.getNome() + "\nNº DE PEDIDOS: "
                        + cliente.getNumPedidos()
                        + "\nMONTANTE GASTO: "
                        + NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(cliente.getMontanteGasto())
                        + "\n"));
    }
}
