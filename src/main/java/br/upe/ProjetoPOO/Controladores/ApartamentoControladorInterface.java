package br.upe.ProjetoPOO.Controladores;

import java.util.List;

import br.upe.ProjetoPOO.Classes.Apartamento;

public interface ApartamentoControladorInterface {
	
	void criarApartamento(Apartamento novoApartamento) throws Exception;
	Apartamento obterPorBloco(Apartamento obterApartamento) throws Exception;
	void removerApartamento(Apartamento removeApartamento) throws Exception;
	List<Apartamento> lista();
	
}
