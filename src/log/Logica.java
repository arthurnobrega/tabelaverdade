/*
 * Logica.java
 *
 */

package log;

import gui.Constantes;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JOptionPane;
import pers.NoDefaultException;
import pers.TabelaVerdade;

/**
 *
 * @author Arthur Thiago Barbosa Nobrega
 */
public class Logica {

    /* Função que retorna a tabela verdade da fórmula passada.
     * @param formula Fórmula que se deseja ver a tabela verdade.
     * @return Um ArrayList de vetores contendo a tabela verdade.
     */
    public static ArrayList retornarTabela(String formula) {
        try {
            testarPadroes(formula);
        } catch (NoDefaultException e) {
            JOptionPane.showMessageDialog(null, "A fórmula informada não segue " +
                    "os padrões estipulados. Por favor leia as regras descritas.");
        }

        TabelaVerdade tabVerdade = new TabelaVerdade(formula);
        ArrayList tabela = tabVerdade.construirTabela();
        return (tabela);
    }

    /* Função que retorna se a conclusao é consequência lógica das premissas.
     * @param premissas ArrayList contendo todas as fórmulas das premissas.
     * @param conclusao Fórmula da conclusão.
     */
    public static int retornarConsequencia(ArrayList premissas, String conclusao) {
        return (Constantes.SUCESSO); // Provisório.
    }

    private static void testarPadroes(String formula) throws NoDefaultException {
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

        /* Testa se a fórmula seguiu os padrões exigidos. */
        if ((simbolos == fechaParenteses) && (abreParenteses == fechaParenteses)) {
            throw new NoDefaultException();
        }
    }
}
