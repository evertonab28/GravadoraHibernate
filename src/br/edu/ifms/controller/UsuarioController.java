package br.edu.ifms.controller;

import br.edu.ifms.dao.UsuarioDAO;
import br.edu.ifms.exception.BusinessException;
import br.edu.ifms.model.Usuario;
import br.edu.ifms.view.LoginView;
import br.edu.ifms.view.PrincipalView;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UsuarioController {

    private Usuario usuario;
    private LoginView loginView;
    private PrincipalView formPrincipal;

    public UsuarioController(Usuario usuario, LoginView view) {
        this.usuario = usuario;
        this.loginView = view;

        this.loginView.addListenerLogin(new ListenerLogin());
    }
//
//    public void efetuarLogin(Usuario usuario) throws BusinessException {
//        UsuarioDao loginDao = new UsuarioDao();
//        Usuario logado = loginDao.findByLoginSenha(usuario.getLogin(), usuario.getSenha());
//
//        if (logado == null) {
//            throw new BusinessException("Usuário e/ou senha inválidos!");
//        }
//    }

    public void startLogin() {
        loginView.setTitle("Login");
        loginView.pack();
        loginView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginView.setLocationRelativeTo(null);
        loginView.setVisible(true);
    }

    public void startFormPrincipal() {
        formPrincipal = new PrincipalView();
        formPrincipal.setTitle("EW Records System 2.0");
        formPrincipal.setVisible(true);
    }

    public class ListenerLogin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
//            UsuarioDao loginDao = new UsuarioDao();
//            Usuario logado = loginDao.findByLoginSenha(loginView.getLogin(), loginView.getSenha());
//
//            if (logado == null) {
//                JOptionPane.showMessageDialog(loginView, "Usuario/Senha inválido",
//                        "Login", JOptionPane.PLAIN_MESSAGE);
//            } else {
//                JOptionPane.showMessageDialog(loginView, "Login efetuado", "Login",
//                        JOptionPane.PLAIN_MESSAGE);
//                        loginView.dispose();
//                        startFormPrincipal();
//            }

            UsuarioDAO usuarioDao = new UsuarioDAO();
            usuario = usuarioDao.findByLoginSenha(loginView.getLogin(), loginView.getSenha());
            if (usuario == null) {
                JOptionPane.showMessageDialog(loginView, "Usuario/Senha inválido",
                        "Login", JOptionPane.PLAIN_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(loginView, "Login efetuado", "Login",
                        JOptionPane.PLAIN_MESSAGE);
                        loginView.dispose();
                        startFormPrincipal();
            }

        }

    }

}
