package br.edu.ifms.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
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
        txtPesquisar = new javax.swing.JTextField();
        ComboBoxAlbum = new javax.swing.JComboBox<>();
        ComboBoxArtista = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ComboBoxCompositor = new javax.swing.JComboBox<>();
        jTextMusica = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Música");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(640, 397));
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 49, 633, 175));

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifms/icons/adicionar-usuário-masculino-25.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        getContentPane().add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 318, -1, -1));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifms/icons/editar-usuário-masculino-25.png"))); // NOI18N
        btnEditar.setText("Editar");
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 318, 100, -1));

        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifms/icons/remover-usuário-masculino-25.png"))); // NOI18N
        btnDeletar.setText("Deletar");
        getContentPane().add(btnDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 318, 100, -1));

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifms/icons/apagador-25.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        getContentPane().add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(467, 318, 100, -1));
        getContentPane().add(txtPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, 633, 25));

        ComboBoxAlbum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        getContentPane().add(ComboBoxAlbum, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 280, -1, -1));

        ComboBoxArtista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        getContentPane().add(ComboBoxArtista, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jLabel6.setText("Artista:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 283, -1, -1));

        jLabel7.setText("Compositor:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 283, -1, -1));

        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 245, -1, -1));

        ComboBoxCompositor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        getContentPane().add(ComboBoxCompositor, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 280, -1, -1));
        getContentPane().add(jTextMusica, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 242, 481, -1));

        jLabel8.setText("Álbum:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(467, 283, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<Object> ComboBoxAlbum;
    public javax.swing.JComboBox<Object> ComboBoxArtista;
    public javax.swing.JComboBox<Object> ComboBoxCompositor;
    public javax.swing.JButton btnCadastrar;
    public javax.swing.JButton btnDeletar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTableMusicas;
    private javax.swing.JTextField jTextMusica;
    private javax.swing.JTextField txtPesquisar;
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
