package br.edu.ifms.controller;

import br.edu.ifms.dao.DaoGenerico;
import br.edu.ifms.model.Compositor;
import br.edu.ifms.view.CompositorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class CompositorController {

    private Compositor compositor;
    private CompositorView compositorView;

    //Construtor do CompositorController, passando um compositor e uma CompositorView
    public CompositorController(Compositor compositor, CompositorView compositorView) {
        this.compositor = compositor;
        this.compositorView = compositorView;
        //ActionListener dos botões e da tabela
        this.compositorView.addButtonListener(new ButtonListener());
        this.compositorView.addTableListener(new TableListener());
        //Definido o modelo da tabela como AbstractTableModel
        DefaultTableModel model = (DefaultTableModel) this.compositorView.getTableM();
        //Definindo ordenação para a tabela
        this.compositorView.getTable().setRowSorter(new TableRowSorter(model));
        //metodo para preencher a tabela com uma lista de compositores
        fillTable();
    }

    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) compositorView.getTableM();
        model.setNumRows(0);
        DaoGenerico<Compositor> daoCompositor = new DaoGenerico<>();
        for (Compositor c : daoCompositor.listaTodos(Compositor.class)) {
            model.addRow(new Object[]{
                c.getId(),
                c.getNomeCompositor(),
                c.getTelefoneCompositor(),
                c.getEnderecoCompositor()
            });
        }
    }

    //Metodo para limpar os campos
    public void clearFields() {
        compositorView.setCompositor("");
        compositorView.setTelefone("");
        compositorView.setEndereco("");
    }

    //Classe que implementa um ActionListener para os botões da view
    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == compositorView.btnCadastrar) {
                cadastrarCompositor();
            }
            if (ae.getSource() == compositorView.btnEditar) {
                editarCompositor();
            }
            if (ae.getSource() == compositorView.btnDeletar) {
                deletarCompositor();
            }
            if (ae.getSource() == compositorView.btnLimpar) {
                clearFields();
            }
        }
    }

    //Metodo para cadastro de um novo Compositor
    public void cadastrarCompositor() {
        compositor = new Compositor();
        DaoGenerico<Compositor> daoCompositor = new DaoGenerico<>();

        if (compositorView.getCompositor().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o nome do Compositor!");
        } else {
            compositor.setNomeCompositor(compositorView.getCompositor());
            compositor.setTelefoneCompositor(compositorView.getTelefone());
            compositor.setEnderecoCompositor(compositorView.getEndereco());
            daoCompositor.saveOrUpdate(compositor);
            clearFields();
            fillTable();
            JOptionPane.showMessageDialog(null, "Compositor cadastrado com sucesso!");
        }
    }

    //Metodo para edicao de um compositor selecionado na tabela
    public void editarCompositor() {
        //Verifica se algum compositor foi selecionado na tabela
        if (compositorView.getTable().getSelectedRow() != -1) {
            compositor = new Compositor();
            DaoGenerico<Compositor> daoCompositor = new DaoGenerico<>();
            if (compositorView.getCompositor().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo nome não pode estar vazio!");
            } else {
                //Seta os atributos do Compositor e salva no banco, limpa os campos e atualiza a tabela
                compositor.setNomeCompositor(compositorView.getCompositor());
                compositor.setTelefoneCompositor(compositorView.getTelefone());
                compositor.setEnderecoCompositor(compositorView.getEndereco());
                compositor.setId((long) compositorView.getTable().getValueAt(compositorView.getTable().getSelectedRow(), 0));
                daoCompositor.saveOrUpdate(compositor);
                clearFields();
                fillTable();
                JOptionPane.showMessageDialog(null, "Compositor editado com sucesso!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione algum Compositor!");
        }
    }

    //Metodo para exclusao de um Compositor selecionado na tabela
    public void deletarCompositor() {
        if (compositorView.getTable().getSelectedRow() != -1) {
            compositor = new Compositor();
            DaoGenerico<Compositor> daoCompositor = new DaoGenerico<>();
            //Seta o id do Compositor selecionado no tabela, faz a exclusao, limpa os campos e atualiza a tabela
            compositor.setId((long) compositorView.getTable().getValueAt(compositorView.getTable().getSelectedRow(), 0));
            daoCompositor.remove(Compositor.class, compositor.getId());
            clearFields();
            fillTable();
            JOptionPane.showMessageDialog(null, "Compositor deletado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione algum Compositor para deletar!");
        }
    }

    //Classe que implementa um MouseListener e ouve um evento de clique na tabela
    //Se alguma linha for selecionada, os dados são preenchidos nos campos
    public class TableListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            if (compositorView.getTable() == me.getSource()) {
                if (compositorView.getTable().getSelectedRow() != -1) {
                    int selected = compositorView.getTable().getSelectedRow();
                    compositorView.setCompositor(compositorView.getTable().getValueAt(selected, 1).toString());
                    compositorView.setTelefone(compositorView.getTable().getValueAt(selected, 2).toString());
                    compositorView.setEndereco(compositorView.getTable().getValueAt(selected, 3).toString());
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
            if (compositorView.getTable() == me.getSource()) {
                if (compositorView.getTable().getSelectedRow() != -1) {
                    int selected = compositorView.getTable().getSelectedRow();
                    compositorView.setCompositor(compositorView.getTable().getValueAt(selected, 1).toString());
                    compositorView.setTelefone(compositorView.getTable().getValueAt(selected, 2).toString());
                    compositorView.setEndereco(compositorView.getTable().getValueAt(selected, 3).toString());
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
