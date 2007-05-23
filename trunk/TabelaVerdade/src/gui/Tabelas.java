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

/**
 *
 * @author Arthur Thiago Barbosa Nobrega
 */
public class Tabelas extends javax.swing.JDialog {

    /** Cria uma nova janela de Tabelas. */
    public Tabelas(java.awt.Frame parent, boolean modal, ArrayList pDados) {
        super(parent, modal);
        dados = pDados;
        initComponents();
        Containers.alinharContainer(this);
    }

    /* Cria uma classe interna que será o modelo da Tabela. */
    class ModeloTabela extends AbstractTableModel {

        /** Cria um novo modelo de Tabela.
         */
        public ModeloTabela(ArrayList dados) {
            int tamanhoLista = dados.size();
            listaColunas = (String[]) dados.get(tamanhoLista - 1);
            dados.remove(tamanhoLista - 1);
            listaLinhas = (ArrayList) dados.clone();
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

        public String[] getValues(int rowIndex){
            return (String[]) listaLinhas.get(rowIndex);
        }

        public Class getCollumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        private ArrayList listaLinhas = null;
        private String[] listaColunas = null;
 
    }
    
    class CellRenderer extends DefaultTableCellRenderer {


        public CellRenderer() {
            super();
        }

        private Color getCellColor(String[] linhas){

            /* Faz um teste para decidir a cor da linha. */            
            
          //if((doc % 2) == 0)
                return Color.GREEN;
          //else
          //    return Color.BLACK;
        }

        public Component getTableCellRendererComponent(javax.swing.JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row, int column){


            JLabel label = (JLabel)super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);

            String[] credor = ((ModeloTabela)table.getModel()).getValues(row);

            // somente para centralizar
            if (column != 0)
                label.setHorizontalAlignment(JLabel.CENTER);

            // se for par
            if((row % 2) == 0){

                // cor de fundo
                label.setBackground(Color.WHITE);  

                // cor da fonte
                if(column != 0)
                    label.setForeground(getCellColor(credor));                      
            }

            // se for ímpar
            else{

                    // cor de fundo
                label.setBackground(new Color(240, 240, 240));

                // cor da fonte
                if(column != 0)
                    label.setForeground(getCellColor(credor));
            }

            if(column == 0)

                    label.setHorizontalAlignment(SwingConstants.CENTER);

            else if(column == 1)

                    label.setHorizontalAlignment(SwingConstants.LEFT);


            return label;
        }
    
    }
    
    class ModeloColuna extends DefaultTableColumnModel {


        public ModeloColuna(FontMetrics fm) {

                int digito = fm.stringWidth("0");
                int letra = fm.stringWidth("M");
                addColumn(criaColuna(0, 100 * letra, fm, true, "Nome/Razão Social"));
                addColumn(criaColuna(1, 20 * digito, fm, false, "Documento"));          
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
        FontMetrics fm = tabela.getFontMetrics(tabela.getFont());
        tabela = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        tabela.setModel(new ModeloTabela(dados));
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
}
