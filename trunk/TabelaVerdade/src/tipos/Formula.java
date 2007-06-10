/*
 * Formula.java
 */

package tipos;

import java.util.ArrayList;
import java.util.Collections;
import tipos.Constantes;

/** Esta classe � respons�vel por dividir as letras da f�rmula em tipos.
 * @author Arthur Thiago Barbosa Nobrega e Felippe Pires Ferreira
 */
public class Formula {
    
    /** Cria uma nova inst�ncia de f�rmula. 
     */
    public Formula(String formula) {
        this.formula = formula;
        contarCaracteres();
    }

    /* Fun��o interna que conta o n�mero de proposi��es distintas que existem na f�rmula e as guarda na vari�vel de objeto 'proposicoes'.
     */
    private void contarCaracteres() {
        String letra;
        proposicoes = new ArrayList();
        /* Testa o caractere e armazena o tipo dele na vari�vel correspondente. */
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
                /* Desconsidera os espa�os. */
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
        Collections.sort(proposicoes);
    }

    /** Retorna a f�rmula em forma de String.
     */
    public String getFormula() {
        return formula;
    }
    
    public void setFormula(String formula) {
        this.formula = formula;
    }
    
    /** Retorna a lista de proposi��es da f�rmula.
     */
    public ArrayList<String> getProposicoes() {
        return proposicoes;
    }
    
    /** Retorna o n�mero de conectivos na f�rmula.
     */
    public int getConectivos() {
        return conectivos;
    }
    
    /** Retorna o n�mero par�nteses abrindo na f�rmula.
     */
    public int getAbreParenteses() {
        return abreParenteses;
    }
    
    /** Retorna o n�mero par�nteses fechando na f�rmula.
     */
    public int getFechaParenteses() {
        return fechaParenteses;
    }
    
    private String formula = null;
    private ArrayList<String> proposicoes = null;
    private int conectivos = 0;
    private int abreParenteses = 0;
    private int fechaParenteses = 0;
}
