package br.com.alura.comex.model.enums;

import br.com.alura.comex.model.entities.Pedido;
import br.com.alura.comex.service.relatorios.*;

import java.util.List;
import java.util.function.Function;

public enum TipoRelatorio {


    UM(RelatorioSintetico::new),
    DOIS(RelatorioClientesFieis::new),
    TRES(RelatorioVendasPorCategoria::new),
    QUATRO(RelatorioProdutosMaisVendidos::new),
    CINCO(RelatorioProdutosMaisCaros::new);

    private final Function<List<Pedido>,Relatorio> relatorioSupplier;

    TipoRelatorio(Function<List<Pedido>,Relatorio> relatorioSupplier) {
        this.relatorioSupplier = relatorioSupplier;
    }

    public Relatorio getRelatorio(List<Pedido> listaDePedidos) {
        return relatorioSupplier.apply(listaDePedidos);
    }


}
