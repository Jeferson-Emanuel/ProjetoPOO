package br.upe.ProjetoPOO.DAO;

import br.upe.ProjetoPOO.Classes.Morador;

import java.util.List;

public interface MoradorDAO {

    void salva(Morador m) throws Exception;
    Morador obterPorId(int id) throws Exception;
    Morador obterPorCpf(String cpf) throws Exception;
    void remove(int id) throws Exception;
    List<Morador> lista();

}
