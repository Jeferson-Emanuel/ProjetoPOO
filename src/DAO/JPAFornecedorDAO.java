package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Classes.Fornecedor;


public class JPAFornecedorDAO implements FornecedorDAO {
	
	EntityManager em;
	EntityManagerFactory emf;
	
	public JPAFornecedorDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}
	
	
	public void salva(Fornecedor f) {
		
		em.getTransaction().begin();
		
		em.merge(f);
		
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remove(Fornecedor f) {
		
		em.getTransaction().begin();
		
		em.remove(f);
		
		em.getTransaction().commit();
		emf.close();
		
	}
	
	public List<Fornecedor> lista() {
		
		em.getTransaction().begin();
		
		Query pesquisa = em.createQuery("select a from Fornecedor f");
		
		@SuppressWarnings("unchecked")
		List<Fornecedor> fornecedor = pesquisa.getResultList();
		
		em.getTransaction().commit();
		emf.close();
		
		return fornecedor;
	}
}
