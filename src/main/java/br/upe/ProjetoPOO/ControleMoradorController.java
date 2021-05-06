package br.upe.ProjetoPOO;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.ResourceBundle;

import com.sun.javafx.binding.SelectBinding.AsString;

import br.upe.ProjetoPOO.Classes.Apartamento;
import br.upe.ProjetoPOO.Classes.Morador;
import br.upe.ProjetoPOO.Controladores.ApartamentoControlador;
import br.upe.ProjetoPOO.Controladores.ApartamentoControladorInterface;
import br.upe.ProjetoPOO.Controladores.MoradorControlador;
import br.upe.ProjetoPOO.Controladores.MoradorControladorInterface;
import br.upe.ProjetoPOO.DAO.JPAMoradorDAO;
import br.upe.ProjetoPOO.DAO.MoradorDAO;
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

public class ControleMoradorController implements Initializable{

	//IDs dos objetos XML
	@FXML
	private TextField textFieldCPF;
	@FXML
	private TextField textFieldNome;
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
	private TableView<Morador> moradorTable;
	@FXML
	private TableColumn<Morador, String> moradorTableCPF;
	@FXML
	private TableColumn<Morador, String> moradorTableNome;
	@FXML
	private TableColumn<Morador, AsString> moradorTableApartamento;
	@FXML
	private Label label01;

	//Regra de negócio de Morador
	MoradorControladorInterface interfaceMorador = MoradorControlador.getINSTANCE();
	//Regra de negócio de Apartamento
	ApartamentoControladorInterface interfaceApartamento = ApartamentoControlador.getINSTANCE();

	//Lista visível para preencher a tabela
	private List<Morador> tableView = new ArrayList<>();

	//Lista visível para preencher a choicebox
	private List<Apartamento> cbView = new ArrayList<Apartamento>();

	//Objeto que recebe dados da linha selecionada na tabela
	private Morador moradorSelecionado;
	//Objeto criado para editar morador
	private Morador editarMorador;
	
	//Objeto que recebe dados do objeto da choicebox
	private Apartamento apartamentoSelecionado;

	//Preenchimento da choicebox e tabela
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		tableView = interfaceMorador.lista();
		cbView = interfaceApartamento.lista();

		//Fábricas, ou que diabo seja isso de dados, pras células das tabelas
		moradorTableCPF.setCellValueFactory(new PropertyValueFactory<Morador, String>("cpf"));
		moradorTableNome.setCellValueFactory(new PropertyValueFactory<Morador, String>("nome"));
		moradorTableApartamento.setCellValueFactory(new PropertyValueFactory<Morador, AsString>("apt"));

		//Preenche a tabela
		if(tableView != null) {
			if(tableView.size() > 0) {
				moradorTable.getItems().setAll(tableView);
			}
		}		
		else {
			moradorTable.getItems().clear();
		}

		//Listerner da tabela
		moradorTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				moradorSelecionado = (Morador) newValue;
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

		//Ação do botão Editar para editar Morador selecionado na tabela
		buttonEditar.setOnMouseClicked((MouseEvent e) -> {
			editaMorador();
		});

		//Ação do botão Deletar para deletar Morador selecionado na tabela
		buttonDeletar.setOnMouseClicked((MouseEvent e) -> {
			deletaMorador();
		});
	}

	//Método para editar Morador
	public void editaMorador() {
		editarMorador = moradorSelecionado;
		textFieldCPF.setText(moradorSelecionado.getCpf());
		textFieldNome.setText(moradorSelecionado.getNome());
		cbApartamento.getSelectionModel().select(moradorSelecionado.getApt());
		this.initialize(null, null);
	}

	//Método para remover Morador
	public void deletaMorador() {
		MoradorDAO interfaceMorador = new JPAMoradorDAO();
		interfaceMorador.remove(moradorSelecionado.getId());

		tableView = interfaceMorador.lista();

		this.initialize(null, null);
	}

	//Ação do botão Salvar
	@FXML
	void salvarMorador(ActionEvent event) {
		
		Morador gravarMorador = new Morador();
		
		if(editarMorador != null) {
			gravarMorador.setId(moradorSelecionado.getId());
			gravarMorador.setCpf(textFieldCPF.getText());
			gravarMorador.setNome(textFieldNome.getText());
			gravarMorador.setApt(apartamentoSelecionado);
		}
		else {
			gravarMorador.setCpf(textFieldCPF.getText());
			gravarMorador.setNome(textFieldNome.getText());
			gravarMorador.setApt(apartamentoSelecionado);	
		}
		
		interfaceMorador.criarMorador(gravarMorador);

		this.initialize(null, null);
		
		textFieldCPF.clear();
		textFieldNome.clear();
		cbApartamento.getItems().clear();
	}

	//Ação do botão Listar
	@FXML
	void chamarListaMorador(ActionEvent event) {
		this.initialize(null, null);		
	}

	//Ação do botão Tela Inicial
	@FXML
	private void switchToTelaInicial() throws IOException {
		App.setRoot("telainicial");
	}

}
