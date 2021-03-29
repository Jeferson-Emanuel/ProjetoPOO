package DAO;

import java.util.List;
import Classes.Produto;

public interface ProdutoDAO {
	
	void salva(Produto p);
	Produto obterPorId(int id);
	Produto remove(int id);
	List<Produto> lista();
}
