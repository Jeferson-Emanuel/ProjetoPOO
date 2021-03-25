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
	
	public Funcionario obterPorId(int id) {
		em.getTransaction().begin();
		Funcionario funcionario = em.find(Funcionario.class, id);
		em.getTransaction().commit();
		emf.close();
		return funcionario;
	}
	
	public void salva(Funcionario func) {
		em.getTransaction().begin();
		em.merge(func);
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> lista() {
		
		return em.createQuery("FROM " +
		         Funcionario.class.getName()).getResultList();
		
		/*em.getTransaction().begin();
		Query pesquisa = em.createQuery("select a from Funcionario func");
		List<Funcionario> funcionario = pesquisa.getResultList();
		em.getTransaction().commit();
		emf.close();
		return funcionario;*/
	}

	@Override
	public Funcionario remove(int id) {
		// TODO Auto-generated method stub
		  em.getTransaction().begin();
	      Funcionario funcionario = em.find(Funcionario.class, id); //consulta por meio do id.
	      System.out.println("Excluindo os dados de: " + funcionario.getNome());
	      em.remove(funcionario);
	      em.getTransaction().commit();
	      em.close();
		return null;
	}
}
