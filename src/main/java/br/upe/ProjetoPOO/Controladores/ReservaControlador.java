package br.upe.ProjetoPOO.Controladores;

import java.util.List;
import br.upe.ProjetoPOO.Classes.Reserva;
import br.upe.ProjetoPOO.DAO.ReservaDAO;
import br.upe.ProjetoPOO.DAO.JPAReservaDAO;

public class ReservaControlador implements ReservaControladorInterface {
	
	private static ReservaControlador INSTANCE;
	/**
	 * Método para chamada do Singleton nessa classe.
	 * @return Retorna a instância da classe.
	 */
	public static ReservaControlador getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new ReservaControlador();
		}
		return INSTANCE;
	}
	
	ReservaDAO interfaceReservaDAO = JPAReservaDAO.getINSTANCE();
	
	/**
	 * Método de Criar Reserva
	 * @param reservaNova recebe um objeto Reserva da interface para ser salvo no BD.
	 * @throws Exception Joga uma exceção para a interface.
	 */
	public void criarReserva(Reserva reservaNova) throws Exception{
		
		Boolean flag = checarChoque(reservaNova);

		try {
			if(flag != true) {
				interfaceReservaDAO.salva(reservaNova);
				System.out.println("Reserva feita com sucesso! 1");
			}
			if(flag == true) {
				System.out.println("Voce nao pode cadastrar nesse horario 4");
			}
		} catch (Exception e) {
			throw e;
			}
		}

	/**
	 * Método de Checar se há Choque
	 * @param reservaNova recebe um objeto Reserva da função salva e compara o id da reserva, o local e horários para checar se há choque de agendamento.
	 * @return Retorna verdadeiro se houver choque no horário agendado
	 * @return Retorna false se não houver choque
	 */

	public boolean checarChoque(Reserva reservaNova) throws Exception {
		boolean flag = false;

		ReservaDAO reservaDAO = new JPAReservaDAO();
		List<Reserva> reservaTemp = null;
		reservaTemp = reservaDAO.obterPorEspaco();

		if(reservaTemp != null) {
			for(int i=0; i < reservaTemp.size(); i ++) {
				
				
				if(reservaTemp.get(i).getId()!=reservaNova.getId()) {
				if((reservaTemp.get(i).getTipo_espaco()).equals(reservaNova.getTipo_espaco())) {
					if(reservaTemp.get(i).getData().isEqual(reservaNova.getData())) {
						if(reservaNova.getHoraInicio().compareTo(reservaTemp.get(i).getHoraInicio())==0) {
							System.out.println("Voce nao pode cadastrar nesse horario 1");
							return flag = true;
							}
						if(reservaNova.getHoraInicio().isAfter(reservaTemp.get(i).getHoraInicio()) == true) {
							if(reservaNova.getHoraInicio().isBefore(reservaTemp.get(i).getHoraFim()) == true) {
								System.out.println("Voce nao pode cadastrar nesse horario 2");
								return flag = true;
								}
							}
						if(reservaNova.getHoraInicio().isBefore(reservaTemp.get(i).getHoraInicio()) == true) {
							if(reservaNova.getHoraFim().isAfter(reservaTemp.get(i).getHoraInicio()) == true) {
								System.out.println("Voce nao pode cadastrar nesse horario 3");
								return flag = true;
								}
							}
						}
					}
				}
			}
		}
		return flag;
		}

	/**
	 * Método de remover Reserva
	 * @param novaReserva recebe um objeto Reserva da interface para ser removido do BD.
	 * @throws Exception Joga uma exceção para a interface.
	 */
	public void removerReserva(Reserva novaReserva) throws Exception{
	try {
			interfaceReservaDAO.remove(novaReserva.getId());
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Método de listar Reservas
	 * @return Retorna a lista de reservas presentes no BD
	 */
	public List<Reserva> lista(){
		return interfaceReservaDAO.lista();
	}

}