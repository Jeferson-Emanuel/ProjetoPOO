package DAO;

import java.util.List;
import Classes.Fornecedor;

public interface FornecedorDAO {
	
	void salva(Fornecedor f);
	void remove(Fornecedor f);
	List<Fornecedor> lista();
}
