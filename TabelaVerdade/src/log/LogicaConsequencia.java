/*
 * LogicaConsequencia.java
 */

package log;

import tipos.Formula;

/**
 *
 * @author Arthur Thiago Barbosa Nobrega e Felippe Pires Ferreira
 */
public class LogicaConsequencia extends Logica {
    
    /** Creates a new instance of LogicaConsequencia */
    public LogicaConsequencia(String strFormula) {
        formula = new Formula(strFormula);
    }
    
    public boolean testarFormulaBemFormada() {
        return super.testarFormulaBemFormada(formula);
    }
    
    Formula formula;
}
