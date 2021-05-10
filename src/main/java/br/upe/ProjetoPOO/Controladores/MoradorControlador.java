package br.upe.ProjetoPOO.Controladores;

import br.upe.ProjetoPOO.Classes.Morador;
import br.upe.ProjetoPOO.DAO.JPAMoradorDAO;
import br.upe.ProjetoPOO.DAO.MoradorDAO;

import java.util.List;

public class MoradorControlador implements MoradorControladorInterface {

    //Singleton
    private static MoradorControlador INSTANCE;

    public static MoradorControlador getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new MoradorControlador();
        }
        return INSTANCE;
    }

    //Instancia Interface MoradorDAO
    MoradorDAO interfaceMoradorDAO = JPAMoradorDAO.getINSTANCE();

    //Método para gravar Morador
    public void criarMorador(Morador novoMorador) throws Exception {
        try {
            interfaceMoradorDAO.salva(novoMorador);
        } catch (Exception e) {
            throw e;
        }
    }

    //Método que lista Morador por CPF
    public Morador obterPorCpf(Morador obterMorador) throws Exception {
        try {
            return interfaceMoradorDAO.obterPorCpf(obterMorador.getCpf());
        } catch (Exception e) {
            throw e;
        }
    }

    //Método para remover Morador
    public void removerMorador(Morador removeMorador) throws Exception {
        try {
            interfaceMoradorDAO.remove(removeMorador.getId());
        } catch (Exception e) {
            throw e;
        }
    }

    //Método que lista todos Moradores
    public List<Morador> lista() {
        List<Morador> lista;
        if ((lista = interfaceMoradorDAO.lista()).size() == 0) {
            lista = null;
        }
        return lista;
    }
}
