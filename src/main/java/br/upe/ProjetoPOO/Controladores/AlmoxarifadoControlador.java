package br.upe.ProjetoPOO.Controladores;

import br.upe.ProjetoPOO.Classes.Almoxarifado;
import br.upe.ProjetoPOO.DAO.AlmoxarifadoDAO;
import br.upe.ProjetoPOO.DAO.JPAAlmoxarifadoDAO;

import java.util.List;

/**
 * Regra de negócio para objeto Almoxarifado.
 */
public class AlmoxarifadoControlador implements AlmoxarifadoControladorInterface {

    //Singleton
    private static AlmoxarifadoControlador INSTANCE;

    /**
     * Método para chamada do Singleton dessa classe.
     *
     * @return Retorna instância dessa classe.
     */
    public static AlmoxarifadoControlador getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new AlmoxarifadoControlador();
        }
        return INSTANCE;
    }

    //Instancia interface AlmoxarifadoDAO
    AlmoxarifadoDAO interfaceAlmoxarifadoDAO = JPAAlmoxarifadoDAO.getINSTANCE();

    /**
     * Método para gravar Almoxarifado.
     *
     * @param novoAlmoxarifado Recebe um objeto Almoxarifado da interface para ser salvo no BD.
     */
    public void registroAlmoxarifado(Almoxarifado novoAlmoxarifado) {
        interfaceAlmoxarifadoDAO.salva(novoAlmoxarifado);
    }

    /**
     * Método para remover Almoxarifado.
     *
     * @param removeAlmoxarifado Recebe um objeto Almoxarifado da Interface para ser removido do BD.
     */
    public void removeAlmoxarifado(Almoxarifado removeAlmoxarifado) {
        interfaceAlmoxarifadoDAO.remove(removeAlmoxarifado.getId());
    }

    /**
     * Método que lista Almoxarifado por id.
     *
     * @param obterAlmoxarifado Recebe um objeto Almoxarifado da Interface para ser pesquisado no BD.
     * @return Retorna um objeto do tipo Almoxarifado.
     */
    public Almoxarifado obterPorId(Almoxarifado obterAlmoxarifado) {
        Almoxarifado temp = new Almoxarifado();
        return temp = interfaceAlmoxarifadoDAO.obterPorId(obterAlmoxarifado.getId());
    }

    /**
     * Método que lista todos Almoxarifados.
     *
     * @return Retorna uma lista com todos objetos do tipo Almoxarifado do BD.
     */
    public List<Almoxarifado> lista() {
        return interfaceAlmoxarifadoDAO.lista();
    }
}