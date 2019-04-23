package br.edu.ifms.dao;

import javax.persistence.EntityManager;
import br.edu.ifms.connection.ConnectionFactory;
import br.edu.ifms.model.EntidadeBase;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public class DaoGenerico<T extends EntidadeBase> {

    private final static EntityManager MANAGER = ConnectionFactory.getEntityManager();

    public T findById(Class<T> clazz, Long id) {
        return MANAGER.find(clazz, id);
    }

    public <T> List<T> findByNome(Class<T> clazz, String nomeBusca, String nomeColuna) {
        String tabela = clazz.getSimpleName();
        String jpql = "from "+tabela+" where "+nomeColuna+" like :nomeBusca";
        Query query = MANAGER.createQuery(jpql, clazz);
        query.setParameter("nomeBusca", nomeBusca + "%");
        return (List<T>) query.getResultList();
    }

    public List<T> listaTodos(Class<T> clazz) {
        CriteriaQuery<T> query = MANAGER.getCriteriaBuilder().createQuery(clazz);
        query.select(query.from(clazz));
        List<T> lista = MANAGER.createQuery(query).getResultList();
        return lista;
    }

    public void saveOrUpdate(T obj) {
        try {
            MANAGER.getTransaction().begin();
            if (obj.getId() == null) {
                MANAGER.persist(obj);
            } else {
                MANAGER.merge(obj);
            }
            MANAGER.getTransaction().commit();
        } catch (Exception e) {
            MANAGER.getTransaction().rollback();
        }
    }

    public void remove(Class<T> clazz, Long id) {
        T t = findById(clazz, id);
        try {
            MANAGER.getTransaction().begin();
            MANAGER.remove(t);
            MANAGER.getTransaction().commit();
        } catch (Exception e) {
            MANAGER.getTransaction().rollback();
        }
    }

}
