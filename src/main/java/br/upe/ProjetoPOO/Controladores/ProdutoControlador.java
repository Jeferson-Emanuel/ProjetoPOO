package br.upe.ProjetoPOO.Controladores;

import br.upe.ProjetoPOO.Classes.Produto;
import br.upe.ProjetoPOO.DAO.ProdutoDAO;
import br.upe.ProjetoPOO.DAO.JPAProdutoDAO;
import java.util.List;

public class ProdutoControlador {
	
	//static ProdutoDAO produtoDAO = new JPAProdutoDAO();
	
	
	public void criarProduto(Produto produto) {
		String nomeProduto = produto.getNome(); //Recebe o nome do produto novo
		//List<Produto> produtos = this.listarProduto(); //Recebe lista de produtos já na base
		
		ProdutoDAO produtoDAO = new JPAProdutoDAO(); //Instancia o JPA
		Produto produto01 = null;
		produto01 = produtoDAO.obterPorNome(nomeProduto);
		
		if(produto01 != null) {
			//Extrair quantidade do produto encontrado
			//Atulizar produto novo com a soma
			//Gravar produto novo atualizado
		}
		else {
			produtoDAO.salva(produto); //se não achou igual, salva o produto novo como novo
			System.out.println("Produto adicionado.");
		}
		
		/*for(int i = 0; i < produtos.size(); i ++) { //for para percorrer a lista e achar igual
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
	
	public List<Produto> listarProduto() {
		ProdutoDAO produtoDAO = new JPAProdutoDAO();
		return produtoDAO.lista();
	}
	
	public void removerProduto(int id) {
		ProdutoDAO produtoDAO = new JPAProdutoDAO();
		produtoDAO.remove(id);
	}
	

}
