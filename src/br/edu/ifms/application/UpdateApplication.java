package br.edu.ifms.application;

import br.edu.ifms.dao.DaoGenerico;
import br.edu.ifms.model.Usuario;

public class UpdateApplication {

    public static void main(String[] args) {

        DaoGenerico<Usuario> daoPessoa = new DaoGenerico<>();

        Usuario usuario = daoPessoa.findById(Usuario.class, 2L);
        usuario.setLogin("Admin2");
        daoPessoa.saveOrUpdate(usuario);
        System.out.println("Entidade atualizada com sucesso.");

    }

}
