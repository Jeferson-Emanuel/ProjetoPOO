package br.upe.ProjetoPOO.DAO;

import static br.upe.ProjetoPOO.DAO.PersistenceManager.getEntityManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import br.upe.ProjetoPOO.Classes.Produto;
import br.upe.ProjetoPOO.Classes.Reserva;

import static br.upe.ProjetoPOO.DAO.PersistenceManager.getEntityManager;

public class JPAReservaDAO implements ReservaDAO {
	
	private static JPAReservaDAO INSTANCE;
	/**
	* Método para chamada do Singleton nessa classe.
	* @return Retorna a instância da classe.
	*/ 
	public static JPAReservaDAO getINSTANCE() {
			if(INSTANCE == null) {
				INSTANCE = new JPAReservaDAO();
			}
			return INSTANCE;
		}
	
	 EntityManager em;
		/**
		* Método de obter funcionário pelo ID
		* @param id recebe um int do controlador para ser procurado no atributo id de Reserva no BD
		* @return Retorna a reserva encontrada identificada pelo ID
		* @throws Exception Joga uma exceção para a interface.
		*/
	 public Reserva obterPorId(int id) throws Exception {			
			em = getEntityManager();
			em.getTransaction().begin();
			Reserva reserva;

			try {
				reserva = em.find(Reserva.class, id);
				em.getTransaction().commit();
			} catch (Exception e) {
				em.getTransaction().rollback();
				throw e;
			}finally {
				em.close();
			}
			return reserva;
		}

	/**
	* Método de obter funcionário pelo Espaço
	* @return Retorna uma lista de reservas com o mesmo tipo de espacos
	* @throws Exception Joga uma exceção para a interface.
	*/
	public List<Reserva> obterPorEspaco() throws Exception{
		List<Reserva> reservas = null;
		em = getEntityManager();
		em.getTransaction().begin();
		try{	
			reservas = (List<Reserva>)(Object) em.createQuery("FROM " + Reserva.class.getName()).getResultList();
			em.getTransaction().commit();
			if(reservas.size()==0) {
				reservas = null;
			}		
		}catch (NoResultException nre){
			throw nre;
		}finally {
			em.close();
			}
		return reservas;
	}
	/**
	 * Método de Salvar Reserva
	 * @param r recebe um objeto Reserva do controlador para ser salvo no BD.
	 * @throws Exception Joga uma exceção para a interface.
	 */
	
	public void salva(Reserva r) throws Exception {	
		em = getEntityManager();
		em.getTransaction().begin();
		
		try {
			em.merge(r);
			em.getTransaction().commit();
		} catch (EntityExistsException e) {
			em.getTransaction().rollback();
			em.flush();
			em.refresh(r);
			throw e;
		}finally {
			em.close();
		}
	}
	/**
	 * Método de remover Reserva
	 * @param id recebe um int do controlador para identificar uma reserva no BD e remove-la.
	 * @throws Exception Joga uma exceção para a interface.
	 */
	@Override
	public void remove(int id) throws Exception {
		em = getEntityManager();
		em.getTransaction().begin();
		Reserva reserva;
			
		try {
			reserva = em.find(Reserva.class, id);
			System.out.println("Excluindo dados de: " + reserva.getId());
			em.remove(reserva);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
	}
	/**
	 * Método de listar Reservas
	 * @return Retorna a lista de reservas presentes no BD
	 * caso nula, @return retorna NULL
	 */
	@SuppressWarnings("unchecked")
	public List<Reserva> lista() {
		em = getEntityManager();
		em.getTransaction().begin();
		
		try {
			return em.createQuery("FROM " + Reserva.class.getName()).getResultList();
		} catch (Exception e) {
			
		}finally {
			em.close();
		}
		return null;
	}
}
