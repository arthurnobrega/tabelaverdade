/*
 * NoDefaultException.java
 *
 * Created on 20 de Maio de 2007, 22:57
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pers;

/**
 *
 * @author UltraXP
 */
public class NoDefaultException extends RuntimeException {
    
    /** Creates a new instance of NoDefaultException */
    public NoDefaultException() {
        super();
    }
    
    public NoDefaultException(String s) {
        super(s);
    }
    
}
