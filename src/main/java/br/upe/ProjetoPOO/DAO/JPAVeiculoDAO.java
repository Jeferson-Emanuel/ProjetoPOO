package br.upe.ProjetoPOO.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import br.upe.ProjetoPOO.Classes.Veiculo;

public class JPAVeiculoDAO implements VeiculoDAO {
	
	//Singleton
	private static JPAVeiculoDAO INSTANCE;
	
	public static JPAVeiculoDAO getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new JPAVeiculoDAO();
		}
		return INSTANCE;
	}
	
	EntityManager em;
	EntityManagerFactory emf;
	
	public JPAVeiculoDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}
	//Persistência que salva objeto no BD
	public void salva(Veiculo v) {
		em.getTransaction().begin();
		try {
			em.merge(v);
			em.getTransaction().commit();
		}
		catch(Exception e) {
			em.getTransaction().rollback();
			em.flush();
			em.refresh(v);
		}
	}
	//Query que recupera objeto por id
	public Veiculo obterPorId(int id) {
		em.getTransaction().begin();
		Veiculo veiculo = em.find(Veiculo.class, id);
		em.getTransaction().commit();
		emf.close();
		return veiculo;
	}
	//Query que recupera objeto por placa
	public Veiculo obterPorPlaca(String placa) {
		Veiculo veiculo = null;
		em.getTransaction().begin();

		try {
			veiculo = em.createQuery("SELECT u from Veiculo u WHERE u.placa = :placa", Veiculo.class).
					setParameter("placa", placa).getSingleResult();
		}catch(NoResultException nre){
			
		}	
		em.getTransaction().commit();
		return veiculo;	
	}	
	//Persistência que remove objeto do BD
	@Override
	public void remove(int id) {
		em.getTransaction().begin();
		Veiculo veiculo = em.find(Veiculo.class, id);
		em.remove(veiculo);
		em.getTransaction().commit();
	}
	//Query que lista todos os objetos no BD
	@SuppressWarnings("unchecked")
	public List<Veiculo> lista() {
		List<Veiculo> veiculos = null;
		veiculos = em.createQuery("FROM " + Veiculo.class.getName()).getResultList();
		if(veiculos.size() == 0) {
			veiculos = null;
		}		
		return veiculos;
	}
}
