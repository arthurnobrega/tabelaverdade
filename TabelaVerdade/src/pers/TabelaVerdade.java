/*
 * TabelaVerdade.java
 */

package pers;

import java.util.ArrayList;
import java.util.Stack;
import tipos.Constantes;
import tipos.Formula;

/** Classe que constroi a tabela verdade.
 * @author Arthur Thiago Barbosa Nobrega e Felippe Pires Ferreira
 */
public class TabelaVerdade {

    /** Cria uma nova instância de Tabela Verdade.
     */
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
    
    /** Preenche as colunas das proposições com V ou F.
     */
    private void preencherTabela() {
        String[] valores = new String[] {Constantes.VERDADEIRO, Constantes.FALSO};
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

    /** Resolve de fato a tabela, preenchendo com V ou F a última coluna, que é o resultado.
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
                    realizarOperacao();
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
    
    /** Realiza a operação de acordo com o respectivo conectivo.
     */
    private void realizarOperacao() {        
        boolean proposicaoSolitaria = false;
        String conectivo = "";
        if (!pilhaConectivos.isEmpty()) {
            conectivo = pilhaConectivos.pop();
        } else {
            proposicaoSolitaria = true;
        }
        String proposicao1, proposicao2;
        
        /* Testa qual conectivo � e faz a opera��o. */
        if (!proposicaoSolitaria) {
            if (conectivo.equals(Constantes.CONJUNCAO)) {             
                proposicao2 = pilhaProposicoes.pop();
                proposicao1 = pilhaProposicoes.pop();
                if((proposicao1.equals(Constantes.VERDADEIRO)) && (proposicao2.equals(Constantes.VERDADEIRO))) {
                   pilhaProposicoes.push(Constantes.VERDADEIRO);
                } else {
                   pilhaProposicoes.push(Constantes.FALSO);
                }
            } else if (conectivo.equals(Constantes.DISJUNCAO)) {
                proposicao2 = pilhaProposicoes.pop();
                proposicao1 = pilhaProposicoes.pop();
                if (proposicao1.equals(Constantes.VERDADEIRO) || proposicao2.equals(Constantes.VERDADEIRO)) {
                    pilhaProposicoes.push(Constantes.VERDADEIRO);
                } else {
                    pilhaProposicoes.push(Constantes.FALSO);
                }

            } else if (conectivo.equals(Constantes.NEGACAO)) {
                proposicao1 = pilhaProposicoes.pop();
                if (proposicao1.equals(Constantes.VERDADEIRO)) {
                    pilhaProposicoes.push(Constantes.FALSO);
                } else {
                    pilhaProposicoes.push(Constantes.VERDADEIRO);
                }
            } else if (conectivo.equals(Constantes.IMPLICACAO)) {
                proposicao2 = pilhaProposicoes.pop();
                proposicao1 = pilhaProposicoes.pop();
                if ((proposicao1.equals(Constantes.VERDADEIRO)) && (proposicao2.equals(Constantes.FALSO))) {
                    pilhaProposicoes.push(Constantes.FALSO);
                } else {
                    pilhaProposicoes.push(Constantes.VERDADEIRO);
                }
            } else if (conectivo.equals(Constantes.DUPLA_IMPLICACAO)) {
                proposicao2 = pilhaProposicoes.pop();
                proposicao1 = pilhaProposicoes.pop();
                if (proposicao1.equals(proposicao2)) {
                    pilhaProposicoes.push(Constantes.VERDADEIRO);
                } else {
                    pilhaProposicoes.push(Constantes.FALSO);
                }
            }
        }
    }
    
    /* Retorna o valor da da proposição em determinada linha (V ou F).
     * @param proposicao O nome da proposição que se deseja pegar o valor.
     * @param linha A linha em que o valor se encontra.
     */
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
    
    /** Retorna as linhas que serão mostradas na tabela.
     */
    public ArrayList<String[]> getLinhas() {
        return (ArrayList<String[]>) linhas.clone();
    }
    
    /** Retorna as colunas que serão mostradas na tabela.
     */
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
}
