package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Classes.Produto;

public class JPAProdutoDAO implements ProdutoDAO {
	
	EntityManager em;
	EntityManagerFactory emf;
	
	public JPAProdutoDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}
	
	
	public void salva(Produto p) {
		
		em.getTransaction().begin();
		
		em.merge(p);
		
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remove(Produto p) {
		
		em.getTransaction().begin();
		
		em.remove(p);
		
		em.getTransaction().commit();
		emf.close();
		
	}
	
	public List<Produto> lista() {
		
		em.getTransaction().begin();
		
		Query pesquisa = em.createQuery("select a from Produto p");
		
		@SuppressWarnings("unchecked")
		List<Produto> produto = pesquisa.getResultList();
		
		em.getTransaction().commit();
		emf.close();
		
		return produto;
	}
}
