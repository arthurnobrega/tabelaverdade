/*
 * teste.java
 *
 * Created on 21 de Maio de 2007, 23:52
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui;

import java.awt.Color;  
import java.awt.Component;  
import java.awt.Font;  
import java.util.Vector;  

import javax.swing.JFrame;  
import javax.swing.JTable;  
import javax.swing.table.DefaultTableCellRenderer;  
import javax.swing.table.DefaultTableModel;  
   
 /** 
 * @author Ronald Tetsuo Miura 
 */  
public class teste extends DefaultTableCellRenderer {  
  
    /** */  
    private Color[] degradeFG;  

    /** */  
    private Color[] degradeBG;  
  
    {  
        degradeFG = new Color[256];  
        for (int i = 0; i < degradeFG.length; i++) {  
            degradeFG[i] = new Color(255, i, i);  
        }

        degradeBG = new Color[256];  
        for (int i = 0; i < degradeBG.length; i++) {  
            degradeBG[i] = new Color(255 - i, 255 - i, 255);  
        }
    }  
 
/** */  
private Font fontePadrao = new Font("monospaced", Font.BOLD, 12);  
  
    /** 
    * @see javax.swing.table.TableCellRenderer#getTableCellRendererComponent(javax.swing.JTable, 
    * java.lang.Object, boolean, boolean, int, int) 
    */  
    public Component getTableCellRendererComponent(JTable table,  
            Object value,  
            boolean isSelected,  
            boolean hasFocus,  
            int row,  
            int column) {  
        
        Component c = super.getTableCellRendererComponent(  
        table,  
        value,  
        isSelected,  
        hasFocus,  
        row,  
        column);  
  
        c.setFont(this.fontePadrao);  
  
        int total = table.getRowCount();  
        int degIndex = (int) (degradeBG.length * ((float) row / total));  

        c.setForeground(degradeFG[degIndex]);  
        c.setBackground(degradeBG[degIndex]);  

        return c;  
    }  
   
    /** 
    * @param args 
    */
    public static void main(String[] args) {  
        Vector header = new Vector();  
        header.add("Teste1");  
        header.add("Teste2");  
        header.add("Teste3");  
        header.add("Teste4");  
  
        Vector data = new Vector();  
        for (int i = 0; i < 10; i++) {  
            Vector row = new Vector();  
            row.add("Teste1");  
            row.add("Teste2");  
            row.add("Teste3");  
            row.add("Teste4");  
            data.add(row);  
        }
        
        JTable table = new JTable(new DefaultTableModel(data, header));
        table.setDefaultRenderer(Object.class, new teste());  

        JFrame frame = new JFrame();  
        frame.getContentPane().add(table);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setSize(640, 480);  
        frame.setVisible(true);  
    }
    
}  