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
    public TabelaVerdade(Formula formula) {        
        /* Inicializa todas as variáveis de objeto com seus respectivos valores. */
        this.formula = formula;
        contruirTabela();
        /*
        pilhaConectivos = new Stack();
        pilhaProposicoes = new Stack();
        vetorLetras = formula.getFormula().toCharArray();
        for (int i = 0; i <= vetorLetras.length; i++) {
            adicionarNaPilha(i);
        }
        */
    }
    
    private static String[] valores = new String[] {"V", "F"};
    private void contruirTabela() {
        nroColunas = formula.getProposicoes().size();
        nroLinhas = (int) Math.pow(2, nroColunas);
        int proporcao = nroLinhas / 2;
        String[] vetorBoolean = new String[nroLinhas];
        for (int i = 0; i <= nroColunas - 1; i++) {
            int j = 0;
            while (j <= nroLinhas - 1) {
                for (String valor : valores) {
                    for (int n = 0; n <= proporcao - 1; n++) {
                        vetorBoolean[j] = valor;
                        j++;
                    }
                }
            }
            colunas.add(vetorBoolean);
            vetorBoolean = new String[nroLinhas];
            proporcao /= 2;
        }
        transformarArray();
    }
    
    /** Função que adiciona uma letra na pilha ou resolve caso a letras seja um parênteses fechando.
     * @param posicao Posição da letra dentro do vetor de letras.
     *
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
    }*/
    
    private void resolverPilhas(boolean negacao) {        
        String conectivo = (String) pilhaConectivos.pop();
        String proposicao2 = (String) pilhaProposicoes.pop();
        if (negacao) {
            
        } else {
            String proposicao1 = (String) pilhaProposicoes.pop();
        }
    }
    
    private void transformarArray() {
        for (int i = 0; i <= nroLinhas - 1; i++) {
            String[] dadosLinha = new String[nroColunas];
            for (int j = 0; j <= nroColunas - 1; j++) {
                String[] dadosColuna = (String[]) colunas.get(j);
                dadosLinha[j] = dadosColuna[i];
            }
            linhas.add(dadosLinha);
        }
    }
    
    public ArrayList getLinhas() {
        return (ArrayList) linhas.clone();
    }
    public ArrayList getColunas() {
        return (ArrayList) formula.getProposicoes();
    }

    private ArrayList linhas = new ArrayList();
    private ArrayList colunas = new ArrayList();
    private Formula formula = null;
    private int nroLinhas = 0;
    private int nroColunas = 0;
    private Stack pilhaConectivos = null;
    private Stack pilhaProposicoes = null;
    private char[] vetorLetras;
}
