package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Classes.Reserva;

public class JPAReservaDAO implements ReservaDAO {
	
	EntityManager em;
	EntityManagerFactory emf;
	
	public JPAReservaDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}
	
	public void salva(Reserva r) {
		
		em.getTransaction().begin();
		
		em.merge(r);
		
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remove(Reserva r) {
		
		em.getTransaction().begin();
		
		em.remove(r);
		
		em.getTransaction().commit();
		emf.close();
		
	}
	
	public List<Reserva> lista() {
		
		em.getTransaction().begin();
		
		Query pesquisa = em.createQuery("select a from Reserva r");
		
		@SuppressWarnings("unchecked")
		List<Reserva> reserva = pesquisa.getResultList();
		
		em.getTransaction().commit();
		emf.close();
		
		return reserva;
	}
}
