/*
 * ProposicoesException.java
 */

package log;

/** Classe de Exceção para quando o usuário informar duas fórmulas que não têm o mesmo número de proposições.
 * @see java.lang.Exception
 * @author Arthur Thiago Barbosa Nobrega e Felippe Pires Ferreira
 */
public class ProposicoesException extends Exception {
    
    public ProposicoesException() {
	super();
    }
    
    public ProposicoesException(String s) {
	super(s);
    }
    
}
