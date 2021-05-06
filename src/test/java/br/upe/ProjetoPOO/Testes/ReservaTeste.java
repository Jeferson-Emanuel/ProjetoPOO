package br.upe.ProjetoPOO.Testes;


import br.upe.ProjetoPOO.Classes.Reserva;
import br.upe.ProjetoPOO.Controladores.InterfaceReservaControlador;
import br.upe.ProjetoPOO.Controladores.ReservaControlador;
import br.upe.ProjetoPOO.DAO.ReservaDAO;
import br.upe.ProjetoPOO.DAO.JPAReservaDAO;
import junit.framework.TestCase;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ReservaTeste extends TestCase{
	
	@Test
	public void testReservaAdiciona(){
		
		LocalDate data = LocalDate.parse("2021-05-04");
		LocalTime horaini = LocalTime.parse("15:00");
		LocalTime horafim = LocalTime.parse("17:00");
		
		//Cria instÃ¢ncia de Reserva
		Reserva criaReserva = new Reserva("Piscina", data, horaini, horafim, "kiko");	
		
		//Cria instÃ¢ncia do controlador
		InterfaceReservaControlador reserva = new ReservaControlador();
		
		//Envia objeto da reserva pro controlador
		reserva.criarReserva(criaReserva);
		
		//Cria instÃ¢ncia da interface de Reserva		
		ReservaDAO interfaceReserva = new JPAReservaDAO();
		
		//Recupera lista de todas as reservas no banco
		List<Reserva>listaTeste = interfaceReserva.lista();
		
		//Extrai dados do Ãºnico objeto da lista
		String espaco = listaTeste.get(0).getTipo_espaco();
		LocalDate dataTeste = listaTeste.get(0).getData();
		LocalTime horaInicio = listaTeste.get(0).getHoraInicio();
		LocalTime horaFim = listaTeste.get(0).getHoraFim();
		String morador = listaTeste.get(0).getMorador();
		
		//Testa se esse valores sÃ£o iguais ao do objeto adicionado
		Assert.assertTrue((espaco).equals(criaReserva.getTipo_espaco()));
		Assert.assertTrue((dataTeste).equals(criaReserva.getData()));
		Assert.assertTrue((horaInicio).equals(criaReserva.getHoraInicio()));
		Assert.assertTrue((horaFim).equals(criaReserva.getHoraFim()));
		Assert.assertTrue((morador).equals(criaReserva.getMorador()));
		
		
		
		/*//Cria instÃ¢ncia de Reserva
		Reserva reserva = new Reserva("Piscina", "04/05/2022", "9:00h", "12:00h");
		//Cria instÃ¢ncia do controlador
		ReservaControlador reservaControlador = new ReservaControlador();
		//Envia objeto da reserva pro controlador
		reservaControlador.criarReserva(reserva);
		//Cria instÃ¢ncia da interface de Reserva
		ReservaDAO interfaceReserva = new JPAReservaDAO();
		//Recupera lista de todas as reservas no banco
		List<Reserva> listaTeste = interfaceReserva.lista();
		//Extrai dados do Ãºnico objeto da lista
		String espaco = listaTeste.get(0).getTipo_espaco();
		String data = listaTeste.get(0).getData();
		String horaInicio = listaTeste.get(0).getHoraIni();
		//Testa se esse valores sÃ£o iguais ao do objeto adicionado
		Assert.assertTrue((espaco).equals(reserva.getTipo_espaco()));
		Assert.assertTrue((data).equals(reserva.getData()));
		Assert.assertTrue((horaInicio).equals(reserva.getHoraIni()));*/
		
	}

}





//--------------------------------------------------------------------------------------//
/*package br.upe.ProjetoPOO.Testes;

import br.upe.ProjetoPOO.Classes.Reserva;
import br.upe.ProjetoPOO.Controladores.ReservaControlador;
import br.upe.ProjetoPOO.DAO.ReservaDAO;
import br.upe.ProjetoPOO.DAO.JPAReservaDAO;
import junit.framework.TestCase;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ReservaTeste extends TestCase{
	
	public void testReservaAdiciona(){
		
		//Cria instância de Reserva
		Reserva reserva = new Reserva("Piscina", "04/05/2022", "9:00h", "12:00h");
		//Cria instância do controlador
		ReservaControlador reservaControlador = new ReservaControlador();
		//Envia objeto da reserva pro controlador
		reservaControlador.criarReserva(reserva);
		//Cria instância da interface de Reserva
		ReservaDAO interfaceReserva = new JPAReservaDAO();
		//Recupera lista de todas as reservas no banco
		List<Reserva> listaTeste = interfaceReserva.lista();
		//Extrai dados do único objeto da lista
		String espaco = listaTeste.get(0).getTipo_espaco();
		String data = listaTeste.get(0).getData();
		String horaInicio = listaTeste.get(0).getHoraIni();
		//Testa se esse valores são iguais ao do objeto adicionado
		Assert.assertTrue((espaco).equals(reserva.getTipo_espaco()));
		Assert.assertTrue((data).equals(reserva.getData()));
		Assert.assertTrue((horaInicio).equals(reserva.getHoraIni()));
		
	}

}
*/
