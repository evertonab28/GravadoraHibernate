package br.edu.ifms.controller;

import br.edu.ifms.dao.DaoGenerico;
import br.edu.ifms.model.Album;
import br.edu.ifms.view.AlbumView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class AlbumController {

    private Album album;
    private AlbumView albumView;

    public AlbumController(Album album, AlbumView albumView) {
        this.album = album;
        this.albumView = albumView;
        this.albumView.JXDateDataLancamento.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
        this.albumView.JXDateDataLancamento.setDate(Calendar.getInstance().getTime());
        this.albumView.addButtonListener(new ButtonListener());
        this.albumView.addTableListener(new TableListener());
        DefaultTableModel model = (DefaultTableModel) this.albumView.jTableAlbuns.getModel();
        this.albumView.jTableAlbuns.setRowSorter(new TableRowSorter(model));
        fillTable();

    }

    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) albumView.jTableAlbuns.getModel();
        model.setNumRows(0);
        DaoGenerico<Album> daoAlbum = new DaoGenerico<>();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for (Album a : daoAlbum.listaTodos(Album.class)) {
            model.addRow(new Object[]{
                a.getId(),
                a.getAlbum(),
                df.format(a.getDatalancamento()), //a.getDatalancamento()
            });
        }
    }

    public void clearFields() {
        albumView.setAlbum("");
        albumView.setDate(Calendar.getInstance().getTime());
    }

    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == albumView.btnCadastrar) {
                cadastrarAlbum();
            }
            if (ae.getSource() == albumView.btnEditar) {
                editarAlbum();
            }
            if (ae.getSource() == albumView.btnDeletar) {
                deletarAlbum();
            }
            if (ae.getSource() == albumView.btnLimpar) {
                clearFields();
            }
        }

    }

    public void cadastrarAlbum() {
        album = new Album();
        DaoGenerico<Album> daoAlbum = new DaoGenerico<>();

        if (albumView.getAlbum().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o nome do album!");
        } else {
            album.setAlbum(albumView.getAlbum());
            album.setDatalancamento(albumView.getDate());
            daoAlbum.saveOrUpdate(album);

            clearFields();
            fillTable();
        }
    }

    public void editarAlbum() {
        if (albumView.jTableAlbuns.getSelectedRow() != -1) {
            album = new Album();
            DaoGenerico<Album> daoAlbum = new DaoGenerico<>();

            album.setAlbum(albumView.getAlbum());
            album.setDatalancamento(albumView.getDate());
            album.setId((long) albumView.jTableAlbuns.getValueAt(albumView.jTableAlbuns.getSelectedRow(), 0));
            daoAlbum.saveOrUpdate(album);

            clearFields();
            fillTable();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione algum album!");
        }
    }

    public void deletarAlbum() {
        if (albumView.jTableAlbuns.getSelectedRow() != -1) {

            album = new Album();
            DaoGenerico<Album> daoAlbum = new DaoGenerico<>();
            album.setId((long) albumView.jTableAlbuns.getValueAt(albumView.jTableAlbuns.getSelectedRow(), 0));

            daoAlbum.remove(Album.class, album.getId());
            clearFields();
            fillTable();
            JOptionPane.showMessageDialog(null, "Album deletado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione algum album para deletar!");
        }
    }

    public class TableListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            if (albumView.jTableAlbuns == me.getSource()) {
                if (albumView.jTableAlbuns.getSelectedRow() != -1) {
                    int selected = albumView.jTableAlbuns.getSelectedRow();

                    albumView.setAlbum(albumView.jTableAlbuns.getValueAt(selected, 1).toString());
                    albumView.setDate((Date) albumView.jTableAlbuns.getValueAt(selected, 2));
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
            if (albumView.jTableAlbuns == me.getSource()) {
                if (albumView.jTableAlbuns.getSelectedRow() != -1) {
                    int selected = albumView.jTableAlbuns.getSelectedRow();

                    albumView.setAlbum(albumView.jTableAlbuns.getValueAt(selected, 1).toString());

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        Date data = sdf.parse(albumView.jTableAlbuns.getValueAt(selected, 2).toString());
                        albumView.setDate(data);
                        //albumView.setDate((Date) albumView.jTableAlbuns.getValueAt(selected, 2));
                    } catch (ParseException ex) {
                        Logger.getLogger(AlbumController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            System.out.println("");
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            System.out.println("");
        }

        @Override
        public void mouseExited(MouseEvent me) {
            System.out.println("");
        }

    }

}
