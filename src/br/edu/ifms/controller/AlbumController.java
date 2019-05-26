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

    //Construtor do AlbumController, passando um album do tipo Album e uma AlbumView
    //O formato de data é definido como DIA/MES/ANO e definida a data de hoje        
    public AlbumController(Album album, AlbumView albumView) {
        this.album = album;
        this.albumView = albumView;
        this.albumView.JXDateDataLancamento.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
        this.albumView.JXDateDataLancamento.setDate(Calendar.getInstance().getTime());
        //ActionListener dos botões e da tabela
        this.albumView.addButtonListener(new ButtonListener());
        this.albumView.addTableListener(new TableListener());
        //Definido o modelo da tabela como AbstractTableModel
        DefaultTableModel model = (DefaultTableModel) this.albumView.getTableM();
        //Definindo ordenação para a tabela
        this.albumView.getTable().setRowSorter(new TableRowSorter(model));
        //metodo para preencher a tabela com uma lista de albuns
        fillTable();

    }

    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) albumView.getTableM();
        model.setNumRows(0);
        DaoGenerico<Album> daoAlbum = new DaoGenerico<>();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for (Album a : daoAlbum.listaTodos(Album.class)) {
            model.addRow(new Object[]{
                a.getId(),
                a.getAlbum(),
                df.format(a.getDatalancamento())
            });
        }
    }

    //Metodo para limpar os campos
    public void clearFields() {
        albumView.setAlbum("");
        albumView.setDate(Calendar.getInstance().getTime());
    }

    //Classe que implementa um ActionListener para os botões da view
    public class ButtonListener implements ActionListener {

        //Verifica qual a fonte do evento
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

    //Metodo para cadastro de um novo album
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
            JOptionPane.showMessageDialog(null, "Album cadastrado com sucesso!");
        }
    }

    //Metodo para edicao de um album selecionado na tabela
    public void editarAlbum() {
        
        //Verifica se algum album foi selecionado na tabela
        if (albumView.getTable().getSelectedRow() != -1) {
            album = new Album();
            DaoGenerico<Album> daoAlbum = new DaoGenerico<>();
            if (albumView.getAlbum().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo Album não pode estar vazio!");
            } else {
                //Seta os atributos do Album e salva no banco, limpa os campos e atualiza a tabela
                album.setAlbum(albumView.getAlbum());
                album.setDatalancamento(albumView.getDate());
                album.setId((long) albumView.getTable().getValueAt(albumView.getTable().getSelectedRow(), 0));
                daoAlbum.saveOrUpdate(album);
                clearFields();
                fillTable();
                JOptionPane.showMessageDialog(null, "Album editado com sucesso!");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione algum album!");
        }
    }

    //Metodo para exclusao de um album selecionado na tabela
    public void deletarAlbum() {
        //Verifica se algum album foi selecionado na tabela
        if (albumView.getTable().getSelectedRow() != -1) {
            album = new Album();
            DaoGenerico<Album> daoAlbum = new DaoGenerico<>();
            //Seta o id do Album selecionado no tabela, faz a exclusao, limpa os campos e atualiza a tabela
            album.setId((long) albumView.getTable().getValueAt(albumView.getTable().getSelectedRow(), 0));
            daoAlbum.remove(Album.class, album.getId());
            clearFields();
            fillTable();
            JOptionPane.showMessageDialog(null, "Album deletado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione algum album para deletar!");
        }
    }

    //Classe que implementa um MouseListener e ouve um evento de clique na tabela
    //Se alguma linha for selecionada, os dados são preenchidos nos campos
    public class TableListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            if (albumView.getTable() == me.getSource()) {
                if (albumView.getTable().getSelectedRow() != -1) {
                    int selected = albumView.getTable().getSelectedRow();
                    albumView.setAlbum(albumView.getTable().getValueAt(selected, 1).toString());
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        Date data = sdf.parse(albumView.getTable().getValueAt(selected, 2).toString());                        
                        albumView.setDate(data);
                    } catch (ParseException ex) {
                        Logger.getLogger(AlbumController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
            if (albumView.getTable() == me.getSource()) {
                if (albumView.getTable().getSelectedRow() != -1) {
                    int selected = albumView.getTable().getSelectedRow();
                    albumView.setAlbum(albumView.getTable().getValueAt(selected, 1).toString());
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        Date data = sdf.parse(albumView.getTable().getValueAt(selected, 2).toString());
                        albumView.setDate(data);
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
