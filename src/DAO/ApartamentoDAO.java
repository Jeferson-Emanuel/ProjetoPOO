package DAO;

import java.util.List;
import Classes.Apartamento;

public interface ApartamentoDAO {
	
	void salva(Apartamento ap);
	void remove(Apartamento ap);
	List<Apartamento> lista();
}
