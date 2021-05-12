package br.upe.ProjetoPOO.Controladores;

import br.upe.ProjetoPOO.Classes.Apartamento;
import br.upe.ProjetoPOO.DAO.ApartamentoDAO;
import br.upe.ProjetoPOO.DAO.JPAApartamentoDAO;

import java.util.List;

/**
 * Regra de negócio para objeto Apartamento.
 */
public class ApartamentoControlador implements ApartamentoControladorInterface {

    //Singleton
    private static ApartamentoControlador INSTANCE;

    /**
     * Método para chamada do Singleton dessa classe.
     *
     * @return Retorna a instância dessa classe.
     */
    public static ApartamentoControlador getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new ApartamentoControlador();
        }
        return INSTANCE;
    }

    //Instancia Interface ApartamentoDAO
    ApartamentoDAO interfaceApartamentoDAO = JPAApartamentoDAO.getINSTANCE();

    /**
     * Método para gravar Apartamento.
     *
     * @param novoApartamento Recebe um objeto Apartamento da Interface para ser salvo no BD.
     * @throws Exception Joga uma exceção para a Interface.
     */
    public void criarApartamento(Apartamento novoApartamento) throws Exception {
        try {
            interfaceApartamentoDAO.salva(novoApartamento);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Método que lista Apartamento por Bloco.
     *
     * @param obterApartamento Recebe um objeto Apartamento da Interface para ser pesquisado no BD.
     * @return Retorna um objeto Apartamento do BD.
     * @throws Exception Joga uma exceção para a Interface.
     */
    public Apartamento obterPorBloco(Apartamento obterApartamento) throws Exception {
        try {
            return interfaceApartamentoDAO.obterPorBloco(obterApartamento.getBloco());
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Método para remover Apartamento.
     *
     * @param removeApartamento Recebe um objeto Apartamento da Interface para ser removido do BD.
     * @throws Exception Joga uma exceção para a Interface.
     */
    public void removerApartamento(Apartamento removeApartamento) throws Exception {
        try {
            interfaceApartamentoDAO.remove(removeApartamento.getId());
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Método para listar todos os Apartamentos.
     *
     * @return Retorna uma lista com todos objetos do tipo Apartamento do BD.
     */
    public List<Apartamento> lista() {
        List<Apartamento> lista;
        if ((lista = interfaceApartamentoDAO.lista()).size() == 0) {
            lista = null;
        }
        return lista;
    }
}