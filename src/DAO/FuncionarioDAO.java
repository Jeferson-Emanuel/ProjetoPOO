package DAO;

import java.util.List;
import Classes.Funcionario;

public interface FuncionarioDAO {
	
	void salva(Funcionario func);
	void remove(Funcionario func);
	List<Funcionario> lista();
}
