package br.upe.ProjetoPOO.DAO;

import br.upe.ProjetoPOO.Classes.Veiculo;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

import static br.upe.ProjetoPOO.DAO.PersistenceManager.getEntityManager;

/**
 * JPA da classe Veiculo.
 */
public class JPAVeiculoDAO implements VeiculoDAO {

    //Singleton
    private static JPAVeiculoDAO INSTANCE;

    public static JPAVeiculoDAO getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new JPAVeiculoDAO();
        }
        return INSTANCE;
    }

    //Cria Entitymanager
    EntityManager em;

    /**
     * Persistência de objeto Veiculo no BD.
     *
     * @param v Recebe um objeto do tipo Veiculo do Controlador.
     * @throws Exception Retorna exceção do tipo EntityExistsException para o Controlador.
     */
    public void salva(Veiculo v) throws Exception {
        em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(v);
            em.getTransaction().commit();
        } catch (EntityExistsException e) {
            em.getTransaction().rollback();
            em.flush();
            em.refresh(v);
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * Query que traz Veiculo por id.
     *
     * @param id Recebe um inteiro extraido de um objeto Veiculo pelo Controlador.
     * @return Retorna objeto do tipo Veiculo.
     * @throws Exception Joga exceção do tipo NoResultException para o Controlador.
     */
    public Veiculo obterPorId(int id) throws Exception {
        em = getEntityManager();
        Veiculo veiculo;
        em.getTransaction().begin();
        try {
            veiculo = em.find(Veiculo.class, id);
            em.getTransaction().commit();
        } catch (NoResultException e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
        return veiculo;
    }

    /**
     * Query que traz Veiculo por placa.
     *
     * @param placa Recebe uma string extraída de um objeto Veiculo pelo Controlador.
     * @return Retorna um objeto do tipo Veiculo.
     * @throws Exception Joga uma exceção do tipo NoResultException para o Controlador.
     */
    public Veiculo obterPorPlaca(String placa) throws Exception {
        em = getEntityManager();
        Veiculo veiculo;
        em.getTransaction().begin();
        try {
            veiculo = em.createQuery("SELECT u from Veiculo u WHERE u.placa = :placa", Veiculo.class).
                    setParameter("placa", placa).getSingleResult();
        } catch (NoResultException nre) {
            throw nre;
        } finally {
            em.close();
        }
        return veiculo;
    }

    /**
     * Persistência que remove Veiculo.
     *
     * @param id Recebe um inteiro extraído de um objeto Veiculo pelo Controlador.
     */
    @Override
    public void remove(int id) {
        em = getEntityManager();
        em.getTransaction().begin();
        try {
            Veiculo veiculo = em.find(Veiculo.class, id);
            em.remove(veiculo);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * Query que traz todos Veiculos do BD.
     *
     * @return Retorna uma lista com todos os objetos do tipo Veiculo do BD.
     */
    @SuppressWarnings("unchecked")
    public List<Veiculo> lista() {
        em = getEntityManager();
        List<Veiculo> veiculos = new ArrayList<>();
        try {
            veiculos = em.createQuery("FROM " + Veiculo.class.getName()).getResultList();
        } catch (Exception e) {

        } finally {
            em.close();
        }
        return veiculos;
    }
}
