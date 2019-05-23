package br.edu.ifms.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ConsultaAlbumView extends javax.swing.JInternalFrame {

    public ConsultaAlbumView() {
        initComponents();
        this.setLocation(350, 100);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMusicas = new javax.swing.JTable();
        txtPesquisar = new javax.swing.JTextField();
        JComboBoxAlbum = new javax.swing.JComboBox<>();
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
                "Código", "Música", "Artista", "Compositor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableMusicas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 633, 190));
        getContentPane().add(txtPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, 633, 25));

        JComboBoxAlbum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        getContentPane().add(JComboBoxAlbum, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        jLabel8.setText("Álbum:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<Object> JComboBoxAlbum;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTableMusicas;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables

    public void addTableListener(MouseListener mouseListener) {
        jTableMusicas.addMouseListener(mouseListener);
    }

    public void addComboBoxListener(ActionListener actionListener) {
        JComboBoxAlbum.addActionListener(actionListener);
    }

    public DefaultTableModel getTableM() {
        return (DefaultTableModel) jTableMusicas.getModel();
    }

    public void setRS(DefaultTableModel model) {
        this.jTableMusicas.setRowSorter(new TableRowSorter(model));
    }

    public JTable getTable() {
        return jTableMusicas;
    }

    public DefaultComboBoxModel getComboBoxModel() {
        return (DefaultComboBoxModel) JComboBoxAlbum.getModel();
    }

    public JComboBox getComboBox() {
        return JComboBoxAlbum;
    }

}
