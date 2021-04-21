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
		em.merge(v);
		em.getTransaction().commit();
		emf.close();
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
		
		return em.createQuery("FROM " + Veiculo.class.getName()).getResultList();
		
		/*em.getTransaction().begin();
		Query pesquisa = em.createQuery("select a from Veiculo v");
		@SuppressWarnings("unchecked")
		List<Veiculo> veiculo = pesquisa.getResultList();
		em.getTransaction().commit();
		emf.close();
		return veiculo;*/
	}
}
