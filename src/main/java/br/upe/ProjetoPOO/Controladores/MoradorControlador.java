package br.upe.ProjetoPOO.Controladores;

import java.util.List;

import br.upe.ProjetoPOO.Classes.Morador;
import br.upe.ProjetoPOO.DAO.MoradorDAO;
import br.upe.ProjetoPOO.DAO.JPAMoradorDAO;

public class MoradorControlador implements MoradorControladorInterface{
	
	//Singleton
	private static MoradorControlador INSTANCE;
	
	public static MoradorControlador getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new MoradorControlador();
		}
		return INSTANCE;
	}
	
	//Instancia o JPAMorador
	MoradorDAO interfaceMoradorDAO = JPAMoradorDAO.getINSTANCE();
	
	//Método que salva Morador
	public void criarMorador(Morador novoMorador) {
		interfaceMoradorDAO.salva(novoMorador);
	}
	//Método que remove Morador
	public void removerMorador(Morador removeMorador) {
		interfaceMoradorDAO.remove(removeMorador.getId());
	}
	//Método que lista todos Moradores
	public List<Morador> lista(){
		return interfaceMoradorDAO.lista();
	}
}
