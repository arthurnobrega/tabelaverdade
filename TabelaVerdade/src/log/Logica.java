/*
 * Logica.java
 *
 */

package log;

import java.util.ArrayList;
import tipos.Constantes;
import tipos.Formula;

/**
 *
 * @author Arthur Thiago Barbosa Nobrega
 */
public class Logica {
    
    protected ArrayList getLinhas() {
        return new ArrayList();
    }
    
    protected ArrayList getColunas() {
        return new ArrayList();
    }
    
    /** 
     * Esta função irá testar se a fórmula é bem formada e segue os padrões exigidos.
     *ela utiliza funções para analizar o uso de operadores e proposições e casos
     *de erro possíveis na construção da fórmula pelo usuário.
     *
     * @param formula Objeto que possui a fórmula como uma String.
     *
     * @return Retorna verdadeiro ou falso, caso seja uma FBF ou não, respectivamente. 
     */
    protected boolean testarFormulaBemFormada(Formula formula) {
        
        String strFormula = formula.getFormula();
        String[] cVetor = StringToChar(strFormula);
        
        if (strFormula.length() == 0) {
            return false;
        }
        
        if (cVetor.length > 3){
            if (parenteses != operadores || parenteses == 0){
                return false;
            }        
        }
        
        for (int i = 0; i< strFormula.length() - 1; i++) {
            if(cVetor[i].equals("(") && cVetor[i+1].equals(")")) {
                return false;
            }
        }    
        
         for (int i = 0; i< strFormula.length() - 1; i++) {
            if(cVetor[i].equals(")") && cVetor[i+1].equals("(")) {
                return false;
            }
        } 
        
        if (!testarConectivosJuntos(cVetor) || !testarProposicoesJuntas(cVetor)) {
            return false;
        }
        
        return true;
        
    }  
    
    /**
     * Transforma a formula recebida em um vetor de caracteres através de um loop. 
     *
     * @param formula String onde está armazenada a fórmula.
     *
     * @return Retorna um vetor de String's, utilizado para manipular cada
     * símbolo da fórmula
     */
    private String[] StringToChar(String formula){
        
        String[] cVetor = new String[formula.length()];
        
        for(int i=0; i <= formula.length() - 1; i++) {
            cVetor[i] = formula.substring(i, i + 1); 
            if (cVetor[i].equals((")"))) {
                parenteses++;
            } else if ((cVetor[i].equals(Constantes.CONJUNCAO)) || (cVetor[i].equals(Constantes.DISJUNCAO))
                    || (cVetor[i].equals(Constantes.NEGACAO)) || (cVetor[i].equals(Constantes.IMPLICACAO))
                    || (cVetor[i].equals(Constantes.DUPLA_IMPLICACAO))) {
                operadores++;
            }
        }
        return cVetor;
    }
    
    
    /** 
     * Função que testa a existência de dois operadores lógicos juntos. 
     *Se existe um parentese '(' iniciando a formula e um parentese ')' encerrando
     *a fórmula.
     *Ela analisa a existência de um um conector e um parentese ')' juntos.
     *
     * @param formula Vetor de Strings.
     *
     * @return Retorna um booleano verificando a utilização dos conectores.
     */
    private boolean testarConectivosJuntos(String[] formula) {
        
        int tamanhoVetor = formula.length;
        
        for (int i=0; i < tamanhoVetor - 1 ; i++) {
            if ((formula[i].equals(Constantes.CONJUNCAO)) || (formula[i].equals(Constantes.DISJUNCAO))
            || (formula[i].equals(Constantes.NEGACAO)) || (formula[i].equals(Constantes.IMPLICACAO))
            || (formula[i].equals(Constantes.DUPLA_IMPLICACAO))) {
                if ((formula[i+1].equals(Constantes.CONJUNCAO)) || (formula[i+1].equals(Constantes.DISJUNCAO))
                || (formula[i+1].equals(Constantes.IMPLICACAO))
                || (formula[i+1].equals(Constantes.DUPLA_IMPLICACAO))) {
                    return false;    
                }
            }           
        }
                
        if (!(formula[tamanhoVetor-1].equals(")"))) {
            return false;
        }
        
        for(int i=0; i< tamanhoVetor - 1; i++){
            if ((formula[i].equals(Constantes.CONJUNCAO)) || (formula[i].equals(Constantes.DISJUNCAO))
            || (formula[i].equals(Constantes.NEGACAO)) || (formula[i].equals(Constantes.IMPLICACAO))
            || (formula[i].equals(Constantes.DUPLA_IMPLICACAO))) {
                 if(formula[i+1].equals(")")){
                     return false;
                 }
             }
        }
        
        return true;
    }
    
    /**
     * Função que testa se existi proposições juntas.
     *
     * @param formula Vetor de strings.
     *
     * @return Retorna um booleano depois de verificar a posição das proposições.
     */
    private boolean testarProposicoesJuntas(String[] formula) {
        
        int tamanhoVetor = formula.length;
        
        for (int i = 1; i< tamanhoVetor - 1; i++) {
            if ((formula[i].equals(Constantes.CONJUNCAO)) || (formula[i].equals(Constantes.DISJUNCAO))
            || (formula[i].equals(Constantes.NEGACAO)) || (formula[i].equals(Constantes.IMPLICACAO))
            || (formula[i].equals(Constantes.DUPLA_IMPLICACAO)) || (formula[i].equals("("))) {
                if((formula[i+1].equals(Constantes.CONJUNCAO)) || (formula[i+1].equals(Constantes.DISJUNCAO))
                || (formula[i+1].equals(Constantes.IMPLICACAO)) || (formula[i+1].equals(Constantes.DUPLA_IMPLICACAO))
                || (formula[i+1].equals(")"))) {
                    return false;
                } 
            }
        }
        
        return true;
    }    
    
    private int parenteses = 0;
    private int operadores = 0;
    
}
