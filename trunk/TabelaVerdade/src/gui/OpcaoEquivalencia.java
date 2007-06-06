/*
 * OpcaoEquivalencia.java
 *
 */

package gui;

import javax.swing.JOptionPane;
import log.FormulaException;
import pers.Equivalencia;
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
    
    /** Este mï¿½todo ï¿½ gerado automaticamente pelo NetBeans e ï¿½ responsï¿½vel por toda a parte grï¿½fica.
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
        javax.swing.ImageIcon iconVoltar = new javax.swing.ImageIcon("img/voltar.png");
        java.awt.Image imgVoltar = iconVoltar.getImage().getScaledInstance(18, 18, java.awt.Image.SCALE_AREA_AVERAGING);
        btnVoltar.setIcon(new javax.swing.ImageIcon(imgVoltar));

        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnVerificar.setText("Verificar Equival\u00eancia");
        javax.swing.ImageIcon iconConfirmar = new javax.swing.ImageIcon("img/confirmar.png");
        java.awt.Image imgConfirmar = iconConfirmar.getImage().getScaledInstance(18, 18, java.awt.Image.SCALE_AREA_AVERAGING);
        btnVerificar.setIcon(new javax.swing.ImageIcon(imgConfirmar));

        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });

        jLabel1.setText("F\u00f3rmula 1:");

        jLabel2.setText("F\u00f3rmula 2:");

        jTextArea1.setBackground(new java.awt.Color(226, 226, 226));
        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Georgia", 0, 13));
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
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtFormula2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtFormula1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(btnVoltar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 368, Short.MAX_VALUE)
                        .add(btnVerificar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtFormula1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel2)
                    .add(txtFormula2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(14, 14, 14)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnVoltar)
                    .add(btnVerificar))
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        try {
            Formula formula1 = new Formula(txtFormula1.getText());
            Formula formula2 = new Formula(txtFormula2.getText());
            Equivalencia equiv = new Equivalencia(formula1, formula2);
            if (equiv.verificarEquivalencia()) {
                JOptionPane.showMessageDialog(null, "As f\u00f3rmulas s\u00e3o sem\u00e2nticamente " +
                        "equivalentes!", "S\u00e3o Equivalentes!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "As f\u00f3rmulas n\u00e3o s\u00e3o sem\u00e2nticamente " +
                        "equivalentes!", "N\u00e3o s\u00e3o Equivalentes!", JOptionPane.INFORMATION_MESSAGE);
            }
            new Tabelas(this, true, equiv.getLinhas(), equiv.getColunas(), null, null).setVisible(true);
        } catch (FormulaException e) {
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
