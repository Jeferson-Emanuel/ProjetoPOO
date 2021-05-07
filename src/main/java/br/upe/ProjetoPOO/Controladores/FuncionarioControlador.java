package br.upe.ProjetoPOO.Controladores;

import java.util.List;
import br.upe.ProjetoPOO.Classes.Funcionario;
import br.upe.ProjetoPOO.DAO.FuncionarioDAO;
import br.upe.ProjetoPOO.DAO.JPAFuncionarioDAO;

public class FuncionarioControlador implements InterfaceFuncionarioControlador {

	//Singleton	
	private static FuncionarioControlador INSTANCE;

	public static FuncionarioControlador getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new FuncionarioControlador();
		}
		return INSTANCE;
	}
	//Metodo de criar funcionario
	public void criarFuncionario(Funcionario funcionarioNovo) {
		
		FuncionarioDAO interfaceFuncionario = new JPAFuncionarioDAO();
		interfaceFuncionario.salva(funcionarioNovo);
		
		/*try {
			interfaceFuncionario.salva(FuncionarioNovo);
			System.out.println("Deu bom.");
			}
			catch(Exception E){
			System.out.println("Deu erro.");
		}*/		
	}

	//Metodo de remover funcionario
	public Funcionario remove(Funcionario removeFuncionario) {

		FuncionarioDAO remove = new JPAFuncionarioDAO();
		remove.remove(removeFuncionario.getId());

		return null;
	}
	
	//Método de listar Funcionário por CPF
	public Funcionario obterPorCpf(Funcionario obterFuncionario) {
		FuncionarioDAO interfaceFuncionario = new JPAFuncionarioDAO();
		return interfaceFuncionario.obterPorCpf(obterFuncionario.getCpf());
	}

	//metodo de listar funcionario
	public List<Funcionario> lista(){
		FuncionarioDAO interfaceFuncionario = new JPAFuncionarioDAO();
		return interfaceFuncionario.lista();
	}	

}







//Metodo antigo do controlador
/*	//Extrair cpf
String cpfNovo = funcionarioNovo.getCpf();
//Pesquisar na base
FuncionarioDAO funcionarioDAO = new JPAFuncionarioDAO();
Funcionario funcionarioBase = null;
funcionarioBase = funcionarioDAO.obterPorCpf(cpfNovo);
//Comparar cpf com resultado da base
if(funcionarioBase != null) {
//Se jï¿½ existir cpf, nï¿½o cadastra
	System.out.println("CPF jï¿½ cadastrado!");
}
else {
//Se nï¿½o existir o cpf, cadastra funcionario
funcionarioDAO.salva(funcionarioNovo);
System.out.println("Funcionario Cadastrado");
}
}*/



//-------------------------------------------------------------------------------------------------------------------//
/*package br.upe.ProjetoPOO.Controladores;

import java.util.List;
import br.upe.ProjetoPOO.Classes.Funcionario;
import br.upe.ProjetoPOO.DAO.FuncionarioDAO;
import br.upe.ProjetoPOO.DAO.JPAFuncionarioDAO;

public class FuncionarioControlador {

	//Singleton	
	private static FuncionarioControlador INSTANCE;
	
	public static FuncionarioControlador getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new FuncionarioControlador();
		}
		return INSTANCE;
	}
	//Método de criar funcionario
	public void criarFuncionario(Funcionario funcionarioNovo) {
	FuncionarioDAO interfaceFuncionario = new JPAFuncionarioDAO();
	interfaceFuncionario.salva(funcionarioNovo);
		/*try {
			interfaceFuncionario.salva(FuncionarioNovo);
			System.out.println("Deu bom.");
			}
			catch(Exception E){
			System.out.println("Deu erro.");
		}		
		}
	public Funcionario remove(Funcionario removeFuncionario) {
		return null;
	}
	
	public List<Funcionario> lista(){
		FuncionarioDAO interfaceFuncionario = new JPAFuncionarioDAO();
		return interfaceFuncionario.lista();
	}	
	
}


*/

//---------------------------------------------------------------------------------------------------------------------------//



/*	//Extrair cpf
String cpfNovo = funcionarioNovo.getCpf();
//Pesquisar na base
FuncionarioDAO funcionarioDAO = new JPAFuncionarioDAO();
Funcionario funcionarioBase = null;
funcionarioBase = funcionarioDAO.obterPorCpf(cpfNovo);
//Comparar cpf com resultado da base
if(funcionarioBase != null) {
//Se j� existir cpf, n�o cadastra
	System.out.println("CPF j� cadastrado!");
}
else {
//Se n�o existir o cpf, cadastra funcionario
funcionarioDAO.salva(funcionarioNovo);
System.out.println("Funcionario Cadastrado");
}
}*/

