package br.upe.ProjetoPOO.DAO;

import br.upe.ProjetoPOO.Classes.Morador;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

import static br.upe.ProjetoPOO.DAO.PersistenceManager.getEntityManager;

/**
 * JPA da classe Morador.
 */
public class JPAMoradorDAO implements MoradorDAO {

    //Singleton
    private static JPAMoradorDAO INSTANCE;

    public static JPAMoradorDAO getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new JPAMoradorDAO();
        }
        return INSTANCE;
    }

    //Cria Entitymanager
    EntityManager em;

    /**
     * Persistência de objeto Morador no BD.
     *
     * @param m Recebe um objeto do tipo Morador do Controlador.
     * @throws Exception Retorna exceção do tipo EntityExistsException para o Controlador.
     */
    public void salva(Morador m) throws Exception {
        em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(m);
            em.getTransaction().commit();
        } catch (EntityExistsException e) {
            em.getTransaction().rollback();
            em.flush();
            em.refresh(m);
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * Query que traz Morador por id.
     *
     * @param id Recebe um inteiro extraido de um objeto Morador pelo Controlador.
     * @return Retorna objeto do tipo Morador.
     * @throws Exception Joga exceção do tipo NoResultException para o Controlador.
     */
    public Morador obterPorId(int id) throws Exception {
        em = getEntityManager();
        Morador morador;
        em.getTransaction().begin();
        try {
            morador = em.find(Morador.class, id);
            em.getTransaction().commit();
        } catch (NoResultException e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
        return morador;
    }

    /**
     * Query que traz Morador por CPF.
     *
     * @param cpf Recebe uma string extraída de um objeto Morador pelo Controlador.
     * @return Retorna um objeto do tipo Morador.
     * @throws Exception Joga uma exceção do tipo NoResultException para o Controlador.
     */
    public Morador obterPorCpf(String cpf) throws Exception {
        em = getEntityManager();
        Morador morador;
        em.getTransaction().begin();
        try {
            morador = em.createQuery(
                    "SELECT u from Morador u WHERE u.cpf = :cpf", Morador.class).
                    setParameter("cpf", cpf).getSingleResult();
        } catch (NoResultException nre) {
            throw nre;
        } finally {
            em.close();
        }
        return morador;
    }

    /**
     * Persistência que remove Morador.
     *
     * @param id Recebe um inteiro extraído de um objeto Morador pelo Controlador.
     */
    @Override
    public void remove(int id) {
        em = getEntityManager();
        em.getTransaction().begin();
        try {
            Morador morador = em.find(Morador.class, id);
            em.remove(morador);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * Query que traz todos Moradores do BD.
     *
     * @return Retorna uma lista com todos os objetos do tipo Apartamento do BD.
     */
    @SuppressWarnings("unchecked")
    public List<Morador> lista() {
        em = getEntityManager();
        List<Morador> moradores = new ArrayList<>();
        try {
            moradores = em.createQuery("FROM " + Morador.class.getName()).getResultList();
        } catch (Exception e) {

        } finally {
            em.close();
        }
        return moradores;
    }
}