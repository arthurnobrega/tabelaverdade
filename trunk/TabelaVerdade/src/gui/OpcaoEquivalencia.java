/*
 * OpcaoEquivalencia.java
 *
 */

package gui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import tipos.Constantes;
import tipos.Containers;

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
    
    /** Este método é gerado automaticamente pelo NetBeans e é responsável por toda a parte gráfica.
     */
    // <editor-fold defaultstate="collapsed" desc=" Código Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAjuda = new javax.swing.JTextArea();
        txtFormula1 = new javax.swing.JTextField();
        txtFormula2 = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();
        btnVerificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Verificando Equival\u00eancia entre duas FBFs");
        txtAjuda.setBackground(new java.awt.Color(226, 226, 226));
        txtAjuda.setColumns(20);
        txtAjuda.setEditable(false);
        txtAjuda.setFont(new java.awt.Font("Courier", 0, 12));
        txtAjuda.setLineWrap(true);
        txtAjuda.setRows(5);
        txtAjuda.setText("Digite as duas fórmulas que você deseja verificar se são semanticamente equivalentes. Para isso siga os seguintes padrões:\n\n" + Constantes.PADRAO_FORMULA);
        txtAjuda.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtAjuda);

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

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(10, 10, 10)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(btnVoltar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 467, Short.MAX_VALUE)
                        .add(btnVerificar))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtFormula2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                .add(10, 10, 10))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtFormula1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                .add(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 217, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(17, 17, 17)
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
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        /* Verifica se pelo menos uma das Fórmulas está em branco. */

        /* Faz a ação. MUDAR COMENTÁRIO. */
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
    private javax.swing.JTextArea txtAjuda;
    private javax.swing.JTextField txtFormula1;
    private javax.swing.JTextField txtFormula2;
    // Fim da declaração de variáveis//GEN-END:variables
    
}
