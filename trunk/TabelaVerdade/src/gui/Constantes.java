/*
 * Constantes.java
 *
 */

package gui;

/** Esta classe guarda as constantes que são usadas no programa e que não foram encaixadas em outras classes.
 *
 * @author Arthur Thiago Barbosa Nobrega
 */
public class Constantes {
    
    /* Constantes de fracasso e sucesso nas funções. */
    public final static int SUCESSO = 0;
    public final static int FRACASSO = 1;
    
    /* Cosntante que é utilizada nas 3 opções iniciais para mostrar os padrões de escrita ao usuário. */
    public final static String PADRAO_FORMULA = "* Operadores lógicos que devem ser utilizados:\n" +
        "& : Conjunção                   - : Implicação                    ~ : Negação\n" +
        "v : Disjunção                   = : Dupla Implicação\n\n" +
        "* O uso de espaços não interfere na leitura da fórmula. Use-os para visualizar " +
            "melhor a fórmula que está digitando.\n" +
        "* Coloque parênteses em torno de todas as subfórmulas. Exemplo: " +
            "( (~ (p & q) ) V (q V r ) ). Note que temos 4 subfórmulas: " +
            "(p & q), ( ~ (p & q) ), (q V r) e ( (~ (p & q) ) V (q V r ) ). " +
            "Portanto 4 duplas de parênteses, uma para cada operador lógico.";

    /* Constantes dos padrões de escrita dos Símbolos Proposicionais. */
    public final static char CONJUNCAO = '&';
    public final static char DISJUNCAO = 'v';
    public final static char IMPLICACAO = '-';
    public final static char DUPLA_IMPLICACAO = '=';
}
