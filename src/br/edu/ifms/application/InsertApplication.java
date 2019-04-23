package br.edu.ifms.application;

import br.edu.ifms.dao.DaoGenerico;
import br.edu.ifms.model.Usuario;

public class InsertApplication {

    public static void main(String[] args) {

        Usuario usuario = new Usuario();
        DaoGenerico<Usuario> daoUser = new DaoGenerico<>();
        
        usuario.setUsuario("Administrador");
        usuario.setLogin("admin");
        usuario.setSenha("1234");
        
        daoUser.saveOrUpdate(usuario);

        System.out.println("Entidades salvas com sucesso!");

    }

}
