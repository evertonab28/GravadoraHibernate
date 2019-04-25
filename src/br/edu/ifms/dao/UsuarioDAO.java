package br.edu.ifms.dao;

import br.edu.ifms.connection.ConnectionFactory;
import br.edu.ifms.model.EntidadeBase;
import br.edu.ifms.model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class UsuarioDAO extends DaoGenerico{

private final static EntityManager MANAGER = ConnectionFactory.getEntityManager();

    @Override
    public EntidadeBase findById(Class clazz, Long id) {
        return super.findById(clazz, id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findByNome(Class clazz, String nomeBusca, String nomeColuna) {
        return super.findByNome(clazz, nomeBusca, nomeColuna); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listaTodos(Class clazz) {
        return super.listaTodos(clazz); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveOrUpdate(EntidadeBase obj) {
        super.saveOrUpdate(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Class clazz, Long id) {
        super.remove(clazz, id); //To change body of generated methods, choose Tools | Templates.
    }

    public Usuario findByLoginSenha(String login, String senha) {

        try{
            Usuario usuario = (Usuario) MANAGER.createQuery("SELECT u from "
                    + "Usuario u WHERE u.login LIKE :login and u.senha LIKE :senha")
                    .setParameter("login", login).setParameter("senha", senha).getSingleResult();
            
            return usuario;
        }catch(NoResultException ex){
            return null;
        }

    }

}
