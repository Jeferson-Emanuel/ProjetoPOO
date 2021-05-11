package br.upe.ProjetoPOO.Controladores;

import java.util.List;
import br.upe.ProjetoPOO.Classes.Funcionario;
import br.upe.ProjetoPOO.Classes.Morador;
import br.upe.ProjetoPOO.DAO.FuncionarioDAO;
import br.upe.ProjetoPOO.DAO.JPAFuncionarioDAO;

public class FuncionarioControlador implements FuncionarioControladorInterface {
	

	private static FuncionarioControlador INSTANCE;
	/**
	 * Método para chamada do Singleton dessa classe.
	 * @return Retorna a instância dessa classe.
	 */
	public static FuncionarioControlador getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new FuncionarioControlador();
		}
		return INSTANCE;
	}
	
	FuncionarioDAO interfaceFuncionarioDAO = JPAFuncionarioDAO.getINSTANCE();
	/**
	 * Método de gravar Funcionário
	 * @param funcionarioNovo recebe um objeto Funcionario da interface para ser salvo no BD.
	 * @throws Exception Joga uma exceção para a interface.
	 */
	public void criarFuncionario(Funcionario funcionarioNovo) throws Exception {
		
		try {
			interfaceFuncionarioDAO.salva(funcionarioNovo) ;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Método de deletar Funcionário
	 * @param removeFuncionario recebe um objeto Funcionario da interface para ser removido do BD.
	 * @throws Exception Joga uma exceção para a interface.
	 */
	public void remove(Funcionario removeFuncionario)  throws Exception{
		try {
			interfaceFuncionarioDAO.remove(removeFuncionario.getId());
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Método de obter funcionário por CPF
	 * @param obterFuncionario recebe um objeto Funcionario da interface para ser procurado no BD.
	 * @return Retorna o funcionário encontrado identificado pelo CPF
	 * @throws Exception Joga uma exceção para a interface.
	 */
	public Funcionario obterPorCpf(Funcionario obterFuncionario) throws Exception {
		try {
			return interfaceFuncionarioDAO.obterPorCpf(obterFuncionario.getCpf());
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Método de listar Funcionário
	 * @return Retorna a lista de Funcionarios presentes no BD.
	 * caso vazia ou nula, @return retorna NULL
	 */
	public List<Funcionario> lista(){
		 List<Funcionario> lista;
	     if ((lista = interfaceFuncionarioDAO.lista()).size() == 0) {
	       lista = null;
	     }
	     return lista;
	}
}