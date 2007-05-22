/*
 * OpcaoConsequencia.java
 *
 */

package gui;

import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    
    /** Este método é gerado automaticamente pelo NetBeans e é responsável por toda a parte gráfica.
     */
    // <editor-fold defaultstate="collapsed" desc=" Código Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAjuda = new javax.swing.JTextArea();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Verificando Consequ\u00eancia L\u00f3gica entre FBFs");
        txtAjuda.setBackground(new java.awt.Color(226, 226, 226));
        txtAjuda.setColumns(20);
        txtAjuda.setEditable(false);
        txtAjuda.setFont(new java.awt.Font("Courier", 0, 12));
        txtAjuda.setRows(5);
        txtAjuda.setText("Informe todas as premissas (ou nenhuma) e a conclusão para verificar se a conclusão é consequência lógica das premissas. Para isso siga os seguintes padrões:\n\n" + Constantes.PADRAO_FORMULA);
        txtAjuda.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtAjuda);

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

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(10, 10, 10)
                .add(btnVoltar)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 425, Short.MAX_VALUE)
                .add(btnVerificar)
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .add(10, 10, 10)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                .add(10, 10, 10))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel3)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel2)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, txtConclusao, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, cmbPremissas, 0, 483, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, txtNovaPremissa, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnRemover)
                    .add(btnAdicionar))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 217, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(19, 19, 19)
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
        /* Verifica se a Conclusão está em branco. */
        if (txtConclusao.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor preencha o campo da " +
                    "fórmula de Conclusão!", "Campo Conclusão em branco!", 
                    JOptionPane.INFORMATION_MESSAGE);
            return;            
        }

        /* Faz a ação. MUDAR COMENTÁRIO. */
        String[] vetor = { "( p v q )" , "( ~ ( p v q ) )"};
        String[] linha1 = { "V" , "F"};
        String[] linha2 = { "V" , "F"};
        String[] linha3 = { "V" , "F"};
        String[] linha4 = { "F" , "V"};
        ArrayList lista = new ArrayList();
        lista.add(linha1);
        lista.add(linha2);
        lista.add(linha3);
        lista.add(linha4);
        lista.add(vetor);
        new Tabelas(this, true, lista).setVisible(true);
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        /* Verifica se a Lista de Premissas está em branco. */
        if (cmbPremissas.getItemCount() == 0) {
            JOptionPane.showMessageDialog(null, "Não existem fórmulas para serem " +
                    "deletadas!", "Lista de Premissas vazia!",JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        /* Remove o item selecionado na Lista de Premissas. */
        int nroPremissa = cmbPremissas.getSelectedIndex();
        cmbPremissas.removeItemAt(nroPremissa);
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        String novaPremissa = txtNovaPremissa.getText();

        /* Verifica se o campo Nova Premissa está em branco. */
        if (novaPremissa.length() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor insira uma fórmula" +
                    " no campo Nova Premissa antes\n de tentar adicioná-la à " +
                    "Lista de Premissas!", "Campo Nova Premissa em branco!", 
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        /* Adiciona a premissa à Lista de Premissas e a seleciona. */
        cmbPremissas.addItem(novaPremissa);
        txtNovaPremissa.setText("");
        cmbPremissas.setSelectedIndex(cmbPremissas.getItemCount() - 1);
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        /* Fecha a janela. */
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed
    
    // Declaração de variáveis - não modifique//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cmbPremissas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAjuda;
    private javax.swing.JTextField txtConclusao;
    private javax.swing.JTextField txtNovaPremissa;
    // Fim da declaração de variáveis//GEN-END:variables
    
}
