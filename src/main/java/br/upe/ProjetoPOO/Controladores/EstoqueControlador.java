package br.upe.ProjetoPOO.Controladores;

import br.upe.ProjetoPOO.Classes.Estoque;
import br.upe.ProjetoPOO.DAO.EstoqueDAO;
import br.upe.ProjetoPOO.DAO.JPAEstoqueDAO;

import java.util.List;

/**
 * Regra de negócio para objeto Estoque.
 */
public class EstoqueControlador implements EstoqueControladorInterface {

    //Singleton
    private static EstoqueControlador INSTANCE;

    /**
     * Método para chamada do Singleton dessa classe.
     *
     * @return Retorna instância dessa classe.
     */
    public static EstoqueControlador getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new EstoqueControlador();
        }
        return INSTANCE;
    }

    //Instancia interface EstoqueDAO
    EstoqueDAO interfaceEstoqueDAO = JPAEstoqueDAO.getINSTANCE();

    /**
     * Método para adicionar Estoque. Chamado se o tipo de fluxo de Almoxarifado for Entrada.
     *
     * @param novoEstoque Recebe um objeto Estoque para ser salvo no BD.
     */
    public void adicionaEstoque(List<Estoque> novoEstoque) {

        Estoque estoqueGrava = new Estoque();
        Estoque estoqueBase = new Estoque();

        for (int i = 0; i < novoEstoque.size(); i++) {

            estoqueBase = interfaceEstoqueDAO.obterPorNome(novoEstoque.get(i).getNomeProduto());
            if (estoqueBase != null) {
                if (novoEstoque.get(i).getNomeProduto().equals(estoqueBase.getNomeProduto())) {
                    estoqueGrava.setId(estoqueBase.getId());
                    estoqueGrava.setNomeProduto(estoqueBase.getNomeProduto());
                    estoqueGrava.setQuantidade(estoqueBase.getQuantidade() + novoEstoque.get(i).getQuantidade());
                }
            } else {
                estoqueGrava = novoEstoque.get(i);
            }
            interfaceEstoqueDAO.salva(estoqueGrava);
        }
    }

    /**
     * Método para retirar estoque. Chamado se o tipo de fluxo de Almoxarifado for Saída.
     *
     * @param novoEstoque Recebe um objeto Estoque para ser salvo no BD.
     */
    public void retiraEstoque(List<Estoque> novoEstoque) {

        Estoque estoqueGrava = new Estoque();
        Estoque estoqueBase = new Estoque();

        for (int i = 0; i < novoEstoque.size(); i++) {

            estoqueBase = interfaceEstoqueDAO.obterPorNome(novoEstoque.get(i).getNomeProduto());
            if (estoqueBase != null) {
                if (novoEstoque.get(i).getNomeProduto().equals(estoqueBase.getNomeProduto())) {
                    estoqueGrava.setId(estoqueBase.getId());
                    estoqueGrava.setNomeProduto(estoqueBase.getNomeProduto());
                    estoqueGrava.setQuantidade(estoqueBase.getQuantidade() - novoEstoque.get(i).getQuantidade());
                }
            } else {
                estoqueGrava = novoEstoque.get(i);
            }
            interfaceEstoqueDAO.salva(estoqueGrava);
        }
    }

    /**
     * Método para editar Estoque. Chamado na janela de Controle de Estoque.
     *
     * @param estoqueSalva Recebe um objeto Estoque para ser salvo no BD.
     */
    public void editaEstoque(Estoque estoqueSalva) {

        Estoque estoqueBase = interfaceEstoqueDAO.obterPorNome(estoqueSalva.getNomeProduto());
        if (estoqueBase != null) {
            if (estoqueSalva.getNomeProduto().equals(estoqueBase.getNomeProduto())) {
                estoqueSalva.setId(estoqueBase.getId());
            }
        }
        interfaceEstoqueDAO.salva(estoqueSalva);
    }

    //Listar estoques
    public List<Estoque> lista() {
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

}
