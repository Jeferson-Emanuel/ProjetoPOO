package br.upe.ProjetoPOO.Controladores;

import java.util.List;

import br.upe.ProjetoPOO.Classes.Funcionario;

public interface FuncionarioControladorInterface {
	void criarFuncionario(Funcionario funcionarioNovo);
	Funcionario remove(Funcionario removeFuncionario);
	Funcionario obterPorCpf(Funcionario obterFuncionario);
	List<Funcionario> lista();
}
