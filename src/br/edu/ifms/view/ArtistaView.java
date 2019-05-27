package br.edu.ifms.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ArtistaView extends javax.swing.JInternalFrame {

    public ArtistaView() {
        initComponents();
        this.setLocation(350, 100);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableArtistas = new javax.swing.JTable();
        btnCadastrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextEndereco = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextArtista = new javax.swing.JTextField();
        jTextTelefone = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Artistas");
        setPreferredSize(new java.awt.Dimension(640, 397));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jTableArtistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Artista", "Telefone", "Endereço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableArtistas);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 581;
        gridBagConstraints.ipady = 139;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 10);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifms/icons/adicionar-usuário-masculino-25.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 10, 20, 0);
        getContentPane().add(btnCadastrar, gridBagConstraints);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifms/icons/editar-usuário-masculino-25.png"))); // NOI18N
        btnEditar.setText("Editar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 8, 20, 0);
        getContentPane().add(btnEditar, gridBagConstraints);

        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifms/icons/remover-usuário-masculino-25.png"))); // NOI18N
        btnDeletar.setText("Deletar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 63, 20, 0);
        getContentPane().add(btnDeletar, gridBagConstraints);

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifms/icons/apagador-25.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 50, 20, 0);
        getContentPane().add(btnLimpar, gridBagConstraints);

        jLabel4.setText("Endereço:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 4, 0, 0);
        getContentPane().add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 359;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 4, 0, 0);
        getContentPane().add(jTextEndereco, gridBagConstraints);

        jLabel2.setText("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 10, 0, 0);
        getContentPane().add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 533;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 4, 0, 0);
        getContentPane().add(jTextArtista, gridBagConstraints);

        try {
            jTextTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 90;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        getContentPane().add(jTextTelefone, gridBagConstraints);

        jLabel3.setText("Telefone:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 10, 0, 0);
        getContentPane().add(jLabel3, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCadastrar;
    public javax.swing.JButton btnDeletar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTableArtistas;
    private javax.swing.JTextField jTextArtista;
    private javax.swing.JTextField jTextEndereco;
    private javax.swing.JFormattedTextField jTextTelefone;
    // End of variables declaration//GEN-END:variables

    //Metodo que retorna uma String preenchida no jTextArtista
    public String getArtista() {
        return jTextArtista.getText();
    }

    //Metodo para preencher uma String no jTextArtista
    public void setArtista(String jTextArtista) {
        this.jTextArtista.setText(jTextArtista);
    }

    //Metodo que retorna uma String preenchida no jTextTelefone
    public String getTelefone() {
        return jTextTelefone.getText();
    }

    //Metodo para preencher uma String no jTextTelefone
    public void setTelefone(String jTextTelefone) {
        this.jTextTelefone.setText(jTextTelefone);
    }

    //Metodo que retorna uma String preenchida no jTextEndereco
    public String getEndereco() {
        return jTextEndereco.getText();
    }

    //Metodo para preencher uma String no jTextEndereco
    public void setEndereco(String jTextEndereco) {
        this.jTextEndereco.setText(jTextEndereco);
    }

    //Metodo para adicionar um ouvidor de ações nos botoes
    public void addButtonListener(ActionListener actionListener) {
        btnCadastrar.addActionListener(actionListener);
        btnEditar.addActionListener(actionListener);
        btnDeletar.addActionListener(actionListener);
        btnLimpar.addActionListener(actionListener);
    }

    //Metodo para adicionar um ouvidor de mouse na tabela
    public void addTableListener(MouseListener mouseListener) {
        jTableArtistas.addMouseListener(mouseListener);
    }

    //Metodo que retorna um DefaultTableModel (implementação de TableModel) que fornece os dados da jTableArtistas
    public DefaultTableModel getTableM() {
        return (DefaultTableModel) jTableArtistas.getModel();
    }

    //Metodo para setar a ordenação de linhas da jTableArtistas
    public void setRS(DefaultTableModel model) {
        this.jTableArtistas.setRowSorter(new TableRowSorter(model));
    }

    //Metodo que retorna a JTable jTableArtistas
    public JTable getTable() {
        return jTableArtistas;
    }

}
