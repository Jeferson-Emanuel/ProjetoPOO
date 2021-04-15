package br.upe.ProjetoPOO.DAO;

import java.util.List;
import br.upe.ProjetoPOO.Classes.Produto;

public interface ProdutoDAO {
	
	void salva(Produto p);
	Produto obterPorId(int id);
	Produto remove(int id);
	List<Produto> lista();
}
