package br.upe.ProjetoPOO;

import br.upe.ProjetoPOO.Classes.Apartamento;
import br.upe.ProjetoPOO.Classes.Morador;
import br.upe.ProjetoPOO.Controladores.ApartamentoControlador;
import br.upe.ProjetoPOO.Controladores.ApartamentoControladorInterface;
import br.upe.ProjetoPOO.Controladores.MoradorControlador;
import br.upe.ProjetoPOO.Controladores.MoradorControladorInterface;
import com.sun.javafx.binding.SelectBinding.AsString;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Classe controladora da interface JavaFX.
 */
public class ControleMoradorController implements Initializable {

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

    //Regra de neg�cio de Morador
    MoradorControladorInterface interfaceMorador = MoradorControlador.getINSTANCE();

    //Regra de neg�cio de Apartamento
    ApartamentoControladorInterface interfaceApartamento = ApartamentoControlador.getINSTANCE();

    //Lista vis�vel para preencher a tabela
    private List<Morador> tableView = new ArrayList<>();

    //Lista vis�vel para preencher a choicebox
    private List<Apartamento> cbView = new ArrayList<Apartamento>();

    //Objeto que recebe dados da linha selecionada na tabela
    private Morador moradorSelecionado;

    //Boolean para confirmar edi��o
    Boolean editar = false;

    //Objeto que recebe dados do objeto da choicebox
    private Apartamento apartamentoSelecionado;

    //Preenchimento da choicebox e tabela
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tableView = interfaceMorador.lista();
        cbView = interfaceApartamento.lista();

        //F�bricas de dados pras c�lulas das tabelas
        moradorTableCPF.setCellValueFactory(new PropertyValueFactory<Morador, String>("cpf"));
        moradorTableNome.setCellValueFactory(new PropertyValueFactory<Morador, String>("nome"));
        moradorTableApartamento.setCellValueFactory(new PropertyValueFactory<Morador, AsString>("apt"));

        //Preenche a tabela
        if (tableView != null && tableView.size() > 0) {
            moradorTable.getItems().setAll(tableView);
        } else {
            moradorTable.getItems().clear();
        }

        //Listerner da tabela
        moradorTable.getSelectionModel().
                selectedItemProperty().
                addListener(new ChangeListener() {
                    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                        moradorSelecionado = (Morador) newValue;
                    }
                });

        //Limpa e depois preenche a choicebox
        if (cbView != null && cbView.size() > 0) {
            cbApartamento.getItems().removeAll(cbView);
            cbApartamento.getItems().addAll(cbView);
        } else {
            cbApartamento.getItems().clear();
        }

        //Listener da choicebox
        cbApartamento.getSelectionModel().
                selectedItemProperty().
                addListener(new ChangeListener() {
                    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                        apartamentoSelecionado = (Apartamento) newValue;
                    }
                });
    }

    /**
     * M�todo para salvar Morador.
     */
    public void salvaMorador() {
        Morador gravaMorador = new Morador();
        try {
            if (editar == true) {
                gravaMorador.setId(moradorSelecionado.getId());
                gravaMorador.setCpf(textFieldCPF.getText());
                gravaMorador.setNome(textFieldNome.getText());
                gravaMorador.setApt(cbApartamento.getValue());
                editar = false;
            } else {
                gravaMorador.setCpf(textFieldCPF.getText());
                gravaMorador.setNome(textFieldNome.getText());
                gravaMorador.setApt(cbApartamento.getValue());
            }
            interfaceMorador.criarMorador(gravaMorador);
            label01.setText("Morador cadastrado.");
            textFieldCPF.clear();
            textFieldNome.clear();
            cbApartamento.getItems().clear();
        } catch (Exception e) {
            label01.setText("CPF j� cadastrado.");
        } finally {
            this.initialize(null, null);
        }
    }

    /**
     * M�todo para editar Morador.
     */
    public void editaMorador() {
        editar = true;
        textFieldCPF.setText(moradorSelecionado.getCpf());
        textFieldNome.setText(moradorSelecionado.getNome());
        cbApartamento.getSelectionModel().select(moradorSelecionado.getApt());
    }

    /**
     * M�todo para deletar Morador.
     */
    public void deletaMorador() {
        try {
            interfaceMorador.removerMorador(moradorSelecionado);
            label01.setText("Morador deletado.");
        } catch (Exception e) {
            label01.setText("Morador n�o existe.");
        } finally {
            this.initialize(null, null);
        }
    }

    //A��o do bot�o Salvar
    @FXML
    void salvarMorador(ActionEvent event) {
        salvaMorador();
    }

    //A��o do bot�o Editar
    @FXML
    void editarMorador(ActionEvent event) {
        editaMorador();
    }

    //A��o do bot�o Deletar
    @FXML
    void deletarMorador(ActionEvent event) {
        deletaMorador();
    }

    //A��o do bot�o Listar
    @FXML
    void chamarListaMorador(ActionEvent event) {

        if ((interfaceMorador.lista() == null) || (interfaceMorador.lista().size() <= 0)) {
            label01.setText("Nada encontrado na base.");
        } else {
            this.initialize(null, null);
        }
    }
}