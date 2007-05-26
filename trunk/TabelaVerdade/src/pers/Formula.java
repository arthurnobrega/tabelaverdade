/*
 * Formula.java
 *
 */

package pers;

import java.util.ArrayList;
import tipos.Constantes;

/**
 * 
 * @author Arthur Thiago Barbosa Nobrega
 */
public class Formula {
    
    /** Cria uma nova instância de fórmula. */
    public Formula(String formula) {
        this.formula = formula;
        contarProposicoes();
    }

    /** Função interna que conta o número de proposições distintas que 
     * existem na fórmula e as guarda na variável de objeto 'proposições'.
     */
    private void contarProposicoes() {        
        int j;
        boolean achou;
        Character letra;
        proposicoes = new ArrayList();
        /* Percorre todo a formula à procura do número de proposições distintas. */
        for (int i = 0; i <= formula.length() - 1; i++) {
            letra = new Character(formula.charAt(i));
            if (!(letra.equals(Constantes.CONJUNCAO)) && !(letra.equals(Constantes.DISJUNCAO))
              && !(letra.equals(Constantes.IMPLICACAO)) && !(letra.equals(Constantes.DUPLA_IMPLICACAO))
              && !(letra.equals(Constantes.NEGACAO)) && (letra != ' ') && (letra != '(') && (letra != ')')) {
                achou = false;
                j = 0;                
                /* É uma proposição, agora temos que testar se ela já não foi incluída na lista. */
                while ((!achou) && (j < proposicoes.size() - 1)) {                    
                    if (letra.equals((Character) proposicoes.get(j))) {
                        achou = true;
                    }
                    else {
                        j++;
                    }
                }
                /* Se não foi encontrada, adiciona à lista de proposições. */
                if ((!achou) || (proposicoes.size() == 0)) {
                    proposicoes.add(letra);
                }
            }
        }
    }

    /** @return A fórmula em forma de String.
     */
    public String getFormula() {
        return formula;
    }
    
    /** @return A lista de proposições da fórmula.
     */
    public ArrayList getProposicoes() {
        return (ArrayList) proposicoes.clone();
    }
    
    /** @return O número de proposições da fórmula.
     */
    public int getCountProposicoes() {
        return proposicoes.size();
    }

    private String formula;
    private ArrayList proposicoes;
}
