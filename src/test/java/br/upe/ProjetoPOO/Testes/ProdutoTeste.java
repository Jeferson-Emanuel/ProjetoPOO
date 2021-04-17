package br.upe.ProjetoPOO.Testes;

import br.upe.ProjetoPOO.Classes.Produto;
import br.upe.ProjetoPOO.Controladores.ProdutoControlador;
import br.upe.ProjetoPOO.DAO.JPAProdutoDAO;
import br.upe.ProjetoPOO.DAO.ProdutoDAO;
import junit.framework.TestCase;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ProdutoTeste extends TestCase{
	
/*	public void testeProdutoAdiciona() {
		
		//Cria instância de produto
		Produto produto = new Produto("Vassoura", "Madeira", 8, 12.0f, true);
		
		//Envia produto criado para controlador
		ProdutoControlador produtoControlador = new ProdutoControlador();
		produtoControlador.criarProduto(produto);
		
		//Teste de produto por tamanho de lista retornada igual 1
		ProdutoDAO produtoDAO = new JPAProdutoDAO();
		List<Produto> listaTeste = produtoDAO.lista();
		int tamanhoLista = listaTeste.size();
		Assert.assertEquals(1, tamanhoLista);
	}*/
	
	public void testeProdutoAtualiza() {
		
		//Cria instância de produto
		Produto produto = new Produto("Vassoura", "Madeira", 8, 12.0f, true);		
		//Instancia controlador
		ProdutoControlador produtoControlador = new ProdutoControlador();
		//Envia produto criado para controlador
		produtoControlador.criarProduto(produto);
		
		//Instancia JPA
		ProdutoDAO produtoDAO = new JPAProdutoDAO();
		//Buscar produto no banco por nome
		Produto produtoBase = produtoDAO.obterPorNome("Vassoura");
		//Extrai quantidade do produto encontrado
		int quantProdutoBase = produtoBase.getQuant();
		//Verifica se é o dobro do produto original
		Assert.assertEquals(quantProdutoBase, produto.getQuant());
	}

}
