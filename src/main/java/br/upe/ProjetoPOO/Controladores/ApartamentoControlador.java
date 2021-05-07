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
	
	//Instancia Interface ApartamentoDAO
	ApartamentoDAO interfaceApartamentoDAO = JPAApartamentoDAO.getINSTANCE();

	//Método para gravar Apartamento
	public String criarApartamento(Apartamento novoApartamento) {
		Apartamento apTemp = obterPorBloco(novoApartamento);

		if(apTemp != null) {
			return "Apartamento já cadastrado.";
		}
		else {
			interfaceApartamentoDAO.salva(novoApartamento);
			return "Apartamento cadastrado.";
		}
		
	}
	//Método que lista Apartamento por Bloco
	public Apartamento obterPorBloco(Apartamento obterApartamento) {
		return interfaceApartamentoDAO.obterPorBloco(obterApartamento.getBloco());		
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
