/*
 * Logica.java
 */

package log;

import java.util.ArrayList;
import tipos.Constantes;
import tipos.Formula;

/** Classe que testa se o usuário informou uma fórmula válida.
 * @author Arthur Thiago Barbosa Nobrega e Felippe Pires Ferreira
 */
public class Logica {
    
    /** 
     * Esta função irá testar se a fórmula é bem formada e segue os padrões exigidos.
     * Ela utiliza funções para analizar o uso de operadores e proposições e casos
     * de erro possíveis na construção da fórmula pelo usuário.
     *
     * @param formula Objeto que possui a fórmula como uma String.
     *
     * @return Retorna verdadeiro ou falso, caso seja uma FBF ou não, respectivamente. 
     */
    public boolean testarFormulaBemFormada(Formula formula) {
        
        String strFormula = formula.getFormula();
        String[] cVetor = StringToChar(strFormula);
        
        if (cVetor.length < 2) {
            return false;
        } else if (cVetor.length == 3) {
            if (!cVetor[0].equals("(") || !cVetor[2].equals(")")) {
                return false;
            }
        } else {
            if ((abreParenteses != fechaParenteses) || (fechaParenteses != operadores)
            || (fechaParenteses == 0)) {
                return false;
            }
        }
        
        for (int i = 0; i< cVetor.length - 1; i++) {
            if(cVetor[i].equals("(") && cVetor[i+1].equals(")")) {
                return false;
            }
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
        
        int j=0;
        int contador = 0;
        char aux;
        
        for(int i=0; i <= formula.length() - 1; i++){
            aux = (char)formula.charAt(i);
            if(aux != ' '){
                contador++;
            }
        }
        
        String[] cVetor = new String[contador];
        
        for(int i=0; i <= formula.length() - 1; i++) {
            String letra = formula.substring(i, i + 1);
            if(!letra.equals(" ")){
                cVetor[j] = letra;
                if (cVetor[j].equals(("("))) {
                    abreParenteses++;
                } else if (cVetor[j].equals((")"))) {
                    fechaParenteses++;
                } else if ((cVetor[j].equals(Constantes.CONJUNCAO)) || (cVetor[j].equals(Constantes.DISJUNCAO))
                        || (cVetor[j].equals(Constantes.NEGACAO)) || (cVetor[j].equals(Constantes.IMPLICACAO))
                        || (cVetor[j].equals(Constantes.DUPLA_IMPLICACAO))) {
                    operadores++;
                }
                j++;
            }
        }
        return cVetor;
    }
    
    
    /** 
     * Função que testa a existência de dois operadores lógicos juntos. 
     * Se existe um parentese '(' iniciando a formula e um parentese ')' encerrando
     * a fórmula.
     * Ela analisa a existência de um um conector e um parentese ')' juntos.
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
            || (formula[i].equals(Constantes.DUPLA_IMPLICACAO)) || formula[i].equals("(")) {
                if ((formula[i+1].equals(Constantes.CONJUNCAO)) || (formula[i+1].equals(Constantes.DISJUNCAO))
                || (formula[i+1].equals(Constantes.IMPLICACAO)|| (formula[i+1].equals(")")))
                || (formula[i+1].equals(Constantes.DUPLA_IMPLICACAO))) {
                    return false;    
                }
            }           
        }
        
        if(!(formula[0].equals("(")) && !(formula[0].equals(Constantes.NEGACAO))){
            return false;
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
        
        for(int i=0; i< tamanhoVetor -1; i++){
            if(formula[i].equals(")") && formula[i+1].equals("(")){
                return false;
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
        
        for (int i = 0; i< tamanhoVetor - 1; i++) {
            if (!(formula[i].equals(Constantes.CONJUNCAO)) && (!formula[i].equals(Constantes.DISJUNCAO))
            && (!formula[i].equals(Constantes.NEGACAO)) && (!formula[i].equals(Constantes.IMPLICACAO))
            && (!formula[i].equals(Constantes.DUPLA_IMPLICACAO)) && (!formula[i].equals("("))
            && (!formula[i].equals(")")) && (!formula[i].equals(" "))) {
                if (!(formula[i+1].equals(Constantes.CONJUNCAO)) && (!formula[i+1].equals(Constantes.DISJUNCAO))
                && (!formula[i+1].equals(Constantes.NEGACAO)) &&(!formula[i+1].equals(Constantes.IMPLICACAO))
                && (!formula[i+1].equals(Constantes.DUPLA_IMPLICACAO)) && (!formula[i+1].equals(")"))
                && (!formula[i+1].equals("(")) && (!formula[i+1].equals(" "))) {
                    return false;
                } 
            }
        }
        
        return true;
    }    
    
    private int fechaParenteses = 0;
    private int abreParenteses = 0;
    private int operadores = 0;
    
}
