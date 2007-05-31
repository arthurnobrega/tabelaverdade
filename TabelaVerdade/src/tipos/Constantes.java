/*
 * Constantes.java
 *
 */

package tipos;

/** Esta classe guarda as constantes que são usadas no programa e que não foram encaixadas em outras classes.
 *
 * @author Arthur Thiago Barbosa Nobrega
 */
public class Constantes {
    
    public final static String MENSAGEM_ERRO_FORMULA = "A f\u00f3rmula inserida n\u00e3o segue os padr\u00f5es pr\u00e9-definidos!";
    public final static String TITULO_ERRO_FORMULA = "Os padr\u00f5es n\u00e3o foram seguidos!";
        
    /* Constante que é utilizada nas 3 opções iniciais para mostrar os padrões de escrita ao usuário. */
    public final static String PADRAO_FORMULA = "* Operadores l\u00f3gicos que devem ser utilizados:\n" +
        "& : Conjun\u00e7\u00e3o                   - : Implica\u00e7\u00e3o                    ~ : Nega\u00e7\u00e3o\n" +
        "| : Disjun\u00e7\u00e3o                   = : Dupla Implica\u00e7\u00e3o\n\n" +
        "* O uso de espa\u00e7os n\u00e3o interfere na leitura da f\u00f3rmula. Use-os para visualizar " +
            "melhor a f\u00f3rmula que est\u00e1 digitando.\n" +
        "* Coloque par\u00eanteses em torno de todas as subf\u00f3rmulas. Exemplo: " +
            "( (~ (p & q) ) | (q | r ) ). Note que temos 4 subf\u00f3rmulas: " +
            "(p & q), ( ~ (p & q) ), (q | r) e ( (~ (p & q) ) | (q | r ) ). " +
            "Portanto 4 duplas de par\u00eanteses, uma para cada operador l\u00f3gico.";

    /* Constantes dos padrões de escrita dos Símbolos Proposicionais. */
    public final static String NEGACAO = "~";
    public final static String CONJUNCAO = "&";
    public final static String DISJUNCAO = "|";
    public final static String IMPLICACAO = "-";
    public final static String DUPLA_IMPLICACAO = "=";
    public final static String ALFABETO_PROPOSICOES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz";
}
