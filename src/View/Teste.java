package View;

import Classes.Produto;
import DAO.JPAProdutoDAO;

import java.util.List;

import Classes.Almoxarifado;
import DAO.JPAAlmoxarifadoDAO;

import Classes.Apartamento;
import DAO.JPAApartamentoDAO;

import Classes.Fornecedor;
import DAO.JPAFornecedorDAO;

import Classes.Funcionario;
import DAO.JPAFuncionarioDAO;
import DAO.FuncionarioDAO;

import Classes.Morador;
import DAO.JPAMoradorDAO;

import Classes.Reserva;
import DAO.JPAReservaDAO;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*JPAProdutoDAO interfaceDAO = new JPAProdutoDAO();
		Produto produto = new Produto();

		produto.setId(1);
		produto.setNome("lampada");
		produto.setPreco(12);
		produto.setQuant(2);
		produto.setTipo("eletrico");
		produto.setDisp(true);
		
		interfaceDAO.salva(produto);*/
/*-----------------------------------------------------------------------------------------------------*/	
		/*JPAAlmoxarifadoDAO almoxarifadoDAO = new JPAAlmoxarifadoDAO();
		Almoxarifado almoxarifado = new Almoxarifado();
		
		almoxarifado.setId(1);
		almoxarifado.setPedido("Luminaria");
		almoxarifado.setPreco(150);
		almoxarifado.setProduto(1, "lampada", "eletrico", 1, 150, true);
		almoxarifado.setRegistroIn("15/03/2021");
		almoxarifado.setRegistroOut("18/03/2021");
		
		almoxarifadoDAO.salva(almoxarifado);*/
/*-----------------------------------------------------------------------------------------------------*/		
		/*JPAApartamentoDAO apartamentoDAO = new JPAApartamentoDAO();
		Apartamento apartamento = new Apartamento();
		
		apartamento.setId(1);
		apartamento.setBloco("B");
		apartamento.setNumero(404);
		
		apartamentoDAO.salva(apartamento);*/
/*-----------------------------------------------------------------------------------------------------*/
		/*JPAFornecedorDAO fornecedorDAO = new JPAFornecedorDAO();
		Fornecedor fornecedor = new Fornecedor();
		
		fornecedor.setId(1);
		fornecedor.setNome("Netcell");
		fornecedor.setTipo("Provedor de Internet");
		fornecedor.setEndereco("Rua José Miguel, nº 16");
		fornecedor.setContato("(81) 3691-1217");
		
		fornecedorDAO.salva(fornecedor);*/
/*-----------------------------------------------------------------------------------------------------*/
		/*AQUI REMOVE DO BANCO*/
		/*FuncionarioDAO r = new JPAFuncionarioDAO();
		r.remove(5);*/
		
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
		
		funcionario.setNome("Sebastiao Rozende");
		funcionario.setFuncao("Encanador");
		funcionario.setEndereco("Paudalho, nº 140");
		funcionario.setContato("(81) 5555-6666");
		
		funcionarioDAO.salva(funcionario);*/
/*-----------------------------------------------------------------------------------------------------*/		
		/*JPAMoradorDAO moradorDAO = new JPAMoradorDAO();
		Morador morador = new Morador();
		
		morador.setId(1);
		morador.setNome("Joao Silva");
		morador.setTipo("morador");
		morador.setApt(1,"B",404);
		
		moradorDAO.salva(morador);*/
/*-----------------------------------------------------------------------------------------------------*/
		/*JPAReservaDAO reservaDAO = new JPAReservaDAO();
		Reserva reserva = new Reserva();
		
		reserva.setId(1);
		reserva.setTipo_espaco("Salao");
		reserva.setData("25/03/2021");
		reserva.setHoraIni("19:00hrs");
		reserva.setHoraFim("22:00hrs");
		
		reservaDAO.salva(reserva);*/
	}

}
