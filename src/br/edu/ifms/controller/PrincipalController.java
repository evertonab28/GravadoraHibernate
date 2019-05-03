package br.edu.ifms.controller;

import br.edu.ifms.model.Usuario;
import br.edu.ifms.view.PrincipalView;
import br.edu.ifms.view.UsuarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class PrincipalController {

    private PrincipalView pView;
    private UsuarioView usuarioView;

    public PrincipalController(PrincipalView pView) {
        this.pView = pView;
        this.pView.addActionMenu(new ActionMenu());
        System.out.println("CONTROLLER INICIADO");

//        formPrincipal.setTitle("EW Records System 2.0");
//        formPrincipal.setVisible(true);
    }

    public class ActionMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (ae.getSource() == pView.jMenuUsuario) {
                System.out.println("Usuario OK!");
                usuarioView = new UsuarioView();
                Usuario usuario = new Usuario();
                UsuarioController usuarioCtrl = new UsuarioController(usuario, usuarioView);
                pView.jDesktopPane1.add(usuarioView);
                usuarioCtrl.UsuarioViewTable();

            }
//            if (ae.getSource() == pView.jMenuAlbum) {
//
//            }
//            if (ae.getSource() == pView.jMenuArtista) {
//
//            }
//            if (ae.getSource() == pView.jMenuCompositor) {
//
//            }
//            if (ae.getSource() == pView.jMenuMusica) {
//
//            }

        }

    }

//    @Override
    //public void actionPerformed(ActionEvent ae) {
}
