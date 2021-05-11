package br.upe.ProjetoPOO.DAO;

import java.util.List;
import br.upe.ProjetoPOO.Classes.Apartamento;

public interface ApartamentoDAO {
	
	void salva(Apartamento ap) throws Exception;
	Apartamento obterPorId(int id) throws Exception;
	Apartamento obterPorBloco(String bloco) throws Exception;
	void remove(int id) throws Exception;
	List<Apartamento> lista();
}
