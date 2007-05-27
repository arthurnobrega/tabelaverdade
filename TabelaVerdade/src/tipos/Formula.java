/*
 * Formula.java
 *
 */

package tipos;

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
        contarCaracteres();
    }

    /** Fun��o interna que conta o n�mero de proposi��es distintas que 
     * existem na f�rmula e as guarda na vari�vel de objeto 'proposicoes'.
     */
    private void contarCaracteres() {
        char letra;
        proposicoes = new ArrayList();
        /* Testa o caractere e armazena o tipo dele na vari�vel correspondente. */
        for (int i = 0; i <= formula.length() - 1; i++) {
            letra = formula.charAt(i);
            switch (letra) {
                case Constantes.CONJUNCAO: {
                    conectivos++;
                    break;
                }
                case Constantes.DISJUNCAO: {
                    conectivos++;
                    break;
                }
                case Constantes.NEGACAO: {
                    conectivos++;
                    break;
                }
                case Constantes.IMPLICACAO: {
                    conectivos++;
                    break;
                }
                case Constantes.DUPLA_IMPLICACAO: {
                    conectivos++;
                    break;
                }
                case '(': {
                    abreParenteses++;
                    break;
                }
                case ')': {
                    fechaParenteses++;
                    break;
                }
                case ' ': {
                    break;
                }
                default: {
                    boolean achou = false;
                    int j = 0;
                    while ((!achou) && (j <= proposicoes.size() - 1)) {                    
                        if (letra == proposicoes.get(j)) {
                            achou = true;
                        }
                        else {
                            j++;
                        }
                    }
                    if (!achou) {
                        proposicoes.add(letra);
                    }
                    break;
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
    
    public int getConectivos() {
        return conectivos;
    }
    
    public int getAbreParenteses() {
        return abreParenteses;
    }
    
    public int getFechaParenteses() {
        return fechaParenteses;
    }
    
    private String formula = null;
    private ArrayList proposicoes = null;
    private int conectivos = 0;
    private int abreParenteses = 0;
    private int fechaParenteses = 0;
}
