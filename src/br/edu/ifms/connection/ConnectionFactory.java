package br.edu.ifms.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("daogravadora");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

}
