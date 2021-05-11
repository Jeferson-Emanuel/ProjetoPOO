package br.upe.ProjetoPOO.Controladores;

import java.util.List;

import br.upe.ProjetoPOO.Classes.Funcionario;

public interface FuncionarioControladorInterface {
	void criarFuncionario(Funcionario funcionarioNovo) throws Exception;
	void remove(Funcionario removeFuncionario) throws Exception;
	Funcionario obterPorCpf(Funcionario obterFuncionario) throws Exception;
	List<Funcionario> lista();
}
