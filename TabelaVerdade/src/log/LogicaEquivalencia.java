/*
 * LogicaEquivalencia.java
 *
 * Created on 26 de Maio de 2007, 23:21
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package log;

import java.io.IOException;
import java.util.ArrayList;
import pers.TabelaVerdade;
import tipos.Formula;

/**
 *
 * @author Arthur Thiago Barbosa Nobrega
 */
public class LogicaEquivalencia extends Logica {
    
    /** Creates a new instance of LogicaEquivalencia */
    public LogicaEquivalencia(Formula formula1, Formula formula2) throws IOException {
        if (!(testarFormulaBemFormada(formula1)) || !(testarFormulaBemFormada(formula2))) {
            throw new IOException();
        }
        
        TabelaVerdade tabela1 = new TabelaVerdade(formula1);
        TabelaVerdade tabela2 = new TabelaVerdade(formula2);
        
        if (tabela1.getColunas().size() != tabela2.getColunas().size()) {
            throw new IOException();
        }
        
        int nroLinhas = tabela1.getLinhas().size();
        int nroColunas = tabela1.getColunas().size();
        
        colunas.add(tabela1.getColunas().get(nroColunas - 1));
        colunas.add(tabela2.getColunas().get(nroColunas - 1));
        
        ArrayList linhas1 = tabela1.getLinhas();
        ArrayList linhas2 = tabela2.getLinhas();
        for (int i = 0; i <=  nroLinhas - 1; i++) {
            String[] linha1 = (String[]) linhas1.get(i);
            String[] linha2 = (String[]) linhas2.get(i);
            String[] novaLinha = new String[2];
            if (!(linha1[nroColunas - 1].equals(linha2[nroColunas - 1]))) {
                throw new IOException();
            }
            novaLinha[0] = linha1[nroColunas - 1];
            novaLinha[1] = linha2[nroColunas - 1];
            linhas.add(novaLinha);
        }
    }
    
    public ArrayList getLinhas() {
        return linhas;
    }
    
    public ArrayList getColunas() {
        return colunas;
    }
    
    private ArrayList linhas = new ArrayList();
    private ArrayList colunas = new ArrayList();
}
