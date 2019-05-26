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
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMusicas = new javax.swing.JTable();
        JComboBoxAlbum = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Música");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(640, 397));
        getContentPane().setLayout(new java.awt.GridBagLayout());

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 610;
        gridBagConstraints.ipady = 173;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 27, 17);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        JComboBoxAlbum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 7, 0, 0);
        getContentPane().add(JComboBoxAlbum, gridBagConstraints);

        jLabel8.setText("Álbum:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        getContentPane().add(jLabel8, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<Object> JComboBoxAlbum;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTableMusicas;
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
