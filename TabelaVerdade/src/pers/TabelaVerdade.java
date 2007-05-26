/*
 * TabelaVerdade.java
 *
 */

package pers;

import java.util.ArrayList;
import pers.Formula;

/**
 *
 * @author Arthur Thiago Barbosa Nobrega
 */
public class TabelaVerdade {

    /** Creates a new instance of TabelaVerdade */
    public TabelaVerdade(String frase) {
        formula = new Formula(frase); 
    }

    Formula formula;
}
