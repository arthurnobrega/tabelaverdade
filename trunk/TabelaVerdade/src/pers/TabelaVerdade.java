/*
 * TabelaVerdade.java
 *
 */

package pers;

import java.util.ArrayList;
import java.util.Stack;
import tipos.Constantes;
import tipos.Formula;

/**
 *
 * @author Arthur Thiago Barbosa Nobrega
 */
public class TabelaVerdade {

    /** Creates a new instance of TabelaVerdade */
    public TabelaVerdade(String frase) {
        formula = new Formula(frase);
        int nroProposicoes = formula.getProposicoes().size();
        Stack pilhaConectivos = new Stack();
        Stack pilhaProposicoes = new Stack();
        char[] vetor = formula.getFormula().toCharArray();
        for (int i = 0; i <= vetor.length; i++) {
            switch (vetor[i]) {
                case ')': {
                    break;
                }
                case Constantes.CONJUNCAO: {
                    break;
                }
                case Constantes.DISJUNCAO: {
                    break;
                }
                case Constantes.NEGACAO: {
                    break;
                }
                case Constantes.IMPLICACAO: {
                    break;
                }
                case Constantes.DUPLA_IMPLICACAO: {
                    break;
                }
            }
        }
    }

    private Formula formula;
}
