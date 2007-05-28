/*
 * LogicaTabela.java
 *
 * Created on 26 de Maio de 2007, 23:21
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package log;

import java.io.IOException;
import java.util.ArrayList;
import pers.TabelaVerdade;
import tipos.Formula;

/**
 *
 * @author UltraXP
 */
public class LogicaTabela extends Logica {
    
    /** Creates a new instance of LogicaTabela */
    public LogicaTabela(Formula formula) throws IOException {
        if (!testarFormula(formula)) {
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
