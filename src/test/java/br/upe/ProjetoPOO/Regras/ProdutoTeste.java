package br.upe.ProjetoPOO.Regras;

import br.upe.ProjetoPOO.Classes.Produto;
import br.upe.ProjetoPOO.Controladores.ProdutoControlador;
import br.upe.ProjetoPOO.DAO.JPAProdutoDAO;
import br.upe.ProjetoPOO.DAO.ProdutoDAO;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ProdutoTeste {
	
	public void testeProduto() {
		
		Produto produto = new Produto("Vassoura", "Madeira", 8, 12.0f, true);
		
		ProdutoControlador produtoControlador = new ProdutoControlador();
		produtoControlador.criarProduto(produto);
		
		ProdutoDAO produtoDAO = new JPAProdutoDAO();
		List<Produto> listaTeste = produtoDAO.lista();
		int tamanhoLista = listaTeste.size();
		Assert.assertEquals(1, tamanhoLista);
	}

}
