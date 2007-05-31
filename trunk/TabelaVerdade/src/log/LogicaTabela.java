/*
 * LogicaTabela.java
 *
 */

package log;

import java.io.IOException;
import java.util.ArrayList;
import pers.TabelaVerdade;
import tipos.Formula;

/**
 *
 * @author Arthur Thiago Barbosa Nobrega
 */
public class LogicaTabela extends Logica {
    
    /** Creates a new instance of LogicaTabela */
    public LogicaTabela(Formula formula) throws IOException {
        if (!(testarFormulaBemFormada(formula))) {
            throw new IOException();
        }
        tabela = new TabelaVerdade(formula);
    }
    
    public ArrayList getLinhas() {
        return tabela.getLinhas();
    }
    
    public ArrayList getColunas() {
        return tabela.getColunas();
    }
    
    TabelaVerdade tabela;
}
