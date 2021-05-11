package br.upe.ProjetoPOO.Controladores;

import java.util.List;

import br.upe.ProjetoPOO.Classes.Reserva;

public interface ReservaControladorInterface {
	void criarReserva(Reserva novaReserva) throws Exception;
	void removerReserva(Reserva novaReserva) throws Exception;
	boolean checarChoque(Reserva novaReserva) throws Exception;
	List<Reserva> lista();
}
