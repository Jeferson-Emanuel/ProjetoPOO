package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Classes.Funcionario;

public class JPAFuncionarioDAO implements FuncionarioDAO {
	
	EntityManager em;
	EntityManagerFactory emf;
	
	public JPAFuncionarioDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}
	
	
	public void salva(Funcionario func) {
		
		em.getTransaction().begin();
		
		em.merge(func);
		
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remove(Funcionario func) {
		
		em.getTransaction().begin();
		
		em.remove(func);
		
		em.getTransaction().commit();
		emf.close();
		
	}
	
	public List<Funcionario> lista() {
		
		em.getTransaction().begin();
		
		Query pesquisa = em.createQuery("select a from Funcionario func");
		
		@SuppressWarnings("unchecked")
		List<Funcionario> funcionario = pesquisa.getResultList();
		
		em.getTransaction().commit();
		emf.close();
		
		return funcionario;
	}
}
