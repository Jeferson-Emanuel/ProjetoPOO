package DAO;

import java.util.List;
import Classes.Morador;

public interface MoradorDAO {
	
	void salva(Morador m);
	void remove(Morador m);
	List<Morador> lista();
}
