package br.edu.ifms.controller;

import br.edu.ifms.dao.UsuarioDAO;
import br.edu.ifms.model.Usuario;
import br.edu.ifms.tablemodel.UsuarioTableModel;
import br.edu.ifms.view.LoginView;
import br.edu.ifms.view.PrincipalView;
import br.edu.ifms.view.UsuarioView;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class LoginController {

    private Usuario usuario;
    private LoginView loginView;
    //private PrincipalView formPrincipal;
    private UsuarioView usuarioView;

    public LoginController(Usuario usuario, LoginView view) {
        this.usuario = usuario;
        this.loginView = view;
        this.loginView.addListenerLogin(new ListenerLogin());

    }

    public void startLogin() {
        loginView.setTitle("Login");
        loginView.pack();
        loginView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginView.setLocationRelativeTo(null);
        loginView.setVisible(true);
    }

    public void startFormPrincipal() {

        PrincipalView formPrincipal = new PrincipalView();
        PrincipalController pc = new PrincipalController(formPrincipal);
        formPrincipal.setVisible(true);

    }

//    public void startUsuarioView(){
//        
//        formPrincipal.jDesktopPane1.add(usuarioView);
//        UsuarioView();
//    }
//    
//    public void UsuarioView() {
//        UsuarioTableModel tableModel = new UsuarioTableModel();
//        usuarioView.tblUsuarios.setModel(tableModel);
//
//    }
    public class ListenerLogin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            UsuarioDAO usuarioDao = new UsuarioDAO();
            usuario = usuarioDao.findByLoginSenha(loginView.getLogin(), loginView.getSenha());
            if (usuario == null) {
                JOptionPane.showMessageDialog(loginView, "Usuario/Senha inválido",
                        "Login", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(loginView, "Login efetuado", "Login",
                        JOptionPane.PLAIN_MESSAGE);
                loginView.dispose();
                startFormPrincipal();
            }

        }

    }

//    public class ListenerUsuarioView implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent ae) {
//            startUsuarioView();
//        }
//        
//        
//    }
}
