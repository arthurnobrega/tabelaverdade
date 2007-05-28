/*
 * Constantes.java
 *
 */

package tipos;

/** Esta classe guarda as constantes que s�o usadas no programa e que n�o foram encaixadas em outras classes.
 *
 * @author Arthur Thiago Barbosa Nobrega
 */
public class Constantes {
        
    /* Cosntante que � utilizada nas 3 op��es iniciais para mostrar os padr�es de escrita ao usu�rio. */
    public final static String PADRAO_FORMULA = "* Operadores l�gicos que devem ser utilizados:\n" +
        "& : Conjun��o                   - : Implica��o                    ~ : Nega��o\n" +
        "v : Disjun��o                   = : Dupla Implica��o\n\n" +
        "* O uso de espa�os n�o interfere na leitura da f�rmula. Use-os para visualizar " +
            "melhor a f�rmula que est� digitando.\n" +
        "* Coloque par�nteses em torno de todas as subf�rmulas. Exemplo: " +
            "( (~ (p & q) ) V (q V r ) ). Note que temos 4 subf�rmulas: " +
            "(p & q), ( ~ (p & q) ), (q V r) e ( (~ (p & q) ) V (q V r ) ). " +
            "Portanto 4 duplas de par�nteses, uma para cada operador l�gico.";

    /* Constantes dos padr�es de escrita dos S�mbolos Proposicionais. */
    public final static String NEGACAO = "~";
    public final static String CONJUNCAO = "&";
    public final static String DISJUNCAO = "v";
    public final static String IMPLICACAO = "-";
    public final static String DUPLA_IMPLICACAO = "=";
}
