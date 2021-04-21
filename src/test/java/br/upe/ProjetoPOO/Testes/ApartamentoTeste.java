package br.upe.ProjetoPOO.Testes;

import br.upe.ProjetoPOO.Classes.Apartamento;
import br.upe.ProjetoPOO.Controladores.ApartamentoControlador;
import br.upe.ProjetoPOO.DAO.ApartamentoDAO;
import br.upe.ProjetoPOO.DAO.JPAApartamentoDAO;
import junit.framework.TestCase;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ApartamentoTeste extends TestCase {
	
	public void testApartamentoAdiciona() {
		
		//Cria instância de apartamento
		Apartamento apartamento = new Apartamento("Bloco A", 02);
		//Cria instância do controlador
		ApartamentoControlador apartamentoControlador = new ApartamentoControlador();
		//Envia objeto da reserva pro controlador
		apartamentoControlador.criarApartamento(apartamento);
		//Cria instância da interface de Apartamento
		ApartamentoDAO interfaceApartamento = new JPAApartamentoDAO();
		//Recupera lista de todos apartamentos do banco
		List<Apartamento> listaTeste = interfaceApartamento.lista();
		//Extrai dados do primeiro objeto da lista
		String bloco = listaTeste.get(0).getBloco();
		int numero = listaTeste.get(0).getNumero();
		//Testa se esses valores são iguais ao objeto adicionado
		Assert.assertTrue((bloco).equals(apartamento.getBloco()));
		Assert.assertEquals(numero, apartamento.getNumero());
	}

}
