package br.upe.ProjetoPOO.Controladores;

import java.util.List;

import br.upe.ProjetoPOO.Classes.Veiculo;

public interface VeiculoControladorInterface {
	
	void criarVeiculo(Veiculo novoVeiculo);
	void removerVeiculo(Veiculo removeVeiculo);
	Veiculo obterPorPlaca(Veiculo obterVeiculo);
	List<Veiculo> lista();

}
