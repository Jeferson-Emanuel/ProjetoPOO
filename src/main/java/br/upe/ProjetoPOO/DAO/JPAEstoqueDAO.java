package br.upe.ProjetoPOO.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import br.upe.ProjetoPOO.Classes.Estoque;

public class JPAEstoqueDAO implements EstoqueDAO{
	
	//Singleton
	private static JPAEstoqueDAO INSTANCE;
	
	public static JPAEstoqueDAO getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new JPAEstoqueDAO();
		}
		return INSTANCE;
	}
	EntityManager em;
	EntityManagerFactory emf;
	
	public JPAEstoqueDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}
	
	//Busca por nome
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
	
	//Salva estoque
	public void salva(Estoque e) {
		em.getTransaction().begin();
		try {
			em.merge(e);
			em.getTransaction().commit();
		}
		catch(Exception a) {
			em.getTransaction().rollback();
			em.flush();
			em.refresh(e);
		}
		finally {
			//emf.close();
		}

	}
	
	//Remove estoque
	@Override
	public void remove(int id) {
		em.getTransaction().begin();
		Estoque estoque = em.find(Estoque.class, id);
		System.out.println("Excluindo dados de: " + estoque.getNomeProduto());
		em.remove(estoque);
		em.getTransaction().commit();
		//em.close();
	}
	
	//Lista Estoque
	@SuppressWarnings("unchecked")
	public List<Estoque> lista() {
		List<Estoque> estoques = null;
		estoques = em.createQuery("FROM " + Estoque.class.getName()).getResultList();
		if(estoques.size() == 0) {
			estoques = null;
		}
		return estoques;
	}

}
