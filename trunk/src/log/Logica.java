/*
 * Logica.java
 *
 */

package log;

import gui.Constantes;
import java.util.ArrayList;
import java.util.Stack;
import pers.TabelaVerdade;

/**
 *
 * @author Arthur Thiago Barbosa Nobrega
 */
public class Logica {
    
    public static ArrayList verTabela(String formula) {
        
    }

    /* Fun��o que retorna a tabela verdade da f�rmula passada.
     * @param formula F�rmula que se deseja ver a tabela verdade.
     * @return Um ArrayList de vetores contendo a tabela verdade.
     */
    public ArrayList retornarTabela(String formula) {
        TabelaVerdade tabVerdade = new TabelaVerdade(formula);
        ArrayList tabela = tabVerdade.construirTabela();
        return tabela;
    }

    /* Fun��o que retorna se a conclusao � consequ�ncia l�gica das premissas.
     * @param premissas ArrayList contendo todas as f�rmulas das premissas.
     * @param conclusao F�rmula da conclus�o.
     */
    public int retornarConsequencia(ArrayList premissas, String conclusao) {
        return (Constantes.SUCESSO); // Provis�rio.
    }

    private int testarPadroes(String formula) {
        char ch;
        int abreParenteses = 0, fechaParenteses = 0, simbolos = 0;
        for(int i = 0; i < formula.length() - 1; i++) {
            ch = formula.charAt(i);
            switch (ch) {
                case ' ': break;
                case '(': abreParenteses++; break;
                case ')': fechaParenteses++; break;
                case Constantes.CONJUNCAO: simbolos++; break;
                case Constantes.DISJUNCAO: simbolos++; break;
                case Constantes.IMPLICACAO: simbolos++; break;
                case Constantes.DUPLA_IMPLICACAO: simbolos++; break;
                default: /* Retorna erro. */ break;
            }            
        }

        /* Testa se a f�rmula seguiu os padr�es exigidos. */
        if ((simbolos == fechaParenteses) && (abreParenteses == fechaParenteses)) {
            return (Constantes.SUCESSO);
        } else {
            return (Constantes.FRACASSO);
        }
    }
}
