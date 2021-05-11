package br.upe.ProjetoPOO.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager(){
        if(emf == null){
           emf = Persistence.createEntityManagerFactory("default");
        }
        EntityManager em = emf.createEntityManager();
        return em;
    }
}
