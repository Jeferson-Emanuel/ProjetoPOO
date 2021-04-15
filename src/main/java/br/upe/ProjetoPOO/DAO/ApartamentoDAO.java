package DAO;

import java.util.List;
import Classes.Apartamento;

public interface ApartamentoDAO {
	
	void salva(Apartamento ap);
	Apartamento obterPorId(int id);
	Apartamento remove(int id);
	List<Apartamento> lista();
}
