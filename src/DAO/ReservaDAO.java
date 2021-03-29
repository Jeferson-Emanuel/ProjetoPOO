package DAO;

import java.util.List;
import Classes.Reserva;

public interface ReservaDAO {
	
	void salva(Reserva r);
	Reserva obterPorId(int id);
	Reserva remove(int id);
	List<Reserva> lista();
}
