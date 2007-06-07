/*
 * FormulaException.java
 *
 */

package log;

/** Classe de Exceção para quando o usuário informar uma fórmula que não segue os padrões pré-definidos.
 * @see java.lang.Exception
 * @author Arthur Thiago Barbosa Nobrega e Felippe Pires Ferreira
 */
public class FormulaException extends Exception {
    
    public FormulaException() {
	super();
    }
    public FormulaException(String s) {
	super(s);
    }
    
}
