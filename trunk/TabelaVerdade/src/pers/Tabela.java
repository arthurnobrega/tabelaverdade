/*
 * LogicaTabela.java
 *
 */

package pers;

import java.util.ArrayList;
import log.FormulaException;
import log.Logica;
import pers.TabelaVerdade;
import tipos.Formula;

/**
 *
 * @author Arthur Thiago Barbosa Nobrega e Felippe Pires Ferreira
 */
public class Tabela {
    
    /** Creates a new instance of LogicaTabela */
    public Tabela(Formula formula) throws FormulaException {
        Logica logica = new Logica();
        if (!(logica.testarFormulaBemFormada(formula))) {
            throw new FormulaException();
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
