/*
 * DialogSobre.java
 *
 * Created on 5 de Junho de 2007, 22:52
 */

package gui;

/** Janela para mostrar informações sobre o software.
 * @see javax.swing.JDialog
 * @author Arthur Thiago Barbosa Nobrega e Felippe Pires Ferreira
 */
public class DialogSobre extends javax.swing.JDialog {
    
    /** Cria uma nova janela de informações do software.
     */
    public DialogSobre(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tipos.Containers.alinharContainer(this);
    }
    
    /** Este método é gerado automaticamente pelo NetBeans e é respons?vel por toda a parte gráfica.
     */
    // <editor-fold defaultstate="collapsed" desc=" Código Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        lblDesenvolvedores = new javax.swing.JLabel();
        lblProfessora = new javax.swing.JLabel();
        lblSemestre = new javax.swing.JLabel();
        pnlDesenvolvedores = new javax.swing.JPanel();
        lblNomeArthur = new javax.swing.JLabel();
        lblNomeFelippe = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblProfessora1 = new javax.swing.JLabel();
        lblSemestre1 = new javax.swing.JLabel();
        lblSemestre2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        lblDesenvolvedores.setFont(new java.awt.Font("Arial", 1, 12));
        lblDesenvolvedores.setText("Desenvolvedores:");

        lblProfessora.setFont(new java.awt.Font("Arial", 1, 12));
        lblProfessora.setText("Professora:");

        lblSemestre.setFont(new java.awt.Font("Arial", 1, 12));
        lblSemestre.setText("Semestre:");

        lblNomeArthur.setFont(new java.awt.Font("Georgia", 0, 13));
        lblNomeArthur.setText("Arthur Thiago Barbosa Nobrega");

        lblNomeFelippe.setFont(new java.awt.Font("Georgia", 0, 13));
        lblNomeFelippe.setText("Felippe Pires Ferreira ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10));
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("(arthurthiago@gmail.com)");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10));
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("(felippepipipe@gmail.com)");

        org.jdesktop.layout.GroupLayout pnlDesenvolvedoresLayout = new org.jdesktop.layout.GroupLayout(pnlDesenvolvedores);
        pnlDesenvolvedores.setLayout(pnlDesenvolvedoresLayout);
        pnlDesenvolvedoresLayout.setHorizontalGroup(
            pnlDesenvolvedoresLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlDesenvolvedoresLayout.createSequentialGroup()
                .add(pnlDesenvolvedoresLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblNomeFelippe)
                    .add(lblNomeArthur))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pnlDesenvolvedoresLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel1)
                    .add(jLabel2)))
        );
        pnlDesenvolvedoresLayout.setVerticalGroup(
            pnlDesenvolvedoresLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlDesenvolvedoresLayout.createSequentialGroup()
                .add(pnlDesenvolvedoresLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblNomeArthur)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pnlDesenvolvedoresLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblNomeFelippe)
                    .add(jLabel2))
                .add(0, 0, Short.MAX_VALUE))
        );

        lblProfessora1.setFont(new java.awt.Font("Georgia", 0, 13));
        lblProfessora1.setText("Cl\u00e1udia Nalon");

        lblSemestre1.setFont(new java.awt.Font("Georgia", 0, 13));
        lblSemestre1.setText("01 / 2007");

        lblSemestre2.setFont(new java.awt.Font("Arial", 1, 12));
        lblSemestre2.setText("Raz\u00e3o:");

        jTextArea1.setBackground(new java.awt.Color(226, 226, 226));
        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Georgia", 0, 13));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Este software foi implementado para a entrega do primeiro trabalho de L\u00f3gica Computacional da Universidade de Bras\u00edlia (UnB) do curso de Ci\u00eancia da Computa\u00e7\u00e3o.");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblSemestre2)
                    .add(lblSemestre)
                    .add(lblProfessora)
                    .add(lblDesenvolvedores))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlDesenvolvedores, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblProfessora1)
                    .add(lblSemestre1)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblDesenvolvedores, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlDesenvolvedores, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblProfessora)
                    .add(lblProfessora1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblSemestre)
                    .add(lblSemestre1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblSemestre2)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Declaração de variáveis - não modifique//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblDesenvolvedores;
    private javax.swing.JLabel lblNomeArthur;
    private javax.swing.JLabel lblNomeFelippe;
    private javax.swing.JLabel lblProfessora;
    private javax.swing.JLabel lblProfessora1;
    private javax.swing.JLabel lblSemestre;
    private javax.swing.JLabel lblSemestre1;
    private javax.swing.JLabel lblSemestre2;
    private javax.swing.JPanel pnlDesenvolvedores;
    // Fim da declaração de variáveis//GEN-END:variables
    
}
