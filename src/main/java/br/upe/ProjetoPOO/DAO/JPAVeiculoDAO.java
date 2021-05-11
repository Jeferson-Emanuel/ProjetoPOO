package br.upe.ProjetoPOO.DAO;

import br.upe.ProjetoPOO.Classes.Veiculo;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

import static br.upe.ProjetoPOO.DAO.PersistenceManager.getEntityManager;

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

    //Persistência de Veículo no BD
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

    //Query que recupera objeto por id
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

    //Query que recupera objeto por placa
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

    //Persistência que remove Veículo
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

    //Query que lista todos os Veículos do BD
    @SuppressWarnings("unchecked")
    public List<Veiculo> lista() {
        em = getEntityManager();
        List<Veiculo> veiculos = new ArrayList<>();
        try {
            veiculos = em.createQuery("FROM " + Veiculo.class.getName()).getResultList();
        }catch (Exception e){

        }finally {
            em.close();
        }
        return veiculos;
    }
}
