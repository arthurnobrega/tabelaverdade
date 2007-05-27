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
import pers.TabelaVerdade;

/**
 *
 * @author UltraXP
 */
public class LogicaTabela extends Logica {
    
    /** Creates a new instance of LogicaTabela */
    public LogicaTabela(String formula) throws IOException {
        if (!testarFormula(formula)) {
            throw new IOException();
        }
        TabelaVerdade tabela = new TabelaVerdade(formula);
    }
    
}
