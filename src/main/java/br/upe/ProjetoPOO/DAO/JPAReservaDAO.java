package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Classes.Reserva;

public class JPAReservaDAO implements ReservaDAO {
	
	EntityManager em;
	EntityManagerFactory emf;
	
	public JPAReservaDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}
	
	public Reserva obterPorId(int id) {
		em.getTransaction().begin();
		Reserva reserva = em.find(Reserva.class, id);
		em.getTransaction().commit();
		emf.close();
		return reserva;
	}
	
	public void salva(Reserva r) {	
		em.getTransaction().begin();
		em.merge(r);
		em.getTransaction().commit();
		emf.close();
	}
	
	@Override
	public Reserva remove(int id) {
		em.getTransaction().begin();
		Reserva reserva = em.find(Reserva.class, id);
		System.out.println("Excluindo dados de: " + reserva.getId());
		em.remove(reserva);
		em.getTransaction().commit();
		em.close();
		return reserva;
	}
	
	@SuppressWarnings("unchecked")
	public List<Reserva> lista() {
		
		return em.createQuery("FROM " + Reserva.class.getName()).getResultList();
		
		/*em.getTransaction().begin();
		Query pesquisa = em.createQuery("select a from Reserva r");
		@SuppressWarnings("unchecked")
		List<Reserva> reserva = pesquisa.getResultList();
		em.getTransaction().commit();
		emf.close();
		return reserva;*/
	}
}
