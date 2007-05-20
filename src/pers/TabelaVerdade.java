/*
 * TabelaVerdade.java
 *
 * Created on 18 de Maio de 2007, 19:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pers;

import java.util.ArrayList;

/**
 *
 * @author UltraXP
 */
public class TabelaVerdade {

    /** Creates a new instance of TabelaVerdade */
    public TabelaVerdade(String pFormula) {
        formula = pFormula;
    }

    public ArrayList construirTabela() {
        return new ArrayList();
    }

    public int verificarSemantica() {
        return 1;
    }

    public int nroProposicoes() {
        return 1;
    }

    public String formula;
}
