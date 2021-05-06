package br.upe.ProjetoPOO.Controladores;

import java.util.ArrayList;
import java.util.List;

import br.upe.ProjetoPOO.Classes.Estoque;
import br.upe.ProjetoPOO.DAO.EstoqueDAO;
import br.upe.ProjetoPOO.DAO.JPAEstoqueDAO;

public class EstoqueControlador implements EstoqueControladorInterface{

	//Singleton
	private static EstoqueControlador INSTANCE;

	public static EstoqueControlador getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new EstoqueControlador();
		}
		return INSTANCE;
	}

	//Instancia interface EstoqueDAO
	EstoqueDAO interfaceEstoqueDAO = JPAEstoqueDAO.getINSTANCE();

	//Método de adicionar estoque
	public void adicionaEstoque(List<Estoque> novoEstoque) {

		//List<Estoque> listaGrava = new ArrayList<>();

		for(int i = 0; i < novoEstoque.size(); i ++) {
			Estoque estoqueGrava = new Estoque();
			Estoque estoqueBase = obterPorNome(novoEstoque.get(i));
			if(estoqueBase != null) {
				if(novoEstoque.get(i).getNomeProduto().equals(estoqueBase.getNomeProduto())) {
					estoqueGrava.setId(estoqueBase.getId());
					estoqueGrava.setNomeProduto(estoqueBase.getNomeProduto());
					estoqueGrava.setQuantidade(estoqueBase.getQuantidade() + novoEstoque.get(i).getQuantidade());

					//listaGrava.add(estoqueGrava);
					interfaceEstoqueDAO.salva(estoqueGrava);
				}
				else {
					estoqueGrava = novoEstoque.get(i);
					//listaGrava.add(estoqueGrava);
					interfaceEstoqueDAO.salva(estoqueGrava);
				}
			}
			else {
				estoqueGrava = novoEstoque.get(i);
				//listaGrava.add(estoqueGrava);
				interfaceEstoqueDAO.salva(estoqueGrava);
			}

		}

		//interfaceEstoqueDAO.salva(listaGrava);

	}

	//Método de retirar estoque
	public void retiraEstoque(List<Estoque> novoEstoque) {

		//List<Estoque> listaGrava = new ArrayList<>();

		for(int i = 0; i < novoEstoque.size(); i ++) {
			Estoque estoqueGrava = new Estoque();
			Estoque estoqueBase = interfaceEstoqueDAO.obterPorNome(novoEstoque.get(i).getNomeProduto());
			if(estoqueBase != null) {
				if(novoEstoque.get(i).getNomeProduto().equals(estoqueBase.getNomeProduto())) {
					estoqueGrava.setId(estoqueBase.getId());
					estoqueGrava.setNomeProduto(estoqueBase.getNomeProduto());
					estoqueGrava.setQuantidade(estoqueBase.getQuantidade() - novoEstoque.get(i).getQuantidade());

					//listaGrava.add(estoqueGrava);
					interfaceEstoqueDAO.salva(estoqueGrava);
				}
				else {
					estoqueGrava = novoEstoque.get(i);
					//listaGrava.add(estoqueGrava);
					interfaceEstoqueDAO.salva(estoqueGrava);
				}
			}
			else {
				estoqueGrava = novoEstoque.get(i);
				//listaGrava.add(estoqueGrava);
				interfaceEstoqueDAO.salva(estoqueGrava);
			}

		}

		//interfaceEstoqueDAO.salva(listaGrava);

	}

	public void editaEstoque(Estoque estoqueSalva) {

		Estoque estoqueBase = interfaceEstoqueDAO.obterPorNome(estoqueSalva.getNomeProduto());
		if(estoqueBase != null) {
			if(estoqueSalva.getNomeProduto().equals(estoqueBase.getNomeProduto())) {

				estoqueSalva.setId(estoqueBase.getId());

			}

			interfaceEstoqueDAO.salva(estoqueSalva);
		}
	}

	//Listar estoques
	public List<Estoque> lista(){
		return interfaceEstoqueDAO.lista();
	}

	//Buscar por nome
	public Estoque obterPorNome(Estoque estoque) {
		return interfaceEstoqueDAO.obterPorNome(estoque.getNomeProduto());
	}

	//Remover estoque
	public void removeEstoque(Estoque estoque) {
		interfaceEstoqueDAO.remove(estoque.getId());
	}

	/*
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
		}*/
}
