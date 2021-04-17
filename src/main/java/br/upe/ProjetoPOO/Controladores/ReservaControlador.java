package br.upe.ProjetoPOO.Controladores;

import java.util.List;

import br.upe.ProjetoPOO.Classes.Reserva;
import br.upe.ProjetoPOO.DAO.ReservaDAO;
import br.upe.ProjetoPOO.DAO.JPAReservaDAO;

public class ReservaControlador {
	
	//Receber nova reserva
	public void criarReserva(Reserva novaReserva) {
	//Extrair os dados de pesquisa
		String espacoReserva = novaReserva.getTipo_espaco();
		String dataReserva = novaReserva.getData();
		String horaInicio = novaReserva.getHoraIni();
		System.out.println(espacoReserva + dataReserva + horaInicio);
	//Pesquisar esses dados na base
	ReservaDAO reservaDAO = new JPAReservaDAO();
	List<Reserva> reservaTemp = null;
	reservaTemp = reservaDAO.obterPorEspaco();
	
	if(reservaTemp != null) {
		for(int i=0; i < reservaTemp.size(); i ++) {
			String espacoCompara = reservaTemp.get(i).getTipo_espaco();
			if(espacoCompara == espacoReserva) {
				if(reservaTemp.get(i).getData() == dataReserva) {
					if(reservaTemp.get(i).getHoraIni() == horaInicio) {
						//Todos os dados são iguais não cadastra
						System.out.println("Já há reserva.");
					}				
				}
			}
			//Se algum dado for diferente ele cadastra
			else {
				reservaDAO.salva(novaReserva);
				System.out.println("Reserva cadastrada.");
		}
		}
		
	}
	else {
		reservaDAO.salva(novaReserva);
		System.out.println("Reserva cadastrada.");
	}	
	}
}
