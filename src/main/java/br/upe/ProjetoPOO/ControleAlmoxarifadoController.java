package br.upe.ProjetoPOO;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.tools.javac.Main;

import br.upe.ProjetoPOO.Classes.Almoxarifado;
import br.upe.ProjetoPOO.Classes.Estoque;
import br.upe.ProjetoPOO.Controladores.AlmoxarifadoControlador;
import br.upe.ProjetoPOO.Controladores.AlmoxarifadoControladorInterface;
import br.upe.ProjetoPOO.Controladores.EstoqueControlador;
import br.upe.ProjetoPOO.Controladores.EstoqueControladorInterface;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class ControleAlmoxarifadoController implements Initializable{

	@FXML
	private Button buttonControleEstoque;

	@FXML
	private Button buttonCadastrarFluxo;

	@FXML
	private Button buttonDetalheFluxo;

	@FXML
	private Button buttonDeeletaFluxo;

	@FXML
	private Button buttonListaFluxo;

	@FXML
	private TableView<Almoxarifado> tableViewFluxos;

	@FXML
	private TableColumn<Almoxarifado, String> tcFluxoData;

	@FXML
	private TableColumn<Almoxarifado, String> tcFluxoTipo;

	@FXML
	private TableView<Estoque> tableViewEstoques;

	@FXML
	private TableColumn<Estoque, String> tcEstoqueProduto;

	@FXML
	private TableColumn<Estoque, Integer> tcEstoqueQuantidade;

	@FXML
	private Button buttonListaEstoque;

	@FXML
	private Button buttonVoltar;

	//Regra de negócio de Almoxarifado
	AlmoxarifadoControladorInterface interfaceAlmoxarifado = AlmoxarifadoControlador.getINSTANCE();
	//Regra de negócio de Estoque
	EstoqueControladorInterface interfaceEstoque = EstoqueControlador.getINSTANCE();

	//Lista visível para preencher a tabela Fluxo
	private List<Almoxarifado> tableViewFluxo = new ArrayList<>(interfaceAlmoxarifado.lista());
	//Lista visível para preencher a tabela Estoque
	private List<Estoque> tableViewEstoque = new ArrayList<>(interfaceEstoque.lista());

	//Objeto que recebe linha selecionada da tabela Fluxos
	Almoxarifado fluxoSelecionado = new Almoxarifado();

	@Override
	public void initialize(URL url, ResourceBundle resources) {

		//Fábricas de dados pras células da tabela de Fluxos
		tcFluxoData.setCellValueFactory(new PropertyValueFactory<Almoxarifado, String>("data"));
		tcFluxoTipo.setCellValueFactory(new PropertyValueFactory<Almoxarifado, String>("tipo"));
		//Fábricas de dados pras células da tabela de Estoques
		tcEstoqueProduto.setCellValueFactory(new PropertyValueFactory<Estoque, String>("nomeProduto"));
		tcEstoqueQuantidade.setCellValueFactory(new PropertyValueFactory<Estoque, Integer>("quantidade"));

		//Preenche a tabela Fluxo se a lista visível não estiver vazia
		if(tableViewFluxo.size() > 0) {
			tableViewFluxos.getItems().setAll(tableViewFluxo);
		}
		else {
			tableViewFluxos.getItems().clear();
		}
		//Preenche a tabela Estoque se a lista visível não estiver vazia
		if(tableViewEstoque.size() > 0) {
			tableViewEstoques.getItems().setAll(tableViewEstoque);
		}
		else {
			tableViewEstoques.getItems().clear();
		}

		//Listener da Tabela
		tableViewFluxos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				fluxoSelecionado = (Almoxarifado) newValue;
			}
		});
	}

	//Ação do botão Cadastrar Fluxo
	@FXML
	void abreAlmoxarifadoFluxo(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("almoxarifadofluxo.fxml"));
			/* 
			 * if "fx:controller" is not set in fxml
			 * fxmlLoader.setController(NewWindowController);
			 */
			Scene scene = new Scene(fxmlLoader.load(), 600, 400);
			Stage stage = new Stage();
			stage.setTitle("Cadastra Fluxo");
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.show();

			/*stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

				public void handle(WindowEvent we) {
					//System.out.println("Stage is closing");
				}
			});*/ 

		} catch (IOException e) {
			Logger logger = Logger.getLogger(getClass().getName());
			logger.log(Level.SEVERE, "Failed to create new Window.", e);
		}
	}

	//Ação do botão Detalhe
	@FXML
	void abreDetalheFluxo(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("almoxarifadodetalhefluxo.fxml"));
			//fxmlLoader.setLocation(Main.class.getResource("/almoxarifadodetalhefluxo.fxml"));

			//Envia objeto para a próxima janela
			//Parent scene = fxmlLoader.load();             


			/* 
			 * if "fx:controller" is not set in fxml
			 * fxmlLoader.setController(NewWindowController);
			 */
			Scene scene = new Scene(fxmlLoader.load(), 600, 400);

			ControleAmoxarifadoDetalheController controller = fxmlLoader.getController();             
			//controller.setData(fluxoSelecionado);
			controller.setData(tableViewFluxos.getSelectionModel().getSelectedItem());

			Stage stage = new Stage();
			stage.setTitle("Detalhe Fluxo");
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.show();
		} catch (IOException e) {
			Logger logger = Logger.getLogger(getClass().getName());
			logger.log(Level.SEVERE, "Failed to create new Window.", e);
		}
	}

	//Ação do botão Listar(Fluxo)
	@FXML
	void listaFluxo(ActionEvent event) {
		tableViewFluxo = interfaceAlmoxarifado.lista();

		this.initialize(null, null);
	}
	//Ação do botão Listar(Estoque)
	@FXML
	void listaEstoque(ActionEvent event) {
		tableViewEstoque = interfaceEstoque.lista();

		this.initialize(null, null);
	}

	@FXML
	void deletaFluxo(ActionEvent event) {
		interfaceAlmoxarifado.removeAlmoxarifado(fluxoSelecionado);

		tableViewFluxo = interfaceAlmoxarifado.lista();

		this.initialize(null, null);
	}

	@FXML
	void abreControleEstoque(ActionEvent event) {
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("almoxarifadocontroleestoque.fxml"));
			
			Scene scene = new Scene(fxmlLoader.load(), 600, 400);
			Stage stage = new Stage();
			stage.setTitle("Controle Estoque");
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.show();

		} catch (IOException e) {
			Logger logger = Logger.getLogger(getClass().getName());
			logger.log(Level.SEVERE, "Failed to create new Window.", e);
		}

	}

	@FXML
	void voltaTelaInicial(ActionEvent event) throws IOException {
		App.setRoot("telainicial");
	}

}
