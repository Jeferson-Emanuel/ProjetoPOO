package br.upe.ProjetoPOO.Testes;

import org.junit.Assert;
import java.util.List;

import br.upe.ProjetoPOO.Classes.Apartamento;
import br.upe.ProjetoPOO.Classes.Veiculo;
import br.upe.ProjetoPOO.Controladores.VeiculoControlador;
import br.upe.ProjetoPOO.DAO.JPAVeiculoDAO;
import br.upe.ProjetoPOO.DAO.VeiculoDAO;
import junit.framework.TestCase;

public class VeiculoTeste extends TestCase{
	public void testeVeiculoAdiciona() {
	
		
	//Cria instância de Veiculo
	//Apartamento apt_1 = new Apartamento("A", 1);
	Veiculo veiculo_novo = new Veiculo("Honda", "carro", "AAAAA", "verde");
		
	
	//Envia Veiculo criado para controlador
	VeiculoControlador veiculo_contrl = new VeiculoControlador();
	veiculo_contrl.criarVeiculo(veiculo_novo);
	
	//Teste de Veiculo por tamanho de lista retornada igual 1
	VeiculoDAO VeiculoDAO = new JPAVeiculoDAO();
	List<Veiculo> listaTeste = VeiculoDAO.lista();
	int tamanhoLista = listaTeste.size();
	Assert.assertEquals(1, tamanhoLista);
}

/*public void testeVeiculoAtualiza() {
	
	//Cria instância de Veiculo
	Veiculo veiculo_novo = new Veiculo("Honda", "carro", "AAAAA", "verde", apt_1);
	//Instancia controlador
	VeiculoControlador veiculo_contrl = new VeiculoControlador();
	//Envia Veiculo criado para controlador
	veiculo_contrl.criarVeiculo(veiculo_novo);
	
	//Instancia JPA
	VeiculoDAO VeiculoDAO = new JPAVeiculoDAO();
	//Buscar Veiculo no banco por nome
	Veiculo VeiculoBase = VeiculoDAO.obterPorNome("Vassoura");
	//Extrai quantidade do Veiculo encontrado
	int quantVeiculoBase = VeiculoBase.getQuant();
	//Verifica se é o dobro do Veiculo original
	Assert.assertEquals(quantVeiculoBase, Veiculo.getQuant());
}*/

}
