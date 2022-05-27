package br.com.alura.comex.service.processadores;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ProcessadorDeJSON extends ProcessadorJackson{

    private static final String arquivoJSON = "pedidos.json";

    @Override
    public ObjectMapper getMapper() {
        return new ObjectMapper();
    }

    @Override
    public String getNomeArquivo() {
        return arquivoJSON;
    }
}
