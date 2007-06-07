/*
 * ProposicoesException.java
 */

package log;

/** Classe de Exce��o para quando o usu�rio informar duas f�rmulas que n�o t�m o mesmo n�mero de proposi��es.
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
