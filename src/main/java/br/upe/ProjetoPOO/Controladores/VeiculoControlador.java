package br.upe.ProjetoPOO.Controladores;

import br.upe.ProjetoPOO.Classes.Veiculo;
import br.upe.ProjetoPOO.DAO.JPAVeiculoDAO;
import br.upe.ProjetoPOO.DAO.VeiculoDAO;

import java.util.List;

/**
 * Regra de negócio para objeto Veiculo.
 */
public class VeiculoControlador implements VeiculoControladorInterface {

    //singleton
    private static VeiculoControlador INSTANCE;

    /**
     * Método para chamada do Singleton dessa classe.
     *
     * @return Retorna a instância dessa classe.
     */
    public static VeiculoControlador getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new VeiculoControlador();
        }
        return INSTANCE;
    }

    //Instancia Interface VeiculoDAO
    VeiculoDAO interfaceVeiculoDAO = JPAVeiculoDAO.getINSTANCE();

    /**
     * Método para gravar Veiculo.
     *
     * @param novoVeiculo Recebe um objeto Veiculo da Interface para ser salvo no BD.
     * @throws Exception Joga um exceção para a Interface.
     */
    public void criarVeiculo(Veiculo novoVeiculo) throws Exception {
        try {
            interfaceVeiculoDAO.salva(novoVeiculo);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Método que lista Veiculo por Placa.
     *
     * @param obterVeiculo Recebe um objeto Veiculo da Interface para ser pesquisado no BD.
     * @return Retorna um objeto Veiculo do BD.
     * @throws Exception Joga uma exceção para a Interface.
     */
    public Veiculo obterPorPlaca(Veiculo obterVeiculo) throws Exception {
        try {
            return interfaceVeiculoDAO.obterPorPlaca(obterVeiculo.getPlaca());
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Método para remover Veiculo.
     *
     * @param removeVeiculo Recebe um objeto Veiculo da Interface para ser removido do BD.
     * @throws Exception Joga uma exceção para a Interface.
     */
    public void removerVeiculo(Veiculo removeVeiculo) throws Exception {
        try {
            interfaceVeiculoDAO.remove(removeVeiculo.getId());
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Método que lista todos Veiculos.
     *
     * @return Retorna uma lista com todos objetos do tipo Veiculo do BD.
     */
    public List<Veiculo> lista() {
        List<Veiculo> lista;
        if ((lista = interfaceVeiculoDAO.lista()).size() == 0) {
            lista = null;
        }
        return lista;
    }
}
