package br.com.alura.comex.model.entities;

import br.com.alura.comex.model.enums.TipoProcessador;
import br.com.alura.comex.model.enums.TipoRelatorio;
import br.com.alura.comex.service.processadores.Processador;
import br.com.alura.comex.service.processadores.ProcessadorDeCSV;
import br.com.alura.comex.service.processadores.ProcessadorDeJSON;
import br.com.alura.comex.service.processadores.ProcessadorDeXML;
import br.com.alura.comex.service.relatorios.*;

import java.util.List;
import java.util.Scanner;

public class MenuDeRelatorios {

    Scanner entrada = new Scanner(System.in);

    private void imprimirOpcoesProcessador() {
        System.out.println("----BEM VINDO----");
        System.out.println("Digite a opção do tipo de arquivo que deseja processar em letras maiúsculas");
        System.out.println("CSV");
        System.out.println("JSON");
        System.out.println("XML");
    }

    private void imprimirOpcoesRelatorio() {
        System.out.println("\nQual relatório deseja imprimir?");
        System.out.println("'UM' - Relatório sintético");
        System.out.println("'DOIS' - Relatório de clientes fiéis");
        System.out.println("'TRÊS' - Relatório de vendas por categoria");
        System.out.println("'QUATRO' - Relatório de produtos mais vendidos");
        System.out.println("'CINCO' - Relatório de produtos mais caros em cada categoria");
    }

    private List<Pedido> arquivo() throws Exception {
        imprimirOpcoesProcessador();
        System.out.print("Digite: ");
        String opcao = entrada.nextLine();
        TipoProcessador processador = TipoProcessador.valueOf(opcao);

        return switch (processador) {
            case CSV -> ((Processador) new ProcessadorDeCSV()).imprimir();
            case JSON -> ((Processador) new ProcessadorDeJSON()).imprimir();
            case XML -> ((Processador) new ProcessadorDeXML()).imprimir();
        };
    }
    
    private void relatorio(List<Pedido> listaDePedidos) {
        imprimirOpcoesRelatorio();
        System.out.print("Digite: ");
        String opcao = entrada.nextLine();
        TipoRelatorio relatorio = TipoRelatorio.valueOf(opcao);

        switch (relatorio) {
            case UM -> new RelatorioSintetico(listaDePedidos).exibir();
            case DOIS -> new RelatorioClientesFieis(listaDePedidos).exibir();
            case TRES -> new RelatorioVendasPorCategoria(listaDePedidos).exibir();
            case QUATRO -> new RelatorioProdutosMaisVendidos(listaDePedidos).exibir();
            case CINCO -> new RelatorioProdutosMaisCaros(listaDePedidos).exibir();
        }
    }




    public void exibirRelatorio() throws Exception {
        List<Pedido> listaDePedidos = arquivo();
        relatorio(listaDePedidos);
    }
}
