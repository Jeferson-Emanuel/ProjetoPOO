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
	public void criarApartamento(Apartamento novoApartamento) throws Exception{
		try {
			interfaceApartamentoDAO.salva(novoApartamento);
		}
		catch(Exception e){
			throw e;			
		}
		/*if(obterPorBloco(novoApartamento) != null) {
			return "Apartamento já cadastrado.";
		}
		else {
			interfaceApartamentoDAO.salva(novoApartamento);
			return "Apartamento cadastrado.";
		}*/
		
	}
	//Método que lista Apartamento por Bloco
	public Apartamento obterPorBloco(Apartamento obterApartamento) throws Exception{
		try {
			return interfaceApartamentoDAO.obterPorBloco(obterApartamento.getBloco());	
		}
		catch(Exception e) {
			throw e;
		}
			
	}
	//Método para remover Apartamento
	public void removerApartamento(Apartamento removeApartamento) throws Exception{
		try {
			interfaceApartamentoDAO.remove(removeApartamento.getId());
		}
		catch(Exception e) {
			throw e;
		}
		
	}
	//Método para listar todos os Apartamentos
	public List<Apartamento> lista(){
		return interfaceApartamentoDAO.lista();
	}

}
