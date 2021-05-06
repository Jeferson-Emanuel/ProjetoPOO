package br.upe.ProjetoPOO.Controladores;

import java.util.List;

import br.upe.ProjetoPOO.Classes.Funcionario;

public interface InterfaceFuncionarioControlador {
	void criarFuncionario(Funcionario funcionarioNovo);
	Funcionario remove(Funcionario removeFuncionario);
	List<Funcionario> lista();
}
