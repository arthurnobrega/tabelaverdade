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

    /** Construtor padrão da classe.
     */
    public FormulaException() {
	super();
    }
    
    /** Construtor que recebe a descrição do erro.
     * @param mensagem Mensagem que será mostrada ao usuário para informar sobre a exceção ocorrida.
     */
    public FormulaException(String mensagem) {
	super(mensagem);
    }

}
