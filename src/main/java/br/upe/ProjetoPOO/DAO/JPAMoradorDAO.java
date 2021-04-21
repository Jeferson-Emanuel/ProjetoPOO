package br.upe.ProjetoPOO.DAO;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

import br.upe.ProjetoPOO.Classes.Morador;

public class JPAMoradorDAO implements MoradorDAO {
	
	EntityManager em;
	EntityManagerFactory emf;
	
	public JPAMoradorDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}
	
	public Morador obterPorId(int id) {
		em.getTransaction().begin();
		Morador morador = em.find(Morador.class, id);
		em.getTransaction().commit();
		emf.close();
		return morador;
	}
	public Morador obterPorCpf(String cpf) {
		Morador morador = null;
		em.getTransaction().begin();
		//Morador morador = em.find(Morador.class, id);
		try{			
			morador = em.createQuery(
					  "SELECT u from Morador u WHERE u.cpf = :cpf", Morador.class).
					  setParameter("cpf", cpf).getSingleResult();
		}
		catch (NoResultException nre){
		
		}
		em.getTransaction().commit();
		//emf.close();
		return morador;
	}
	
	public void salva(Morador m) {
		em.getTransaction().begin();
		em.merge(m);
		em.getTransaction().commit();
		emf.close();
	}
	
	@Override
	public Morador remove(int id) {
		em.getTransaction().begin();
		Morador morador = em.find(Morador.class, id);
		System.out.println("Excluindo dados de: " + morador.getNome());
		em.remove(morador);
		em.getTransaction().commit();
		em.close();
		return morador;
	}
	
	@SuppressWarnings("unchecked")
	public List<Morador> lista() {
		
		return em.createQuery("FROM " + Morador.class.getName()).getResultList();
		
		/*em.getTransaction().begin();
		Query pesquisa = em.createQuery("select a from Morador m");
		@SuppressWarnings("unchecked")
		List<Morador> morador = pesquisa.getResultList();
		em.getTransaction().commit();
		emf.close();
		return morador;*/
	}
}
