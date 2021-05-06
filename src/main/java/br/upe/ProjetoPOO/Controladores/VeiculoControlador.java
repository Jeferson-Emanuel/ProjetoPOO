package br.upe.ProjetoPOO.Controladores;

import java.util.List;

import br.upe.ProjetoPOO.Classes.Veiculo;
import br.upe.ProjetoPOO.DAO.VeiculoDAO;
import br.upe.ProjetoPOO.DAO.JPAVeiculoDAO;

public class VeiculoControlador implements VeiculoControladorInterface{

	//singleton
	private static VeiculoControlador INSTANCE;

	public static VeiculoControlador getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new VeiculoControlador();
		}
		return INSTANCE;
	}
	//Instancia JPAVeiculo
	VeiculoDAO interfaceVeiculoDAO = JPAVeiculoDAO.getINSTANCE();
	
	//Método que salva Veículo
	public void criarVeiculo(Veiculo novoVeiculo) {
		interfaceVeiculoDAO.salva(novoVeiculo);
	}
	//Método que remove Veículo
	public void removerVeiculo(Veiculo removeVeiculo) {
		interfaceVeiculoDAO.remove(removeVeiculo.getId());
	}
	//Método que lista Veículo por placa
	public Veiculo obterPorPlaca(Veiculo obterVeiculo) {
		return interfaceVeiculoDAO.obterPorPlaca(obterVeiculo.getPlaca());
	}
	//Método que lista todos veículo do BD
	public List<Veiculo> lista() {
		return interfaceVeiculoDAO.lista();
	}
}
