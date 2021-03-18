package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Classes.Veiculo;

public class JPAVeiculoDAO implements VeiculoDAO {
	
	EntityManager em;
	EntityManagerFactory emf;
	
	public JPAVeiculoDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}
	
	public void salva(Veiculo v) {
		
		em.getTransaction().begin();
		
		em.merge(v);
		
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remove(Veiculo v) {
		
		em.getTransaction().begin();
		
		em.remove(v);
		
		em.getTransaction().commit();
		emf.close();
		
	}
	
	public List<Veiculo> lista() {
		
		em.getTransaction().begin();
		
		Query pesquisa = em.createQuery("select a from Veiculo v");
		
		@SuppressWarnings("unchecked")
		List<Veiculo> veiculo = pesquisa.getResultList();
		
		em.getTransaction().commit();
		emf.close();
		
		return veiculo;
	}
}
