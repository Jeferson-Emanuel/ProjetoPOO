package br.upe.ProjetoPOO.DAO;

import java.util.List;
import br.upe.ProjetoPOO.Classes.Reserva;

public interface ReservaDAO {
	
	void salva(Reserva r) throws Exception;
	Reserva obterPorId(int id) throws Exception;
	List<Reserva> obterPorEspaco() throws Exception;
	void remove(int id) throws Exception;
	List<Reserva> lista();
}
