package br.upe.ProjetoPOO.Controladores;

import br.upe.ProjetoPOO.Classes.Veiculo;
import br.upe.ProjetoPOO.DAO.JPAVeiculoDAO;
import br.upe.ProjetoPOO.DAO.VeiculoDAO;

import java.util.List;

public class VeiculoControlador implements VeiculoControladorInterface {

    //singleton
    private static VeiculoControlador INSTANCE;

    public static VeiculoControlador getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new VeiculoControlador();
        }
        return INSTANCE;
    }

    //Instancia Interface VeiculoDAO
    VeiculoDAO interfaceVeiculoDAO = JPAVeiculoDAO.getINSTANCE();

    //Método para gravar Veículo
    public void criarVeiculo(Veiculo novoVeiculo) throws Exception {
        try {
            interfaceVeiculoDAO.salva(novoVeiculo);
        } catch (Exception e) {
            throw e;
        }
    }

    //Método que lista Veiculo por Placa
    public Veiculo obterPorPlaca(Veiculo obterVeiculo) throws Exception {
        try {
            return interfaceVeiculoDAO.obterPorPlaca(obterVeiculo.getPlaca());
        } catch (Exception e) {
            throw e;
        }
    }

    //Método para remover Veículo
    public void removerVeiculo(Veiculo removeVeiculo) throws Exception {
        try {
            interfaceVeiculoDAO.remove(removeVeiculo.getId());
        } catch (Exception e) {
            throw e;
        }
    }

    //Método que lista todos Veículos
    public List<Veiculo> lista() {
        List<Veiculo> lista;
        if((lista = interfaceVeiculoDAO.lista()).size() == 0){
            lista = null;
        }
        return lista;
    }
}
