package br.upe.ProjetoPOO.DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import br.upe.ProjetoPOO.Classes.Produto;
import br.upe.ProjetoPOO.Classes.Reserva;

public class JPAReservaDAO implements ReservaDAO {
	
	EntityManager em;
	EntityManagerFactory emf;
	
	public JPAReservaDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}
	
	/*public static List<Reserva> castList(Class<? extends Reserva> clazz, Collection<?> c) {
	    List<Reserva> r = new ArrayList<Reserva>(c.size());
	    for(Object o: c)
	      r.add(clazz.cast(o));
	    return r;
	}*/
	
	public Reserva obterPorId(int id) {
		em.getTransaction().begin();
		Reserva reserva = em.find(Reserva.class, id);
		em.getTransaction().commit();
		emf.close();
		return reserva;
	}
	
	public List<Reserva> obterPorEspaco() {
		List<Reserva> reservas = null;
		em.getTransaction().begin();
		try{	
			reservas = (List<Reserva>)(Object) em.createQuery("FROM " + Reserva.class.getName()).getResultList();
			//reservas = em.createQuery("FROM " + Reserva.class.getName()).getResultList();
			//System.out.println(em.createQuery("FROM " + Reserva.class.getName()).getResultList().getClass());
			//this.castList(reservas);
		}
		catch (NoResultException nre){
		
		}
		em.getTransaction().commit();
		//emf.close();
		if(reservas.size()==0) {
			reservas = null;
		}		
		return reservas;		
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
