package br.upe.ProjetoPOO.DAO;

import static br.upe.ProjetoPOO.DAO.PersistenceManager.getEntityManager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.ProjetoPOO.Classes.Funcionario;
import static br.upe.ProjetoPOO.DAO.PersistenceManager.getEntityManager;

public class JPAFuncionarioDAO implements FuncionarioDAO {
	
	private static JPAFuncionarioDAO INSTANCE;
	/**
	 * M�todo para chamada do Singleton dessa classe.
	 * @return Retorna a inst�ncia dessa classe.
	 */
	public static JPAFuncionarioDAO getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new JPAFuncionarioDAO();
		}
		return INSTANCE;
	}

	EntityManager em;
	/**
	 * M�todo de obter funcion�rio por ID
	 * @param id recebe um int do controlador para ser procurado no atributo id de Funcion�rio no BD.
	 * @return Retorna o funcion�rio encontrado identificado pelo ID
	 * @throws Exception Joga uma exce��o para a interface.
	 */
	public Funcionario obterPorId(int id) throws Exception{
		em = getEntityManager();
		Funcionario funcionario;
		em.getTransaction().begin();
		
		try {
			funcionario = em.find(Funcionario.class, id);
			em.getTransaction().commit();
		} catch (NoResultException e) {
			em.getTransaction().rollback();
			throw e;
		}finally {
			em.close();
		}
		return funcionario;
	}
	/**
	 * M�todo de obter funcion�rio por CPF
	 * @param cpf recebe uma String do controlador para ser procurado no atributo cpf de Funcion�rio no BD.
	 * @return Retorna o funcion�rio encontrado identificado pelo CPF
	 * @throws Exception Joga uma exce��o para a interface.
	 */
	public Funcionario obterPorCpf(String cpf) throws Exception{
		em = getEntityManager();
		Funcionario funcionario;
		em.getTransaction().begin();

		try {
			funcionario = em.createQuery(
			"SELECT u from Funcionario u WHERE u.cpf = :cpf", Funcionario.class).
				setParameter("cpf", cpf).getSingleResult();
			em.getTransaction().commit();
		}
		catch(NoResultException e){
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
		return funcionario;
	}
	/**
	 * M�todo de salvar Funcion�rio
	 * @param func recebe um objeto Funcionario do controlador para ser salvo no BD.
	 * @throws Exception Joga uma exce��o para a interface.
	 */	
	public void salva(Funcionario func) throws Exception{
		em = getEntityManager();
		em.getTransaction().begin();

		try {
			em.merge(func);
			em.getTransaction().commit();
		} catch (NoResultException e) {
			em.getTransaction().rollback();
			em.flush();
			em.refresh(func);
			throw e;
		}finally {
			em.close();
		}
	}
	/**
	 * M�todo de listar Funcion�rio
	 * @return Retorna a lista de Funcionarios presentes no BD.
	 * caso vazia ou nula, @return retorna NULL
	 */
	@SuppressWarnings("unchecked")
	public List<Funcionario> lista() {
		em = getEntityManager();
		em.getTransaction().begin();
		
		try {
			return em.createQuery("FROM " + Funcionario.class.getName()).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			em.close();	
		}
		return null;
	}
	/**
	 * M�todo de deletar Funcion�rio
	 * @param id recebe um int do controlador para ser identificar o funcion�rio no BD e remov�-lo.
	 * @throws Exception Joga uma exce��o para a interface.
	 */
	@Override
	public void remove(int id) throws Exception{
		em = getEntityManager();
		em.getTransaction().begin();

		try {
			Funcionario funcionario = em.find(Funcionario.class, id); //consulta por meio do id.
			System.out.println("Excluindo os dados de: " + funcionario.getNome());
			em.remove(funcionario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
	}
}
