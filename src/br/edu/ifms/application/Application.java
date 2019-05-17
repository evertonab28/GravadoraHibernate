package br.edu.ifms.application;

import br.edu.ifms.controller.LoginController;
import br.edu.ifms.model.Usuario;
import br.edu.ifms.view.LoginView;
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

        LoginController controller = new LoginController(usuario, loginView);
        loginView.setLocationRelativeTo(null);
        loginView.setVisible(true);
    }

}
