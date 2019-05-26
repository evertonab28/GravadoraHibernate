package br.edu.ifms.controller;

import br.edu.ifms.dao.DaoGenerico;
import br.edu.ifms.model.Artista;
import br.edu.ifms.view.ArtistaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ArtistaController {

    private Artista artista;
    private ArtistaView artistaView;

    public ArtistaController(Artista artista, ArtistaView artistaView) {
        this.artista = artista;
        this.artistaView = artistaView;
        this.artistaView.addButtonListener(new ButtonListener());
        this.artistaView.addTableListener(new TableListener());
        DefaultTableModel model = (DefaultTableModel) this.artistaView.getTableM();
        this.artistaView.getTable().setRowSorter(new TableRowSorter(model));
        fillTable();
    }

    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) artistaView.getTableM();
        model.setNumRows(0);
        DaoGenerico<Artista> daoArtista = new DaoGenerico<>();
        for (Artista a : daoArtista.listaTodos(Artista.class)) {
            model.addRow(new Object[]{
                a.getId(),
                a.getNomeArtista(),
                a.getTelefoneArtista(),
                a.getEnderecoArtista()
            });
        }
    }

    public void clearFields() {
        artistaView.setArtista("");
        artistaView.setTelefone("");
        artistaView.setEndereco("");
    }

    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == artistaView.btnCadastrar) {
                cadastrarArtista();
            }
            if (ae.getSource() == artistaView.btnEditar) {
                editarArtista();
            }
            if (ae.getSource() == artistaView.btnDeletar) {
                deletarArtista();
            }
            if (ae.getSource() == artistaView.btnLimpar) {
                clearFields();
            }
        }
    }

    public void cadastrarArtista() {
        artista = new Artista();
        DaoGenerico<Artista> daoArtista = new DaoGenerico<>();
        if (artistaView.getArtista().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o nome do artista!");
        } else {
            artista.setNomeArtista(artistaView.getArtista());
            artista.setTelefoneArtista(artistaView.getTelefone());
            artista.setEnderecoArtista(artistaView.getEndereco());
            daoArtista.saveOrUpdate(artista);
            clearFields();
            fillTable();
            JOptionPane.showMessageDialog(null, "Artista cadastrado com sucesso!");
        }
    }

    public void editarArtista() {
        if (artistaView.getTable().getSelectedRow() != -1) {
            artista = new Artista();
            DaoGenerico<Artista> daoArtista = new DaoGenerico<>();
            if (artistaView.getArtista().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo nome não pode estar vazio!");
            } else {
                artista.setNomeArtista(artistaView.getArtista());
                artista.setTelefoneArtista(artistaView.getTelefone());
                artista.setEnderecoArtista(artistaView.getEndereco());
                artista.setId((long) artistaView.getTable().getValueAt(artistaView.getTable().getSelectedRow(), 0));
                daoArtista.saveOrUpdate(artista);
                clearFields();
                fillTable();
                JOptionPane.showMessageDialog(null, "Artista editado com sucesso!");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione algum artista!");
        }
    }

    public void deletarArtista() {
        if (artistaView.getTable().getSelectedRow() != -1) {
            artista = new Artista();
            DaoGenerico<Artista> daoArtista = new DaoGenerico<>();
            artista.setId((long) artistaView.getTable().getValueAt(artistaView.getTable().getSelectedRow(), 0));
            daoArtista.remove(Artista.class, artista.getId());
            clearFields();
            fillTable();
            JOptionPane.showMessageDialog(null, "Artista deletado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione algum Artista para deletar!");
        }
    }

    public class TableListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            if (artistaView.getTable() == me.getSource()) {
                if (artistaView.getTable().getSelectedRow() != -1) {
                    int selected = artistaView.getTable().getSelectedRow();
                    artistaView.setArtista(artistaView.getTable().getValueAt(selected, 1).toString());
                    artistaView.setTelefone(artistaView.getTable().getValueAt(selected, 2).toString());
                    artistaView.setEndereco(artistaView.getTable().getValueAt(selected, 3).toString());
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
            if (artistaView.getTable() == me.getSource()) {
                if (artistaView.getTable().getSelectedRow() != -1) {
                    int selected = artistaView.getTable().getSelectedRow();
                    artistaView.setArtista(artistaView.getTable().getValueAt(selected, 1).toString());
                    artistaView.setTelefone(artistaView.getTable().getValueAt(selected, 2).toString());
                    artistaView.setEndereco(artistaView.getTable().getValueAt(selected, 3).toString());
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
