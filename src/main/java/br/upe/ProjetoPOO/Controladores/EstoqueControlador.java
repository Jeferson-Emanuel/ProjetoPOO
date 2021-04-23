package br.upe.ProjetoPOO.Controladores;

import br.upe.ProjetoPOO.Classes.Almoxarifado;
import br.upe.ProjetoPOO.Classes.Estoque;
import br.upe.ProjetoPOO.Classes.Produto;
import br.upe.ProjetoPOO.DAO.EstoqueDAO;
import br.upe.ProjetoPOO.DAO.JPAEstoqueDAO;
import java.util.List;

public class EstoqueControlador {
	
	//Método de criar/atualizar um estoque na base
		public void criarEstoque(Almoxarifado novoAlmoxarifado) {
			String tipoFluxoProdutos = novoAlmoxarifado.getTipo(); //Recebe o tipo do fluxo
			List<Produto> listaAlmoxarifado = novoAlmoxarifado.getFluxoProdutos(); //Recebe lista de produtos de almoxarifado
			
			//EstoqueDAO interfaceEstoque = new JPAEstoqueDAO();//Instancia a interface
		
			for(int i = 0; i < listaAlmoxarifado.size(); i ++) {
				EstoqueDAO interfaceEstoque = new JPAEstoqueDAO();//Instancia a interface
				String nomeProdutoNovo = listaAlmoxarifado.get(i).getNome(); //Extrai nome do produto no índice
				Estoque estoqueTemp = null;
				estoqueTemp = interfaceEstoque.obterPorNome(nomeProdutoNovo);
				if(estoqueTemp != null) {//Se encontrar o produto já na base
					if((tipoFluxoProdutos).equals("Entrada")) {//Se o tipo de fluxo for entrada soma o estoque
						Estoque novoEstoque = new Estoque();
						novoEstoque.setId(estoqueTemp.getId());
						novoEstoque.setNomeProduto(listaAlmoxarifado.get(i).getNome());
						novoEstoque.setQuantidade(estoqueTemp.getQuantidade() + listaAlmoxarifado.get(i).getQuant());
						interfaceEstoque.salva(novoEstoque);
						System.out.println("Estoque atualizado com sucesso.");
					}
					else {//Se não for entrada, diminui estoque
						Estoque novoEstoque = new Estoque();
						novoEstoque.setId(estoqueTemp.getId());
						novoEstoque.setNomeProduto(listaAlmoxarifado.get(i).getNome());
						novoEstoque.setQuantidade(estoqueTemp.getQuantidade() - listaAlmoxarifado.get(i).getQuant());
						interfaceEstoque.salva(novoEstoque);
						System.out.println("Estoque atualizado com sucesso.");
					}
				}
				else {//Se não encontrou na base, salva como novo estoque
					Estoque novoEstoque = new Estoque();
					novoEstoque.setNomeProduto(listaAlmoxarifado.get(i).getNome());
					novoEstoque.setQuantidade(listaAlmoxarifado.get(i).getQuant());
					interfaceEstoque.salva(novoEstoque);
					System.out.println("Estoque adicionado com sucesso.");
				}
			
			}
		}
}
