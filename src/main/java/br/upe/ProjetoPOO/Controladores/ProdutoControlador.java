package br.upe.ProjetoPOO.Controladores;

import br.upe.ProjetoPOO.Classes.Produto;
import br.upe.ProjetoPOO.DAO.ProdutoDAO;
import br.upe.ProjetoPOO.DAO.JPAProdutoDAO;
import java.util.List;

public class ProdutoControlador {	
	
	//Método de criar um produto na base
	public void criarProduto(Produto produtoNovo) {
		String nomeProduto = produtoNovo.getNome(); //Recebe o nome do produto novo
				
		ProdutoDAO produtoDAO = new JPAProdutoDAO(); //Instancia o JPA
		Produto produtoTemp = null; //Cria um produto nulo/vazio
		produtoTemp = produtoDAO.obterPorNome(nomeProduto); //Guarda o resultado da busca por nome no produto nulo
		
		if(produtoTemp != null) { //Se foi encontrado um produto com o nome então produto nulo não é mais nulo
			//Extrair id e quantidade do produto encontrado na base
			int idBase = produtoTemp.getId();
			int quantBase = produtoTemp.getQuant();
			//Guarda soma quantidade antiga + nova em variável
			int quantNova = quantBase + produtoNovo.getQuant();
			//Atualiza produto novo com id e a soma
			produtoNovo.setId(idBase);
			produtoNovo.setQuant(quantNova);
			//Grava produto com id e quantidade atualizados
			produtoDAO.salva(produtoNovo);
			System.out.println("Produto atualizado.");
		}
		else {
			produtoDAO.salva(produtoNovo); //se não achou igual, salva o produto novo como novo atribuindo id automático
			System.out.println("Produto adicionado.");
		}
		
		/*
		 	List<Produto> produtos = this.listarProduto(); //Recebe lista de produtos já na base
		 	for(int i = 0; i < produtos.size(); i ++) { //for para percorrer a lista e achar igual
			if (nomeProduto.compareTo(produtos.get(i).getNome())==0) { //compara nome do novo com os nomes antigos
				int id = produtos.get(i).getId(); //se achou igual, guarda o id do antigo aqui
				int quant = produtos.get(i).getQuant() + produto.getQuant(); //guarda quantidadade do novo + antigo aqui
				produto.setId(id); //atualiza o novo com o id do antigo
				produto.setQuant(quant); //atualiza a quantidade do novo com a soma novo+antigo
				produtoDAO.salva(produto); //salva produto novo atualizando quantidade
				System.out.println("Produto atualizado.");
			}
			else {
				produtoDAO.salva(produto); //se não achou igual, salva o produto novo como novo
				System.out.println("Produto adicionado.");
			}				
			
		}*/
			
	}
	
	//Método de listar produtos
	public List<Produto> listarProduto() {
		ProdutoDAO produtoDAO = new JPAProdutoDAO();
		return produtoDAO.lista();
	}
	
	//Método de remover produtos
	public void removerProduto(int id) {
		ProdutoDAO produtoDAO = new JPAProdutoDAO();
		produtoDAO.remove(id);
	}	

}
