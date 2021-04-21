package br.upe.ProjetoPOO.DAO;

import java.util.List;

import br.upe.ProjetoPOO.Classes.Apartamento;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAApartamentoDAO implements ApartamentoDAO {
	
	EntityManager em;
	EntityManagerFactory emf;
	
	public JPAApartamentoDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}
	
	public Apartamento obterPorId(int id) {
		em.getTransaction().begin();
		Apartamento apartamento = em.find(Apartamento.class, id);
		em.getTransaction().commit();
		emf.close();
		return apartamento;
	}
	
	public void salva(Apartamento ap) {
		em.getTransaction().begin();
		em.merge(ap);
		em.getTransaction().commit();
		emf.close();
	}
	
	@Override
	public Apartamento remove(int id) {
		em.getTransaction().begin();
		Apartamento apartamento = em.find(Apartamento.class, id);
		System.out.println("Excluindo dados do: " + apartamento.getId());
		em.remove(apartamento);
		em.getTransaction().commit();
		em.close();
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Apartamento> lista() {
		List<Apartamento> apartamentos = null;
		apartamentos = em.createQuery("FROM " + Apartamento.class.getName()).getResultList();
		if(apartamentos.size() == 0) {
			apartamentos = null;
		}
		return apartamentos;	
		
		/*em.getTransaction().begin();
		Query pesquisa = em.createQuery("select a from Apartamento ap");
		@SuppressWarnings("unchecked")
		List<Apartamento> apartamento = pesquisa.getResultList();
		em.getTransaction().commit();
		emf.close();
		return apartamento;*/
	}
}
