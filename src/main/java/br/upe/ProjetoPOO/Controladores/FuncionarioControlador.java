package br.upe.ProjetoPOO.Controladores;

import br.upe.ProjetoPOO.Classes.Funcionario;
import br.upe.ProjetoPOO.DAO.FuncionarioDAO;
import br.upe.ProjetoPOO.DAO.JPAFuncionarioDAO;

public class FuncionarioControlador {
	
	//Método de criar funcionario
	public void criarFuncionario(Funcionario funcionarioNovo) {
	
	//Extrair cpf
	String cpfNovo = funcionarioNovo.getCpf();
	//Pesquisar na base
	FuncionarioDAO funcionarioDAO = new JPAFuncionarioDAO();
	Funcionario funcionarioBase = null;
	funcionarioBase = funcionarioDAO.obterPorCpf(cpfNovo);
	//Comparar cpf com resultado da base
	if(funcionarioBase != null) {
	//Se já existir cpf, não cadastra
		System.out.println("CPF já cadastrado!");
	}
	else {
	//Se não existir o cpf, cadastra funcionario
	funcionarioDAO.salva(funcionarioNovo);
	System.out.println("Funcionario Cadastrado");
	}
	}
}
