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

public class UsuarioController {

    private Usuario usuario;
    private UsuarioView usuarioView;

    public UsuarioController(Usuario usuario, UsuarioView usuarioView) {
        this.usuario = usuario;
        this.usuarioView = usuarioView;
    }
    
 
//
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
    
    public class ListenerCadastrar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
        }
        
        
    }

}
