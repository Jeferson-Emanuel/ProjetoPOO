package DAO;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityManager;

import Classes.Morador;

public class JPAMoradorDAO implements MoradorDAO {
	
	EntityManager em;
	EntityManagerFactory emf;
	
	public JPAMoradorDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}
	
	public void salva(Morador m) {
		
		em.getTransaction().begin();
		
		em.merge(m);
		
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remove(Morador m) {
		
		em.getTransaction().begin();
		
		em.remove(m);
		
		em.getTransaction().commit();
		emf.close();
		
	}
	
	public List<Morador> lista() {
		
		em.getTransaction().begin();
		
		Query pesquisa = em.createQuery("select a from Morador m");
		
		@SuppressWarnings("unchecked")
		List<Morador> morador = pesquisa.getResultList();
		
		em.getTransaction().commit();
		emf.close();
		
		return morador;
	}
}
