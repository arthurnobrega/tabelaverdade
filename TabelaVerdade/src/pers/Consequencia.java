/*
 * Consequencia.java
 */

package pers;

import java.util.ArrayList;
import java.util.Iterator;
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
    public Consequencia(ArrayList<String> premissas, String conclusao) throws FormulaException {
        /* Testa se a conclus�o segue os padr�es. */
        Logica logica = new Logica();
        Formula formConclusao = new Formula(conclusao);
        if (!logica.testarFormulaBemFormada(formConclusao)) {
            throw new FormulaException();
        }
        
        /* Testa se a lista das premissas est� vazia. */
        if (!premissas.isEmpty()) {
            
            ArrayList<Formula> formPremissas = new ArrayList<Formula>();
            for (int i = 0; i <= premissas.size() - 1; i++) {
                Formula formula = new Formula(premissas.get(i));
                formPremissas.add(formula);
            }
            
            Formula formConclusaoComp = new Formula(conclusao);
            ArrayList<Formula> formPremissasComp = new ArrayList<Formula>();
            for (int i = 0; i <= premissas.size() - 1; i++) {
                Formula formula = new Formula(premissas.get(i));
                formPremissasComp.add(formula);
            }
            
            Iterator<Formula> it = formPremissasComp.iterator();
            while (it.hasNext()) {
                ArrayList<String> propPremissa1 = it.next().getProposicoes();
                testarProposicoes(propPremissa1, formConclusaoComp.getProposicoes());
                if (it.hasNext()) {
                    ArrayList<String> propPremissa2 = it.next().getProposicoes();
                    testarProposicoes(propPremissa2, formConclusaoComp.getProposicoes());
                    testarProposicoes(propPremissa1, propPremissa2);
                }
            }
            
            adicionarProposicoes(formConclusaoComp, formConclusao.getProposicoes());
            
            for (int i = 0; i <= formPremissasComp.size() - 1; i++) {
                adicionarProposicoes(formPremissasComp.get(i), formPremissas.get(i).getProposicoes());
            }
            
            /* Constroi a tabela da conclus�o. */
            formConclusao = new Formula(formConclusaoComp.getFormula());
            tabelaConclusao = new TabelaVerdade(formConclusao);
            tabelaConclusao.getFormula().setFormula(conclusao);
            
            int nroLinhasConclusao = tabelaConclusao.getLinhas().size();
            int nroColunasConclusao = tabelaConclusao.getColunas().size();
        
            /* Constroi as tabelas verdade das premissas. */
            for (int i = 0; i <= formPremissasComp.size() - 1; i++) {
                formPremissas.set(i, new Formula(formPremissasComp.get(i).getFormula()));
                TabelaVerdade tabela = new TabelaVerdade(formPremissas.get(i));
                tabela.getFormula().setFormula(premissas.get(i));
                tabelasPremissas.add(tabela);
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
                    if (valoracaoPremissa.equals(Constantes.VERDADEIRO)) {
                        nroVerdadeiros++;
                    }
                    novalinha[j] = valoracaoPremissa;
                    j++;
                }
                if (nroVerdadeiros == premissas.size()) {
                    if (valoracaoConclusao.equals(Constantes.VERDADEIRO)) {
                        linhasCorretas.add(novoInteiro);
                    } else {
                        resultadoFinal = false;
                        linhasIncorretas.add(novoInteiro);
                    }
                }
                novalinha[tabelasPremissas.size()] = valoracaoConclusao;
                linhas.add(novalinha);
            }
        } else {
            /* A lista de premissas est� vazia. */
            premissaVazia = true;
            
            tabelaConclusao = new TabelaVerdade(formConclusao);
            
            int nroLinhasConclusao = (int) Math.pow(2, formConclusao.getProposicoes().size());
            int nroColunasConclusao = formConclusao.getProposicoes().size();
            
            /* Testa se a conclus�o � ou n�o uma tautologia. */
            for (int linha = 0; linha <= nroLinhasConclusao - 1; linha++) {
                String valoracaoConclusao = tabelaConclusao.getLinhas().get(linha)[nroColunasConclusao];
                Integer novoInteiro = new Integer(linha);
                if (valoracaoConclusao.equals(Constantes.VERDADEIRO)) {
                    String[] novalinha = {Constantes.VERDADEIRO, Constantes.VERDADEIRO};
                    linhas.add(novalinha);
                    linhasCorretas.add(novoInteiro);
                } else {
                    resultadoFinal = false;
                    String[] novalinha = {Constantes.VERDADEIRO, Constantes.FALSO};
                    linhas.add(novalinha);
                    linhasIncorretas.add(novoInteiro);
                }
            }
        }
    }
    
    private void testarProposicoes(ArrayList<String> proposicoes1, ArrayList<String> proposicoes2) {
        Iterator<String> iterator1 = proposicoes1.iterator();
        Iterator<String> iterator2;
        
        while (iterator1.hasNext()) {
            String prop1 = iterator1.next();
            boolean achou = false;
            iterator2 = proposicoes2.iterator();
            while (iterator2.hasNext()) {             
                String prop2 = iterator2.next();
                if (prop1.equals(prop2)) {
                    achou = true;
                    break;
                }
            }
            if (!achou) {
                proposicoes2.add(prop1);
            }
        }
        
        iterator2 = proposicoes2.iterator();
        
        while (iterator2.hasNext()) {
            String prop2 = iterator2.next();
            boolean achou = false;
            iterator1 = proposicoes1.iterator();
            while (iterator1.hasNext()) {             
                String prop1 = iterator1.next();
                if (prop2.equals(prop1)) {
                    achou = true;
                    break;
                }
            }
            if (!achou) {
                proposicoes1.add(prop2);
            }
        }
    }
    
    private void adicionarProposicoes(Formula formulaComp, ArrayList<String> proposicoesAntes) {
        ArrayList<String> proposicoesDepois = formulaComp.getProposicoes();
        
        for (int i = 0; i <= proposicoesDepois.size() - 1; i++) {
            boolean achou = false;
            String prop2 = proposicoesDepois.get(i);
            for (int j = 0; j <= proposicoesAntes.size() - 1; j++) {
                if (proposicoesAntes.get(j).equals(prop2)) {
                    achou = true;
                    break;
                }
            }
            if (!achou) {
                String formulaAntiga = formulaComp.getFormula();
                formulaComp.setFormula("( " + formulaAntiga + " " + Constantes.CONJUNCAO
                        + " (" + proposicoesDepois.get(i)+ " " + Constantes.DISJUNCAO + " (~" +
                        proposicoesDepois.get(i) + ")) )");
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
        int nroColunasConclusao = tabelaConclusao.getColunas().size();
        if (premissaVazia) {
            colunas.add("VAZIA");
        } else {
            for (int i = 0; i <= tabelasPremissas.size() - 1; i++) {
                int nroColunas = tabelasPremissas.get(i).getColunas().size();
                colunas.add(tabelasPremissas.get(i).getColunas().get(nroColunas - 1));
            }
        }
        colunas.add(tabelaConclusao.getColunas().get(nroColunasConclusao - 1));
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
