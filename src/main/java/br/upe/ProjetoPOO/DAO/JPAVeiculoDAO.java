package br.upe.ProjetoPOO.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import br.upe.ProjetoPOO.Classes.Veiculo;

public class JPAVeiculoDAO implements VeiculoDAO {
	
	EntityManager em;
	EntityManagerFactory emf;
	
	public JPAVeiculoDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}
	
	public Veiculo obterPorId(int id) {
		em.getTransaction().begin();
		Veiculo veiculo = em.find(Veiculo.class, id);
		em.getTransaction().commit();
		emf.close();
		return veiculo;
	}
	
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
		finally {
			emf.close();
		}
	}
	
	@Override
	public Veiculo remove(int id) {
		em.getTransaction().begin();
		Veiculo veiculo = em.find(Veiculo.class, id);
		System.out.println("Excluindo dados de: " + veiculo.getPlaca());
		em.remove(veiculo);
		em.getTransaction().commit();
		em.close();
		return veiculo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Veiculo> lista() {
		List<Veiculo> veiculos = null;
		veiculos = em.createQuery("FROM " + Veiculo.class.getName()).getResultList();
		if(veiculos.size() == 0) {
			veiculos = null;
		}		
		return veiculos;
		
		/*em.getTransaction().begin();
		Query pesquisa = em.createQuery("select a from Veiculo v");
		@SuppressWarnings("unchecked")
		List<Veiculo> veiculo = pesquisa.getResultList();
		em.getTransaction().commit();
		emf.close();
		return veiculo;*/
	}
}
