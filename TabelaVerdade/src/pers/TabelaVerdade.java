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
        /* Preenche a tabela primeiramente com as colunas das proposições. */
        preencherTabela();
        /* Agora realmente resolve a tabela. */
        String[] resultado = new String[nroLinhas];
        for (int i = 0; i <= nroLinhas - 1; i++) {
            resultado[i] = resolverFormula(i);
        }
        colunas.add(resultado);
        transformarArray();
    }
    
    /** Função que preenche as colunas das proposições com V ou F.
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

    /** Resolve de fato a tabela, preenchendo com V ou F nas fórmulas.
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
                pilhaProposicoes.add(letra);
            } else if (letra.equals(")")) {
                    realizarOperacao(linha);
                    parent--;
            } else if (!(letra.equals("(")) && !(letra.equals(" "))) {
                pilhaConectivos.add(letra);
            }
            i++;
        }
        Stack retorno = (Stack) pilhaProposicoes.clone();
        pilhaConectivos = new Stack();
        pilhaProposicoes = new Stack();
        return (String) retorno.pop();
    }
    
    private void realizarOperacao(int linha) {
        String conectivo = (String) pilhaConectivos.pop();
        String proposicao1, proposicao2;
        
        /* Testa qual conectivo é e faz a operação. */
        if (conectivo.equals(Constantes.CONJUNCAO)) {             
            proposicao2 = pegarValor((String) pilhaProposicoes.pop(), linha);
            proposicao1 = pegarValor((String) pilhaProposicoes.pop(), linha);
            if((proposicao1.equals(verdadeiro)) && (proposicao2.equals(verdadeiro))) {
               pilhaProposicoes.push(verdadeiro);
            } else {
               pilhaProposicoes.push(falso);
            }
        } else if (conectivo.equals(Constantes.DISJUNCAO)) {
            proposicao2 = pegarValor((String) pilhaProposicoes.pop(), linha);
            proposicao1 = pegarValor((String) pilhaProposicoes.pop(), linha);
            if (proposicao1.equals(verdadeiro) || proposicao2.equals(verdadeiro)) {
                pilhaProposicoes.push(verdadeiro);
            } else {
                pilhaProposicoes.push(falso);
            }
            
        } else if (conectivo.equals(Constantes.NEGACAO)) {
            proposicao1 = pegarValor((String) pilhaProposicoes.pop(), linha);
            if (proposicao1.equals(verdadeiro)) {
                pilhaProposicoes.push(falso);
            } else {
                pilhaProposicoes.push(verdadeiro);
            }
        } else if (conectivo.equals(Constantes.IMPLICACAO)) {
            proposicao2 = pegarValor((String) pilhaProposicoes.pop(), linha);
            proposicao1 = pegarValor((String) pilhaProposicoes.pop(), linha);
            if ((proposicao1.equals(falso)) && (proposicao2.equals(verdadeiro))) {
                pilhaProposicoes.push(falso);
            } else {
                pilhaProposicoes.push(verdadeiro);
            }
        } else if (conectivo.equals(Constantes.DUPLA_IMPLICACAO)) {
            proposicao2 = pegarValor((String) pilhaProposicoes.pop(), linha);
            proposicao1 = pegarValor((String) pilhaProposicoes.pop(), linha);
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
        String[] vetorColuna = (String[]) colunas.get(coluna);
        return vetorColuna[linha];
    }
    
    private void transformarArray() {
        for (int i = 0; i <= nroLinhas - 1; i++) {
            String[] dadosLinha = new String[nroColunas + 1];
            for (int j = 0; j <= nroColunas; j++) {
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
        ArrayList listaColunas = formula.getProposicoes();
        listaColunas.add(formula.getFormula());
        return (ArrayList) listaColunas;
    }

    private ArrayList linhas = new ArrayList();
    private ArrayList colunas = new ArrayList();
    private Formula formula = null;
    private int nroLinhas = 0;
    private int nroColunas = 0;
    private Stack pilhaConectivos = new Stack();
    private Stack pilhaProposicoes = new Stack();
    private String verdadeiro = "V";
    private String falso = "F";
}
