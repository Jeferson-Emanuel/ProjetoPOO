package br.upe.ProjetoPOO.Testes;

import br.upe.ProjetoPOO.Classes.Funcionario;
import br.upe.ProjetoPOO.Controladores.FuncionarioControlador;
import br.upe.ProjetoPOO.Controladores.InterfaceFuncionarioControlador;
import br.upe.ProjetoPOO.DAO.FuncionarioDAO;
import br.upe.ProjetoPOO.DAO.JPAFuncionarioDAO;
import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

public class FuncionarioTeste extends TestCase{
	@Test
	public void testeFuncionarioCadastra() {

		//criar um funcionário
		Funcionario funcionario = new Funcionario("666.666.666-66", "Nelson", "Porteiro", "R. Ma Fama, 14", "4002-8922");
		//cria funcionário para receber pesquisa da base
		Funcionario funcionarioBase = new Funcionario();
		//Instancia interface Funcinário
		InterfaceFuncionarioControlador interfaceFuncionario = FuncionarioControlador.getINSTANCE();
		//Grava Funcionário na base
		interfaceFuncionario.criarFuncionario(funcionario);

		//pesquisa na base
		funcionarioBase = interfaceFuncionario.obterPorCpf(funcionario);

		//Comparar
		Assert.assertTrue(funcionarioBase.getCpf().equals(funcionario.getCpf()));
		Assert.assertTrue(funcionarioBase.getNome().equals(funcionario.getNome()));
		Assert.assertTrue(funcionarioBase.getFuncao().equals(funcionario.getFuncao()));
		
		//Muda valores de funcionário externo
		funcionario.setCpf("111.222.333-64");
		funcionario.setNome("Júlio");

		//Grava Funcionário na base
		interfaceFuncionario.criarFuncionario(funcionario);

		//Pesquisa na base
		funcionarioBase = interfaceFuncionario.obterPorCpf(funcionario);

		//Comparar
		Assert.assertTrue(funcionarioBase.getCpf().equals(funcionario.getCpf()));
		Assert.assertTrue(funcionarioBase.getNome().equals(funcionario.getNome()));
		Assert.assertTrue(funcionarioBase.getFuncao().equals(funcionario.getFuncao()));
		
		//Deleta funcionário
		interfaceFuncionario.remove(interfaceFuncionario.obterPorCpf(funcionario));
		
		//Testa
		Assert.assertTrue();
		
	}
}