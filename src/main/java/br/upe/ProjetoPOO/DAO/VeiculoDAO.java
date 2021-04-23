package br.upe.ProjetoPOO.DAO;

import java.util.List;
import br.upe.ProjetoPOO.Classes.Veiculo;

public interface VeiculoDAO {
	
	void salva(Veiculo v);
	Veiculo obterPorId(int id);
	Veiculo obterPorPlaca(String placa);
	Veiculo remove(int id);
	List<Veiculo> lista();
}
