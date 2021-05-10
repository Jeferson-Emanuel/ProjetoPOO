package br.upe.ProjetoPOO.DAO;

import br.upe.ProjetoPOO.Classes.Veiculo;

import java.util.List;

public interface VeiculoDAO {

    void salva(Veiculo v) throws Exception;
    Veiculo obterPorId(int id) throws Exception;
    Veiculo obterPorPlaca(String placa) throws Exception;
    void remove(int id) throws Exception;
    List<Veiculo> lista();

}
