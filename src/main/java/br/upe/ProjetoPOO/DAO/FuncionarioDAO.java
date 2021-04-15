package DAO;

import java.util.List;
import Classes.Funcionario;

public interface FuncionarioDAO {
	
	void salva(Funcionario func);
	Funcionario obterPorId(int id);
	Funcionario remove(int id);
	List<Funcionario> lista();
}
