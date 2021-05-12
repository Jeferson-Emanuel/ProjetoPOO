package br.upe.ProjetoPOO;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.upe.ProjetoPOO.Classes.Funcionario;
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

	//vari�vel que indica se est� editando ou n�o
	private boolean edita;

	//Regra de negocio de funcionario
	FuncionarioControladorInterface controladorFuncionario = FuncionarioControlador.getINSTANCE();

	/**M�todo de Preenchimento da Tabela
	 * Configura as colunas da tabela
	 * Preenche a tabela
	 * Extrai os valores de um objeto do banco de dados quando uma linha � selecionada na tabela  
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		funcTableCpf.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("Cpf"));
		funcTableNome.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("Nome"));
		funcTableFuncao.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("Funcao"));
		funcTableEndereco.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("Endereco"));
		funcTableContato.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("Contato"));

		funcTable.getItems().setAll(tableView);
		
		funcTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				selecionado = (Funcionario) newValue;
			}
		});

		funcDeletar.setOnMouseClicked((MouseEvent e) -> {
			deletaFuncionario();
		});
	}

	/**M�todo de salvar funcionario
	 * caso edita seja verdadeiro, ent�o o processo atual � o de editar
	 * nesse caso, os dados nos campos de texto s�o sobreescritos com o funcionario selecionado
	 * caso contr�rio, os dados ser�o salvos no banco de dados como um novo funcion�rio
	 */
	public void salvaFuncionario(){
		Funcionario func = new Funcionario();
		try{
			if(edita  == true) {

				func.setId(selecionado.getId());
				func.setCpf(textFieldCpf.getText());
				func.setNome(textFieldNome.getText());
				func.setFuncao(textFieldFuncao.getText());
				func.setEndereco(textFieldEndereco.getText());
				func.setContato(textFieldContato.getText());
				controladorFuncionario.criarFuncionario(func);
				edita = false;
				funcLabel.setText("Editado com sucesso");

			}else{

				func.setCpf(textFieldCpf.getText());
				func.setNome(textFieldNome.getText());
				func.setFuncao(textFieldFuncao.getText());
				func.setEndereco(textFieldEndereco.getText());
				func.setContato(textFieldContato.getText());
				controladorFuncionario.criarFuncionario(func);
				funcLabel.setText("Salvo com sucesso");
			}
			tableView = controladorFuncionario.lista();
			textFieldCpf.clear();
			textFieldNome.clear();
			textFieldFuncao.clear();
			textFieldEndereco.clear();
			textFieldContato.clear();

		}catch(Exception e) {
			funcLabel.setText("Erro ao salvar funcionario");
		}finally {
			this.initialize(null, null);
		}
	}



	/**
	 * M�todo de deletar Funcionario
	 * remove o Funcionario da linha selecionada na tabela Funcionario
	 * Caso haja erro, retorna mensagem de erro
	 */
	public void deletaFuncionario(){
		try{
			controladorFuncionario.remove(selecionado);
			tableView = controladorFuncionario.lista();
			funcLabel.setText("Deletado com sucesso");

		}catch(Exception e){
			funcLabel.setText("Erro ao deletar funcionario");
		}finally {
			this.initialize(null, null);	
		}

	}

	/**
	 * M�todo de editar funcion�rio
	 * sobe o valor do @param edita para true.
	 * define os valores do @param selecionado com os valores dos campos de texto.
	 */
	public void editaFuncionario() {

		edita = true;
		textFieldCpf.setText(selecionado.getCpf());
		textFieldNome.setText(selecionado.getNome());
		textFieldFuncao.setText(selecionado.getFuncao());
		textFieldContato.setText(selecionado.getContato());
		textFieldEndereco.setText(selecionado.getEndereco());

	}

	/**
	 * A��o de listar Funcionarios
	 * @param chama na tabela o m�todo lista do controlador de Funcionario
	 * caso nulo retorna mensagem de erro
	 */
	@FXML
	void chamarListaFunc(ActionEvent event){

		if ((controladorFuncionario.lista() == null) || (controladorFuncionario.lista().size() <= 0)) {
			funcLabel.setText("Nada encontrado na base.");
		} else {
			tableView = controladorFuncionario.lista();
			this.initialize(null, null);
		}

	}
	/**
	 * A��o de editar Funcion�rio
	 * @param Chama a fun��o de editar o funcion�rio
	 */
	@FXML
	void editarFuncinario(ActionEvent event) {
		editaFuncionario();
	}
	/**
	 * A��o de salvar Funcion�rio
	 * @param Chama a fun��o de salvar o funcion�rio
	 */
	@FXML
	void salvarFunc(ActionEvent event) {
		salvaFuncionario();
	}
	/**
	 * A��o de deletar Funcion�rio
	 * @param Chama a fun��o de remover funcion�rio 
	 */
	@FXML
	void deletarFuncionario(ActionEvent event) {
		deletaFuncionario();
	}

}