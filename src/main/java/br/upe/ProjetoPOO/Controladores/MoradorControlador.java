package br.upe.ProjetoPOO.Controladores;

import br.upe.ProjetoPOO.Classes.Morador;
import br.upe.ProjetoPOO.DAO.JPAMoradorDAO;
import br.upe.ProjetoPOO.DAO.MoradorDAO;

import java.util.List;

/**
 * Regra de negócio para objeto Morador.
 */
public class MoradorControlador implements MoradorControladorInterface {

    //Singleton
    private static MoradorControlador INSTANCE;

    /**
     * Método para chamada do Singleton dessa classe.
     *
     * @return Retorna a instância dessa classe.
     */
    public static MoradorControlador getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new MoradorControlador();
        }
        return INSTANCE;
    }

    //Instancia Interface MoradorDAO
    MoradorDAO interfaceMoradorDAO = JPAMoradorDAO.getINSTANCE();

    /**
     * Método para gravar Morador.
     *
     * @param novoMorador Recebe um objeto Morador da Interface para ser salvo no BD.
     * @throws Exception Joga um exceção para a Interface.
     */
    public void criarMorador(Morador novoMorador) throws Exception {
        try {
            interfaceMoradorDAO.salva(novoMorador);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Método que lista Morador por CPF.
     *
     * @param obterMorador Recebe um objeto Morador da Interface para ser pesquisado no BD.
     * @return Retorna um objeto Morador do BD.
     * @throws Exception Joga uma exceção para a Interface.
     */
    public Morador obterPorCpf(Morador obterMorador) throws Exception {
        try {
            return interfaceMoradorDAO.obterPorCpf(obterMorador.getCpf());
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Método para remover Morador.
     *
     * @param removeMorador Recebe um objeto Morador da Interface para ser removido do BD.
     * @throws Exception Joga uma exceção para a Interface.
     */
    public void removerMorador(Morador removeMorador) throws Exception {
        try {
            interfaceMoradorDAO.remove(removeMorador.getId());
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Método que lista todos Moradores.
     *
     * @return Retorna uma lista com todos objetos do tipo Morador do BD.
     */
    public List<Morador> lista() {
        List<Morador> lista;
        if ((lista = interfaceMoradorDAO.lista()).size() == 0) {
            lista = null;
        }
        return lista;
    }
}
