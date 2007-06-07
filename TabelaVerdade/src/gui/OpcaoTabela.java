/*
 * OpcaoTabela.java
 *
 */

package gui;

import javax.swing.JOptionPane;
import log.FormulaException;
import pers.Tabela;
import tipos.Constantes;
import tipos.Containers;
import tipos.Formula;

/** Janela para que o usuário insira uma fórmula.
 * @see javax.swing.JFrame
 * @author Arthur Thiago Barbosa Nobrega e Felippe Pires Ferreira
 */
public class OpcaoTabela extends javax.swing.JFrame {
    
    /** Cria uma nova janela de Tabela Verdade. 
     */
    public OpcaoTabela() {
        initComponents();
        Containers.alinharContainer(this);
    }
    
    /** Este método é gerado automaticamente pelo NetBeans e é responsável por toda a parte gráfica.
     */
    // <editor-fold defaultstate="collapsed" desc=" Código Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        txtFormula = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();
        btnVisualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visualizando a Tabela Verdade de uma FBF");

        btnVoltar.setText("Voltar");
        javax.swing.ImageIcon iconVoltar = new javax.swing.ImageIcon("img/voltar.png");
        java.awt.Image imgVoltar = iconVoltar.getImage().getScaledInstance(18, 18, java.awt.Image.SCALE_AREA_AVERAGING);
        btnVoltar.setIcon(new javax.swing.ImageIcon(imgVoltar));

        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnVisualizar.setText("Visualizar Tabela Verdade");
        javax.swing.ImageIcon iconConfirmar = new javax.swing.ImageIcon("img/confirmar.png");
        java.awt.Image imgConfirmar = iconConfirmar.getImage().getScaledInstance(18, 18, java.awt.Image.SCALE_AREA_AVERAGING);
        btnVisualizar.setIcon(new javax.swing.ImageIcon(imgConfirmar));

        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        jLabel1.setText("F\u00f3rmula:");

        jTextArea1.setBackground(new java.awt.Color(226, 226, 226));
        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 13));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Digite a f\u00f3rmula que voc\u00ea deseja visualizar a tabela verdade. Para isso siga os seguintes padr\u00f5es:\n\n" + Constantes.PADRAO_FORMULA);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(layout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(btnVoltar)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 350, Short.MAX_VALUE)
                                .add(btnVisualizar))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                .add(jLabel1)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(txtFormula, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)))
                        .add(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(txtFormula, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnVisualizar)
                    .add(btnVoltar))
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** Cria uma ação quando o usuário pressionar o botão "Visualizar Tabela Verdade".
     * @see java.awt.event.ActionEvent
     */
    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        try {
            /* Cria um novo objeto Tabela. */
            Formula formula = new Formula(txtFormula.getText());
            Tabela logTab = new Tabela(formula);
            
            /* Cria uma nova janela de Tabelas para mostrar os dados da fórmula. */
            new Tabelas(this, true, logTab.getLinhas(), logTab.getColunas(), null, null).setVisible(true);
        } catch (FormulaException e) {
            JOptionPane.showMessageDialog(null, Constantes.MENSAGEM_ERRO_FORMULA, Constantes.TITULO_ERRO_FORMULA, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVisualizarActionPerformed

    /** Cria uma ação quando o usuário pressionar o botão "Voltar".
     * @see java.awt.event.ActionEvent
     */
    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        /* Fecha a janela. */
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed
    
    // Declaração de variáveis - não modifique//GEN-BEGIN:variables
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtFormula;
    // Fim da declaração de variáveis//GEN-END:variables
    
}
