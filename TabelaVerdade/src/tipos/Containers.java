/*
 * Containers.java
 *
 */

package tipos;

/**
 *
 * @author Arthur Thiago Barbosa Nobrega e Felippe Pires Ferreira
 */
public class Containers {
    
    /** Creates a new instance of Containers */
    public Containers() {
    }
    
      /**
      * Centraliza na tela um diálogo, um frame ou outro container.
      * @param container O container.
      */
     public static void alinharContainer(java.awt.Container container) {
         java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
         int componentWidth = container.getWidth();
         int componentHeight = container.getHeight();
         container.setBounds((screenSize.width - componentWidth) / 2, (int) (((screenSize.height - componentHeight) / 2) * 0.5), componentWidth, componentHeight);
     }
    
}
