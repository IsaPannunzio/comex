package br.com.alura.comex.model.enums;

import br.com.alura.comex.model.entities.Pedido;
import br.com.alura.comex.service.relatorios.*;

import java.util.List;
import java.util.function.Function;

public enum TipoRelatorio {


    A(RelatorioSintetico::new),
    B(RelatorioClientesFieis::new),
    C(RelatorioVendasPorCategoria::new),
    D(RelatorioProdutosMaisVendidos::new),
    E(RelatorioProdutosMaisCaros::new),
    F(RelatorioClientesMaisLucrativos::new);

    private final Function<List<Pedido>, Relatorio> relatorioSupplier;

    TipoRelatorio(Function<List<Pedido>, Relatorio> relatorioSupplier) {
        this.relatorioSupplier = relatorioSupplier;
    }

    public Relatorio getRelatorio(List<Pedido> listaDePedidos) {
        return relatorioSupplier.apply(listaDePedidos);
    }


}
