package DAO;

import java.util.List;

import Classes.Apartamento;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPAApartamentoDAO implements ApartamentoDAO {
	
	EntityManager em;
	EntityManagerFactory emf;
	
	public JPAApartamentoDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}
	
	
	public void salva(Apartamento ap) {
		
		em.getTransaction().begin();
		
		em.merge(ap);
		
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remove(Apartamento ap) {
		
		em.getTransaction().begin();
		
		em.remove(ap);
		
		em.getTransaction().commit();
		emf.close();
		
	}
	
	public List<Apartamento> lista() {
		
		em.getTransaction().begin();
		
		Query pesquisa = em.createQuery("select a from Apartamento ap");
		
		@SuppressWarnings("unchecked")
		List<Apartamento> apartamento = pesquisa.getResultList();
		
		em.getTransaction().commit();
		emf.close();
		
		return apartamento;
	}
}
