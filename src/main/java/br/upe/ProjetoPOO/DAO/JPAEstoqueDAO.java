package br.upe.ProjetoPOO.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import br.upe.ProjetoPOO.Classes.Estoque;

public class JPAEstoqueDAO implements EstoqueDAO{
	
	EntityManager em;
	EntityManagerFactory emf;
	
	public JPAEstoqueDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}
	
	public Estoque obterPorNome(String nomeProduto) {
		Estoque estoque = null;
		
		em.getTransaction().begin();
		
		try{			
			estoque = em.createQuery(
					  "SELECT u from Estoque u WHERE u.nomeProduto = :nomeProduto", Estoque.class).
					  setParameter("nomeProduto", nomeProduto).getSingleResult();
		}
		catch (NoResultException nre){
		
		}
		
		em.getTransaction().commit();
		//em.close();		
		return estoque;
	}
	
	public void salva(Estoque e) {
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
		em.close();
		//emf.close();
	}
	
	@Override
	public void remove(int id) {
		em.getTransaction().begin();
		Estoque estoque = em.find(Estoque.class, id);
		System.out.println("Excluindo dados de: " + estoque.getNomeProduto());
		em.remove(estoque);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Estoque> lista() {		
		return em.createQuery("FROM " + Estoque.class.getName()).getResultList();
	}

}
