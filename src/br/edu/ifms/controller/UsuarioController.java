package br.edu.ifms.controller;

import br.edu.ifms.dao.DaoGenerico;
import br.edu.ifms.model.Usuario;
import br.edu.ifms.view.UsuarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class UsuarioController {

    private Usuario usuario;
    private UsuarioView usuarioView;

    //Construtor do UsuarioController, passando um usuario e uma UsuarioView
    public UsuarioController(Usuario usuario, UsuarioView usuarioView) {
        this.usuario = usuario;
        this.usuarioView = usuarioView;
        //ActionListener dos botões e da tabela
        this.usuarioView.addButtonListener(new ButtonListener());
        this.usuarioView.addTableListener(new TableListener());
        //Definido o modelo da tabela como AbstractTableModel
        DefaultTableModel model = (DefaultTableModel) this.usuarioView.getTableM();
        //Definindo ordenação para a tabela
        this.usuarioView.getTable().setRowSorter(new TableRowSorter(model));
        //metodo para preencher a tabela com uma lista de usuarios
        fillTable();
    }

    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) usuarioView.getTableM();
        model.setNumRows(0);
        DaoGenerico<Usuario> daoUsuario = new DaoGenerico<>();
        for (Usuario u : daoUsuario.listaTodos(Usuario.class)) {
            model.addRow(new Object[]{
                u.getId(),
                u.getUsuario(),
                u.getLogin(),});
        }
    }

    //Metodo para limpar os campos
    public void clearFields() {
        usuarioView.setUsuario("");
        usuarioView.setLogin("");
        usuarioView.setSenha("");
    }

    //Classe que implementa um ActionListener para os botões da view
    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == usuarioView.btnCadastrar) {
                cadastrarUsuario();
            }

            if (ae.getSource() == usuarioView.btnEditar) {
                editarUsuario();
            }

            if (ae.getSource() == usuarioView.btnDeletar) {
                deletarUsuario();
            }

            if (ae.getSource() == usuarioView.btnLimpar) {
                clearFields();
            }
        }
    }

    //Metodo para cadastro de um novo Usuario
    public void cadastrarUsuario() {
        usuario = new Usuario();
        DaoGenerico<Usuario> daoUsuario = new DaoGenerico<>();
        if (usuarioView.getUsuario().isEmpty() || usuarioView.getLogin().isEmpty() || usuarioView.getSenha().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        } else {
            usuario.setUsuario(usuarioView.getUsuario());
            usuario.setLogin(usuarioView.getLogin());
            usuario.setSenha(usuarioView.getSenha());
            daoUsuario.saveOrUpdate(usuario);
            clearFields();
            fillTable();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        }
    }

    //Metodo para edicao de um usuario selecionado na tabela
    public void editarUsuario() {
        //Verifica se algum usuario foi selecionado na tabela
        if (usuarioView.getTable().getSelectedRow() != -1) {
            usuario = new Usuario();
            DaoGenerico<Usuario> daoUsuario = new DaoGenerico<>();
            Usuario u = daoUsuario.findById(Usuario.class, (Long) usuarioView.getTable().getValueAt(usuarioView.getTable().getSelectedRow(), 0));

            if (usuarioView.getSenha().equals("")) {
                usuario.setSenha(u.getSenha());
            } else {
                usuario.setSenha(usuarioView.getSenha());
            }

            if (usuarioView.getLogin().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo login não pode estar vazio!");
            } else {
                //Seta os atributos do Usuario e salva no banco, limpa os campos e atualiza a tabela
                usuario.setUsuario(usuarioView.getUsuario());
                usuario.setLogin(usuarioView.getLogin());
                usuario.setId((long) usuarioView.getTable().getValueAt(usuarioView.getTable().getSelectedRow(), 0));
                daoUsuario.saveOrUpdate(usuario);
                clearFields();
                fillTable();
                JOptionPane.showMessageDialog(null, "Usuário editado com sucesso!");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione algum usuário!");
        }
    }

    //Metodo para exclusao de um Usuario selecionado na tabela
    public void deletarUsuario() {
        if (usuarioView.getTable().getSelectedRow() != -1) {
            usuario = new Usuario();
            DaoGenerico<Usuario> daoUsuario = new DaoGenerico<>();
            usuario.setId((long) usuarioView.getTable().getValueAt(usuarioView.getTable().getSelectedRow(), 0));
            daoUsuario.remove(Usuario.class, usuario.getId());
            clearFields();
            fillTable();
            JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione algum usuário para deletar!");
        }
    }

    //Classe que implementa um MouseListener e ouve um evento de clique na tabela
    //Se alguma linha for selecionada, os dados são preenchidos nos campos
    public class TableListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            if (usuarioView.getTable() == me.getSource()) {
                if (usuarioView.getTable().getSelectedRow() != -1) {
                    int selected = usuarioView.getTable().getSelectedRow();
                    usuarioView.setUsuario(usuarioView.getTable().getValueAt(selected, 1).toString());
                    usuarioView.setLogin(usuarioView.getTable().getValueAt(selected, 2).toString());
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
            if (usuarioView.getTable() == me.getSource()) {
                if (usuarioView.getTable().getSelectedRow() != -1) {
                    int selected = usuarioView.getTable().getSelectedRow();
                    usuarioView.setUsuario(usuarioView.getTable().getValueAt(selected, 1).toString());
                    usuarioView.setLogin(usuarioView.getTable().getValueAt(selected, 2).toString());
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
