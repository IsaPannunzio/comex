package br.com.alura.comex.model.enums;

import br.com.alura.comex.service.processadores.Processador;
import br.com.alura.comex.service.processadores.ProcessadorDeCSV;
import br.com.alura.comex.service.processadores.ProcessadorDeJSON;
import br.com.alura.comex.service.processadores.ProcessadorDeXML;

public enum TipoProcessador {

    CSV(new ProcessadorDeCSV()), JSON(new ProcessadorDeJSON()), XML(new ProcessadorDeXML());

    private final Processador processador;
    TipoProcessador(Processador processador) {
        this.processador = processador;
    }
    public Processador getProcessador() {
        return processador;
    }
}
