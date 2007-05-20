/*
 * TabelaVerdade.java
 *
 * Created on 18 de Maio de 2007, 19:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pers;

import java.util.ArrayList;

/**
 *
 * @author UltraXP
 */
public class TabelaVerdade {
    
    /** Creates a new instance of TabelaVerdade */
    public TabelaVerdade(String formula) {
    }
    
    public ArrayList getTabela() {
        return new ArrayList();
    }
    
    /* Esta função retorna se não ocorreu nenhum erro no uso do objeto. */
    public int verificarSucesso() {
        return sucesso;
    }
    
    private int sucesso = 0;
}
