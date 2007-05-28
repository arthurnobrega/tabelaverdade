/*
 * OpcaoTabela.java
 *
 */

package gui;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import log.LogicaTabela;
import tipos.Constantes;
import tipos.Containers;
import tipos.Formula;

/**
 *
 * @author Arthur Thiago Barbosa Nobrega
 */
public class OpcaoTabela extends javax.swing.JFrame {
    
    /** Cria uma nova janela de OpcaoTabela. */
    public OpcaoTabela() {
        initComponents();
        Containers.alinharContainer(this);
    }
    
    /** Este método é gerado automaticamente pelo NetBeans e é responsável por toda a parte gráfica.
     */
    // <editor-fold defaultstate="collapsed" desc=" Código Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAjuda = new javax.swing.JTextArea();
        txtFormula = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();
        btnVisualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visualizando a Tabela Verdade de uma FBF");
        txtAjuda.setBackground(new java.awt.Color(226, 226, 226));
        txtAjuda.setColumns(20);
        txtAjuda.setEditable(false);
        txtAjuda.setFont(new java.awt.Font("Courier", 0, 12));
        txtAjuda.setLineWrap(true);
        txtAjuda.setRows(5);
        txtAjuda.setText("Digite a fórmula que você deseja visualizar a tabela verdade. Para isso siga os seguintes padrões:\n\n" + Constantes.PADRAO_FORMULA);
        txtAjuda.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtAjuda);

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnVisualizar.setText("Visualizar Tabela Verdade");
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        jLabel1.setText("F\u00f3rmula:");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                            .add(layout.createSequentialGroup()
                                .add(btnVoltar)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 478, Short.MAX_VALUE)
                                .add(btnVisualizar))))
                    .add(layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtFormula, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 217, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(21, 21, 21)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(txtFormula, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnVoltar)
                    .add(btnVisualizar))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        try {
            Formula formula = new Formula(txtFormula.getText());
            LogicaTabela logTab = new LogicaTabela(formula);
            new Tabelas(this, true, logTab.getLinhas(), logTab.getColunas(), null).setVisible(true);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "A fórmula não segue os padrões estipulados!");
        }
    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        /* Fecha a janela. */
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed
    
    // Declaração de variáveis - não modifique//GEN-BEGIN:variables
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAjuda;
    private javax.swing.JTextField txtFormula;
    // Fim da declaração de variáveis//GEN-END:variables
    
}
