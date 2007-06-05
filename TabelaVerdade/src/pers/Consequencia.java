/*
 * Consequencia.java
 *
 */

package pers;

import java.util.ArrayList;
import log.FormulaException;
import log.Logica;
import tipos.Formula;

/**
 *
 * @author Arthur Thiago Barbosa Nobrega
 */
public class Consequencia {
    
    /** Creates a new instance of Consequencia */
    public Consequencia(ArrayList<String> premissas, String conclusao) throws FormulaException {
        Logica logica = new Logica();
        Formula formConclusao = new Formula(conclusao);
        if (!logica.testarFormulaBemFormada(formConclusao)) {
            throw new FormulaException();
        }
        tabelaConclusao = new TabelaVerdade(formConclusao);
        
        /* Constroi as tabelas verdade das premissas. */
        for (int i = 0; i <= premissas.size() - 1; i++) {
            String strFormula = premissas.get(i);
            Formula formula = new Formula(strFormula);
            TabelaVerdade tabela = new TabelaVerdade(formula);
            tabelasPremissas.add(tabela);
        }

        /* Testa se o número de linhas da conclusão é igual ao das premissas. */
        int nroLinhasConclusao = tabelaConclusao.getLinhas().size();
        for (int i = 0; i <= tabelasPremissas.size() - 1; i++) {
            int nroLinhas = tabelasPremissas.get(i).getLinhas().size();
            if (nroLinhas != nroLinhasConclusao) {
                throw new FormulaException();
            }
        }
        
        /* Testa se a conclusão é consequência lógica das premissas. */
        int nroColunas = tabelaConclusao.getColunas().size();
        for (int linha = 0; linha <= nroLinhasConclusao - 1; linha++) {
            int j = 0;
            String valoracaoConclusao = tabelaConclusao.getLinhas().get(linha)[nroColunas - 1];
            String[] novalinha = new String[tabelasPremissas.size() + 1];
            while (j <= tabelasPremissas.size() - 1) {
                String valoracaoPremissa = tabelasPremissas.get(j).getLinhas().get(linha)[nroColunas - 1];
                if (valoracaoConclusao.equals(verdadeiro)) {
                    if (valoracaoPremissa.equals(falso)) {
                        resultadoFinal = false;
                        Integer novoInteiro = new Integer(linha);
                        linhasIncorretas.add(novoInteiro);
                    } else {
                        Integer novoInteiro = new Integer(linha);
                        linhasCorretas.add(novoInteiro);
                    }
                }
                novalinha[j] = valoracaoPremissa;
                j++;
            }
            novalinha[tabelasPremissas.size()] = valoracaoConclusao;
            linhas.add(novalinha);
        }
    }
    
    public boolean getConsequenciaLogica() {
        return resultadoFinal;
    }
    
    public ArrayList<String[]> getLinhas() {
        return linhas;
    }
    
    public ArrayList<String> getColunas() {
        int nroColunas = tabelaConclusao.getColunas().size();
        for (int i = 0; i <= tabelasPremissas.size() - 1; i++) {
            colunas.add(tabelasPremissas.get(i).getColunas().get(nroColunas - 1));
        }
        colunas.add(tabelaConclusao.getColunas().get(nroColunas - 1));
        return colunas;
    }
    
    public ArrayList<Integer> getLinhasCorretas() {
        return linhasCorretas;
    }
    
    public ArrayList<Integer> getLinhasIncorretas() {
        return linhasIncorretas;
    }
    
    private boolean resultadoFinal = true;
    private ArrayList<TabelaVerdade> tabelasPremissas = new ArrayList<TabelaVerdade>();
    private TabelaVerdade tabelaConclusao;
    private ArrayList<Integer> linhasCorretas = new ArrayList<Integer>();
    private ArrayList<Integer> linhasIncorretas = new ArrayList<Integer>();
    private String verdadeiro = "V";
    private String falso = "F";
    private ArrayList<String[]> linhas = new ArrayList<String[]>();
    private ArrayList<String> colunas = new ArrayList<String>();
}
