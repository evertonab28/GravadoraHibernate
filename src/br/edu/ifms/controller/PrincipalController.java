package br.edu.ifms.controller;

import br.edu.ifms.model.Album;
import br.edu.ifms.model.Usuario;
import br.edu.ifms.view.AlbumView;
import br.edu.ifms.view.PrincipalView;
import br.edu.ifms.view.UsuarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class PrincipalController {

    private PrincipalView pView;
    private UsuarioView usuarioView;
    private AlbumView albumView;

    public PrincipalController(PrincipalView pView) {
        this.pView = pView;
        this.pView.addActionMenu(new ActionMenu());
    }

    public class ActionMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (ae.getSource() == pView.jMenuUsuario) {
                usuarioView = new UsuarioView();
                Usuario usuario = new Usuario();
                UsuarioController usuarioCtrl = new UsuarioController(usuario, usuarioView);
                pView.jDesktopPane1.add(usuarioView);
                usuarioView.setVisible(true);

            }
            if (ae.getSource() == pView.jMenuAlbum) {
                albumView = new AlbumView();
                Album album = new Album();
                AlbumController albumCtrl = new AlbumController(album, albumView);
                pView.jDesktopPane1.add(albumView);
                albumView.setVisible(true);
            }
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
