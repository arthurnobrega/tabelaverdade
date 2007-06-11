/*
 * Equivalencia.java
 */

package pers;

import java.util.Iterator;
import log.FormulaException;
import log.Logica;
import java.util.ArrayList;
import tipos.Constantes;
import tipos.Formula;

/** Classe que testa se as fórmulas inseridas são equivalentes semânticamente.
 * @author Arthur Thiago Barbosa Nobrega e Felippe Pires Ferreira
 */
public class Equivalencia {
    
    /** Cria um novo teste de Equivalência Semântica.
     * @param strFormula1 Primeira fórmula que será comparada.
     * @param strFormula2 Segunda fórmula que será comparada.
     */
    public Equivalencia(String strFormula1, String strFormula2) throws FormulaException {
        /* Testa se as fórmulas seguem os padrões. */
        Formula formula1 = new Formula(strFormula1);
        Formula formula2 = new Formula(strFormula2);
        Logica logica = new Logica();
        if (!(logica.testarFormulaBemFormada(formula1)) || !(logica.testarFormulaBemFormada(formula2))) {
            throw new FormulaException();
        }
        
        Formula formula1Comp = new Formula(formula1.getFormula());
        Formula formula2Comp = new Formula(formula2.getFormula());
        testarProposicoes(formula1Comp.getProposicoes(), formula2Comp.getProposicoes());
        
        adicionarProposicoes(formula1Comp, formula1.getProposicoes());
        adicionarProposicoes(formula2Comp, formula2.getProposicoes());
        
        formula1 = new Formula(formula1Comp.getFormula());
        formula2 = new Formula(formula2Comp.getFormula());
        
        /* Cria as tabelas das fórmulas. */
        tabela1 = new TabelaVerdade(formula1);
        tabela1.getFormula().setFormula(strFormula1);
        tabela2 = new TabelaVerdade(formula2);
        tabela2.getFormula().setFormula(strFormula2);
        
        int nroLinhas = tabela1.getLinhas().size();
        nroColunas = tabela1.getColunas().size();
        
        ArrayList linhas1 = tabela1.getLinhas();
        ArrayList linhas2 = tabela2.getLinhas();
        
        /* Verifica a equivalência das fórmulas e constroi as novas linhas da tabela. */
        for (int i = 0; i <=  nroLinhas - 1; i++) {
            String[] linha1 = (String[]) linhas1.get(i);
            String[] linha2 = (String[]) linhas2.get(i);
            String[] novaLinha = new String[2];
            if (!(linha1[nroColunas - 1].equals(linha2[nroColunas - 1]))) {
                resultado = false;
            }
            novaLinha[0] = linha1[nroColunas - 1];
            novaLinha[1] = linha2[nroColunas - 1];
            linhas.add(novaLinha);
        }
    }
    
    /** Adiciona as proposições que não existem em uma fórmula mas existem na outra.
            * @param proposicoes1 Primeira lista de proposicoes.
            * @param proposicoes2 Segunda lista de proposicoes.
    */
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
    
    /** Adiciona as proposicoes que não existem na antiga fórmula e aumenta ela.
            * @param formulaComp Fórmula que será expandida e que contem a nova lista de proposicoes.
            * @param proposicoesAntes lista de proposicoes antes da expansão.
    */
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
    
    /** Retorna o resultado do teste de Equivalência Semântica.
     */
    public boolean verificarEquivalencia() {
        return resultado;
    }
    
    /** Retorna as linhas para serem mostradas na tabela. 
     */
    public ArrayList getLinhas() {
        return linhas;
    }
    
    /** Retorna as colunas para serem mostradas na tabela. 
     */
    public ArrayList getColunas() {
        colunas.add(tabela1.getColunas().get(nroColunas - 1));
        colunas.add(tabela2.getColunas().get(nroColunas - 1));
        return colunas;
    }
    
    
    private int nroColunas = 0;
    private TabelaVerdade tabela1;
    private TabelaVerdade tabela2;
    private boolean resultado = true;
    private ArrayList linhas = new ArrayList();
    private ArrayList colunas = new ArrayList();
}