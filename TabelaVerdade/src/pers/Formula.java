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
    
    /** Cria uma nova inst�ncia de f�rmula. */
    public Formula(String formula) {
        this.formula = formula;
        contarProposicoes();
    }

    /** Fun��o interna que conta o n�mero de proposi��es distintas que 
     * existem na f�rmula e as guarda na vari�vel de objeto 'proposi��es'.
     */
    private void contarProposicoes() {        
        int j;
        boolean achou;
        Character letra;
        proposicoes = new ArrayList();
        /* Percorre todo a formula � procura do n�mero de proposi��es distintas. */
        for (int i = 0; i <= formula.length() - 1; i++) {
            letra = new Character(formula.charAt(i));
            if (!(letra.equals(Constantes.CONJUNCAO)) && !(letra.equals(Constantes.DISJUNCAO))
              && !(letra.equals(Constantes.IMPLICACAO)) && !(letra.equals(Constantes.DUPLA_IMPLICACAO))
              && !(letra.equals(Constantes.NEGACAO)) && (letra != ' ') && (letra != '(') && (letra != ')')) {
                achou = false;
                j = 0;                
                /* � uma proposi��o, agora temos que testar se ela j� n�o foi inclu�da na lista. */
                while ((!achou) && (j < proposicoes.size() - 1)) {                    
                    if (letra.equals((Character) proposicoes.get(j))) {
                        achou = true;
                    }
                    else {
                        j++;
                    }
                }
                /* Se n�o foi encontrada, adiciona � lista de proposi��es. */
                if ((!achou) || (proposicoes.size() == 0)) {
                    proposicoes.add(letra);
                }
            }
        }
    }

    /** @return A f�rmula em forma de String.
     */
    public String getFormula() {
        return formula;
    }
    
    /** @return A lista de proposi��es da f�rmula.
     */
    public ArrayList getProposicoes() {
        return (ArrayList) proposicoes.clone();
    }
    
    /** @return O n�mero de proposi��es da f�rmula.
     */
    public int getCountProposicoes() {
        return proposicoes.size();
    }

    private String formula;
    private ArrayList proposicoes;
}
