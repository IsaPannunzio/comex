package br.com.alura.comex.model.entities;

import br.com.alura.comex.model.enums.TipoProcessador;
import br.com.alura.comex.model.enums.TipoRelatorio;
import br.com.alura.comex.service.processadores.Processador;
import br.com.alura.comex.service.relatorios.*;

import java.util.List;
import java.util.Scanner;

public class MenuDeRelatorios {

    Scanner entrada = new Scanner(System.in);

    private void imprimirOpcoesProcessador() {
        System.out.println("BEM VINDO!");
        System.out.println("Qual tipo de arquivo deseja processar?");
        System.out.println("'A' - CSV");
        System.out.println("'B' - JSON");
        System.out.println("'C' - XML");
    }

    private void imprimirOpcoesRelatorio() {
        System.out.println("\nQual relatório deseja imprimir?");
        System.out.println("'A' - Relatório sintético");
        System.out.println("'B' - Relatório de clientes fiéis");
        System.out.println("'C' - Relatório de vendas por categoria");
        System.out.println("'D' - Relatório de produtos mais vendidos");
        System.out.println("'E' - Relatório de produtos mais caros em cada categoria");
        System.out.println("'F' - Relatório de clientes mais lucrativos");
    }

    private List<Pedido> arquivo() throws Exception {
        imprimirOpcoesProcessador();
        System.out.print("Digite: ");
        String opcao = entrada.nextLine();
        TipoProcessador tipoProcessador = TipoProcessador.valueOf(opcao);
        Processador processador = tipoProcessador.getProcessador();
        return processador.lerArquivos();
    }

    private void relatorio(List<Pedido> listaDePedidos) {
        imprimirOpcoesRelatorio();
        System.out.print("Digite: ");
        String opcao = entrada.nextLine();
        TipoRelatorio tipoRelatorio = TipoRelatorio.valueOf(opcao);
        Relatorio relatorio = tipoRelatorio.getRelatorio(listaDePedidos);
        relatorio.exibir();
    }

    public void exibirRelatorio() throws Exception {
        List<Pedido> listaDePedidos = arquivo();
        relatorio(listaDePedidos);
    }
}
