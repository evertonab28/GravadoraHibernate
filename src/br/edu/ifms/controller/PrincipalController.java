package br.edu.ifms.controller;

import br.edu.ifms.model.Album;
import br.edu.ifms.model.Artista;
import br.edu.ifms.model.Compositor;
import br.edu.ifms.model.Musica;
import br.edu.ifms.model.Usuario;
import br.edu.ifms.view.AlbumView;
import br.edu.ifms.view.ArtistaView;
import br.edu.ifms.view.CompositorView;
import br.edu.ifms.view.ConsultaAlbumView;
import br.edu.ifms.view.MusicaView;
import br.edu.ifms.view.PrincipalView;
import br.edu.ifms.view.UsuarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalController {

    private PrincipalView pView;
    private UsuarioView usuarioView;
    private AlbumView albumView;
    private ArtistaView artistaView;
    private CompositorView compositorView;
    private MusicaView musicaView;
    private ConsultaAlbumView consAlbView;

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
            if (ae.getSource() == pView.jMenuArtista) {
                artistaView = new ArtistaView();
                Artista artista = new Artista();
                ArtistaController artistaCtrl = new ArtistaController(artista, artistaView);
                pView.jDesktopPane1.add(artistaView);
                artistaView.setVisible(true);
            }
            if (ae.getSource() == pView.jMenuCompositor) {
                compositorView = new CompositorView();
                Compositor compositor = new Compositor();
                CompositorController compositorCtrl = new CompositorController(compositor, compositorView);
                pView.jDesktopPane1.add(compositorView);
                compositorView.setVisible(true);
            }
            if (ae.getSource() == pView.jMenuMusica) {
                musicaView = new MusicaView();
                Musica musica = new Musica();
                MusicaController musicaCtrl = new MusicaController(musica, musicaView);
                pView.jDesktopPane1.add(musicaView);
                musicaView.setVisible(true);
            }

            if (ae.getSource() == pView.jMenuConsAlbum) {
                consAlbView = new ConsultaAlbumView();
                Album album = new Album();
                //ConsultaAlbumControllerOLD consAlbCtrl = new ConsultaAlbumControllerOLD(album, consAlbView);                         
                ConsultaController ctrl = new ConsultaController(album, consAlbView);
                pView.jDesktopPane1.add(consAlbView);
                consAlbView.setVisible(true);
            }

        }

    }

}
