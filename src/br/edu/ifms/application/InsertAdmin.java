package br.edu.ifms.application;

import br.edu.ifms.dao.DaoGenerico;
import br.edu.ifms.model.Usuario;

public class InsertAdmin {

    public static void main(String[] args) {

        Usuario usuario = new Usuario();
        DaoGenerico<Usuario> daoUsuario = new DaoGenerico<>();
        usuario.setUsuario("Administrador");
        usuario.setLogin("admin");
        usuario.setSenha("admin");
        daoUsuario.saveOrUpdate(usuario);
        System.out.println("Administrador inserido com sucesso!");

    }

}
