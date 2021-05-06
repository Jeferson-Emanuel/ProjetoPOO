package br.upe.ProjetoPOO.Controladores;

import java.util.List;

import br.upe.ProjetoPOO.Classes.Veiculo;
import br.upe.ProjetoPOO.DAO.VeiculoDAO;
import br.upe.ProjetoPOO.DAO.JPAVeiculoDAO;

public class VeiculoControlador {

	//singleton
	private static VeiculoControlador INSTANCE;

	public static VeiculoControlador getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new VeiculoControlador();
		}
		return INSTANCE;
	}

	public void criarVeiculo(Veiculo novoVeiculo) {
		VeiculoDAO interfaceVeiculo = new JPAVeiculoDAO();
		interfaceVeiculo.salva(novoVeiculo);
	}
	

	public void removerVeiculo(Veiculo removeVeiculo) {
		VeiculoDAO interfaceVeiculo = new JPAVeiculoDAO();
		interfaceVeiculo.remove(removeVeiculo.getId());
	}
	
	public List<Veiculo> lista() {
		VeiculoDAO interfaceVeiculo = new JPAVeiculoDAO();
		return interfaceVeiculo.lista();
	}

	/*public void criarVeiculo(Veiculo veiculo_novo){
		//extrair placa
		String placaNova = veiculo_novo.getPlaca();

		//Pesquisar na base
		VeiculoDAO veiculo_dao = new JPAVeiculoDAO();
		Veiculo veiculo_base = null;
		veiculo_base = veiculo_dao.obterPorPlaca(placaNova);

		//comparar cpf com resultado da base
		if(veiculo_base != null) {
			//se já existir placa, não cadastra
			System.out.println("Placa j� cadastrada!");
		}else {
			//se n�o existir a placa, cadastra veiculo
			veiculo_dao.salva(veiculo_novo);
			System.out.println("Ve�culo cadastrado!");
		}
	}*/
}
