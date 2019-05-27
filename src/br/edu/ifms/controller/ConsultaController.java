package br.edu.ifms.controller;

import br.edu.ifms.dao.DaoGenerico;
import br.edu.ifms.model.Album;
import br.edu.ifms.model.Musica;
import br.edu.ifms.view.ConsultaAlbumView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class ConsultaController {

    private Album album;
    private ConsultaAlbumView consultaAlbumView;

    public ConsultaController(Album album, ConsultaAlbumView consultaAlbumView) {
        this.album = album;
        this.consultaAlbumView = consultaAlbumView;
        popular();
        this.consultaAlbumView.addComboBoxListener(new ComboListener());
    }

    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) consultaAlbumView.getTableM();
        model.setNumRows(0);
        DaoGenerico<Musica> daoMusica = new DaoGenerico<>();

        for (Musica m : daoMusica.listaTodos(Musica.class)) {
            model.addRow(new Object[]{
                m.getId(),
                m.getMusica(),
                m.getArtista(),
                m.getCompositor(),                
            });
        }
    }

    //Metodo para popular o comboBox
    private void popular() {

        DefaultComboBoxModel cmbArtModel = (DefaultComboBoxModel) consultaAlbumView.getComboBoxModel();
        consultaAlbumView.getComboBox().removeAllItems();
        DaoGenerico<Album> albumDao = new DaoGenerico<>();
        consultaAlbumView.getComboBox().addItem("Selecione...");
        for (Album a : albumDao.listaTodos(Album.class)) {
            cmbArtModel.addElement(a);
        }
    }

    //Metodo para exibir na tabela as musicas do Album selecionado no comboBox
    private void listar() {
        if (consultaAlbumView.getComboBox().getModel().getSelectedItem() == "Selecione...") {

        } else {
            Album a = (Album) consultaAlbumView.getComboBox().getSelectedItem();
            DefaultTableModel model = (DefaultTableModel) consultaAlbumView.getTableM();
            model.setNumRows(0);
            DaoGenerico<Musica> daoMusica = new DaoGenerico<>();
            for (Musica m : daoMusica.findByForeignKey(Musica.class, a.getId(), "idalbum")) {
                model.addRow(new Object[]{
                    m.getId(),
                    m.getMusica(),
                    m.getArtista(),
                    m.getCompositor()
                });
            }
        }
    }

    public class ComboListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == consultaAlbumView.getComboBox()) {
                listar();
            }
        }
    }
}
