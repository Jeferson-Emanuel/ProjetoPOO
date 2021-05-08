package br.upe.ProjetoPOO;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.sun.javafx.binding.SelectBinding.AsInteger;

import br.upe.ProjetoPOO.Classes.Apartamento;
import br.upe.ProjetoPOO.Controladores.ApartamentoControlador;
import br.upe.ProjetoPOO.Controladores.ApartamentoControladorInterface;
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

public class ControleApartamentosController implements Initializable{

	//IDs dos objetos FXML
	@FXML
	private Button apSalvar;
	@FXML
	private Button apEditar;
	@FXML
	private Button apDeletar;
	@FXML
	private Button voltarInicial;
	@FXML
	private TableView<Apartamento> apTable;
	@FXML
	private TableColumn<Apartamento, String> apTableBloco;
	@FXML
	private TableColumn<Apartamento, AsInteger> apTableNumero;
	@FXML
	private Button apListar;
	@FXML
	private TextField textFieldBloco;
	@FXML
	private TextField texteFieldNumero;
	@FXML
	private Label apLabel;

	//Regra de negócio de Apartamento
	ApartamentoControladorInterface interfaceApartamento = ApartamentoControlador.getINSTANCE();

	//Lista visível para preencher a tabela
	private List<Apartamento> tableView = new ArrayList<>();

	//Objeto que recebe dados da linha selecionada na tabela
	private Apartamento selecionado;
	//Objeto que recebe dados da tabela para editar
	private Apartamento editar;

	//Preenchimento da tabela    
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		tableView = interfaceApartamento.lista();

		apTableBloco.setCellValueFactory(new PropertyValueFactory<Apartamento, String>("Bloco"));

		//Preenche a tabela
		tableView = interfaceApartamento.lista();
		if(tableView != null) {
			if(tableView.size() > 0) {
				apTable.getItems().setAll(tableView);
			}
		}
		else {
			apTable.getItems().clear();
		}

		//Extrai valores da linha selecionada na tabela para objeto
		apTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				selecionado = (Apartamento) newValue;
			}
		});

		//Action to botão Editar para editar apartamento selecionado na lista da tabela
		apEditar.setOnMouseClicked((MouseEvent e)->{			
			editaApartamento();
		});

		//Action do botão Deletar para deletar apartamento selecionado na lista da tabela
		apDeletar.setOnMouseClicked((MouseEvent e) -> {			
			deletaApartamento();
		});		
	}

	//Método para editar apartamento
	public void editaApartamento(){
		editar = apTable.getSelectionModel().getSelectedItem();
		textFieldBloco.setText(editar.getBloco());
	}

	//Método para atualizar apartamento
	public void atualizaApartamento() {
		Apartamento ap = new Apartamento();
		ap.setId(selecionado.getId());
		ap.setBloco(textFieldBloco.getText());

		//interfaceApartamento.criarApartamento(ap);
	}

	//Método para remover apartamento
	public void deletaApartamento() {

		try {
			interfaceApartamento.removerApartamento(selecionado);
			apLabel.setText("Apartamento deletado.");
		}
		catch(Exception e) {
			apLabel.setText("Apartamento não existe.");
		}
		this.initialize(null, null);  
	}

	//Ação do botão Salvar
	@FXML
	void salvarAP(ActionEvent event) {

		try {
			Apartamento ap = new Apartamento();

			if(editar != null) {			
				ap.setId(selecionado.getId());
				ap.setBloco(textFieldBloco.getText());
				editar = null;
			}
			else {
				ap.setBloco(textFieldBloco.getText());
			}
			interfaceApartamento.criarApartamento(ap);
			apLabel.setText("Apartamento cadastrado.");
		}
		catch(Exception e) {
			apLabel.setText("Apartamento já cadastrado.");
		}
		finally {
			this.initialize(null, null);			
			textFieldBloco.clear();
		}

	}

	//Ação do botão Listar
	@FXML
	void chamarListaAP(ActionEvent event) {
		this.initialize(null, null);
	}

	//Ação do botão Tela Inicial
	@FXML
	private void switchToTelaInicial() throws IOException {
		App.setRoot("telainicial");
	}

}
