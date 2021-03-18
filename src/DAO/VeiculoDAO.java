package DAO;

import java.util.List;
import Classes.Veiculo;

public interface VeiculoDAO {
	
	void salva(Veiculo v);
	void remove(Veiculo v);
	List<Veiculo> lista();
}
