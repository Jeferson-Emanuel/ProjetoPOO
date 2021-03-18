package DAO;

import java.util.List;
import Classes.Almoxarifado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPAAlmoxarifadoDAO implements AlmoxarifadoDAO {
	
	EntityManager em;
	EntityManagerFactory emf;
	
	public JPAAlmoxarifadoDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}
	
	
	public void salva(Almoxarifado a) {
		
		em.getTransaction().begin();
		
		em.merge(a);
		
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remove(Almoxarifado a) {

		em.getTransaction().begin();
		
		em.remove(a);
		
		em.getTransaction().commit();
		emf.close();
		
	}
	
	public List<Almoxarifado> lista() {
		
		em.getTransaction().begin();
		
		Query pesquisa = em.createQuery("select a from Almoxarifado a");
		
		@SuppressWarnings("unchecked")
		List<Almoxarifado> almoxarifado = pesquisa.getResultList();
		
		em.getTransaction().commit();
		emf.close();
		
		return almoxarifado;
	}

}
