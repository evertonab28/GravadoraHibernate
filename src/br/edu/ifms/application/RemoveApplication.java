package br.edu.ifms.application;

import br.edu.ifms.dao.DaoGenerico;
import br.edu.ifms.model.Usuario;

public class RemoveApplication {

    public static void main(String[] args) {

        DaoGenerico<Usuario> daoUsuario = new DaoGenerico<>();

        daoUsuario.remove(Usuario.class, 1L);

        System.out.println("Entidades removidas com sucesso!");

    }
}
