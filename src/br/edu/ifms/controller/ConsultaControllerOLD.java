package br.edu.ifms.controller;

import br.edu.ifms.dao.DaoGenerico;
import br.edu.ifms.model.Album;
import br.edu.ifms.model.Musica;
import br.edu.ifms.view.ConsultaAlbumView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class ConsultaControllerOLD {

    private Album album;
    private ConsultaAlbumView consultaAlbumView;

    public ConsultaControllerOLD(Album album, ConsultaAlbumView consultaAlbumView) {
        this.album = album;
        this.consultaAlbumView = consultaAlbumView;
        this.consultaAlbumView.addComboBoxListener(new ComboListener());
        popular();
    }

    private void popular() {
        DefaultComboBoxModel cmbArtModel = (DefaultComboBoxModel) consultaAlbumView.JComboBoxAlbum.getModel();
        consultaAlbumView.JComboBoxAlbum.removeAllItems();
        DaoGenerico<Album> albumDao = new DaoGenerico<>();
        consultaAlbumView.JComboBoxAlbum.addItem("Selecione...");
        for (Album a : albumDao.listaTodos(Album.class)) {
            cmbArtModel.addElement(a);
        }
    }

    private void listar() {
        if (consultaAlbumView.JComboBoxAlbum.getModel().getSelectedItem() == "Selecione...") {
            System.out.println("nada");
        } else {            
            Album a = (Album) consultaAlbumView.JComboBoxAlbum.getModel().getSelectedItem();            
            DefaultTableModel model = (DefaultTableModel) consultaAlbumView.getTableM();
            model.setNumRows(0);
            DaoGenerico<Musica> daoMusica = new DaoGenerico<>();
            System.out.println(a.getId());
            /*
            for (Musica m : daoMusica.findByForeignKey(Musica.class, a.getId(), "idalbum")) {
                model.addRow(new Object[]{
                    m.getId(),
                    m.getMusica(),
                    m.getArtista(),
                    m.getCompositor()
                });
            }*/
        }
    }

    public class ComboListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == consultaAlbumView.JComboBoxAlbum) {
                listar();
            }
        }
    }
}
