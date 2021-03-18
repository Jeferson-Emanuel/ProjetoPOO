package DAO;

import java.util.List;
import Classes.Produto;

public interface ProdutoDAO {
	
	void salva(Produto p);
	void remove(Produto p);
	List<Produto> lista();
}
