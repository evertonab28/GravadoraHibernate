package br.edu.ifms.view;

import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;

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

        ImageIcon icon = new ImageIcon(getClass().getResource("/br/edu/ifms/images/fundo.jpg"));
        Image image = icon.getImage();
        jDesktopPane1 = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuUsuario = new javax.swing.JMenuItem();
        jMenuAlbum = new javax.swing.JMenuItem();
        jMenuArtista = new javax.swing.JMenuItem();
        jMenuCompositor = new javax.swing.JMenuItem();
        jMenuMusica = new javax.swing.JMenuItem();
        jMenuConsultar = new javax.swing.JMenu();
        jMenuConsAlbum = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");

        jDesktopPane1.setLayout(new java.awt.FlowLayout());

        jMenuBar1.setMinimumSize(new java.awt.Dimension(300, 300));

        jMenu1.setText("Cadastro");

        jMenuUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.CTRL_MASK));
        jMenuUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifms/icons/adicionar-usuário-masculino-25.png"))); // NOI18N
        jMenuUsuario.setText("Usuários");
        jMenu1.add(jMenuUsuario);

        jMenuAlbum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifms/icons/Music.png"))); // NOI18N
        jMenuAlbum.setText("Álbuns");
        jMenu1.add(jMenuAlbum);

        jMenuArtista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifms/icons/Microphone-icon.png"))); // NOI18N
        jMenuArtista.setText("Artistas");
        jMenu1.add(jMenuArtista);

        jMenuCompositor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifms/icons/document-audio-icon.png"))); // NOI18N
        jMenuCompositor.setText("Compositores");
        jMenu1.add(jMenuCompositor);

        jMenuMusica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifms/icons/Audio_Cd.png"))); // NOI18N
        jMenuMusica.setText("Músicas");
        jMenu1.add(jMenuMusica);

        jMenuBar1.add(jMenu1);

        jMenuConsultar.setText("Consultar");

        jMenuConsAlbum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifms/icons/Music.png"))); // NOI18N
        jMenuConsAlbum.setText("Albuns");
        jMenuConsultar.add(jMenuConsAlbum);

        jMenuBar1.add(jMenuConsultar);

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
    public javax.swing.JMenuItem jMenuAlbum;
    public javax.swing.JMenuItem jMenuArtista;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuCompositor;
    public javax.swing.JMenuItem jMenuConsAlbum;
    private javax.swing.JMenu jMenuConsultar;
    private javax.swing.JMenuItem jMenuItem2;
    public javax.swing.JMenuItem jMenuMusica;
    public javax.swing.JMenuItem jMenuUsuario;
    // End of variables declaration//GEN-END:variables

    public void addActionMenu(ActionListener ActionMenu) {
        jMenuUsuario.addActionListener(ActionMenu);
        jMenuAlbum.addActionListener(ActionMenu);
        jMenuArtista.addActionListener(ActionMenu);
        jMenuCompositor.addActionListener(ActionMenu);
        jMenuMusica.addActionListener(ActionMenu);
        jMenuConsAlbum.addActionListener(ActionMenu);
    }

}
