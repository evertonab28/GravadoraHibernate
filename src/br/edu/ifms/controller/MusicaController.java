package br.edu.ifms.controller;

import br.edu.ifms.dao.DaoGenerico;
import br.edu.ifms.model.Album;
import br.edu.ifms.model.Artista;
import br.edu.ifms.model.Compositor;
import br.edu.ifms.model.Musica;
import br.edu.ifms.view.MusicaView;
import br.edu.ifms.view.MusicaViewLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class MusicaController {

    private Musica musica;
    private MusicaView musicaView;

    //Construtor do MusicaController, passando um Musica e uma MusicaView
    public MusicaController(Musica musica, MusicaView musicaView) {
        this.musica = musica;
        this.musicaView = musicaView;
        //ActionListener dos botões e da tabela
        this.musicaView.addButtonListener(new ButtonListener());
        this.musicaView.addTableListener(new TableListener());
        //Definido o modelo da tabela como AbstractTableModel
        DefaultTableModel model = (DefaultTableModel) this.musicaView.getTableM();
        //Definindo ordenação para a tabela
        this.musicaView.getTable().setRowSorter(new TableRowSorter(model));
        populaComboBoxArtista();
        populaComboBoxCompositor();
        populaComboBoxAlbum();
        //metodo para preencher a tabela com uma lista de Musicas
        fillTable();
    }

    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) musicaView.getTableM();
        model.setNumRows(0);
        DaoGenerico<Musica> daoMusica = new DaoGenerico<>();
        for (Musica m : daoMusica.listaTodos(Musica.class)) {
            model.addRow(new Object[]{
                m.getId(),
                m.getMusica(),
                m.getArtista(),
                m.getCompositor(),
                m.getAlbum()
            });
        }
    }

    //Metodo para limpar os campos
    public void clearFields() {
        musicaView.setMusica("");
        populaComboBoxArtista();
        populaComboBoxCompositor();
        populaComboBoxAlbum();
    }

    //Classe que implementa um ActionListener para os botões da view
    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == musicaView.btnCadastrar) {
                cadastrarMusica();
            }
            if (ae.getSource() == musicaView.btnEditar) {
                editarMusica();
            }
            if (ae.getSource() == musicaView.btnDeletar) {
                deletarMusica();
            }
            if (ae.getSource() == musicaView.btnLimpar) {
                clearFields();
            }
        }
    }

    //Metodo para cadastro de uma nova Musica
    public void cadastrarMusica() {
        musica = new Musica();
        DaoGenerico<Musica> daoMusica = new DaoGenerico<>();
        if (musicaView.getMusica().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o nome da Música!");
        } else {
            if (musicaView.ComboBoxArtista.getModel().getSelectedItem() == "Selecione...") {
                JOptionPane.showMessageDialog(null, "Informe o Artista");
            } else {
                if (musicaView.ComboBoxCompositor.getModel().getSelectedItem() == "Selecione...") {
                    JOptionPane.showMessageDialog(null, "Informe o Compositor");
                } else {
                    if (musicaView.ComboBoxAlbum.getModel().getSelectedItem() == "Selecione...") {
                        JOptionPane.showMessageDialog(null, "Informe o Album");
                    } else {
                        musica.setMusica(musicaView.getMusica());
                        musica.setArtista((Artista) musicaView.ComboBoxArtista.getSelectedItem());
                        musica.setCompositor((Compositor) musicaView.ComboBoxCompositor.getSelectedItem());
                        musica.setAlbum((Album) musicaView.ComboBoxAlbum.getSelectedItem());
                        daoMusica.saveOrUpdate(musica);
                        clearFields();
                        fillTable();
                        JOptionPane.showMessageDialog(null, "Música cadastrada com sucesso!");
                    }
                }
            }
        }
    }

    //Metodo para edicao de uma Musica selecionada na tabela
    public void editarMusica() {
        //Verifica se alguma Musica foi selecionada na tabela
        if (musicaView.getTable().getSelectedRow() != -1) {
            musica = new Musica();
            DaoGenerico<Musica> daoMusica = new DaoGenerico<>();

            if (musicaView.getMusica().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo nome não pode estar vazio!");
            } else {
                //Seta os atributos da Musica e salva no banco, limpa os campos e atualiza a tabela
                musica.setMusica(musicaView.getMusica());
                musica.setArtista((Artista) musicaView.ComboBoxArtista.getSelectedItem());
                musica.setCompositor((Compositor) musicaView.ComboBoxCompositor.getSelectedItem());
                musica.setAlbum((Album) musicaView.ComboBoxAlbum.getSelectedItem());
                musica.setId((long) musicaView.getTable().getValueAt(musicaView.getTable().getSelectedRow(), 0));
                Album a = (Album) musicaView.ComboBoxAlbum.getSelectedItem();
                daoMusica.saveOrUpdate(musica);
                clearFields();
                fillTable();
                JOptionPane.showMessageDialog(null, "Música editada com sucesso!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione alguma Música!");
        }
    }

    //Metodo para exclusao de uma Musica selecionado na tabela
    public void deletarMusica() {
        //Verifica se alguma Musica foi selecionada na tabela
        if (musicaView.getTable().getSelectedRow() != -1) {
            musica = new Musica();
            DaoGenerico<Musica> daoMusica = new DaoGenerico<>();
            //Seta o id da Musica selecionada no tabela, faz a exclusao, limpa os campos e atualiza a tabela
            musica.setId((long) musicaView.getTable().getValueAt(musicaView.getTable().getSelectedRow(), 0));
            daoMusica.remove(Musica.class, musica.getId());
            fillTable();
            JOptionPane.showMessageDialog(null, "Música deletada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione alguma Música para deletar!");
        }
    }

    //Preenche o ComboBox de Artista através de uma lista de Artistas do banco
    public void populaComboBoxArtista() {
        DefaultComboBoxModel cmbArtModel = (DefaultComboBoxModel) musicaView.ComboBoxArtista.getModel();
        musicaView.ComboBoxArtista.removeAllItems();
        DaoGenerico<Artista> artistaDao = new DaoGenerico<>();
        musicaView.ComboBoxArtista.addItem("Selecione...");
        for (Artista a : artistaDao.listaTodos(Artista.class)) {
            cmbArtModel.addElement(a);
        }
    }

    //Preenche o ComboBox de Compositor através de uma lista de Compositores do banco
    public void populaComboBoxCompositor() {
        DefaultComboBoxModel cmbCompModel = (DefaultComboBoxModel) musicaView.ComboBoxCompositor.getModel();
        musicaView.ComboBoxCompositor.removeAllItems();
        DaoGenerico<Compositor> compositorDao = new DaoGenerico<>();
        musicaView.ComboBoxCompositor.addItem("Selecione...");
        for (Compositor c : compositorDao.listaTodos(Compositor.class)) {
            cmbCompModel.addElement(c);
        }
    }

    //Preenche o ComboBox de Album através de uma lista de Albuns do banco
    public void populaComboBoxAlbum() {
        DefaultComboBoxModel cmbAlbModel = (DefaultComboBoxModel) musicaView.ComboBoxAlbum.getModel();
        musicaView.ComboBoxAlbum.removeAllItems();
        DaoGenerico<Album> albumDao = new DaoGenerico<>();
        musicaView.ComboBoxAlbum.addItem("Selecione...");
        for (Album a : albumDao.listaTodos(Album.class)) {
            cmbAlbModel.addElement(a);
        }
    }

    //Classe que implementa um MouseListener e ouve um evento de clique na tabela
    //Se alguma linha for selecionada, os dados são preenchidos nos campos
    public class TableListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            if (musicaView.getTable() == me.getSource()) {
                if (musicaView.getTable().getSelectedRow() != -1) {
                    int selected = musicaView.getTable().getSelectedRow();
                    musicaView.setMusica(musicaView.getTable().getValueAt(selected, 1).toString());
                    musicaView.ComboBoxArtista.setSelectedItem(musicaView.getTable().getValueAt(selected, 2));
                    musicaView.ComboBoxCompositor.setSelectedItem(musicaView.getTable().getValueAt(selected, 3));
                    musicaView.ComboBoxAlbum.setSelectedItem(musicaView.getTable().getValueAt(selected, 4));
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
            if (musicaView.getTable() == me.getSource()) {
                if (musicaView.getTable().getSelectedRow() != -1) {
                    int selected = musicaView.getTable().getSelectedRow();
                    musicaView.setMusica(musicaView.getTable().getValueAt(selected, 1).toString());
                    musicaView.ComboBoxArtista.setSelectedItem(musicaView.getTable().getValueAt(selected, 2));
                    musicaView.ComboBoxCompositor.setSelectedItem(musicaView.getTable().getValueAt(selected, 3));
                    musicaView.ComboBoxAlbum.setSelectedItem(musicaView.getTable().getValueAt(selected, 4));
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
