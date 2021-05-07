package br.upe.ProjetoPOO.DAO;

import java.util.List;
import br.upe.ProjetoPOO.Classes.Apartamento;

public interface ApartamentoDAO {
	
	void salva(Apartamento ap);
	Apartamento obterPorId(int id);
	Apartamento obterPorBloco(String bloco);
	void remove(int id);
	List<Apartamento> lista();
}
