package DAO;

import java.util.List;
import Classes.Morador;

public interface MoradorDAO {
	
	void salva(Morador m);
	Morador obterPorId(int id);
	Morador remove(int id);
	List<Morador> lista();
}
