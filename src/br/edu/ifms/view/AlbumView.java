package br.edu.ifms.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Date;

public class AlbumView extends javax.swing.JInternalFrame {

    public AlbumView() {
        initComponents();
        this.setLocation(350, 100);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAlbuns = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextAlbum = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        txtPesquisar = new javax.swing.JTextField();
        JXDateDataLancamento = new org.jdesktop.swingx.JXDatePicker();

        setBackground(new java.awt.Color(204, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de usuários");
        setPreferredSize(new java.awt.Dimension(640, 397));

        jTableAlbuns.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Album", "Data de Lançamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableAlbuns);

        jLabel2.setText("Nome do album:");

        jLabel3.setText("Data de Lançamento:");

        btnCadastrar.setText("Cadastrar");

        btnEditar.setText("Editar");

        btnDeletar.setText("Deletar");

        btnLimpar.setText("Limpar");

        JXDateDataLancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JXDateDataLancamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnCadastrar)
                                .addGap(51, 51, 51)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPesquisar, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JXDateDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCadastrar, btnDeletar, btnEditar, btnLimpar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JXDateDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnEditar)
                    .addComponent(btnDeletar)
                    .addComponent(btnLimpar))
                .addGap(31, 31, 31))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCadastrar, btnDeletar, btnEditar, btnLimpar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JXDateDataLancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JXDateDataLancamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JXDateDataLancamentoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public org.jdesktop.swingx.JXDatePicker JXDateDataLancamento;
    public javax.swing.JButton btnCadastrar;
    public javax.swing.JButton btnDeletar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableAlbuns;
    private javax.swing.JTextField jTextAlbum;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables

    public String getAlbum() {
        return jTextAlbum.getText();
    }

    public void setAlbum(String album) {
        this.jTextAlbum.setText(album);
    }
    
    public Date getDate(){
        return JXDateDataLancamento.getDate();
    }
    
    public void setDate(Date date){
        this.JXDateDataLancamento.setDate(date);
    }

    public void addButtonListener(ActionListener actionListener) {
        btnCadastrar.addActionListener(actionListener);
        btnEditar.addActionListener(actionListener);
        btnDeletar.addActionListener(actionListener);
        btnLimpar.addActionListener(actionListener);
    }

    public void addTableListener(MouseListener mouseListener) {
        jTableAlbuns.addMouseListener(mouseListener);
    }

}
