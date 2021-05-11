package br.upe.ProjetoPOO.DAO;

import br.upe.ProjetoPOO.Classes.Apartamento;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

import static br.upe.ProjetoPOO.DAO.PersistenceManager.getEntityManager;

public class JPAApartamentoDAO implements ApartamentoDAO {

	//Singleton
	private static JPAApartamentoDAO INSTANCE;

	public static JPAApartamentoDAO getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new JPAApartamentoDAO();
		}
		return INSTANCE;
	}

	//Cria Entitymanager
	EntityManager em;

	//Persistência de objeto no BD
	public void salva(Apartamento ap) throws Exception {
		em = getEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(ap);
			em.getTransaction().commit();
		}
		catch(EntityExistsException e) {
			em.getTransaction().rollback();
			em.flush();
			em.refresh(ap);
			throw e;
		}
		finally {
			em.close();
		}
	}

	//Query que retorna Apartamento por id
	public Apartamento obterPorId(int id) throws Exception {
		em = getEntityManager();
		Apartamento apartamento;
		em.getTransaction().begin();
		try {
			apartamento = em.find(Apartamento.class, id);
			em.getTransaction().commit();
		}
		catch(NoResultException e){
			em.getTransaction().rollback();
			throw e;
		}
		finally {
			em.close();
		}		
		return apartamento;
	}

	//Query que traz Apartamento por bloco
	public Apartamento obterPorBloco(String bloco) throws Exception {
		em = getEntityManager();
		Apartamento apartamento;
		em.getTransaction().begin();
		try {
			apartamento = em.createQuery(
					"SELECT u from Apartamento u WHERE u.bloco = :bloco", Apartamento.class).
					setParameter("bloco", bloco).getSingleResult();
			em.getTransaction().commit();
		}
		catch(NoResultException nre){
			throw nre;
		}
		finally {
			em.close();
		}
		return apartamento;
	}

	//Persistência que remove Apartamento
	@Override
	public void remove(int id) throws Exception{
		em = getEntityManager();
		em.getTransaction().begin();
		try {
			Apartamento apartamento = em.find(Apartamento.class, id);
			em.remove(apartamento);
			em.getTransaction().commit();
		}
		catch(Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
		finally {
			em.close();
		}		
	}

	//Query que traz todos Apartamentos do BD
	@SuppressWarnings("unchecked")
	public List<Apartamento> lista() {
		em = getEntityManager();
		List<Apartamento> apartamentos = new ArrayList<>();
		try{
			apartamentos = em.createQuery("FROM " + Apartamento.class.getName()).getResultList();
		}
		catch(Exception e){

		}
		finally{
			em.close();
		}
		return apartamentos;
	}
}