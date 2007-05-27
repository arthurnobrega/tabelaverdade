/*
 * Logica.java
 *
 */

package log;

import java.util.ArrayList;
import tipos.Formula;

/**
 *
 * @author Arthur Thiago Barbosa Nobrega
 */
public class Logica {
    
    /* Esta função irá testar se a fórmula é bem formada e segue os padrões exigidos.*/
    protected boolean testarFormula(String strFormula) {
        ArrayList listaChar = new ArrayList();
        /* Passa a String da fórmula para uma lista de chars. */
        for (int i = 0; i <= strFormula.length() - 1; i++) {
            listaChar.add(strFormula.charAt(i));
        }
        boolean achou = false;
        int j = 0;
        while ((!achou) && (j <= listaChar.size() - 1)) {
            if (listaChar.get(j).equals('(')) {
                
            }
        }
        return true;
    }
}
