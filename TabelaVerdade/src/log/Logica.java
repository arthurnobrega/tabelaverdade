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
    
    /* Esta fun��o ir� testar se a f�rmula � bem formada e segue os padr�es exigidos.*/
    protected boolean testarFormula(String strFormula) {
        ArrayList listaChar = new ArrayList();
        /* Passa a String da f�rmula para uma lista de chars. */
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
