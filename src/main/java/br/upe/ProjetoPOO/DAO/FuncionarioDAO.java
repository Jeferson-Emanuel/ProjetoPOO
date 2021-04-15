package br.upe.ProjetoPOO.DAO;

import java.util.List;
import br.upe.ProjetoPOO.Classes.Funcionario;

public interface FuncionarioDAO {
	
	void salva(Funcionario func);
	Funcionario obterPorId(int id);
	Funcionario remove(int id);
	List<Funcionario> lista();
}
