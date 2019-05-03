package br.edu.ifms.controller;

import br.edu.ifms.dao.UsuarioDAO;
import br.edu.ifms.model.Usuario;
import br.edu.ifms.view.PrincipalView;
import br.edu.ifms.view.UsuarioView;


public class UsuarioController {

    private Usuario usuario;
    private UsuarioView usuarioView;
    private PrincipalView formPrincipal;

    public UsuarioController(Usuario usuario, UsuarioView usuarioView) {
        this.usuario = usuario;
        this.usuarioView = usuarioView;
    }

//    public void startUsuarioView(){
//        
//        formPrincipal.jDesktopPane1.add(usuarioView);
//        UsuarioView();
//    }
//    
//    public void UsuarioViewTable() {
//        UsuarioTableModel tableModel = new UsuarioTableModel();
//        usuarioView.tblUsuarios.setModel(tableModel);
//
//    }
//    
//    public class ListenerCadastrar implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent ae) {
//            startUsuarioView();
//        }
//        
//        
//    }

}
