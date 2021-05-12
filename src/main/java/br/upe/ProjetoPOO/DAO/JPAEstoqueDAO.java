package br.upe.ProjetoPOO.DAO;

import br.upe.ProjetoPOO.Classes.Estoque;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

import static br.upe.ProjetoPOO.DAO.PersistenceManager.getEntityManager;

public class JPAEstoqueDAO implements EstoqueDAO {

    //Singleton
    private static JPAEstoqueDAO INSTANCE;

    public static JPAEstoqueDAO getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new JPAEstoqueDAO();
        }
        return INSTANCE;
    }

    //Cria Entitymanager
    EntityManager em;

    //Persistência de Estoque no BD
    public void salva(Estoque e) {
        em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(e);
            em.getTransaction().commit();
        } catch (Exception a) {
            em.getTransaction().rollback();
            em.flush();
            em.refresh(e);
        } finally {
            em.close();
        }

    }

    //Query que retorna Estoque por Nome
    public Estoque obterPorNome(String nomeProduto) {
        em = getEntityManager();
        Estoque estoque;
        em.getTransaction().begin();
        try {
            estoque = em.createQuery(
                    "SELECT u from Estoque u WHERE u.nomeProduto = :nomeProduto", Estoque.class).
                    setParameter("nomeProduto", nomeProduto).getSingleResult();
        } catch (NoResultException nre) {
            estoque = null;
        } finally {
            em.close();
        }
        return estoque;
    }

    //Persistência que remove Estoque
    @Override
    public void remove(int id) {
        em = getEntityManager();
        em.getTransaction().begin();
        try {
            Estoque estoque = em.find(Estoque.class, id);
            em.remove(estoque);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    //Query que traz todos Estoques do BD
    @SuppressWarnings("unchecked")
    public List<Estoque> lista() {
        em = getEntityManager();
        List<Estoque> estoques = new ArrayList<>();
        try {
            estoques = em.createQuery("FROM " + Estoque.class.getName()).getResultList();
        } catch (Exception e) {

        } finally {
            em.close();
        }
        return estoques;
    }
}
