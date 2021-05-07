package br.upe.ProjetoPOO;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.upe.ProjetoPOO.Classes.Funcionario;
import br.upe.ProjetoPOO.DAO.FuncionarioDAO;
import br.upe.ProjetoPOO.DAO.JPAFuncionarioDAO;
import br.upe.ProjetoPOO.Controladores.FuncionarioControlador;
import br.upe.ProjetoPOO.Controladores.FuncionarioControladorInterface;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ControleFuncionarioController implements Initializable {

	//IDs dos objetos FXML
	@FXML
	private Button funcSalvar;

	@FXML
	private Button funcEditar;

	@FXML
	private Button funcDeletar;

	@FXML
	private Button voltarInicial;

	@FXML
	private TableView<Funcionario> funcTable;

	@FXML
	private TableColumn<Funcionario, String> funcTableCpf;

	@FXML
	private TableColumn<Funcionario, String> funcTableNome;

	@FXML
	private TableColumn<Funcionario, String> funcTableFuncao;

	@FXML
	private TableColumn<Funcionario, String> funcTableEndereco;

	@FXML
	private TableColumn<Funcionario, String> funcTableContato;

	@FXML
	private Button funcListar;

	@FXML
	private TextField textFieldCpf;

	@FXML
	private TextField textFieldNome;

	@FXML
	private TextField textFieldFuncao;

	@FXML
	private TextField textFieldEndereco;

	@FXML
	private TextField textFieldContato;

	@FXML
	private Label funcLabel;

	//Lista para preencher a tabela
	private List<Funcionario> tableView = new ArrayList<>();

	//Objeto que recebe os dados da linha selecionada
	private Funcionario selecionado;
	
	private Funcionario edita;

	//Regra de negocio de funcionario
	FuncionarioControladorInterface controladorFuncionario = FuncionarioControlador.getINSTANCE();

	//Preenchimento da tabela
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//Configuracao das colunas
		funcTableCpf.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("Cpf"));
		funcTableNome.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("Nome"));
		funcTableFuncao.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("Funcao"));
		funcTableEndereco.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("Endereco"));
		funcTableContato.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("Contato"));

		//Preenche a tabela
		funcTable.getItems().setAll(tableView);

		//Acao do botao para deletar funcionario selecionado na tabela
		funcDeletar.setOnMouseClicked((MouseEvent e) -> {

			deletaFuncionario();
		});

		//extrai valores da linha selecionada na tabela, para o objeto
		funcTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				selecionado = (Funcionario) newValue;
			}
		});
	}

	//Metodo para deletar funcionario
	public void deletaFuncionario() {

		FuncionarioDAO interfaceFuncionario = new JPAFuncionarioDAO();
		interfaceFuncionario.remove(selecionado.getId());

		//Preence a tabela com os itens listados
		tableView = controladorFuncionario.lista();
		this.initialize(null, null);  
	}

	//Acao do botao salvar
	@FXML
	void salvarFunc(ActionEvent event) {

		
		if(edita  != null) {

			Funcionario func = new Funcionario();
			func.setId(selecionado.getId());
			func.setCpf(textFieldCpf.getText());
			func.setNome(textFieldNome.getText());
			func.setFuncao(textFieldFuncao.getText());
			func.setEndereco(textFieldEndereco.getText());
			func.setContato(textFieldContato.getText());

			controladorFuncionario.criarFuncionario(func);
		}
		else {
			Funcionario func = new Funcionario();

			func.setCpf(textFieldCpf.getText());
			func.setNome(textFieldNome.getText());
			func.setFuncao(textFieldFuncao.getText());
			func.setEndereco(textFieldEndereco.getText());
			func.setContato(textFieldContato.getText());

			controladorFuncionario.criarFuncionario(func);
		}

		tableView = controladorFuncionario.lista();
		this.initialize(null, null);  

		//funcLabel.setText(controladorFuncionario.criarFuncionario(func));

	}
	
	@FXML
    void editaFuncionario(ActionEvent event) {
		edita = selecionado;
		
		textFieldCpf.setText(selecionado.getCpf());
		textFieldNome.setText(selecionado.getNome());
		textFieldFuncao.setText(selecionado.getFuncao());
		textFieldContato.setText(selecionado.getContato());
		textFieldEndereco.setText(selecionado.getEndereco());
		
		
    }

	//Acao do botao listar
	@FXML
	void chamarListaFunc(ActionEvent event) {

		//FuncionarioControlador controladorFuncionario = new FuncionarioControlador();
		tableView = controladorFuncionario.lista();
		this.initialize(null, null);    	
	}
	
	//Acao do botao tela inicial
	@FXML
	private void switchToTelaInicial() throws IOException {
		App.setRoot("telainicial");
	}
}




//----------------------------------------------------------------------
/*package br.upe.ProjetoPOO;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.upe.ProjetoPOO.Classes.Funcionario;
import br.upe.ProjetoPOO.DAO.FuncionarioDAO;
import br.upe.ProjetoPOO.DAO.JPAFuncionarioDAO;
import br.upe.ProjetoPOO.Controladores.FuncionarioControlador;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ControleFuncionarioController implements Initializable {

	@FXML
	private Button funcSalvar;

	@FXML
	private Button funcEditar;

	@FXML
	private Button funcDeletar;

	@FXML
	private Button voltarInicial;

	@FXML
	private TableView<Funcionario> funcTable;

	@FXML
	private TableColumn<Funcionario, String> funcTableCpf;

	@FXML
	private TableColumn<Funcionario, String> funcTableNome;
	
	@FXML
	private TableColumn<Funcionario, String> funcTableFuncao;
	
	@FXML
	private TableColumn<Funcionario, String> funcTableEndereco;
	
	@FXML
	private TableColumn<Funcionario, String> funcTableContato;

	@FXML
	private Button funcListar;

	@FXML
	private TextField textFieldCpf;
	
	@FXML
	private TextField textFieldNome;
	
	@FXML
	private TextField textFieldFuncao;
	
	@FXML
	private TextField textFieldEndereco;
	
	@FXML
	private TextField textFieldContato;
	
	@FXML
	private Label funcLabel;

	//Lista para preencher a tabela
	private List<Funcionario> tableView = new ArrayList<>();
	
	private Funcionario selecionado;
	
	FuncionarioControlador controladorFuncionario = FuncionarioControlador.getINSTANCE();
	
	//Preenchimento da tabela
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		funcTableCpf.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("Cpf"));
		funcTableNome.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("Nome"));
		funcTableFuncao.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("Funcao"));
		funcTableEndereco.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("Endereco"));
		funcTableContato.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("Contato"));
		
		funcTable.getItems().setAll(tableView);

		funcDeletar.setOnMouseClicked((MouseEvent e) -> {
			deletaFuncionario();
		});

		funcTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				selecionado = (Funcionario) newValue;
				}
			});
		}
	public void deletaFuncionario() {
		FuncionarioDAO interfaceFuncionario = new JPAFuncionarioDAO();
		interfaceFuncionario.remove(selecionado.getId());

		tableView = controladorFuncionario.lista();

		this.initialize(null, null);  
	}
	
	@FXML
	void salvarFunc(ActionEvent event) {
		Funcionario func = new Funcionario(textFieldCpf.getText(), textFieldNome.getText(), textFieldFuncao.getText(), textFieldEndereco.getText(), textFieldContato.getText());
		controladorFuncionario.criarFuncionario(func);

		tableView = controladorFuncionario.lista();

		this.initialize(null, null);  

		//funcLabel.setText(controladorFuncionario.criarFuncionario(func));

	}

	@FXML
	void chamarListaFunc(ActionEvent event) {
		//FuncionarioControlador controladorFuncionario = new FuncionarioControlador();
		tableView = controladorFuncionario.lista();

		this.initialize(null, null);    	
	}

	@FXML
	private void switchToTelaInicial() throws IOException {
		App.setRoot("telainicial");
	}

	
}


*/
