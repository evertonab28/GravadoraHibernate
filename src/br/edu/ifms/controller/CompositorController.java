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

    public CompositorController(Compositor compositor, CompositorView compositorView) {
        this.compositor = compositor;
        this.compositorView = compositorView;
        this.compositorView.addButtonListener(new ButtonListener());
        this.compositorView.addTableListener(new TableListener());
        //DefaultTableModel model = (DefaultTableModel) this.compositorView.jTableCompositores.getModel();
        DefaultTableModel model = (DefaultTableModel) this.compositorView.getTableM();
        
        //this.compositorView.jTableCompositores.setRowSorter(new TableRowSorter(model));
        this.compositorView.getTable().setRowSorter(new TableRowSorter(model));
        fillTable();
    }

    public void fillTable() {
        //DefaultTableModel model = (DefaultTableModel) compositorView.jTableCompositores.getModel();
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

    public void clearFields() {
        compositorView.setCompositor("");
        compositorView.setTelefone("");
        compositorView.setEndereco("");
    }

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
        }
    }

    public void editarCompositor() {
        //if (compositorView.jTableCompositores.getSelectedRow() != -1) {
        if (compositorView.getTable().getSelectedRow() != -1) {
            compositor = new Compositor();
            DaoGenerico<Compositor> daoCompositor = new DaoGenerico<>();

            if (compositorView.getCompositor().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo nome não pode estar vazio!");
            } else {
                compositor.setNomeCompositor(compositorView.getCompositor());
                compositor.setTelefoneCompositor(compositorView.getTelefone());
                compositor.setEnderecoCompositor(compositorView.getEndereco());
                //compositor.setId((long) compositorView.jTableCompositores.getValueAt(compositorView.jTableCompositores.getSelectedRow(), 0));
                compositor.setId((long) compositorView.getTable().getValueAt(compositorView.getTable().getSelectedRow(), 0));
                daoCompositor.saveOrUpdate(compositor);

                clearFields();
                fillTable();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione algum Compositor!");
        }
    }

    public void deletarCompositor() {
        //if (compositorView.jTableCompositores.getSelectedRow() != -1) {
        if (compositorView.getTable().getSelectedRow() != -1) {

            compositor = new Compositor();
            DaoGenerico<Compositor> daoCompositor = new DaoGenerico<>();
            //compositor.setId((long) compositorView.jTableCompositores.getValueAt(compositorView.jTableCompositores.getSelectedRow(), 0));
            compositor.setId((long) compositorView.getTable().getValueAt(compositorView.getTable().getSelectedRow(), 0));

            daoCompositor.remove(Compositor.class, compositor.getId());
            clearFields();
            fillTable();
            JOptionPane.showMessageDialog(null, "Compositor deletado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione algum Compositor para deletar!");
        }
    }

    public class TableListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            //if (compositorView.jTableCompositores == me.getSource()) {
            if (compositorView.getTable() == me.getSource()) {
                //if (compositorView.jTableCompositores.getSelectedRow() != -1) {
                if (compositorView.getTable().getSelectedRow() != -1) {
                    //int selected = compositorView.jTableCompositores.getSelectedRow();
                    int selected = compositorView.getTable().getSelectedRow();

                   // compositorView.setCompositor(compositorView.jTableCompositores.getValueAt(selected, 1).toString());
                    compositorView.setCompositor(compositorView.getTable().getValueAt(selected, 1).toString());
                    
                    //compositorView.setTelefone(compositorView.jTableCompositores.getValueAt(selected, 2).toString());
                    compositorView.setTelefone(compositorView.getTable().getValueAt(selected, 2).toString());
                    
                    //compositorView.setEndereco(compositorView.jTableCompositores.getValueAt(selected, 3).toString());
                    compositorView.setEndereco(compositorView.getTable().getValueAt(selected, 3).toString());
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
           //if (compositorView.jTableCompositores == me.getSource()) {
            if (compositorView.getTable() == me.getSource()) {
                //if (compositorView.jTableCompositores.getSelectedRow() != -1) {
                if (compositorView.getTable().getSelectedRow() != -1) {
                    //int selected = compositorView.jTableCompositores.getSelectedRow();
                    int selected = compositorView.getTable().getSelectedRow();

                    //compositorView.setCompositor(compositorView.jTableCompositores.getValueAt(selected, 1).toString());
                    compositorView.setCompositor(compositorView.getTable().getValueAt(selected, 1).toString());
                    
                    //compositorView.setTelefone(compositorView.jTableCompositores.getValueAt(selected, 2).toString());
                    compositorView.setTelefone(compositorView.getTable().getValueAt(selected, 2).toString());
                    
                    //compositorView.setEndereco(compositorView.jTableCompositores.getValueAt(selected, 3).toString());
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
