package br.upe.ProjetoPOO.Controladores;

import java.util.List;
import br.upe.ProjetoPOO.Classes.Funcionario;
import br.upe.ProjetoPOO.Classes.Morador;
import br.upe.ProjetoPOO.DAO.FuncionarioDAO;
import br.upe.ProjetoPOO.DAO.JPAFuncionarioDAO;

public class FuncionarioControlador implements FuncionarioControladorInterface {
	

	private static FuncionarioControlador INSTANCE;
	/**
	 * M�todo para chamada do Singleton dessa classe.
	 * @return Retorna a inst�ncia dessa classe.
	 */
	public static FuncionarioControlador getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new FuncionarioControlador();
		}
		return INSTANCE;
	}
	
	FuncionarioDAO interfaceFuncionarioDAO = JPAFuncionarioDAO.getINSTANCE();
	/**
	 * M�todo de gravar Funcion�rio
	 * @param funcionarioNovo recebe um objeto Funcionario da interface para ser salvo no BD.
	 * @throws Exception Joga uma exce��o para a interface.
	 */
	public void criarFuncionario(Funcionario funcionarioNovo) throws Exception {
		
		try {
			interfaceFuncionarioDAO.salva(funcionarioNovo) ;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * M�todo de deletar Funcion�rio
	 * @param removeFuncionario recebe um objeto Funcionario da interface para ser removido do BD.
	 * @throws Exception Joga uma exce��o para a interface.
	 */
	public void remove(Funcionario removeFuncionario)  throws Exception{
		try {
			interfaceFuncionarioDAO.remove(removeFuncionario.getId());
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * M�todo de obter funcion�rio por CPF
	 * @param obterFuncionario recebe um objeto Funcionario da interface para ser procurado no BD.
	 * @return Retorna o funcion�rio encontrado identificado pelo CPF
	 * @throws Exception Joga uma exce��o para a interface.
	 */
	public Funcionario obterPorCpf(Funcionario obterFuncionario) throws Exception {
		try {
			return interfaceFuncionarioDAO.obterPorCpf(obterFuncionario.getCpf());
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * M�todo de listar Funcion�rio
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