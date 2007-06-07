/*
 * Containers.java
 */

package tipos;

/** Esta classe é responsável por implementar métodos que serão utilizados nas janelas.
 * @author Arthur Thiago Barbosa Nobrega e Felippe Pires Ferreira
 */
public class Containers {

      /** Alinha uma janela em uma posição arbitrária no monitor do usuário.
      * @param container A janela.
      */
     public static void alinharContainer(java.awt.Container container) {
         /* Pega a resolução da tela do usuário. */
         java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
         int componentWidth = container.getWidth();
         int componentHeight = container.getHeight();
         
         /* Alinha a janela. */
         container.setBounds((screenSize.width - componentWidth) / 2, (int) (((screenSize.height - componentHeight) / 2) * 0.5), componentWidth, componentHeight);
     }
    
}
