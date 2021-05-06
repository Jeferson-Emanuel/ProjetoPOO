package br.upe.ProjetoPOO.Controladores;

import java.util.List;

import br.upe.ProjetoPOO.Classes.Estoque;

public interface EstoqueControladorInterface {
	
	void adicionaEstoque(List<Estoque> novoEstoque);
	void retiraEstoque(List<Estoque> novoEstoque);
	void editaEstoque(Estoque estoqueSalva);
	List<Estoque> lista();
	Estoque obterPorNome(Estoque estoque);
	void removeEstoque(Estoque estoque);

}
