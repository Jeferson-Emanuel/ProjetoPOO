package br.upe.ProjetoPOO.Controladores;

import br.upe.ProjetoPOO.Classes.Apartamento;
import br.upe.ProjetoPOO.DAO.ApartamentoDAO;
import br.upe.ProjetoPOO.DAO.JPAApartamentoDAO;
import java.util.List;

public class ApartamentoControlador {
	
	//Receber novo apartamento
	public void criarApartamento(Apartamento novoApartamento) {
	//Extrair dados para pesquisa
		String bloco = novoApartamento.getBloco();
		int numero = novoApartamento.getNumero();
	//Pesquisar esses dados na base
		ApartamentoDAO interfaceApartamento = new JPAApartamentoDAO();
		List<Apartamento> apartamentosBase = null;
		apartamentosBase = interfaceApartamento.lista();
	//Se lista voltou não vazia, checa se já existe apartamento igual
		if(apartamentosBase != null) {
			for(int i = 0; i < apartamentosBase.size(); i ++) {
				//Extrai bloco e número do apartamento no índice i da lista
				String blocoTemp = apartamentosBase.get(i).getBloco();
				int numeroTemp = apartamentosBase.get(i).getNumero();
				if((blocoTemp).equals(bloco)) {
					if(numeroTemp == numero){
						System.out.println("Apartamento já cadastrado");
					}
					else {
						interfaceApartamento.salva(novoApartamento);
						System.out.println("Apartamento cadastrado.");
					}
				}
			}
		}
		else {
			interfaceApartamento.salva(novoApartamento);
			System.out.println("Apartamento cadastrado.");
		}
	}
	
	public Apartamento remove(Apartamento removeApartamento) {
		return null;
	}
	
	public List<Apartamento> lista(){
		ApartamentoDAO interfaceApartamento = new JPAApartamentoDAO();
		return interfaceApartamento.lista();
	}

}
