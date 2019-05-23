package br.edu.ifms.controller;

import br.edu.ifms.dao.DaoGenerico;
import br.edu.ifms.model.Album;
import br.edu.ifms.model.Artista;
import br.edu.ifms.model.Musica;
import br.edu.ifms.view.ConsultaAlbumView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ConsultaAlbumControllerOLD {

    private Album album;
    private ConsultaAlbumView consAlbView;

    public ConsultaAlbumControllerOLD(Album album, ConsultaAlbumView consAlbView) {
        this.album = album;
        this.consAlbView = consAlbView;
        this.consAlbView.addComboBoxListener(new JComboBoxListener());
        //DefaultTableModel model = this.consAlbView.getTableM();
        //this.consAlbView.getTable().setRowSorter(new TableRowSorter(model));
        //populaComboBoxAlbum();
        popula();
    }

    /*
    public void populaComboBoxAlbum() {
        DefaultComboBoxModel cmbAlbModel = (DefaultComboBoxModel) consAlbView.getComboBoxModel();

        consAlbView.getComboBox().removeAllItems();
        DaoGenerico<Album> albumDao = new DaoGenerico<>();
        consAlbView.getComboBox().addItem("Selecione...");
        for (Album a : albumDao.listaTodos(Album.class)) {
           // cmbAlbModel.addElement(a);
           consAlbView.getComboBox().addItem(a.getAlbum().toString());
        }
    }*/
 /*
    public void populaComboBoxAlbum() {

        DefaultComboBoxModel cmbAlbModel = (DefaultComboBoxModel) consAlbView.JComboBoxAlbum.getModel();
        consAlbView.JComboBoxAlbum.removeAllItems();

        DaoGenerico<Album> albumDao = new DaoGenerico<>();
        consAlbView.JComboBoxAlbum.addItem("Selecione...");
        for (Album a : albumDao.listaTodos(Album.class)) {
            cmbAlbModel.addElement(a);
        }
    }
     */
    private void popula() {
        DefaultComboBoxModel combo = (DefaultComboBoxModel) consAlbView.JComboBoxAlbum.getModel();
        consAlbView.JComboBoxAlbum.removeAllItems();
        
        DaoGenerico<Artista> art = new DaoGenerico<>();
        consAlbView.JComboBoxAlbum.addItem("Selecione...");
        for(Artista a : art.listaTodos(Artista.class)){
            combo.addElement(a);
        }
    }

    private void mostrarMusicas() {
        if (consAlbView.JComboBoxAlbum.getSelectedItem() != "Selecione...") {
            //Album a = (Album) consAlbView.JComboBoxAlbum.getSelectedItem();
            
            //System.out.println(a.getId());
            
            Artista a = (Artista) consAlbView.JComboBoxAlbum.getSelectedItem();
            System.out.println(a.getId());
        }
    }

    /*
    private void mostraMusicasAlbum() {

        if (consAlbView.getComboBox().getSelectedItem() != "Selecione...") {            
            //Album a = (Album) consAlbView.getComboBox().getSelectedItem();
            //Album a = (Album) consAlbView.JComboBoxAlbum.getSelectedItem();
            DefaultTableModel model = consAlbView.getTableM(); 
            model.setNumRows(0);            
            DaoGenerico<Musica> musicaDao = new DaoGenerico<>();   
            System.out.println(consAlbView.JComboBoxAlbum.getSelectedItem());
            
            for (Musica m : musicaDao.findByForeignKey(Musica.class, a.getId(), "idalbum")) {
                model.addRow(new Object[]{
                    m.getId(),
                    m.getMusica(),
                    m.getArtista(),
                    m.getCompositor()
                });
            }
        }
    }
     */
    public class JComboBoxListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            //if (consAlbView.getComboBox() == ae.getSource()) {                
            if (consAlbView.JComboBoxAlbum == ae.getSource()) {
                //mostraMusicasAlbum();
                mostrarMusicas();
            }

        }
    }

}
