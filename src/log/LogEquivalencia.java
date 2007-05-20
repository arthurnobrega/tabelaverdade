/*
 * LogEquivalencia.java
 *
 */

package log;

import java.util.ArrayList;
import gui.Constantes;
import pers.TabelaVerdade;

/**
 *
 * @author Arthur Thiago Barbosa Nobrega
 */
public class LogEquivalencia extends Logica {
    
    /** Creates a new instance of LogEquivalencia */
    public LogEquivalencia(String formula1, String formula2) {
        TabelaVerdade tabVerdade1 = new TabelaVerdade(formula1);
        TabelaVerdade tabVerdade2 = new TabelaVerdade(formula2);
        tabela1 = tabVerdade1.getTabela();
        tabela2 = tabVerdade2.getTabela();
    }
    
    /** Compara se as duas tabelas são iguais, ou seja, se são semânticamente equivalentes.
     * @return SUCESSO caso forem iguais as tabelas ou FRACASSSO caso não forem iguais.
     */
    public int compararTabelas() {
        if (tabela1.equals(tabela2)) {
            return Constantes.SUCESSO;
        }
        
        return Constantes.FRACASSO;
    }
    
    private ArrayList tabela1;
    private ArrayList tabela2;
}
