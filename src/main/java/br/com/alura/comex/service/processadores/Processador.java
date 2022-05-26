package br.com.alura.comex.service.processadores;

import br.com.alura.comex.model.entities.Pedido;

import java.util.List;

public interface Processador {

    List<Pedido> imprimir() throws Exception;
}
