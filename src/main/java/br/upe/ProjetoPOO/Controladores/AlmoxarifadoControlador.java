package br.upe.ProjetoPOO.Controladores;

import br.upe.ProjetoPOO.Classes.Almoxarifado;
import br.upe.ProjetoPOO.DAO.AlmoxarifadoDAO;
import br.upe.ProjetoPOO.DAO.JPAAlmoxarifadoDAO;
import java.util.List;

public class AlmoxarifadoControlador implements AlmoxarifadoControladorInterface {

	//Singleton
	private static AlmoxarifadoControlador INSTANCE;

	public static AlmoxarifadoControlador getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new AlmoxarifadoControlador();
		}
		return INSTANCE;
	}

	public void registroAlmoxarifado(Almoxarifado novoAlmoxarifado) {
		AlmoxarifadoDAO interfaceAlmoxarifado = new JPAAlmoxarifadoDAO();
		interfaceAlmoxarifado.salva(novoAlmoxarifado);
	}

	public void removeAlmoxarifado(Almoxarifado removeAlmoxarifado) {
		AlmoxarifadoDAO interfaceAlmoxarifado = new JPAAlmoxarifadoDAO();
		interfaceAlmoxarifado.remove(removeAlmoxarifado.getId());
	}
	
	public Almoxarifado obterPorId(Almoxarifado obterAlmoxarifado) {
		
		Almoxarifado temp = new Almoxarifado();
		AlmoxarifadoDAO interfaceAlmoxarifado = new JPAAlmoxarifadoDAO();
		return temp = interfaceAlmoxarifado.obterPorId(obterAlmoxarifado.getId());
		
	}

	public List<Almoxarifado> lista(){
		AlmoxarifadoDAO interfaceAlmoxarifado = new JPAAlmoxarifadoDAO();
		return interfaceAlmoxarifado.lista();
	}
	/*public void registroAlmoxarifado(Almoxarifado novoAlmoxarifado) {//Recebe instância de almoxarifado

		//Cria instância de controlador de estoque
		EstoqueControlador estoqueControlador = new EstoqueControlador();
		estoqueControlador.criarEstoque(novoAlmoxarifado);

		AlmoxarifadoDAO interfaceAlmoxarifado = new JPAAlmoxarifadoDAO();
		interfaceAlmoxarifado.salva(novoAlmoxarifado);
		System.out.println("Fluxo de produtos registrado com sucesso.");
	}*/


}

