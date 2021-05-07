package br.upe.ProjetoPOO.Controladores;

import java.util.List;

import br.upe.ProjetoPOO.Classes.Apartamento;

public interface ApartamentoControladorInterface {
	
	String criarApartamento(Apartamento novoApartamento);
	void removerApartamento(Apartamento removeApartamento);
	List<Apartamento> lista();
	
}
