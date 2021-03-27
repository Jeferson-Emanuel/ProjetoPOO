package DAO;

import java.util.List;
import Classes.Fornecedor;

public interface FornecedorDAO {
	
	void salva(Fornecedor f);
	Fornecedor obterPorId(int id);
	Fornecedor remove(int id);
	List<Fornecedor> lista();
}
