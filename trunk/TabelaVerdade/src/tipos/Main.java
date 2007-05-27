/*
 * Main.java
 *
 * Created on 26 de Maio de 2007, 22:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tipos;

import java.util.ArrayList;

/**
 *
 * @author UltraXP
 */
public class Main {
    
    /** Creates a new instance of Main */
    public static void main(String args[]) {
        Formula formula = new Formula("( ~( (p & q) v (p - q) & (r v s) ) )");
        System.out.println("Proposições=" + formula.getProposicoes().size() +
                " Conectivos=" + formula.getConectivos() + 
                " Abre Parênteses=" + formula.getAbreParenteses() +
                " Fecha Parênteses=" + formula.getFechaParenteses());
    }
    
}
