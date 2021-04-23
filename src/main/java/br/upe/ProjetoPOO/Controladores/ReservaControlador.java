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
	//Pesquisar esses dados na base
	ReservaDAO reservaDAO = new JPAReservaDAO();
	List<Reserva> reservaTemp = null;
	reservaTemp = reservaDAO.obterPorEspaco();
	
	if(reservaTemp != null) {
		System.out.println(reservaTemp.size());
		for(int i=0; i < reservaTemp.size(); i ++) {
			String espacoCompara = reservaTemp.get(i).getTipo_espaco();
			if((espacoCompara).equals(espacoReserva)) {
				if((reservaTemp.get(i).getData()).equals(dataReserva)) {
					if((reservaTemp.get(i).getHoraIni()).equals(horaInicio)) {
						//Todos os dados são iguais não cadastra
						System.out.println("Já há reserva.");
					}
					else {
						reservaDAO.salva(novaReserva);
						System.out.println("Reserva cadastrada.");
					}
				}
				else {
					reservaDAO.salva(novaReserva);
					System.out.println("Reserva cadastrada.");
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
	
	public List<Reserva> lista(){
		ReservaDAO reservaDAO = new JPAReservaDAO();
		return reservaDAO.lista();
	}
}
