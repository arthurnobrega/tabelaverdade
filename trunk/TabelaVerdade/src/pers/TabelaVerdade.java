/*
 * TabelaVerdade.java
 *
 */

package pers;

import java.util.ArrayList;
import java.util.Stack;
import tipos.Constantes;
import tipos.Formula;

/**
 *
 * @author Arthur Thiago Barbosa Nobrega
 */
public class TabelaVerdade {

    /** Creates a new instance of TabelaVerdade */
    public TabelaVerdade(String frase) {

        /* Inicializa todas as variáveis de objeto com seus respectivos valores. */
        formula = new Formula(frase);
        contruirTabela();
        pilhaConectivos = new Stack();
        pilhaProposicoes = new Stack();
        vetorLetras = formula.getFormula().toCharArray();
        
        for (int i = 0; i <= vetorLetras.length; i++) {
            adicionarNaPilha(i);            
        }
    }
    
    private void contruirTabela() {
        int nroProposicoes = formula.getProposicoes().size();
        nroLinhas = (int) Math.pow(2, nroProposicoes);
        int proporcao = 1;
        for (int i = 0; i <= nroProposicoes - 1; i++) {
            String[] vetorBoolean = new String[nroLinhas];
            int j = 0;
            while (j <= nroLinhas - 1) {
                String valor = "V";
                for (int n = 0; n <= proporcao - 1; n++) {
                    vetorBoolean[j] = valor;
                    System.out.println(n);
                    j++;
                }
                valor = "F";
                for (int n = 0; n <= proporcao - 1; n++) {
                    vetorBoolean[j] = valor;
                    j++;
                }
            }
            for (int k = 0; k <= vetorBoolean.length - 1; k++) {
                System.out.println(vetorBoolean[i]);
            }
            linhas.add(vetorBoolean);
            System.out.println("entrou");
            vetorBoolean = new String[nroLinhas];
            proporcao *= 2;
        }
    }
    
    /** Função que adiciona uma letra na pilha ou resolve caso a letras seja um parênteses fechando.
     * @param posicao Posição da letra dentro do vetor de letras.
     */
    private void adicionarNaPilha(int posicao) {
        switch (vetorLetras[posicao]) {
            case ' ': {
                break;
            }
            case '(': {
                break;
            }
            case ')': {
                boolean negacao = false;
                String topoPilha = (String) pilhaConectivos.get(pilhaConectivos.size() - 1);
                if (topoPilha.equals(Constantes.NEGACAO)) {
                    negacao = true;
                }
                resolverPilhas(negacao);
                break;
            }
            case Constantes.CONJUNCAO: {
                pilhaConectivos.push(vetorLetras[posicao]);
                break;
            }
            case Constantes.DISJUNCAO: {
                pilhaConectivos.push(vetorLetras[posicao]);
                break;
            }
            case Constantes.NEGACAO: {
                pilhaConectivos.push(vetorLetras[posicao]);
                break;
            }
            case Constantes.IMPLICACAO: {
                pilhaConectivos.push(vetorLetras[posicao]);
                break;
            }
            case Constantes.DUPLA_IMPLICACAO: {
                pilhaConectivos.push(vetorLetras[posicao]);
                break;
            }
            default: {
                pilhaProposicoes.push(vetorLetras[posicao]);
            }
        }
    }
    
    private void resolverPilhas(boolean negacao) {        
        String conectivo = (String) pilhaConectivos.pop();
        String proposicao2 = (String) pilhaProposicoes.pop();
        if (negacao) {
            
        } else {
            String proposicao1 = (String) pilhaProposicoes.pop();
        }
    }
    
    public ArrayList getLinhas() {
        return (ArrayList) linhas.clone();
    }
    public ArrayList getColunas() {
        return (ArrayList) formula.getProposicoes();
    }

    private ArrayList linhas;
    private Formula formula;
    private int nroLinhas;
    private Stack pilhaConectivos;
    private Stack pilhaProposicoes;
    private char[] vetorLetras;
}
