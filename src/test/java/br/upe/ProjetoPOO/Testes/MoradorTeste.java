package br.upe.ProjetoPOO.Testes;

import br.upe.ProjetoPOO.Classes.Morador;
import br.upe.ProjetoPOO.Controladores.MoradorControlador;
import br.upe.ProjetoPOO.DAO.MoradorDAO;
import br.upe.ProjetoPOO.DAO.JPAMoradorDAO;
import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

public class MoradorTeste extends TestCase{
	@Test
	public void testeMoradorCadastra() {
		//Criar um morador	
		Morador morador = new Morador("222.444.555-66", "Mané", "Funcionário");
		MoradorControlador moradorControlador = new MoradorControlador();
		moradorControlador.criarMorador(morador);
		
		//Pesquisar na base
		MoradorDAO moradorDAO = new JPAMoradorDAO();
		Morador moradorBase = moradorDAO.obterPorCpf("222.444.555-66");
		//Extrair valor à comparar
		String cpfBase = moradorBase.getCpf();
		//Comparar valores
		Assert.assertEquals(cpfBase, morador.getCpf());
	}
	
	
	
	

}
