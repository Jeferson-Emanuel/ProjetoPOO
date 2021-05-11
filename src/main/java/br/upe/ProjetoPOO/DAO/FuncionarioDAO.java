package br.upe.ProjetoPOO.DAO;

import java.util.List;
import br.upe.ProjetoPOO.Classes.Funcionario;

public interface FuncionarioDAO {
	
	void salva(Funcionario func)throws Exception;
	void remove(int id)throws Exception;
	Funcionario obterPorId(int id)throws Exception;
	Funcionario obterPorCpf(String cpf)throws Exception;	
	List<Funcionario> lista();
}
