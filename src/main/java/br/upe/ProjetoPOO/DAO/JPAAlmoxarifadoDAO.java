package br.upe.ProjetoPOO.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.upe.ProjetoPOO.Classes.Almoxarifado;

public class JPAAlmoxarifadoDAO implements AlmoxarifadoDAO {
	
	//Singleton
	private static JPAAlmoxarifadoDAO INSTANCE;
	
	public static JPAAlmoxarifadoDAO getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new JPAAlmoxarifadoDAO();
		}
		return INSTANCE;
	}

	EntityManager em;
	EntityManagerFactory emf;

	public JPAAlmoxarifadoDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}

	public Almoxarifado obterPorId(int id) {
		em.getTransaction().begin();
		Almoxarifado almoxarifado = em.find(Almoxarifado.class, id);
		em.getTransaction().commit();
		emf.close();
		return almoxarifado;
	}

	public void salva(Almoxarifado a) {
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
		//emf.close();
	}

	@Override
	public Almoxarifado remove(int id) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		Almoxarifado almoxarifado = em.find(Almoxarifado.class, id); //consulta por meio do id.
		System.out.println("Excluindo os dados de: " + almoxarifado.getId());
		em.remove(almoxarifado);
		em.getTransaction().commit();
		em.close();
		return almoxarifado;
	}

	@SuppressWarnings("unchecked")
	public List<Almoxarifado> lista() {

		Query query = em.createQuery("SELECT DISTINCT a FROM Almoxarifado a INNER JOIN a.fluxoProdutos p");
		List<Almoxarifado> resultList = query.getResultList();
		
		return resultList;

		//return em.createQuery("FROM " + Almoxarifado.class.getName()).getResultList();		

		/*em.getTransaction().begin();
		Query pesquisa = em.createQuery("select a from Almoxarifado a");
		@SuppressWarnings("unchecked")
		List<Almoxarifado> almoxarifado = pesquisa.getResultList();
		em.getTransaction().commit();
		emf.close();
		return almoxarifado;*/
	}

}
