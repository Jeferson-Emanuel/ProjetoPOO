package br.upe.ProjetoPOO.DAO;

import br.upe.ProjetoPOO.Classes.Almoxarifado;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static br.upe.ProjetoPOO.DAO.PersistenceManager.getEntityManager;

/**
 * JPA da classe Almoxarifado.
 */
public class JPAAlmoxarifadoDAO implements AlmoxarifadoDAO {

    //Singleton
    private static JPAAlmoxarifadoDAO INSTANCE;

    public static JPAAlmoxarifadoDAO getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new JPAAlmoxarifadoDAO();
        }
        return INSTANCE;
    }

    //Cria Entitymanager
    EntityManager em;

    /**
     * Persistência de objeto Almoxarifado no BD.
     * @param a Recebe um objeto do tipo Almoxarifado do Controlador.
     */
    public void salva(Almoxarifado a) {
        em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(a);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.flush();
            em.refresh(a);
        } finally {
            em.close();
        }
    }

    /**
     * Query que traz Almoxarifado por id.
     * @param id Recebe um inteiro extraido de um objeto Almoxarifado pelo Controlador.
     * @return Retorna objeto do tipo Almoxarifado.
     */
    public Almoxarifado obterPorId(int id) {
        em = getEntityManager();
        Almoxarifado almoxarifado;
        em.getTransaction().begin();
        try {
            almoxarifado = em.find(Almoxarifado.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
        return almoxarifado;
    }

    /**
     * Persistência que remove Almoxarifado.
     * @param id Recebe um inteiro extraído de um objeto Almoxarifado pelo Controlador.
     */
    @Override
    public void remove(int id) {
        em = getEntityManager();
        em.getTransaction().begin();
        try {
            Almoxarifado almoxarifado = em.find(Almoxarifado.class, id);
            em.remove(almoxarifado);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * Query que traz todos Almoxarifados do BD
     * @return Retorna uma lista com todos os objetos do tipo Almoxarifado do BD.
     */
    @SuppressWarnings("unchecked")
    public List<Almoxarifado> lista() {
        em = getEntityManager();
        List<Almoxarifado> almoxarifados = new ArrayList<>();
        try {
            Query query = em.createQuery("SELECT DISTINCT a FROM Almoxarifado a INNER JOIN a.fluxoProdutos p");
            almoxarifados = query.getResultList();
        } catch (Exception e) {

        } finally {
            em.close();
        }
        return almoxarifados;
    }

}
