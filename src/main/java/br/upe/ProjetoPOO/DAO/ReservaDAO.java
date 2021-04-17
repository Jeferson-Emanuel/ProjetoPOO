package br.upe.ProjetoPOO.DAO;

import java.util.List;
import br.upe.ProjetoPOO.Classes.Reserva;

public interface ReservaDAO {
	
	void salva(Reserva r);
	Reserva obterPorId(int id);
	List<Reserva> obterPorEspaco();
	Reserva remove(int id);
	List<Reserva> lista();
}
