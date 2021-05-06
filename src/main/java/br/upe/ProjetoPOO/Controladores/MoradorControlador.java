package br.upe.ProjetoPOO.Controladores;

import java.util.List;

import br.upe.ProjetoPOO.Classes.Morador;
import br.upe.ProjetoPOO.DAO.MoradorDAO;
import br.upe.ProjetoPOO.DAO.JPAMoradorDAO;

public class MoradorControlador {
	
	//Singleton
	private static MoradorControlador INSTANCE;
	
	public static MoradorControlador getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new MoradorControlador();
		}
		return INSTANCE;
	}
	
	public void criarMorador(Morador novoMorador) {
		MoradorDAO interfaceMorador = new JPAMoradorDAO();
		interfaceMorador.salva(novoMorador);
	}
	
	public void removerMorador(Morador removeMorador) {
		MoradorDAO interfaceMorador = new JPAMoradorDAO();
		interfaceMorador.remove(removeMorador.getId());
	}
	
	public List<Morador> lista(){
		MoradorDAO interfaceMorador = new JPAMoradorDAO();
		return interfaceMorador.lista();
	}

/*
	//Método de criar morador
	public void criarMorador(Morador moradorNovo) {	
	//Extrair cpf
	String cpfNovo = moradorNovo.getCpf();
	//Pesquisar na base
	MoradorDAO moradorDAO = new JPAMoradorDAO();
	Morador moradorBase = null;
	moradorBase = moradorDAO.obterPorCpf(cpfNovo);
	//Comparar cpf com resultado da base
	if(moradorBase != null) {
		//Se já existir cpf, não cadastra
		System.out.println("CPF já cadastrado.");
	}
	else {
		//Se não existir o cpf, cadastra morador
		moradorDAO.salva(moradorNovo);
		System.out.println("Morador cadastrado.");
	}	
	}
*/
}
