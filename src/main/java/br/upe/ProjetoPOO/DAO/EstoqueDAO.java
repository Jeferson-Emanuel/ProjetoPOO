package br.upe.ProjetoPOO.DAO;

import java.util.List;
import br.upe.ProjetoPOO.Classes.Estoque;

public interface EstoqueDAO {
	
	void salva(Estoque e);
	Estoque obterPorNome(String nome);
	void remove(int id);
	List<Estoque> lista();

}
