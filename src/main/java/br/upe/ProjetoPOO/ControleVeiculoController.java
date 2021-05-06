package br.upe.ProjetoPOO;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.sun.javafx.binding.SelectBinding.AsString;

import br.upe.ProjetoPOO.Classes.Apartamento;
import br.upe.ProjetoPOO.Classes.Veiculo;
import br.upe.ProjetoPOO.Controladores.ApartamentoControlador;
import br.upe.ProjetoPOO.Controladores.ApartamentoControladorInterface;
import br.upe.ProjetoPOO.Controladores.VeiculoControlador;
import br.upe.ProjetoPOO.Controladores.VeiculoControladorInterface;
import br.upe.ProjetoPOO.DAO.JPAVeiculoDAO;
import br.upe.ProjetoPOO.DAO.VeiculoDAO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ControleVeiculoController implements Initializable{

	//IDs dos objetos XML
	@FXML
	private TextField textFieldPlaca;
	@FXML
	private TextField textFieldDescricao;
	@FXML
	private ChoiceBox<Apartamento> cbApartamento;
	@FXML
	private Button voltarInicial;
	@FXML
	private Button buttonSalvar;
	@FXML
	private Button buttonEditar;
	@FXML
	private Button buttonDeletar;
	@FXML
	private Button buttonListar;
	@FXML
	private TableView<Veiculo> veiculoTable;
	@FXML
	private TableColumn<Veiculo, String> veiculoTablePlaca;
	@FXML
	private TableColumn<Veiculo, String> veiculoTableDescricao;
	@FXML
	private TableColumn<Veiculo, AsString> veiculoTableApartamento;
	@FXML
	private Label label01;

	//Regra de negócio de Veiculo
	VeiculoControladorInterface interfaceVeiculo = VeiculoControlador.getINSTANCE();
	//Regra de negócio de Apartamento
	ApartamentoControladorInterface interfaceApartamento = ApartamentoControlador.getINSTANCE();

	//Lista visível para preencher a tabela
	private List<Veiculo> tableView = new ArrayList<>();	

	//Lista visível para preencher a choicebox
	private List<Apartamento> cbView = new ArrayList<Apartamento>();

	//Objeto que recebe dados da linha selecionada na tabela
	private Veiculo veiculoSelecionado;
	//Objeto criado para editar
	private Veiculo veiculoEdita;

	//Objeto que recebe dados do objeto da choicebox
	private Apartamento apartamentoSelecionado;

	//Preenchimento da choicebox e tabela
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		tableView = interfaceVeiculo.lista();
		cbView = interfaceApartamento.lista();

		//Fábricas, ou que diabo seja isso de dados, pras células das tabelas
		veiculoTablePlaca.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("placa"));
		veiculoTableDescricao.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("descricao"));
		veiculoTableApartamento.setCellValueFactory(new PropertyValueFactory<Veiculo, AsString>("apartamento"));

		//Preenche a tabela
		if(tableView != null) {
			if(tableView.size() > 0) {
				veiculoTable.getItems().setAll(tableView);
			}		
		}
		else {
			veiculoTable.getItems().removeAll();
		}

		//Listerner da tabela
		veiculoTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				veiculoSelecionado = (Veiculo) newValue;
			}
		});

		//Limpa e depois preenche a choicebox
		if(cbView != null) {
			if(cbView.size() > 0) {
				cbApartamento.getItems().removeAll(cbView);
				cbApartamento.getItems().addAll(cbView);
			}		
		}
		else {
			cbApartamento.getItems().clear();
		}

		//Listener da choicebox
		cbApartamento.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				apartamentoSelecionado = (Apartamento) newValue;
			}
		});

		//Ação do botão Editar para editar Veiculo selecionado na tabela
		buttonEditar.setOnMouseClicked((MouseEvent e) -> {
			editaVeiculo();
		});

		//Ação do botão Deletar para deletar Veiculo selecionado na tabela
		buttonDeletar.setOnMouseClicked((MouseEvent e) -> {
			deletaVeiculo();
		});
	}

	//Método para editar Veiculo
	public void editaVeiculo() {
		veiculoEdita = veiculoSelecionado;
		textFieldPlaca.setText(veiculoSelecionado.getPlaca());
		textFieldDescricao.setText(veiculoSelecionado.getDescricao());
		cbApartamento.getSelectionModel().select(veiculoSelecionado.getApartamento());
		this.initialize(null, null);
	}

	//Método para remover Veiculo
	public void deletaVeiculo() {
		interfaceVeiculo.removerVeiculo(veiculoSelecionado);
		this.initialize(null, null);
	}

	//Ação do botão Salvar
	@FXML
	void salvarVeiculo(ActionEvent event) {
		Veiculo gravaVeiculo = new Veiculo();
		
		if(veiculoEdita != null) {
			gravaVeiculo.setId(veiculoSelecionado.getId());
			gravaVeiculo.setPlaca(textFieldPlaca.getText());
			gravaVeiculo.setDescricao(textFieldDescricao.getText());
			gravaVeiculo.setApartamento(apartamentoSelecionado);			
		}
		else {
			gravaVeiculo.setPlaca(textFieldPlaca.getText());
			gravaVeiculo.setDescricao(textFieldDescricao.getText());
			gravaVeiculo.setApartamento(apartamentoSelecionado);			
		}
		
		interfaceVeiculo.criarVeiculo(gravaVeiculo);

		this.initialize(null, null);
	}

	//Ação do botão Listar
	@FXML
	void chamarListaVeiculo(ActionEvent event) {
		this.initialize(null, null);		
	}

	//Ação do botão Tela Inicial
	@FXML
	private void switchToTelaInicial() throws IOException {
		App.setRoot("telainicial");
	}

}
