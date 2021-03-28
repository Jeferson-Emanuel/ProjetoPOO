package View;

import Classes.Produto;
import DAO.JPAProdutoDAO;

import java.util.ArrayList;
import java.util.List;

import Classes.Almoxarifado;
import DAO.JPAAlmoxarifadoDAO;

import Classes.Apartamento;
import DAO.JPAApartamentoDAO;

import Classes.Fornecedor;
import DAO.JPAFornecedorDAO;

import Classes.Funcionario;
import DAO.JPAFuncionarioDAO;
import DAO.AlmoxarifadoDAO;
import DAO.FuncionarioDAO;

import Classes.Morador;
import DAO.JPAMoradorDAO;

import Classes.Reserva;
import Classes.Veiculo;
import DAO.JPAReservaDAO;
import DAO.JPAVeiculoDAO;
import DAO.ProdutoDAO;

public class Teste {

	public static void main(String[] args) {
		
		
		JPAProdutoDAO interfaceDAO = new JPAProdutoDAO();
		
		Produto produto = new Produto();		
		//produto.setId(3);
		produto.setNome("lampada");
		produto.setPreco(12);
		produto.setQuant(2);
		produto.setTipo("eletrico");
		produto.setDisp(true);
		
		interfaceDAO.salva(produto);
		
		Produto produto2 = new Produto();
		//produto2.setId(4);
		produto2.setNome("vassoura");
		produto2.setPreco(5);
		produto2.setQuant(6);
		produto2.setTipo("madeira");
		produto2.setDisp(true);
		
		interfaceDAO.salva(produto2);
		
		/*List<Produto> p = interfaceDAO.lista();
		
		for(Produto prod : p) {
			System.out.println(prod.getNome());
		}*/
				
		//ProdutoDAO p = new JPAProdutoDAO();
		//p.remove(1);
		
//-------------------------------------------------------------------------------------------
		JPAAlmoxarifadoDAO almoxarifadoDAO = new JPAAlmoxarifadoDAO();
		Almoxarifado almoxarifado = new Almoxarifado();
		System.out.println(produto2.getNome());
		//almoxarifado.setId(2);
		List <Produto> produtosE = new ArrayList<Produto>();
		produtosE.add(produto);
		produtosE.add(produto2);
		almoxarifado.setProdutosEntrada(produtosE);
		//almoxarifado.setProdutosSaida(produtosE);
		
		almoxarifadoDAO.salva(almoxarifado);
/*-----------------------------------------------------------------------------------------------------*/	
		/*JPAAlmoxarifadoDAO almoxarifadoDAO = new JPAAlmoxarifadoDAO();
		Almoxarifado almoxarifado = new Almoxarifado();
		
		almoxarifado.setId(2);
		almoxarifado.setPedido("Luminaria");
		almoxarifado.setProduto(produto);
		almoxarifado.setRegistroIn("15/03/2021");
		almoxarifado.setRegistroOut("18/03/2021");*/
		
		/*List<Almoxarifado> al = almoxarifadoDAO.lista();
		
		for(Almoxarifado a : al) {
			System.out.println(a.getProduto());
		}
		AlmoxarifadoDAO a = new JPAAlmoxarifadoDAO();
		a.remove(3);*/
		
		//almoxarifadoDAO.salva(almoxarifado);
/*-----------------------------------------------------------------------------------------------------*/		
		/*JPAApartamentoDAO apartamentoDAO = new JPAApartamentoDAO();
		Apartamento apartamento = new Apartamento();
		
		apartamento.setId(1);
		apartamento.setBloco("B");
		apartamento.setNumero(404);*/
		
		/*List<Apartamento> apartamentos = apartamentoDAO.lista();
		
		for(Apartamento ap : apartamentos) {
			System.out.println(ap.getBloco());
		}*/
		//apartamentoDAO.salva(apartamento);
/*-----------------------------------------------------------------------------------------------------*/
		/*JPAFornecedorDAO fornecedorDAO = new JPAFornecedorDAO();
		Fornecedor fornecedor = new Fornecedor();
		
		fornecedor.setId(1);
		fornecedor.setNome("Netcell");
		fornecedor.setTipo("Provedor de Internet");
		fornecedor.setEndereco("Rua José Miguel, nº 16");
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
		f.setFuncao("Serviços Gerais");
		FuncionarioDAO g = new JPAFuncionarioDAO();
		g.salva(f);*/
				
		/*AQUI ESTÁ LISTANDO*/
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
		funcionario.setEndereco("Ferro velho, nº 20");
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
