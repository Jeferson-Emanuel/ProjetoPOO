package br.upe.ProjetoPOO.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.ProjetoPOO.Classes.Apartamento;

public class JPAApartamentoDAO implements ApartamentoDAO {
	
	//Singleton
	private static JPAApartamentoDAO INSTANCE;
	
	public static JPAApartamentoDAO getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new JPAApartamentoDAO();
		}
		return INSTANCE;
	}
	
	//Instancia de conexão com o BD
	EntityManager em;
	EntityManagerFactory emf;
	
	//Método de conexão com o BD
	public JPAApartamentoDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}	
	
	//Persistência de objeto no BD
	public void salva(Apartamento ap) {
		em.getTransaction().begin();
		try {
			em.merge(ap);
			em.getTransaction().commit();
		}
		catch(Exception e) {
			em.getTransaction().rollback();
			em.flush();
			em.refresh(ap);
		}
	}
	
	//Query que retorna Apartamento por id
	public Apartamento obterPorId(int id) {
		em.getTransaction().begin();
		Apartamento apartamento = em.find(Apartamento.class, id);
		em.getTransaction().commit();
		emf.close();
		return apartamento;
	}
	
	//Persistência que remove Apartamento
	@Override
	public void remove(int id) {
		em.getTransaction().begin();
		Apartamento apartamento = em.find(Apartamento.class, id);
		em.remove(apartamento);
		em.getTransaction().commit();
	}
	
	//Query que traz todos Apartamentos do BD
	@SuppressWarnings("unchecked")
	public List<Apartamento> lista() {
		List<Apartamento> apartamentos = null;
		apartamentos = em.createQuery("FROM " + Apartamento.class.getName()).getResultList();
		if(apartamentos.size() == 0) {
			apartamentos = null;
		}
		return apartamentos;
	}
}
