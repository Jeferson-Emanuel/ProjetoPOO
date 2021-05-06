package br.upe.ProjetoPOO.Controladores;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import br.upe.ProjetoPOO.Classes.Reserva;
import br.upe.ProjetoPOO.DAO.ReservaDAO;
import br.upe.ProjetoPOO.DAO.JPAReservaDAO;

public class ReservaControlador implements InterfaceReservaControlador {
	
	//Singleton	
	private static ReservaControlador INSTANCE;
	
	public static ReservaControlador getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new ReservaControlador();
		}
		return INSTANCE;
	}
	
	//Metodo criar reserva
	public void criarReserva(Reserva reservaNova) {
		
		//Extrai os dados da pesquisa e seta nas variaveis de comparacao
		String espacoReserva = reservaNova.getTipo_espaco();
		LocalDate data = reservaNova.getData();
		LocalTime horaInicio = reservaNova.getHoraInicio();
		LocalTime horaFim = reservaNova.getHoraFim();
		String morador = reservaNova.getMorador();
		Boolean flag = false;
		
		//Pesquisa os dados na base
		ReservaDAO reservaDAO = new JPAReservaDAO();
		List<Reserva> reservaTemp = null;
		reservaTemp = reservaDAO.obterPorEspaco();
		
		//Verifica se o banco esta vazio
		if(reservaTemp != null) {

			for(int i=0; i < reservaTemp.size(); i ++) {
				
				//pega os valores do banco e joga nas variaveis de comparação
				String espacoCompara = reservaTemp.get(i).getTipo_espaco();
				LocalDate dataCompara = reservaTemp.get(i).getData();
				LocalTime horaInicioCompara = reservaTemp.get(i).getHoraInicio();
				LocalTime horaFimCompara = reservaTemp.get(i).getHoraFim();
				String moradorCompara = reservaTemp.get(i).getMorador();

				//pega as variaveis espacoCompara (com os dados do banco) e espacoReserva (com os dados recebidos), para comparação
				
				//compara os espacos
				if((espacoCompara).equals(espacoReserva)) {
					
					//compara a data
					if(dataCompara.isEqual(data)) {
						
						//if((moradorCompara).equals(morador)) {
						//	flag = true;
						//	System.out.println("Voce nao pode cadastrar nesse horario 0");
						//}
						
							//compara a hora inicial, se for igual nao pode cadastrar
							if(horaInicio.compareTo(horaInicioCompara)==0) {
								flag = true;
								System.out.println("Voce nao pode cadastrar nesse horario 1");
								}
							
							//compara se a horaInicio (valor recebido) é maior que horaInicioCompara (valor do banco)
							if(horaInicio.isAfter(horaInicioCompara) == true) {
								
								//compara se a horaInicio (valor recebido) é menor que horaFimCompara (valor do banco)
								if(horaInicio.isBefore(horaFimCompara) == true) {
									flag = true;
									System.out.println("Voce nao pode cadastrar nesse horario 2");
									}
								}
							if(horaInicio.isBefore(horaInicioCompara) == true) {
								if(horaFim.isAfter(horaInicioCompara) == true) {
									flag = true;
									System.out.println("Voce nao pode cadastrar nesse horario 3");
									}
								}
							
						}
					}
				}
			//Verifica se o horario esta disponivel para cadastro (false)
			if(flag != true) {
				ReservaDAO interfaceReserva = new JPAReservaDAO();
				interfaceReserva.salva(reservaNova);
				System.out.println("Reserva feita com sucesso! 1");
			}
			if(flag == true) {
				System.out.println("Voce nao pode cadastrar nesse horario 4");
			}			
		
		//Caso o banco esteja vazio, cadastra direto	
		}else {
			ReservaDAO interfaceReserva = new JPAReservaDAO();
			interfaceReserva.salva(reservaNova);

			System.out.println("Reserva feita com sucesso! 2");
		}


		}
	
	//Metodo de remover a reserva
	public void removerReserva(Reserva novaReserva) {

		ReservaDAO interfaceReserva = new JPAReservaDAO();
		interfaceReserva.remove(novaReserva.getId());

	}
	
	//Metodo de listar as reservas disponiveis
	public List<Reserva> lista(){
		ReservaDAO interfaceReserva = new JPAReservaDAO();
		return interfaceReserva.lista();
	}

}
		


//--------------------------------------------------------------------------------------------//
/*package br.upe.ProjetoPOO.Controladores;

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
*/
