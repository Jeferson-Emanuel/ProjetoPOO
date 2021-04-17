package br.upe.ProjetoPOO.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import br.upe.ProjetoPOO.Classes.Produto;

public class JPAProdutoDAO implements ProdutoDAO {
	
	EntityManager em;
	EntityManagerFactory emf;
	
	public JPAProdutoDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}
	
	public Produto obterPorId(int id) {
		em.getTransaction().begin();
		Produto produto = em.find(Produto.class, id);
		em.getTransaction().commit();
		emf.close();
		return produto;
	}
	
	public Produto obterPorNome(String nome) {
		Produto produto = null;
		
		em.getTransaction().begin();
		
		try{			
			produto = em.createQuery(
					  "SELECT u from Produto u WHERE u.nome = :nome", Produto.class).
					  setParameter("nome", nome).getSingleResult();
		}
		catch (NoResultException nre){
		
		}
		
		em.getTransaction().commit();
		//em.close();		
		return produto;
	}
	
	public void salva(Produto p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		em.close();
		//emf.close();
	}
	
	@Override
	public void /*Produto*/remove(int id) {
		em.getTransaction().begin();
		Produto produto = em.find(Produto.class, id);
		System.out.println("Excluindo dados de: " + produto.getNome());
		em.remove(produto);
		em.getTransaction().commit();
		em.close();
		//return produto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> lista() {
		
		return em.createQuery("FROM " + Produto.class.getName()).getResultList();
		
		/*em.getTransaction().begin();
		Query pesquisa = em.createQuery("select a from Produto p");
		@SuppressWarnings("unchecked")
		List<Produto> produto = pesquisa.getResultList();
		em.getTransaction().commit();
		emf.close();
		return produto;*/
	}
}
