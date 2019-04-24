package br.edu.ifms.view;

import br.edu.ifms.controller.UsuarioController;
import br.edu.ifms.model.Usuario;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Application {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        Usuario usuario = new Usuario();
        LoginView loginView = new LoginView();

        UsuarioController controller = new UsuarioController(usuario, loginView);
        loginView.setLocationRelativeTo(null);
        loginView.setVisible(true);
    }

}
