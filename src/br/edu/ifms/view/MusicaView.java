package br.edu.ifms.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class MusicaView extends javax.swing.JInternalFrame {

    public MusicaView() {
        initComponents();
        this.setLocation(350, 100);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMusicas = new javax.swing.JTable();
        btnCadastrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        ComboBoxAlbum = new javax.swing.JComboBox<>();
        ComboBoxArtista = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ComboBoxCompositor = new javax.swing.JComboBox<>();
        jTextMusica = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Música");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(660, 430));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableMusicas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Música", "Artista", "Compositor", "Album"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableMusicas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 633, 175));

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifms/icons/adicionar-usuário-masculino-25.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        getContentPane().add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifms/icons/editar-usuário-masculino-25.png"))); // NOI18N
        btnEditar.setText("Editar");
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 100, -1));

        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifms/icons/remover-usuário-masculino-25.png"))); // NOI18N
        btnDeletar.setText("Deletar");
        getContentPane().add(btnDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 100, -1));

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifms/icons/apagador-25.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        getContentPane().add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 100, -1));

        ComboBoxAlbum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        getContentPane().add(ComboBoxAlbum, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        ComboBoxArtista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        getContentPane().add(ComboBoxArtista, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabel6.setText("Artista:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel7.setText("Compositor:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        ComboBoxCompositor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        getContentPane().add(ComboBoxCompositor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        jTextMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMusicaActionPerformed(evt);
            }
        });
        getContentPane().add(jTextMusica, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 560, -1));

        jLabel8.setText("Álbum:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));
        getContentPane().add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 0, 8, 386));
        getContentPane().add(filler3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 290, -1, 85));
        getContentPane().add(filler4, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 250, 9, 20));
        getContentPane().add(filler5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 9, 85));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifms/images/headphone.png"))); // NOI18N
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMusicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMusicaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<Object> ComboBoxAlbum;
    public javax.swing.JComboBox<Object> ComboBoxArtista;
    public javax.swing.JComboBox<Object> ComboBoxCompositor;
    public javax.swing.JButton btnCadastrar;
    public javax.swing.JButton btnDeletar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnLimpar;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTableMusicas;
    private javax.swing.JTextField jTextMusica;
    // End of variables declaration//GEN-END:variables

    public String getMusica() {
        return jTextMusica.getText();
    }

    public void setMusica(String jTextMusica) {
        this.jTextMusica.setText(jTextMusica);
    }
        
    public void addButtonListener(ActionListener actionListener) {
        btnCadastrar.addActionListener(actionListener);
        btnEditar.addActionListener(actionListener);
        btnDeletar.addActionListener(actionListener);
        btnLimpar.addActionListener(actionListener);
    }

    public void addTableListener(MouseListener mouseListener) {
        jTableMusicas.addMouseListener(mouseListener);
    }
    
    public DefaultTableModel getTableM(){
        return (DefaultTableModel) jTableMusicas.getModel();
    }
    
    public void setRS(DefaultTableModel model){
        this.jTableMusicas.setRowSorter(new TableRowSorter(model));
    }
    
    public JTable getTable(){
        return jTableMusicas;
    }

}
