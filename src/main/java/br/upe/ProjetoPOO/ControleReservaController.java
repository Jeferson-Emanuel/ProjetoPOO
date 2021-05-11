package br.upe.ProjetoPOO;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import br.upe.ProjetoPOO.Classes.Reserva;
import br.upe.ProjetoPOO.Controladores.ReservaControladorInterface;
import br.upe.ProjetoPOO.Controladores.ReservaControlador;
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
	@FXML
	private Label reservaLabel;

	//Lista visivel para preencher a tabela
	private List<Reserva> tableView = new ArrayList<>();

	//Lista visivel para preencher a choicebox
	private List<String> espacos = new ArrayList<>();

	//Objeto que recebe dados do objeto da choicebox
	private Reserva reservaSelecionada;

	//variável que indica se está editando ou não
	private boolean atualiza;

	//Regra de negocio de Reserva
	ReservaControladorInterface controladorReserva = ReservaControlador.getINSTANCE();

	/**Método de Preenchimento da Tabela
	 * Configura as colunas da tabela
	 * Preenche a tabela
	 * Extrai os valores de um objeto do banco de dados quando uma linha é selecionada na tabela  
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initialize(URL location, ResourceBundle resources) {

		reservaTableEspaco.setCellValueFactory(new PropertyValueFactory<Reserva, String>("tipo_espaco"));
		reservaTableData.setCellValueFactory(new PropertyValueFactory<Reserva, LocalDate>("Data"));
		reservaTableHorainicio.setCellValueFactory(new PropertyValueFactory<Reserva, LocalTime>("HoraInicio"));
		reservaTableHorafim.setCellValueFactory(new PropertyValueFactory<Reserva, LocalTime>("HoraFim"));
		reservaTableMorador.setCellValueFactory(new PropertyValueFactory<Reserva, String>("Morador"));

		reservaTable.getItems().setAll(tableView);
		
		reservaTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				reservaSelecionada = (Reserva) newValue;
			}
		});

		deletaReserva.setOnMouseClicked((MouseEvent e)->{
				try {
					deletarReserva();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

		});

		espacos = Arrays.asList("Piscina", "Salao", "Quiosque", "Quadra");

		choiceReserva.getItems().setAll(espacos);
	}

	/**Método de salvar Reserva
	 * Os valores nos campos de texto são convertidos de LocalDateTime para String 
	 * caso atualiza seja verdadeiro, então o processo atual é o de atualizar
	 * nesse caso, os dados nos campos de texto são sobreescritos com reservaSelecionada
	 * caso contrário, os dados serão salvos no banco de dados como uma nova Reserva
	 */
	public void salvaReserva() throws Exception {

		Reserva reserva = new Reserva();

		String data = reservaData.getText();
		LocalDate ld = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		reservaData.setText(String.valueOf(ld.minusDays(1)));
		reserva.setData(ld);

		String hora = reservaHoraInicio.getText();
		LocalTime lti = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
		reservaData.setText(String.valueOf(lti.minusNanos(1)));
		reserva.setHoraInicio(lti);

		String horaf = reservaHoraFim.getText();
		LocalTime ltf = LocalTime.parse(horaf, DateTimeFormatter.ofPattern("HH:mm"));
		reservaData.setText(String.valueOf(ltf.minusNanos(1)));
		reserva.setHoraFim(ltf);

		try {
			if(atualiza == true) {

				reserva.setId(reservaSelecionada.getId());
				reserva.setTipo_espaco(choiceReserva.getValue());
				reserva.setMorador(reservaMorador.getText());

				reservaLabel.setText("Atualizado com sucesso");

				reservaMorador.clear();
				reservaData.clear();
				reservaHoraInicio.clear();
				reservaMorador.clear();
				reservaHoraFim.clear();

				atualiza = false;
			}else {

				System.out.println("atualiza ta falso");
				reserva.setTipo_espaco(choiceReserva.getValue());
				reserva.setMorador(reservaMorador.getText());

				reservaLabel.setText("Salvo com sucesso");

			}
			controladorReserva.criarReserva(reserva);

			reservaMorador.clear();
			reservaData.clear();
			reservaHoraInicio.clear();
			reservaMorador.clear();
			reservaHoraFim.clear();

			tableView = controladorReserva.lista();

		}catch(Exception e){
			reservaLabel.setText("Erro ao salvar reserva");	
		}finally{
			this.initialize(null, null);
		}
	}

	/**
	 * Método de editar Reserva
	 * sobe o valor do @param atualiza para true.
	 * define os valores do @param reservaSelecionada com os valores dos campos de texto.
	 */
	public void atualizarReserva() {
		atualiza = true;

		try {
			choiceReserva.getSelectionModel().select(reservaSelecionada.getTipo_espaco());
			reservaMorador.setText(reservaSelecionada.getMorador());
			reservaData.setText(String.valueOf(reservaSelecionada.getData()));
			reservaHoraInicio.setText(String.valueOf(reservaSelecionada.getHoraInicio()));
			reservaHoraFim.setText(String.valueOf(reservaSelecionada.getHoraFim()));

			reservaData.clear();
		}catch(Exception e){
			reservaLabel.setText("Escolha uma reserva para edicao");
		}

	}

	/**
	 * Método de deletar Reserva
	 * remove a Reserva da linha selecionada na tabela Reserva
	 * Caso haja erro, retorna mensagem de erro
	 */
	public void deletarReserva() throws Exception {

		try {

			controladorReserva.removerReserva(reservaSelecionada);
			tableView = controladorReserva.lista();
			reservaLabel.setText("Reserva deletada");

		} catch (Exception e) {
			reservaLabel.setText("Erro ao deletar reserva");
		}

		this.initialize(null, null);  
	}
	/**
	 * Ação de listar Reserva
	 * @param chama na tabela o método lista do controlador de Reserva
	 * caso nulo retorna mensagem de erro
	 */
	@FXML
	void chamarListaReserva(ActionEvent event) {
		if ((controladorReserva.lista() == null) || (controladorReserva.lista().size() <= 0)) {
			reservaLabel.setText("Nada encontrado na base.");
		} else {
			tableView = controladorReserva.lista();
			this.initialize(null, null);
		}    	
	}
	/**
	 * Ação de editar Reserva
	 * @param Chama a função de editar o reserva
	 */
	@FXML
	void editarReserva(ActionEvent event) {
		atualizarReserva();
	}
	/**
	 * Ação de salvar Reserva
	 * @param Chama a função de salvar a reserva
	 */
	@FXML
	void salvarReserva(ActionEvent event) throws Exception {
		salvaReserva();
	}
	/**
	 * Ação de deletar Reserva
	 * @param Chama a função de remover reserva 
	 */
	@FXML
	void deletaReserva(ActionEvent event) throws Exception {
		deletarReserva();
	}

}