package br.edu.ifms.view;

import java.awt.event.ActionListener;

public class PrincipalView extends javax.swing.JFrame {

    public PrincipalView() {

        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setResizable(true);
        this.setTitle("EW Records System 2.0");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuUsuario = new javax.swing.JMenuItem();
        jMenuAlbum = new javax.swing.JMenuItem();
        jMenuArtista = new javax.swing.JMenuItem();
        jMenuCompositor = new javax.swing.JMenuItem();
        jMenuMusica = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");

        jDesktopPane1.setLayout(new java.awt.FlowLayout());

        jMenuBar1.setMinimumSize(new java.awt.Dimension(300, 300));

        jMenu1.setText("Cadastro");

        jMenuUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.CTRL_MASK));
        jMenuUsuario.setText("Usuários");
        jMenu1.add(jMenuUsuario);

        jMenuAlbum.setText("Álbuns");
        jMenu1.add(jMenuAlbum);

        jMenuArtista.setText("Artistas");
        jMenu1.add(jMenuArtista);

        jMenuCompositor.setText("Compositores");
        jMenu1.add(jMenuCompositor);

        jMenuMusica.setText("Músicas");
        jMenu1.add(jMenuMusica);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Consultar");

        jMenuItem7.setText("Musicas");
        jMenu3.add(jMenuItem7);

        jMenuItem8.setText("Musicas Layout");
        jMenu3.add(jMenuItem8);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Opções");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Sair");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    public javax.swing.JMenuItem jMenuAlbum;
    public javax.swing.JMenuItem jMenuArtista;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuCompositor;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    public javax.swing.JMenuItem jMenuMusica;
    public javax.swing.JMenuItem jMenuUsuario;
    // End of variables declaration//GEN-END:variables

    public void addActionMenu(ActionListener ActionMenu) {
        jMenuUsuario.addActionListener(ActionMenu);
        jMenuAlbum.addActionListener(ActionMenu);
        jMenuArtista.addActionListener(ActionMenu);
        jMenuCompositor.addActionListener(ActionMenu);
        jMenuMusica.addActionListener(ActionMenu);
    }

}
