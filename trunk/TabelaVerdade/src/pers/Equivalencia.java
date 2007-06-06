/*
 * Equivalencia.java
 *
 */

package pers;

import log.FormulaException;
import log.Logica;
import tipos.Constantes;
import java.util.ArrayList;
import tipos.Formula;

/**
 *
 * @author Arthur Thiago Barbosa Nobrega e Felippe Pires Ferreira
 */
public class Equivalencia {
    
    /** Creates a new instance of LogicaEquivalencia */
    public Equivalencia(Formula formula1, Formula formula2) throws FormulaException {
        Logica logica = new Logica();
        if (!(logica.testarFormulaBemFormada(formula1)) || !(logica.testarFormulaBemFormada(formula2))) {
            throw new FormulaException();
        }
        
        tabela1 = new TabelaVerdade(formula1);
        tabela2 = new TabelaVerdade(formula2);
        
        if (tabela1.getLinhas().size() != tabela2.getLinhas().size()) {
            throw new FormulaException();
        }
        
        int nroLinhas = tabela1.getLinhas().size();
        int nroColunas = tabela1.getColunas().size();
                
        ArrayList linhas1 = tabela1.getLinhas();
        ArrayList linhas2 = tabela2.getLinhas();
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
    
    public boolean verificarEquivalencia() {
        return resultado;
    }
    
    public ArrayList getLinhas() {
        return linhas;
    }
    
    public ArrayList getColunas() {
        int nroColunas = tabela1.getColunas().size();
        colunas.add(tabela1.getColunas().get(nroColunas - 1));
        colunas.add(tabela2.getColunas().get(nroColunas - 1));
        return colunas;
    }
    
    TabelaVerdade tabela1;
    TabelaVerdade tabela2;
    private boolean resultado = true;
    private ArrayList linhas = new ArrayList();
    private ArrayList colunas = new ArrayList();
}