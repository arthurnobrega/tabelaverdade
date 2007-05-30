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
    
    /** Cria uma nova instância de fórmula. */
    public Formula(String formula) {
        this.formula = formula;
        contarCaracteres();
    }

    /** Função interna que conta o número de proposições distintas que 
     * existem na fórmula e as guarda na variável de objeto 'proposicoes'.
     */
    private void contarCaracteres() {
        String letra;
        proposicoes = new ArrayList();
        /* Testa o caractere e armazena o tipo dele na variável correspondente. */
        for (int i = 0; i <= formula.length() - 1; i++) {
            letra = formula.substring(i, i + 1);
            if (letra.equals(Constantes.CONJUNCAO) || letra.equals(Constantes.DISJUNCAO)
                    || letra.equals(Constantes.NEGACAO) || letra.equals(Constantes.IMPLICACAO)
                    || letra.equals(Constantes.DUPLA_IMPLICACAO)) {
                conectivos++;
            } else if (letra.equals("(")) {
                abreParenteses++;
            } else if (letra.equals(")")) {
                fechaParenteses++;
            } else if (letra.equals(" ")) {
                /* Desconsidera os espaços. */
            } else {
                boolean achou = false;
                int j = 0;
                while ((!achou) && (j <= proposicoes.size() - 1)) {
                    if (letra.equals(proposicoes.get(j))) {
                        achou = true;
                    }
                    else {
                        j++;
                    }
                }
                if (!achou) {
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
