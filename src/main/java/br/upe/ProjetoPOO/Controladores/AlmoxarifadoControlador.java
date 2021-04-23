package br.upe.ProjetoPOO.Controladores;

import br.upe.ProjetoPOO.Classes.Almoxarifado;
import br.upe.ProjetoPOO.DAO.AlmoxarifadoDAO;
import br.upe.ProjetoPOO.DAO.JPAAlmoxarifadoDAO;
import java.util.List;

public class AlmoxarifadoControlador {
	
	public void registroAlmoxarifado(Almoxarifado novoAlmoxarifado) {//Recebe instância de almoxarifado
		
		//Cria instância de controlador de estoque
		EstoqueControlador estoqueControlador = new EstoqueControlador();
		estoqueControlador.criarEstoque(novoAlmoxarifado);
		
		AlmoxarifadoDAO interfaceAlmoxarifado = new JPAAlmoxarifadoDAO();
		interfaceAlmoxarifado.salva(novoAlmoxarifado);
		System.out.println("Fluxo de produtos registrado com sucesso.");
	}
	
	public List<Almoxarifado> lista(){
		AlmoxarifadoDAO interfaceAlmoxarifado = new JPAAlmoxarifadoDAO();
		return interfaceAlmoxarifado.lista();
		}
}

	