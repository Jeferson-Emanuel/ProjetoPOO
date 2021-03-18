package DAO;

import java.util.List;
import Classes.Reserva;

public interface ReservaDAO {
	
	void salva(Reserva r);
	void remove(Reserva r);
	List<Reserva> lista();
}
