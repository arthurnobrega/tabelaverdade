/*
 * Equivalencia.java
 *
 */

package pers;

import gui.Constantes;
import java.util.ArrayList;

/**
 *
 * @author Arthur Thiago Barbosa Nobrega
 */
public class Equivalencia {
    
    /** Creates a new instance of Equivalencia */
    public Equivalencia(String pFormula1, String pFormula2) {
        formula1 = pFormula1;
        formula2 = pFormula2;
    }
    
    /* Função que retorna se as fórmulas são ou não equivalentes.
     * @param formula1 Fórmula para se comparar com a segunda.
     * @param formula2 Fórmula para se comparar com a primeira.
     * @return Constantes.SUCESSO caso forem equivalentes, ou Constantes.FRACASSO caso contrário.
     */
    public int retornarEquivalencia() {
        TabelaVerdade tabVerdade1 = new TabelaVerdade(formula1);
        TabelaVerdade tabVerdade2 = new TabelaVerdade(formula2);
        ArrayList tabela1 = tabVerdade1.construirTabela();
        ArrayList tabela2 = tabVerdade2.construirTabela();
        
        ArrayList comparacao = new ArrayList();
        comparacao.add(tabela1.get(tabela1.size() - 1));
        comparacao.add(tabela2.get(tabela2.size() - 1));
        
        /* Compara as duas formulas */
        if (comparacao.get(0).equals(comparacao.get(1))) {
            return (Constantes.SUCESSO);
        } else { 
            return (Constantes.FRACASSO);
        }
    }

    private String formula1;
    private String formula2;
}