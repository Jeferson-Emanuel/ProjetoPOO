package br.upe.ProjetoPOO.Controladores;

import java.util.List;

import br.upe.ProjetoPOO.Classes.Veiculo;
import br.upe.ProjetoPOO.DAO.VeiculoDAO;
import br.upe.ProjetoPOO.DAO.JPAVeiculoDAO;

public class VeiculoControlador {
	
		public void criarVeiculo(Veiculo veiculo_novo){
		//extrair placa
		String placaNova = veiculo_novo.getPlaca();
	
		//Pesquisar na base
		VeiculoDAO veiculo_dao = new JPAVeiculoDAO();
		Veiculo veiculo_base = null;
		veiculo_base = veiculo_dao.obterPorPlaca(placaNova);
		
		//comparar cpf com resultado da base
		if(veiculo_base != null) {
			//se já existir placa, não cadastra
			System.out.println("Placa já cadastrada!");
		}else {
			//se não existir a placa, cadastra veiculo
			veiculo_dao.salva(veiculo_novo);
			System.out.println("Veículo cadastrado!");
			}
		}
		public List<Veiculo> listarVeiculo() {
			VeiculoDAO veiculo_DAO = new JPAVeiculoDAO();
			return veiculo_DAO.lista();
		}
		
		public void removerVeiculo(int id) {
			VeiculoDAO veiculo_DAO = new JPAVeiculoDAO();
			veiculo_DAO.remove(id);
		}
}
