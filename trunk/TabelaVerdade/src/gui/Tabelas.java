/*
 * Tabelas.java
 *
 */

package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.FontMetrics;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import tipos.Containers;

/**
 *
 * @author Arthur Thiago Barbosa Nobrega
 */
public class Tabelas extends javax.swing.JDialog {

    /** Cria uma nova janela de Tabelas. */
    public Tabelas(java.awt.Frame parent, boolean modal, ArrayList pDados, ArrayList pColunas) {
        super(parent, modal);
        dados = pDados;
        colunas = pColunas;
        initComponents();
        Containers.alinharContainer(this);
    }

    /* Cria uma classe interna que será o modelo da Tabela. */
    class ModeloTabela extends AbstractTableModel {

        /** Cria um novo modelo de Tabela.
         */
        public ModeloTabela() {            
            int tamanhoLista = dados.size();
            listaLinhas = (ArrayList) dados.clone();
        }

        /**
         * Retorna o numero de colunas no modelo.
         * @see javax.swing.table.TableModel#getColumnCount()
         */
        public int getColumnCount() {
             return ((String[])listaLinhas.get(0)).length;
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

        public String[] getValues(int rowIndex){
            return (String[]) listaLinhas.get(rowIndex);
        }

        private ArrayList listaLinhas = null;
 
    }
    
    class CellRenderer extends DefaultTableCellRenderer {


        public CellRenderer() {
            super();
        }

        private Color getCellColor(String[] linhas) {
            /* Faz um teste para decidir a cor da letra */
            return Color.BLACK;
        }

        public Component getTableCellRendererComponent(javax.swing.JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row, int column) {


            JLabel label = (JLabel)super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);

            String[] dados = ((ModeloTabela)table.getModel()).getValues(row);

            // somente para centralizar
            if (column != 0)
                label.setHorizontalAlignment(JLabel.CENTER);

            // se for par
            if (row == 2){

                // cor de fundo
                label.setBackground(new Color(255, 218, 185));

                // cor da fonte
                label.setForeground(getCellColor(dados));
            }

            // se for ímpar
            else {

                // cor de fundo
                label.setBackground(Color.WHITE);

                // cor da fonte
                label.setForeground(getCellColor(dados));
            }

            label.setHorizontalAlignment(SwingConstants.CENTER);


            return label;
        }
    
    }


    class ModeloColuna extends DefaultTableColumnModel {


        public ModeloColuna(FontMetrics fm) {

                int nColunas = colunas.size();
                for (int i = 0; i <= nColunas - 1; i++) {
                    addColumn(criaColuna(i, tabela.getWidth() / nColunas, fm, true, (String) colunas.get(i)));
                }
        }

        private TableColumn criaColuna(int columnIndex, int largura, FontMetrics fm, boolean resizable, String titulo){

            int larguraTitulo = fm.stringWidth(titulo + "  ");
            if (largura < larguraTitulo){
                largura = larguraTitulo;            
            }

            TableColumn col = new TableColumn(columnIndex);
            col.setCellRenderer(new CellRenderer());
            col.setHeaderRenderer(null);
            col.setHeaderValue(titulo);
            col.setPreferredWidth(largura);
            if(!resizable){

                col.setMaxWidth(largura);
                col.setMinWidth(largura);
            }
            col.setResizable(resizable);
            return col;        
        }    
    }

    /** Este método é gerado automaticamente pelo NetBeans e é responsável por toda a parte gráfica.
     */
    // <editor-fold defaultstate="collapsed" desc=" Código Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        FontMetrics fm = tabela.getFontMetrics(tabela.getFont());
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        tabela.setModel(new ModeloTabela());
        tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabela.setColumnModel(new ModeloColuna(fm));
        jScrollPane.setViewportView(tabela);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
        );

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(btnVoltar))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(20, 20, 20)
                .add(btnVoltar)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        /* Fecha a janela. */
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    // Declaração de variáveis - não modifique//GEN-BEGIN:variables
    private javax.swing.JButton btnVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable tabela;
    // Fim da declaração de variáveis//GEN-END:variables
    ArrayList dados;
    ArrayList colunas;
}
