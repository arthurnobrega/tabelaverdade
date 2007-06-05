/*
 * OpcaoConsequencia.java
 *
 */

package gui;

import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import log.FormulaException;
import log.Logica;
import log.LogicaConsequencia;
import pers.Consequencia;
import tipos.Constantes;
import tipos.Containers;
import tipos.Formula;

/**
 * 
 * @author Arthur Thiago Barbosa Nobrega
 */
public class OpcaoConsequencia extends javax.swing.JFrame {
    
    /** Cria uma nova janela de OpcaoConsequencia. */
    public OpcaoConsequencia() {
        initComponents();
        Containers.alinharContainer(this);
    }
    
    /** Este m�todo � gerado automaticamente pelo NetBeans e � respons�vel por toda a parte gr�fica.
     */
    // <editor-fold defaultstate="collapsed" desc=" C�digo Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        btnVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNovaPremissa = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbPremissas = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtConclusao = new javax.swing.JTextField();
        btnVerificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Verificando Consequ\u00eancia L\u00f3gica entre FBFs");
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nova Premissa:");

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        jLabel2.setText("Lista de Premissas:");

        jLabel3.setText("Conclus\u00e3o:");

        btnVerificar.setText("Verificar Consequ\u00eancia L\u00f3gica");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });

        jTextArea1.setBackground(new java.awt.Color(226, 226, 226));
        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 13));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Informe todas as premissas (ou nenhuma) e a conclus\u00e3o para verificar se a conclus\u00e3o \u00e9 consequ\u00eancia l\u00f3gica das premissas. Para isso siga os seguintes padr\u00f5es:\n\n" + Constantes.PADRAO_FORMULA);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(btnVoltar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 560, Short.MAX_VALUE)
                        .add(btnVerificar))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel3)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel2)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel1))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, txtConclusao, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, cmbPremissas, 0, 618, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, txtNovaPremissa, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(btnRemover)
                            .add(btnAdicionar)))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(11, 11, 11)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 232, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAdicionar)
                    .add(jLabel1)
                    .add(txtNovaPremissa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(btnRemover)
                    .add(cmbPremissas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(txtConclusao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(36, 36, 36)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnVoltar)
                    .add(btnVerificar))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        ComboBoxModel modelo = cmbPremissas.getModel();
        ArrayList listaPremissas = new ArrayList();
        for (int i = 0; i <= nroPremissas - 1; i++) {
            listaPremissas.add(modelo.getElementAt(i));
        }
        
        String conclusao = txtConclusao.getText();
        
        try {
            Consequencia conseq = new Consequencia(listaPremissas, conclusao);
            ArrayList<Integer> linhasSelecionadas;
            if (conseq.getConsequenciaLogica()) {
                 linhasSelecionadas = conseq.getLinhasSelecionadas();
                JOptionPane.showMessageDialog(null, "A conclus\u00e3o \u00e9 consequ\u00eancia l\u00f3gica " +
                        "das premissas!", "\u00c9 consequ\u00eancia l\u00f3gica!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                linhasSelecionadas = null;
                JOptionPane.showMessageDialog(null, "A conclus\u00e3o n\u00e3o \u00e9 consequ\u00eancia l\u00f3gica " +
                        "das premissas!", "\u00c9 consequ\u00eancia l\u00f3gica!", JOptionPane.INFORMATION_MESSAGE);
            }
            new Tabelas(this, true, conseq.getLinhas(), conseq.getColunas(), linhasSelecionadas).setVisible(true);
        } catch (FormulaException e) {
            JOptionPane.showMessageDialog(null, "A conclus\u00e3o n\u00e3o segue os padr\u00f5es estipulados!",
                    "Conclus\u00e3o inv\u00e1lida", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        /* Verifica se a Lista de Premissas est� em branco. */
        if (cmbPremissas.getItemCount() == 0) {
            JOptionPane.showMessageDialog(null, "N\u00e3o existem f\u00f3rmulas para serem deletadas!", 
                    "Lista de Premissas vazia!",JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        /* Remove o item selecionado na Lista de Premissas. */
        int nroPremissa = cmbPremissas.getSelectedIndex();
        cmbPremissas.removeItemAt(nroPremissa);
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        String novaPremissa = txtNovaPremissa.getText();
        
        LogicaConsequencia logica = new LogicaConsequencia(novaPremissa);
        if (!logica.testarFormulaBemFormada()) {
            JOptionPane.showMessageDialog(null, "A premissa n\u00e3o p\u00f4de ser inserida pois n\u00e3o segue " +
                    "os padr\u00f5es estipulados!", "Premissa inv\u00e1lida!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        nroPremissas++;
        /* Adiciona a premissa � Lista de Premissas e a seleciona. */
        cmbPremissas.addItem(novaPremissa);
        txtNovaPremissa.setText("");
        cmbPremissas.setSelectedIndex(cmbPremissas.getItemCount() - 1);
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        /* Fecha a janela. */
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed
    
    // Declara��o de vari�veis - n�o modifique//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cmbPremissas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtConclusao;
    private javax.swing.JTextField txtNovaPremissa;
    // Fim da declara��o de vari�veis//GEN-END:variables
    int nroPremissas = 0;
}
