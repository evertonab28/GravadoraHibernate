package br.edu.ifms.controller;

import br.edu.ifms.dao.DaoGenerico;
import br.edu.ifms.model.Album;
import br.edu.ifms.view.ConsultaAlbumView;
import javax.swing.DefaultComboBoxModel;

public class ConsultaAlbumController {

    private Album album;
    private ConsultaAlbumView consAlbView;

    public ConsultaAlbumController(Album album, ConsultaAlbumView consAlbView) {
        this.album = album;
        this.consAlbView = consAlbView;

        populaComboBoxAlbum();
    }

    public void populaComboBoxAlbum() {
        DefaultComboBoxModel cmbAlbModel = (DefaultComboBoxModel) consAlbView.ComboBoxAlbum.getModel();
        consAlbView.ComboBoxAlbum.removeAllItems();
        DaoGenerico<Album> albumDao = new DaoGenerico<>();
        consAlbView.ComboBoxAlbum.addItem("Selecione...");
        for (Album a : albumDao.listaTodos(Album.class)) {
            cmbAlbModel.addElement(a);
        }
    }

}
