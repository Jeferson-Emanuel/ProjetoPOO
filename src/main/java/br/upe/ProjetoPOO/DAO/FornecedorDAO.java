package br.upe.ProjetoPOO.DAO;

import java.util.List;
import br.upe.ProjetoPOO.Classes.Fornecedor;

public interface FornecedorDAO {
	
	void salva(Fornecedor f);
	Fornecedor obterPorId(int id);
	Fornecedor remove(int id);
	List<Fornecedor> lista();
}
