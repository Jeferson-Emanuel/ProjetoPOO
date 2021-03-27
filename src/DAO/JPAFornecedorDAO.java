package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Classes.Fornecedor;


public class JPAFornecedorDAO implements FornecedorDAO {
	
	EntityManager em;
	EntityManagerFactory emf;
	
	public JPAFornecedorDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}
	
	public Fornecedor obterPorId(int id) {
		em.getTransaction().begin();
		Fornecedor fornecedor = em.find(Fornecedor.class, id);
		em.getTransaction().commit();
		emf.close();
		return fornecedor;
	}
	
	public void salva(Fornecedor f) {
		em.getTransaction().begin();
		em.merge(f);
		em.getTransaction().commit();
		emf.close();
	}
	
	@Override
	public Fornecedor remove(int id) {
		em.getTransaction().begin();
		Fornecedor fornecedor = em.find(Fornecedor.class, id);
		System.out.println("Exluindo dados de: " + fornecedor.getNome());
		em.remove(fornecedor);
		em.getTransaction().commit();
		em.close();
		return fornecedor;
	}
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> lista() {
		
		return em.createQuery("FROM " + Fornecedor.class.getName()).getResultList();
		
		/*em.getTransaction().begin();
		Query pesquisa = em.createQuery("select a from Fornecedor f");
		@SuppressWarnings("unchecked")
		List<Fornecedor> fornecedor = pesquisa.getResultList();
		em.getTransaction().commit();
		emf.close();
		return fornecedor;*/
	}
}
