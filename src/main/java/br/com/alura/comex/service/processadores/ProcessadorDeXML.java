package br.com.alura.comex.service.processadores;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ProcessadorDeXML extends ProcessadorJackson {

    private static final String arquivoXML = "pedidos.xml";

    @Override
    public ObjectMapper getMapper() {
        return new XmlMapper();
    }
    @Override
    public String getNomeArquivo() {
        return arquivoXML;
    }
}
