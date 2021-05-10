package br.upe.ProjetoPOO.Controladores;

import java.util.List;

import br.upe.ProjetoPOO.Classes.Veiculo;

public interface VeiculoControladorInterface {
	
	void criarVeiculo(Veiculo novoVeiculo) throws Exception;
	Veiculo obterPorPlaca(Veiculo obterVeiculo) throws Exception;
	void removerVeiculo(Veiculo removeVeiculo) throws Exception;
	List<Veiculo> lista();

}
