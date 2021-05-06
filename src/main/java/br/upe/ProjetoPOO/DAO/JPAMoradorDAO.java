package br.upe.ProjetoPOO.DAO;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

import br.upe.ProjetoPOO.Classes.Morador;

public class JPAMoradorDAO implements MoradorDAO {
	
	//Singleton
	private static JPAMoradorDAO INSTANCE;
	
	public static JPAMoradorDAO getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new JPAMoradorDAO();
		}
		return INSTANCE;
	}
	
	EntityManager em;
	EntityManagerFactory emf;
	
	public JPAMoradorDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}
	//Persistência de objeto no BD
	public void salva(Morador m) {
		em.getTransaction().begin();
		try {
			em.merge(m);
			em.getTransaction().commit();
		}
		catch(Exception e){
			em.getTransaction().rollback();
			em.flush();
			em.refresh(m);
		}
	}
	//Query que traz objeto por id
	public Morador obterPorId(int id) {
		em.getTransaction().begin();
		Morador morador = em.find(Morador.class, id);
		em.getTransaction().commit();
		emf.close();
		return morador;
	}
	//Query que traz objeto por cpf
	public Morador obterPorCpf(String cpf) {
		Morador morador = null;
		em.getTransaction().begin();
		//Morador morador = em.find(Morador.class, id);
		try{			
			morador = em.createQuery(
					  "SELECT u from Morador u WHERE u.cpf = :cpf", Morador.class).
					  setParameter("cpf", cpf).getSingleResult();
		}
		catch (NoResultException nre){
		
		}
		em.getTransaction().commit();
		return morador;
	}	
	
	//Persistência que remove objeto
	@Override
	public void remove(int id) {
		em.getTransaction().begin();
		Morador morador = em.find(Morador.class, id);
		em.remove(morador);
		em.getTransaction().commit();
	}
	//Query que traz todos objetos do BD
	@SuppressWarnings("unchecked")
	public List<Morador> lista() {
		List<Morador> moradores = null;
		moradores = em.createQuery("FROM " + Morador.class.getName()).getResultList();
		if(moradores.size() == 0) {
			moradores = null;
		}		
		return moradores;
	}
}
