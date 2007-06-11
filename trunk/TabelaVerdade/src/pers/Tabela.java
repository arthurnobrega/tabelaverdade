/*
 * LogicaTabela.java
 */

package pers;

import java.util.ArrayList;
import log.FormulaException;
import log.Logica;
import tipos.Constantes;
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
        int nroColunas = tabela.getColunas().size();
        int pontos = 0;
        for (int linha = 0; linha <= tabela.getLinhas().size() - 1; linha++) {
            if (tabela.getLinhas().get(linha)[nroColunas - 1].equals(Constantes.VERDADEIRO)) {
                pontos++;
            } else {
                pontos--;
            }
        }
        if (pontos == tabela.getLinhas().size()) {
            propriedade = Constantes.TAUTOLOGIA;
        } else if (pontos == -tabela.getLinhas().size()) {
            propriedade = Constantes.CONTRADICAO;
        } else {
            propriedade = Constantes.CONTINGENCIA;
        }
    }
    
    /** Retorna as linhas para serem mostradas na tabela. 
     */
    public ArrayList getLinhas() {
        return tabela.getLinhas();
    }
    
    /** Retorna as colunas para serem mostradas na tabela. 
     */
    public ArrayList getColunas() {
        ArrayList<String> colunas = tabela.getColunas();
        colunas.remove(colunas.size() - 1);
        return colunas;
    }
    
    public int getPropriedade() {
        return propriedade;
    }
    
    private int propriedade = 0;
    private TabelaVerdade tabela;
}
