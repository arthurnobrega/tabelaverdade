/*
 * ModeloTabela.java
 *
 */

package gui;

 import java.util.ArrayList;
 import javax.swing.table.AbstractTableModel;
 
 /**
  *
  * @author Arthur Thiago Barbosa Nobrega
  */
 public class ModeloTabela extends AbstractTableModel{
     
    /** Cria um novo modelo de Tabela.
     */
    public ModeloTabela(ArrayList lista) {
        int tamanhoLista = lista.size();
        listaColunas = (String[]) lista.get(tamanhoLista - 1);
        lista.remove(tamanhoLista - 1);
        listaLinhas = (ArrayList) lista.clone();
    }
     
    /**
     * Retorna o nome da coluna passada como parâmetro pelo seu número.
     * @see javax.swing.table.TableModel#getColummName(int)
     */     
    public String getColumnName(int col) {
 		return listaColunas[col];
    }
    
    /**
     * Retorna o numero de colunas no modelo.
     * @see javax.swing.table.TableModel#getColumnCount()
     */
    public int getColumnCount() {
         return listaColunas.length;
    }
 
     /**
      * Retorna o numero de linhas existentes no modelo
      * @see javax.swing.table.TableModel#getRowCount()
      */
    public int getRowCount() {
         return listaLinhas.size();
    }
 
     /**
      * Obtem o valor na linha e coluna
      * @see javax.swing.table.TableModel#getValueAt(int, int)
      */
     public Object getValueAt(int rowIndex, int columnIndex) {
         // Obtem a linha, que é uma String []
         String[] linha = (String []) listaLinhas.get(rowIndex);
         // Retorna o objeto que esta na coluna
         return linha[columnIndex];
     } 
 
     private ArrayList listaLinhas = null;
     private String[] listaColunas = null;
 
}