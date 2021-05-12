package br.upe.ProjetoPOO.DAO;

import br.upe.ProjetoPOO.Classes.Estoque;

import java.util.List;

public interface EstoqueDAO {

    void salva(Estoque e);
    Estoque obterPorNome(String nome);
    void remove(int id);
    List<Estoque> lista();

}
