/*
 * LogicaTabela.java
 */

package pers;

import java.util.ArrayList;
import log.FormulaException;
import log.Logica;
import tipos.Formula;

/** Classe que retorna a tabela se a f�rmula passar nos testes.
 * @author Arthur Thiago Barbosa Nobrega e Felippe Pires Ferreira
 */
public class Tabela {
    
    /** Cria um novo teste de tabela.
     */
    public Tabela(Formula formula) throws FormulaException {
        /* Testa se a f�rmula segue os padr�es. */
        Logica logica = new Logica();
        if (!(logica.testarFormulaBemFormada(formula))) {
            throw new FormulaException();
        }
        tabela = new TabelaVerdade(formula);
    }
    
    /** Retorna as linhas para serem mostradas na tabela. 
     */
    public ArrayList getLinhas() {
        return tabela.getLinhas();
    }
    
    /** Retorna as colunas para serem mostradas na tabela. 
     */
    public ArrayList getColunas() {
        return tabela.getColunas();
    }
    
    TabelaVerdade tabela;
}
