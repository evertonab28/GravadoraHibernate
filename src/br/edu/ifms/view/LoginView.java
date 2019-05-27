package br.edu.ifms.view;

import java.awt.event.ActionListener;

public class LoginView extends javax.swing.JFrame {

    public LoginView() {
        initComponents();
        this.setTitle("Login");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextLogin = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jLoginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(350, 250));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Login");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 50, -1, -1));

        jLabel2.setText("Senha");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 88, -1, -1));
        getContentPane().add(jTextLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 47, 126, -1));
        getContentPane().add(jPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 85, 124, -1));

        jLoginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifms/icons/Unlock.png"))); // NOI18N
        jLoginButton.setText("Login");
        getContentPane().add(jLoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jLoginButton;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextLogin;
    // End of variables declaration//GEN-END:variables

    public String getLogin() {
        return jTextLogin.getText();
    }

    public String getSenha() {
        return jPasswordField.getText();
    }

    public void addListenerLogin(ActionListener loginListener) {
        jLoginButton.addActionListener(loginListener);
    }

}
