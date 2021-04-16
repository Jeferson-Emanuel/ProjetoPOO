package br.upe.ProjetoPOO.View;

import br.upe.ProjetoPOO.Classes.Produto;
import br.upe.ProjetoPOO.DAO.JPAProdutoDAO;

import java.util.ArrayList;
import java.util.List;

import br.upe.ProjetoPOO.Classes.Almoxarifado;
import br.upe.ProjetoPOO.DAO.JPAAlmoxarifadoDAO;

import br.upe.ProjetoPOO.Classes.Apartamento;
import br.upe.ProjetoPOO.DAO.JPAApartamentoDAO;

import br.upe.ProjetoPOO.Classes.Fornecedor;
import br.upe.ProjetoPOO.DAO.JPAFornecedorDAO;

import br.upe.ProjetoPOO.Classes.Funcionario;
import br.upe.ProjetoPOO.DAO.JPAFuncionarioDAO;
import br.upe.ProjetoPOO.DAO.AlmoxarifadoDAO;
import br.upe.ProjetoPOO.DAO.ApartamentoDAO;
import br.upe.ProjetoPOO.DAO.FuncionarioDAO;

import br.upe.ProjetoPOO.Classes.Morador;
import br.upe.ProjetoPOO.DAO.JPAMoradorDAO;

import br.upe.ProjetoPOO.Classes.Reserva;
import br.upe.ProjetoPOO.Classes.Veiculo;
import br.upe.ProjetoPOO.DAO.JPAReservaDAO;
import br.upe.ProjetoPOO.DAO.JPAVeiculoDAO;
import br.upe.ProjetoPOO.DAO.ProdutoDAO;

public class Teste {

	public static void main(String[] args) {
		
//Cadastro de produtos em lista 

		JPAProdutoDAO produto1DAO = new JPAProdutoDAO();
		JPAProdutoDAO produto2DAO = new JPAProdutoDAO();
		

		Produto produto1 = new Produto();		
		produto1.setNome("lampada");
		produto1.setPreco(12);
		produto1.setQuant(2);
		produto1.setTipo("eletrico");
		produto1.setDisp(true);

		Produto produto2 = new Produto();
		produto2.setNome("vassoura");
		produto2.setPreco(5);
		produto2.setQuant(6);
		produto2.setTipo("madeira");
		produto2.setDisp(true);
		

		JPAAlmoxarifadoDAO almoxarifadoDAO = new JPAAlmoxarifadoDAO();

		Almoxarifado almoxarifado = new Almoxarifado();

		List <Produto> produtosE = new ArrayList<Produto>();
		produtosE.add(produto1);
		produtosE.add(produto2);

		almoxarifado.setData("28-03-2021");
		almoxarifado.setProdutos(produtosE);

		almoxarifadoDAO.salva(almoxarifado);
		

		
//Teste de Classe/interface de Produto
/*	
		JPAProdutoDAO produtoDAO = new JPAProdutoDAO();
		
		Produto produto = new Produto();
		produto.setNome("esfregao");
		produto.setPreco(8);
		produto.setQuant(5);
		produto.setTipo("comum");
		produto.setDisp(true);
		
		produtoDAO.salva(produto);
		
		
		List<Produto> p = produtoDAO.lista();

		for(Produto prod : p) {
			System.out.println(prod.getNome());
		}
		

		ProdutoDAO p = new JPAProdutoDAO();
		p.remove(1);
		
*/
		
//Teste de Classe/Interface de Apartamento
/*		
		JPAApartamentoDAO apartamentoDAO = new JPAApartamentoDAO();
		Apartamento apartamento = new Apartamento();

		apartamento.setId(1);
		apartamento.setBloco("B");
		apartamento.setNumero(404);
		
		apartamentoDAO.salva(apartamento);
		

		List<Apartamento> apartamentos = apartamentoDAO.lista();

		for(Apartamento ap : apartamentos) {
			System.out.println(ap.getBloco());
		}
		
		ApartamentoDAO ap = new JPAApartamentoDAO();
		ap.remove(1);

*/
		
		
		/*-----------------------------------------------------------------------------------------------------*/
		/*JPAFornecedorDAO fornecedorDAO = new JPAFornecedorDAO();
		Fornecedor fornecedor = new Fornecedor();

		fornecedor.setId(1);
		fornecedor.setNome("Netcell");
		fornecedor.setTipo("Provedor de Internet");
		fornecedor.setEndereco("Rua Jos� Miguel, n� 16");
		fornecedor.setContato("(81) 3691-1217");

		List<Fornecedor> f = fornecedorDAO.lista();

		for(Fornecedor forn : f) {
			System.out.println(forn.getNome());
		}*/

		//fornecedorDAO.salva(fornecedor);
		/*-----------------------------------------------------------------------------------------------------*/
		/*AQUI REMOVE DO BANCO*/
		/*FuncionarioDAO r = new JPAFuncionarioDAO();
		r.remove(6);*/

		/*AQUI ATUALIZA NO BANCO*/
		/*Funcionario f = new JPAFuncionarioDAO().obterPorId(3);
		//f.setNome("Zezinho");
		f.setFuncao("Servi�os Gerais");
		FuncionarioDAO g = new JPAFuncionarioDAO();
		g.salva(f);*/

		/*AQUI EST� LISTANDO*/
		/*JPAFuncionarioDAO funcionarioDAO = new JPAFuncionarioDAO();
		List<Funcionario> funcionarios = funcionarioDAO.lista();

		for(Funcionario func : funcionarios) {
			System.out.println(func.getNome());
		}*/

		/*AQUI SALVA NO BANCO*/
		/*JPAFuncionarioDAO funcionarioDAO = new JPAFuncionarioDAO();
		Funcionario funcionario = new Funcionario();

		funcionario.setNome("Francisco");
		funcionario.setFuncao("Limpador da Piscina");
		funcionario.setEndereco("Ferro velho, n� 20");
		funcionario.setContato("(81) 1111-2222");*/

		//funcionarioDAO.salva(funcionario);
		/*-----------------------------------------------------------------------------------------------------*/		
		/*JPAMoradorDAO moradorDAO = new JPAMoradorDAO();
		Morador morador = new Morador();

		morador.setId(2);
		morador.setNome("Maria Silva");
		morador.setTipo("morador");
		morador.setApt(apartamento);

		List<Morador> moradores = moradorDAO.lista();

		for(Morador m : moradores) {
			System.out.println(m.getNome());
		}*/

		//moradorDAO.salva(morador);
		/*-----------------------------------------------------------------------------------------------------*/
		/*JPAReservaDAO reservaDAO = new JPAReservaDAO();
		Reserva reserva = new Reserva();

		reserva.setId(2);
		reserva.setTipo_espaco("Piscina");
		reserva.setData("01/04/2021");
		reserva.setHoraIni("14:00hrs");
		reserva.setHoraFim("17:00hrs");

		List<Reserva> rese = reservaDAO.lista();

		for(Reserva r : rese) {
			System.out.println(r.getTipo_espaco());
		}*/

		//reservaDAO.salva(reserva);
		/*-----------------------------------------------------------------------------------------------------*/
		/*JPAVeiculoDAO veiculoDAO = new JPAVeiculoDAO();
		Veiculo veiculo = new Veiculo();

		veiculo.setId(1);
		veiculo.setApartamento(apartamento);
		veiculo.setCor("Vermelho");
		veiculo.setModelo("BMW");
		veiculo.setPlaca("JDK 3040");
		veiculo.setTipo("Carro");*/

		/*List<Veiculo> vei = veiculoDAO.lista();

		for(Veiculo v : vei) {
			System.out.println(v.getPlaca());
		}*/

		//veiculoDAO.salva(veiculo);
	}

}
