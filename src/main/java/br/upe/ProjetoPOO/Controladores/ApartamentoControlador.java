package br.upe.ProjetoPOO.Controladores;

import java.util.List;

import br.upe.ProjetoPOO.Classes.Apartamento;
import br.upe.ProjetoPOO.DAO.ApartamentoDAO;
import br.upe.ProjetoPOO.DAO.JPAApartamentoDAO;

public class ApartamentoControlador implements ApartamentoControladorInterface{

	//Singleton	
	private static ApartamentoControlador INSTANCE;

	public static ApartamentoControlador getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new ApartamentoControlador();
		}
		return INSTANCE;
	}

	ApartamentoDAO interfaceApartamentoDAO = JPAApartamentoDAO.getINSTANCE();

	//Método para gravar Apartamento
	public void criarApartamento(Apartamento novoApartamento) {
		interfaceApartamentoDAO.salva(novoApartamento);
	}
	//Método para remover Apartamento
	public void removerApartamento(Apartamento removeApartamento) {
		interfaceApartamentoDAO.remove(removeApartamento.getId());
	}
	//Método para listar todos os Apartamentos
	public List<Apartamento> lista(){
		return interfaceApartamentoDAO.lista();
	}

}
