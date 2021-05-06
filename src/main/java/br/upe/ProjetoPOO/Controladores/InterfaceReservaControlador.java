package br.upe.ProjetoPOO.Controladores;

import java.util.List;

import br.upe.ProjetoPOO.Classes.Reserva;

public interface InterfaceReservaControlador {
	void criarReserva(Reserva novaReserva);
	void removerReserva(Reserva novaReserva);
	List<Reserva> lista();
}
