/*
 * Principal.java
 *
 */

package gui;

import javax.swing.ImageIcon;
import tipos.Containers;

/**
 *
 * @author Arthur Thiago Barbosa Nobrega
 */
public class Principal extends javax.swing.JFrame {
    
    private final String TEXTOPADRAO = "Passe o mouse sobre a op\u00e7\u00e3o desejada para visualizar uma breve descri\u00e7\u00e3o da mesma.";
    
    /** Cria uma nova janela Principal. */
    public Principal() {
        initComponents();
        Containers.alinharContainer(this);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" C�digo Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        btnTabela = new javax.swing.JButton();
        btnEquivalencia = new javax.swing.JButton();
        btnConsequencia = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAjuda = new javax.swing.JTextArea();
        txtAjuda.setText(TEXTOPADRAO);
        jLabel1 = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        menuAjuda = new javax.swing.JMenu();
        subMenuSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rela\u00e7\u00f5es entre F\u00f3rmulas Bem-Formadas");
        setResizable(false);
        btnTabela.setText("Tabela Verdade");
        javax.swing.ImageIcon iconTabela = new javax.swing.ImageIcon("img/tabelaverdade.png");
        java.awt.Image imgTabela = iconTabela.getImage().getScaledInstance(18, 18, java.awt.Image.SCALE_AREA_AVERAGING);
        btnTabela.setIcon(new javax.swing.ImageIcon(imgTabela));
        btnTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTabelaActionPerformed(evt);
            }
        });
        btnTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTabelaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTabelaMouseExited(evt);
            }
        });

        btnEquivalencia.setText("Equival\u00eancia Sem\u00e2ntica");
        javax.swing.ImageIcon iconEquivalencia = new javax.swing.ImageIcon("img/equivalencia.png");
        java.awt.Image imgEquivalencia = iconEquivalencia.getImage().getScaledInstance(18, 18, java.awt.Image.SCALE_AREA_AVERAGING);
        btnEquivalencia.setIcon(new javax.swing.ImageIcon(imgEquivalencia));
        btnEquivalencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquivalenciaActionPerformed(evt);
            }
        });
        btnEquivalencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEquivalenciaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEquivalenciaMouseExited(evt);
            }
        });

        btnConsequencia.setText("Consequ\u00eancia L\u00f3gica");
        javax.swing.ImageIcon iconConsequencia = new javax.swing.ImageIcon("img/consequencia.png");
        java.awt.Image imgConsequencia = iconConsequencia.getImage().getScaledInstance(18, 18, java.awt.Image.SCALE_AREA_AVERAGING);
        btnConsequencia.setIcon(new javax.swing.ImageIcon(imgConsequencia));
        btnConsequencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsequenciaActionPerformed(evt);
            }
        });
        btnConsequencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConsequenciaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConsequenciaMouseExited(evt);
            }
        });

        txtAjuda.setBackground(new java.awt.Color(226, 226, 226));
        txtAjuda.setColumns(20);
        txtAjuda.setEditable(false);
        txtAjuda.setLineWrap(true);
        txtAjuda.setRows(5);
        txtAjuda.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtAjuda);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11));
        jLabel1.setText(".: Escolha uma op\u00e7\u00e3o:");

        menuAjuda.setText("Ajuda");
        javax.swing.ImageIcon iconAjuda = new javax.swing.ImageIcon("img/ajuda.png");
        java.awt.Image imgAjuda = iconAjuda.getImage().getScaledInstance(22, 22, java.awt.Image.SCALE_AREA_AVERAGING);
        menuAjuda.setIcon(new javax.swing.ImageIcon(imgAjuda));

        subMenuSobre.setText("Sobre");
        javax.swing.ImageIcon iconSobre = new javax.swing.ImageIcon("img/sobre.png");
        java.awt.Image imgSobre = iconSobre.getImage().getScaledInstance(22, 22, java.awt.Image.SCALE_AREA_AVERAGING);
        subMenuSobre.setIcon(new javax.swing.ImageIcon(imgSobre));

        subMenuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuSobreActionPerformed(evt);
            }
        });

        menuAjuda.add(subMenuSobre);

        menu.add(menuAjuda);

        setJMenuBar(menu);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(btnTabela)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnEquivalencia, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnConsequencia))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .add(23, 23, 23)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnTabela)
                    .add(btnEquivalencia)
                    .add(btnConsequencia))
                .add(14, 14, 14)
                .add(jScrollPane1)
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void subMenuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuSobreActionPerformed
// TODO adicione seu código de manipulação aqui:
        new DialogSobre(this, true).setVisible(true);
    }//GEN-LAST:event_subMenuSobreActionPerformed

    private void btnConsequenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsequenciaActionPerformed
        new OpcaoConsequencia().setVisible(true);
    }//GEN-LAST:event_btnConsequenciaActionPerformed

    private void btnEquivalenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquivalenciaActionPerformed
        new OpcaoEquivalencia().setVisible(true);
    }//GEN-LAST:event_btnEquivalenciaActionPerformed

    private void btnTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTabelaActionPerformed
        new OpcaoTabela().setVisible(true);
    }//GEN-LAST:event_btnTabelaActionPerformed

    private void btnConsequenciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsequenciaMouseExited
        txtAjuda.setText(TEXTOPADRAO);
    }//GEN-LAST:event_btnConsequenciaMouseExited

    private void btnConsequenciaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsequenciaMouseEntered
        String texto = "Voc\u00ea poder\u00e1 fornecer v\u00e1rias premissas (ou nenhuma) " +
                "e uma conclus\u00e3o, ent\u00e3o voc\u00ea saber\u00e1 se aquela conclus\u00e3o " +
                "\u00e9 uma consequ\u00eancia l\u00f3gica das premissas.";
        txtAjuda.setText(texto);
    }//GEN-LAST:event_btnConsequenciaMouseEntered

    private void btnEquivalenciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEquivalenciaMouseExited
        txtAjuda.setText(TEXTOPADRAO);
    }//GEN-LAST:event_btnEquivalenciaMouseExited

    private void btnEquivalenciaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEquivalenciaMouseEntered
        String texto = "Voc\u00ea poder\u00e1 fornecer duas f\u00f3rmulas bem-formadas " +
                "(FBF) e testar se as duas t\u00eam as tabelas verdade iguais, ou seja, " +
                "se as duas f\u00f3rmulas s\u00e3o equivalentes sem\u00e2nticamente.";
        txtAjuda.setText(texto);
    }//GEN-LAST:event_btnEquivalenciaMouseEntered

    private void btnTabelaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTabelaMouseExited
        txtAjuda.setText(TEXTOPADRAO);
    }//GEN-LAST:event_btnTabelaMouseExited

    private void btnTabelaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTabelaMouseEntered
        String texto = "Voc\u00ea poder\u00e1 visualizar a tabela verdade de uma dada " +
                "f\u00f3rmula bem-formada (FBF) que voc\u00ea fornecer.";
        txtAjuda.setText(texto);
    }//GEN-LAST:event_btnTabelaMouseEntered
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    
    // Declara��o de vari�veis - n�o modifique//GEN-BEGIN:variables
    private javax.swing.JButton btnConsequencia;
    private javax.swing.JButton btnEquivalencia;
    private javax.swing.JButton btnTabela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenuItem subMenuSobre;
    private javax.swing.JTextArea txtAjuda;
    // Fim da declara��o de vari�veis//GEN-END:variables
    
}
