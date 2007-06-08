/*
 * Consequencia.java
 */

package pers;

import java.util.ArrayList;
import log.FormulaException;
import log.Logica;
import log.ProposicoesException;
import tipos.Constantes;
import tipos.Formula;

/** Classe que testa se a conclus�o � consequ�ncia l�gica das premissas.
 * @author Arthur Thiago Barbosa Nobrega e Felippe Pires Ferreira
 */
public class Consequencia {
    
    /** Cria um novo teste de Consequ�ncia L�gica.
     */
    public Consequencia(ArrayList<String> premissas, String conclusao) throws FormulaException, ProposicoesException {
        /* Testa se a conclus�o segue os padr�es. */
        Logica logica = new Logica();
        Formula formConclusao = new Formula(conclusao);
        if (!logica.testarFormulaBemFormada(formConclusao)) {
            throw new FormulaException();
        }
        
        /* Constroi a tabela da conclus�o. */
        tabelaConclusao = new TabelaVerdade(formConclusao);
        int nroColunasConclusao = tabelaConclusao.getColunas().size();
        int nroLinhasConclusao = tabelaConclusao.getLinhas().size();
        
        /* Testa se a lista das premissas est� vazia. */
        if (!premissas.isEmpty()) {
        
            /* Constroi as tabelas verdade das premissas. */
            for (int i = 0; i <= premissas.size() - 1; i++) {
                String strFormula = premissas.get(i);
                Formula formula = new Formula(strFormula);
                TabelaVerdade tabela = new TabelaVerdade(formula);
                tabelasPremissas.add(tabela);
            }

            /* Testa se o n�mero de linhas da conclus�o � igual ao das premissas. */
            for (int i = 0; i <= tabelasPremissas.size() - 1; i++) {
                int nroLinhas = tabelasPremissas.get(i).getLinhas().size();
                if (nroLinhas != nroLinhasConclusao) {
                    throw new ProposicoesException();
                }
            }

            /* Testa se a conclus�o � consequ�ncia l�gica das premissas. */
            for (int linha = 0; linha <= nroLinhasConclusao - 1; linha++) {
                int j = 0;
                String valoracaoConclusao = tabelaConclusao.getLinhas().get(linha)[nroColunasConclusao - 1];
                String[] novalinha = new String[tabelasPremissas.size() + 1];
                int nroVerdadeiros = 0;
                Integer novoInteiro = null;
                while (j <= tabelasPremissas.size() - 1) {
                    String valoracaoPremissa = tabelasPremissas.get(j).getLinhas().get(linha)[nroColunasConclusao - 1];
                    novoInteiro = new Integer(linha);
                    if (valoracaoConclusao.equals(Constantes.VERDADEIRO)) {
                        if (valoracaoPremissa.equals(Constantes.FALSO)) {
                            resultadoFinal = false;
                            linhasIncorretas.add(novoInteiro);
                        } else {
                            nroVerdadeiros++;
                            
                        }
                    }
                    novalinha[j] = valoracaoPremissa;
                    j++;
                }
                if (nroVerdadeiros == premissas.size()) {
                    linhasCorretas.add(novoInteiro);
                }
                novalinha[tabelasPremissas.size()] = valoracaoConclusao;
                linhas.add(novalinha);
            }
        } else {
            /* A lista de premissas est� vazia. */
            premissaVazia = true;
            /* Testa se a conclus�o � ou n�o uma tautologia. */
            for (int linha = 0; linha <= nroLinhasConclusao - 1; linha++) {
                String valoracaoConclusao = tabelaConclusao.getLinhas().get(linha)[nroColunasConclusao - 1];
                Integer novoInteiro = new Integer(linha);
                if (valoracaoConclusao.equals(Constantes.VERDADEIRO)) {
                    String[] novalinha = {"", Constantes.VERDADEIRO};
                    linhas.add(novalinha);
                    linhasCorretas.add(novoInteiro);
                } else {
                    resultadoFinal = false;
                    String[] novalinha = {"", Constantes.FALSO};
                    linhas.add(novalinha);
                    linhasIncorretas.add(novoInteiro);
                }
            }
        }
    }
    
    /** Retorna o resultado do teste de Consequ�ncia L�gica.
     */
    public boolean getConsequenciaLogica() {
        return resultadoFinal;
    }
    
    /** Retorna as linhas para serem mostradas na tabela. 
     */
    public ArrayList<String[]> getLinhas() {
        return linhas;
    }
    
    /** Retorna as colunas para serem mostradas na tabela. 
     */
    public ArrayList<String> getColunas() {
        int nroColunas = tabelaConclusao.getColunas().size();
        if (premissaVazia) {
            colunas.add("VAZIA");
        } else {
            for (int i = 0; i <= tabelasPremissas.size() - 1; i++) {
                colunas.add(tabelasPremissas.get(i).getColunas().get(nroColunas - 1));
            }
        }
        colunas.add(tabelaConclusao.getColunas().get(nroColunas - 1));
        return colunas;
    }
    
    /** Retorna as linhas que ser�o selecionadas como verde. 
     */
    public ArrayList<Integer> getLinhasCorretas() {
        return linhasCorretas;
    }
    
    /** Retorna as linhas que ser�o selecionadas como vermelha.
     */
    public ArrayList<Integer> getLinhasIncorretas() {
        return linhasIncorretas;
    }
    
    private boolean premissaVazia = false;
    private boolean resultadoFinal = true;
    private ArrayList<TabelaVerdade> tabelasPremissas = new ArrayList<TabelaVerdade>();
    private TabelaVerdade tabelaConclusao;
    private ArrayList<Integer> linhasCorretas = new ArrayList<Integer>();
    private ArrayList<Integer> linhasIncorretas = new ArrayList<Integer>();
    private ArrayList<String[]> linhas = new ArrayList<String[]>();
    private ArrayList<String> colunas = new ArrayList<String>();
}
