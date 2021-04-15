package DAO;

import java.util.List;
import Classes.Veiculo;

public interface VeiculoDAO {
	
	void salva(Veiculo v);
	Veiculo obterPorId(int id);
	Veiculo remove(int id);
	List<Veiculo> lista();
}
