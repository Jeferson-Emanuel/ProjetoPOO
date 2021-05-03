package br.upe.ProjetoPOO.Testes;

import br.upe.ProjetoPOO.Classes.Funcionario;
import br.upe.ProjetoPOO.Controladores.FuncionarioControlador;
import br.upe.ProjetoPOO.DAO.FuncionarioDAO;
import br.upe.ProjetoPOO.DAO.JPAFuncionarioDAO;
import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

public class FuncionarioTeste extends TestCase{
	@Test
	public void testeFuncionarioCadastra() {
		//criar um funcionario
		Funcionario funcionario = new Funcionario("666.666.666-66", "Nelson", "Porteiro", "R. Ma Fama, 14", "4002-8922");
		FuncionarioControlador funcionarioControlador = new FuncionarioControlador();
		funcionarioControlador.criarFuncionario(funcionario);
		
		//pesquisa na base
		FuncionarioDAO funcionarioDAO = new JPAFuncionarioDAO();
		Funcionario funcionarioBase = funcionarioDAO.obterPorCpf("666.666.666-66");
		
		//extrair para compara��o
		String cpfBase = funcionarioBase.getCpf();
		//comparar
		Assert.assertEquals(cpfBase, funcionario.getCpf());
		//se existir avisa
		//seno cadastra
	}
}
