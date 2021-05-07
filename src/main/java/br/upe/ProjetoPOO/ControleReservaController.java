package br.upe.ProjetoPOO;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import br.upe.ProjetoPOO.Classes.Reserva;
import br.upe.ProjetoPOO.Controladores.ReservaControladorInterface;
import br.upe.ProjetoPOO.Controladores.ReservaControlador;
import br.upe.ProjetoPOO.DAO.JPAReservaDAO;
import br.upe.ProjetoPOO.DAO.ReservaDAO;
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
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;


public class ControleReservaController implements Initializable {

	//ID dos objetos FXML
	@FXML
	private Pane paneTable;

	@FXML
	private TableView<Reserva> reservaTable;

	@FXML
	private TableColumn<Reserva, String> reservaTableEspaco;

	@FXML
	private TableColumn<Reserva, LocalDate> reservaTableData;

	@FXML
	private TableColumn<Reserva, LocalTime> reservaTableHorainicio;

	@FXML
	private TableColumn<Reserva, LocalTime> reservaTableHorafim;

	@FXML
	private TableColumn<Reserva, String> reservaTableMorador;

	@FXML
	private ChoiceBox<String> choiceReserva;

	@FXML
	private TextField reservaEspaco;

	@FXML
	private TextField reservaData;

	@FXML
	private TextField reservaHoraInicio;

	@FXML
	private TextField reservaHoraFim;

	@FXML
	private TextField reservaMorador;

	@FXML
	private Button salvaReserva;

	@FXML
	private Button deletaReserva;

	@FXML
	private Button atualizaReserva;

	@FXML
	private Button listaReserva;

	@FXML
	private Button voltarInicial;

	//Lista visivel para preencher a tabela
	private List<Reserva> tableView = new ArrayList<>();

	//Lista visivel para preencher a choicebox
	private List<String> espacos = new ArrayList<>();

	//Objeto que recebe dados do objeto da choicebox
	private Reserva reservaSelecionada;
	
	private Reserva atualiza;

	//Regra de negocio de Reserva
	ReservaControladorInterface controladorReserva = ReservaControlador.getINSTANCE();

	//Preenchemento da tabela e da choicebox
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initialize(URL location, ResourceBundle resources) {

		//Configura as colunas da tabela
		reservaTableEspaco.setCellValueFactory(new PropertyValueFactory<Reserva, String>("tipo_espaco"));
		reservaTableData.setCellValueFactory(new PropertyValueFactory<Reserva, LocalDate>("Data"));
		reservaTableHorainicio.setCellValueFactory(new PropertyValueFactory<Reserva, LocalTime>("HoraInicio"));
		reservaTableHorafim.setCellValueFactory(new PropertyValueFactory<Reserva, LocalTime>("HoraFim"));
		reservaTableMorador.setCellValueFactory(new PropertyValueFactory<Reserva, String>("Morador"));

		//Preenche a tabela
		reservaTable.getItems().setAll(tableView);

		//Listener
		reservaTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				reservaSelecionada = (Reserva) newValue;
			}
		});

		//Acao do botao deletar, para deletar uma reserva da tabela
		deletaReserva.setOnMouseClicked((MouseEvent e)->{
			deletaReserva();
		});

		//Lista que preenche a choicebox
		espacos = Arrays.asList("Piscina", "Salao", "Quiosque", "Quadra");
		
		//Preenche a choicebox
		choiceReserva.getItems().setAll(espacos);
	}

	//Acao do botao	salvar
	@FXML
	void salvarReserva(ActionEvent event) {


		Reserva reserva = new Reserva();

		if(atualiza != null) {
			
			reserva.setId(reservaSelecionada.getId());
			reserva.setTipo_espaco(choiceReserva.getValue());
			reserva.setMorador(reservaMorador.getText());

			//Conversao de String para LocalDate e LocalTime
			String data = reservaData.getText();
			LocalDate ld = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			String dia = String.valueOf(ld.minusDays(1));
			reservaData.setText(dia);
			reserva.setData(ld);

			String hora = reservaHoraInicio.getText();
			LocalTime lti = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
			String di = String.valueOf(lti.minusNanos(1));
			reservaData.setText(di);
			reserva.setHoraInicio(lti);

			String horaf = reservaHoraFim.getText();
			LocalTime ltf = LocalTime.parse(horaf, DateTimeFormatter.ofPattern("HH:mm"));
			String d = String.valueOf(ltf.minusNanos(1));
			reservaData.setText(d);
			reserva.setHoraFim(ltf);
		}else {
			
			//reserva.setId(reservaSelecionada.getId());
			reserva.setTipo_espaco(choiceReserva.getValue());
			reserva.setMorador(reservaMorador.getText());

			//Conversao de String para LocalDate e LocalTime
			String data = reservaData.getText();
			LocalDate ld = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			String dia = String.valueOf(ld.minusDays(1));
			reservaData.setText(dia);
			reserva.setData(ld);

			String hora = reservaHoraInicio.getText();
			LocalTime lti = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
			String di = String.valueOf(lti.minusNanos(1));
			reservaData.setText(di);
			reserva.setHoraInicio(lti);

			String horaf = reservaHoraFim.getText();
			LocalTime ltf = LocalTime.parse(horaf, DateTimeFormatter.ofPattern("HH:mm"));
			String d = String.valueOf(ltf.minusNanos(1));
			reservaData.setText(d);
			reserva.setHoraFim(ltf);
			
		}	

		//Chama a interface do controlador, que chama o metodo que cria a reserva
		controladorReserva.criarReserva(reserva);

		//Lista as informacoes na tabela
		tableView = controladorReserva.lista();

		//Responsavel pelo preenchimento
		this.initialize(null, null);  

		//}
		//else {
		//	Reserva reserva = new Reserva();
		//	controladorReserva.criarReserva(reserva);
		//	}
	}

	//Acao do botao listar
	@FXML
	void chamarListaReserva(ActionEvent event) {

		tableView = controladorReserva.lista();
		this.initialize(null, null);    	
	}
	
	@FXML
    void atualizarReserva(ActionEvent event) {
		
		atualiza = reservaSelecionada;
		
		choiceReserva.getSelectionModel().select(reservaSelecionada.getTipo_espaco());
		reservaMorador.setText(reservaSelecionada.getMorador());
		reservaData.setText(String.valueOf(reservaSelecionada.getData()));
		reservaHoraInicio.setText(String.valueOf(reservaSelecionada.getHoraInicio()));
		reservaHoraFim.setText(String.valueOf(reservaSelecionada.getHoraFim()));
		
		
    }

	//acao do botao deletar
	public void deletaReserva() {

		ReservaDAO interfaceReserva = new JPAReservaDAO();
		interfaceReserva.remove(reservaSelecionada.getId());

		tableView = controladorReserva.lista();
		this.initialize(null, null);  
	}

	//Acao do botao tela inicial
	@FXML
	void switchToTelaInicial(ActionEvent event) throws IOException {
		App.setRoot("telainicial");
	}
}
