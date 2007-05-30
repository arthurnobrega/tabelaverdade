/*
 * Logica.java
 *
 */

package log;

import java.util.ArrayList;
import tipos.Formula;

/**
 *
 * @author Arthur Thiago Barbosa Nobrega
 */
public class Logica {
    
    private int parentese = 0;
    private int operadores = 0;
    
    /* Transforma a formula recebida em um vetor de caracteres*/
    private char[] StringToChar(String formula){
        
        char[] cVetor = new char[formula.length()];
        
        for(int i=0; i <= formula.length() - 1; i++){
            cVetor[i] = formula.charAt(i); 
            if(cVetor[i] == '('){
                parentese +=1;
            }
            else if(cVetor[i] == '^' || cVetor[i] == 'v' || cVetor[i] == '-' ||
                    cVetor[i] == '~' || cVetor[i] == '='){
                    operadores += 1;
                }
        }
        return cVetor;
    }
    
    
    /*Função que testa a existência de dois operadores lógicos juntos*/
    private boolean testarOperadoresJuntos(char[] formula){
        
        int tamanhoVetor = formula.length;
        
        for(int i=0;i<(tamanhoVetor-1);i++){
            if(formula[i] == '^' || formula[i] == 'v' || formula[i] ==
                    '-' || formula[i] == '~' || formula[i] == '='){
                if(formula[i+1] == '^' || formula[i+1] == 'v' || 
                   formula[i+1] == '-' || formula[i+1] == '~' || 
                   formula[i+1] == '='){
                    return false;    
                }
            }           
        }
        
        if(formula[0] == '^' || formula[0] == 'v' || formula[0] == '-' ||
            formula[0] == '~' || formula[0] == '='){
            return false;            
        }
        
        if(formula[0] != '('){
            return false;
        }
        
        if(formula[tamanhoVetor-1] != ')')
            return false;
                
        return true;
    }
    
    /*Função que testa o número de proposições juntas*/
    private boolean testarProposicoesJuntas(char[] formula){
        
        int tamanhoVetor = formula.length;
        
        for(int i=1;i<(tamanhoVetor-1);i++){
            if(formula[i] != '^' && formula[i] != 'v' && formula[i] !=
               '-' && formula[i] != '~' && formula[i] != '=' && formula[i] !='('
               && formula[i] != ')'){
                if(formula[i+1] != '^' && formula[i+1] != 'v' && formula[i+1] !=
                   '-' && formula[i+1] != '~' && formula[i+1] != '=' && 
                   formula[i+1] !='(' && formula[i+1] != ')'){
                    return false;
                } 
            }
        }
        
        return true;
    }
    
    
    /* Esta fun��o ir� testar se a f�rmula � bem formada e segue os padr�es exigidos.*/
    protected boolean testarFormulaBemFormada(Formula formula) {
        
        String strFormula = formula.getFormula();
        char[] cVetor = StringToChar(strFormula);
        
        
        if(parentese != operadores || parentese == 0){
            return false;
        }        
        
        for(int i=0;i<strFormula.length()-1;i++){
            if(cVetor[i] == '(' && cVetor[i+1] == ')'){
                return false;
            }
        }    
        
        if(!testarOperadoresJuntos(cVetor) || !testarProposicoesJuntas(cVetor)){
            return false;
        }
        
        return true;
        
    }
    
    
    public static void main(String[] args){
        Logica log = new Logica();
        
        Formula x = new Formula("(~(p^q))");
        if(log.testarFormulaBemFormada(x))
            System.out.println("true");              
        else
            System.out.println("false");
                
                
    }
    
}
