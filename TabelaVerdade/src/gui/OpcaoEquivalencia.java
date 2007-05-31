/*
 * OpcaoEquivalencia.java
 *
 */

package gui;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import log.LogicaEquivalencia;
import log.LogicaTabela;
import tipos.Constantes;
import tipos.Containers;
import tipos.Formula;

/**
 *
 * @author Arthur Thiago Barbosa Nobrega
 */
public class OpcaoEquivalencia extends javax.swing.JFrame {
    
    /** Cria uma nova janela de OpcaoEquivalencia. */
    public OpcaoEquivalencia() {
        initComponents();
        Containers.alinharContainer(this);
    }
    
    /** Este m�todo � gerado automaticamente pelo NetBeans e � respons�vel por toda a parte gr�fica.
     */
    // <editor-fold defaultstate="collapsed" desc=" Código Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        txtFormula1 = new javax.swing.JTextField();
        txtFormula2 = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();
        btnVerificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Verificando Equival\u00eancia entre duas FBFs");

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnVerificar.setText("Verificar Equival\u00eancia");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });

        jLabel1.setText("F\u00f3rmula 1:");

        jLabel2.setText("F\u00f3rmula 2:");

        jTextArea1.setBackground(new java.awt.Color(226, 226, 226));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 13));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Digite as duas f\u00f3rmulas que voc\u00ea deseja verificar se s\u00e3o semanticamente equivalentes. Para isso siga os seguintes padr\u00f5es:\n\n" + Constantes.PADRAO_FORMULA);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(10, 10, 10)
                .add(btnVoltar)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 549, Short.MAX_VALUE)
                .add(btnVerificar)
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtFormula2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                .add(10, 10, 10))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtFormula1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                .add(10, 10, 10))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 743, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 232, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(txtFormula1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(txtFormula2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(21, 21, 21)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnVerificar)
                    .add(btnVoltar))
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        try {
            Formula formula1 = new Formula(txtFormula1.getText());
            Formula formula2 = new Formula(txtFormula2.getText());
            LogicaEquivalencia logEquiv = new LogicaEquivalencia(formula1, formula2);
            new Tabelas(this, true, logEquiv.getLinhas(), logEquiv.getColunas(), null).setVisible(true);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, Constantes.MENSAGEM_ERRO_FORMULA, Constantes.TITULO_ERRO_FORMULA, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        /* Fecha a janela. */
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed
    
    // Declaração de variáveis - não modifique//GEN-BEGIN:variables
    private javax.swing.JButton btnVerificar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtFormula1;
    private javax.swing.JTextField txtFormula2;
    // Fim da declaração de variáveis//GEN-END:variables
    
}
