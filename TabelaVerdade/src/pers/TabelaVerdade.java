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
 * @author Arthur Thiago Barbosa Nobrega e Felippe Pires Ferreira
 */
public class TabelaVerdade {

    /** Creates a new instance of TabelaVerdade */
    public TabelaVerdade(Formula formula) {        
        /* Inicializa todas as vari�veis de objeto com seus respectivos valores. */
        this.formula = formula;
        /* Preenche a tabela primeiramente com as colunas das proposi��es. */
        preencherTabela();
        /* Agora realmente resolve a tabela. */
        String[] resultado = new String[nroLinhas];
        for (int i = 0; i <= nroLinhas - 1; i++) {
            resultado[i] = resolverFormula(i);
        }
        colunas.add(resultado);
        transformarArray();
    }
    
    /** Fun��o que preenche as colunas das proposi��es com V ou F.
     *
     */
    private void preencherTabela() {
        String[] valores = new String[] {verdadeiro, falso};
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
    }

    /** Resolve de fato a tabela, preenchendo com V ou F nas f�rmulas.
     *
     */
    private String resolverFormula(int linha) {
        int parent = formula.getFechaParenteses();
        String strFormula = formula.getFormula();
        int i = 0;
        while (parent > 0) {
            String letra = strFormula.substring(i, i + 1);
            if(!(letra.equals(Constantes.CONJUNCAO)) && !(letra.equals(Constantes.DISJUNCAO))
                    && !(letra.equals(Constantes.NEGACAO)) && !(letra.equals(Constantes.IMPLICACAO)) 
                    && !(letra.equals(Constantes.DUPLA_IMPLICACAO)) && !(letra.equals("("))
                    && !(letra.equals(")")) && !(letra.equals(" "))) {
                pilhaProposicoes.add(pegarValor(letra, linha));
            } else if (letra.equals(")")) {
                    realizarOperacao(linha);
                    parent--;
            } else if (!(letra.equals("(")) && !(letra.equals(" "))) {
                pilhaConectivos.add(letra);
            }
            i++;
        }
        Stack<String> retorno = (Stack<String>) pilhaProposicoes.clone();
        pilhaConectivos = new Stack();
        pilhaProposicoes = new Stack();
        return retorno.pop();
    }
    
    private void realizarOperacao(int linha) {
        String conectivo = pilhaConectivos.pop();
        String proposicao1, proposicao2;
        
        /* Testa qual conectivo � e faz a opera��o. */
        if (conectivo.equals(Constantes.CONJUNCAO)) {             
            proposicao2 = pilhaProposicoes.pop();
            proposicao1 = pilhaProposicoes.pop();
            if((proposicao1.equals(verdadeiro)) && (proposicao2.equals(verdadeiro))) {
               pilhaProposicoes.push(verdadeiro);
            } else {
               pilhaProposicoes.push(falso);
            }
//            if (pilhaConectivos.get(pilhaConectivos.size() - 1).equals(Constantes.NEGACAO)) {
//                realizarOperacao(linha);
//            }
        } else if (conectivo.equals(Constantes.DISJUNCAO)) {
            proposicao2 = pilhaProposicoes.pop();
            proposicao1 = pilhaProposicoes.pop();
            if (proposicao1.equals(verdadeiro) || proposicao2.equals(verdadeiro)) {
                pilhaProposicoes.push(verdadeiro);
            } else {
                pilhaProposicoes.push(falso);
            }
            
        } else if (conectivo.equals(Constantes.NEGACAO)) {
            proposicao1 = pilhaProposicoes.pop();
            if (proposicao1.equals(verdadeiro)) {
                pilhaProposicoes.push(falso);
            } else {
                pilhaProposicoes.push(verdadeiro);
            }
        } else if (conectivo.equals(Constantes.IMPLICACAO)) {
            proposicao2 = pilhaProposicoes.pop();
            proposicao1 = pilhaProposicoes.pop();
            if ((proposicao1.equals(verdadeiro)) && (proposicao2.equals(falso))) {
                pilhaProposicoes.push(falso);
            } else {
                pilhaProposicoes.push(verdadeiro);
            }
        } else if (conectivo.equals(Constantes.DUPLA_IMPLICACAO)) {
            proposicao2 = pilhaProposicoes.pop();
            proposicao1 = pilhaProposicoes.pop();
            if (proposicao1.equals(proposicao2)) {
                pilhaProposicoes.push(verdadeiro);
            } else {
                pilhaProposicoes.push(falso);
            }
        }
    }
    
    private String pegarValor(String proposicao, int linha) {
        ArrayList listaProposicoes = formula.getProposicoes();
        int coluna = 0;
        while (coluna <= nroColunas - 1) {
            String letracoluna = (String) listaProposicoes.get(coluna);
            if (proposicao.equals(letracoluna)) {
                break;
            }
            coluna++;
        }
        String[] vetorColuna = colunas.get(coluna);
        return vetorColuna[linha];
    }
    
    private void transformarArray() {
        for (int i = 0; i <= nroLinhas - 1; i++) {
            String[] dadosLinha = new String[nroColunas + 1];
            for (int j = 0; j <= nroColunas; j++) {
                String[] dadosColuna = colunas.get(j);
                dadosLinha[j] = dadosColuna[i];
            }
            linhas.add(dadosLinha);
        }
    }    
    
    public ArrayList<String[]> getLinhas() {
        return (ArrayList<String[]>) linhas.clone();
    }
    public ArrayList<String> getColunas() {
        ArrayList listaColunas = formula.getProposicoes();
        listaColunas.add(formula.getFormula());
        return (ArrayList<String>) listaColunas;
    }

    private ArrayList<String[]> linhas = new ArrayList<String[]>();
    private ArrayList<String[]> colunas = new ArrayList<String[]>();
    private Formula formula = null;
    private int nroLinhas = 0;
    private int nroColunas = 0;
    private Stack<String> pilhaConectivos = new Stack<String>();
    private Stack<String> pilhaProposicoes = new Stack<String>();
    private String verdadeiro = "V";
    private String falso = "F";
}
