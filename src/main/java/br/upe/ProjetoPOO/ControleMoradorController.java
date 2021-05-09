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
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
    Boolean editar = false;
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
        if (tableView != null) {
            if (tableView.size() > 0) {
                moradorTable.getItems().setAll(tableView);
            }
        } else {
            moradorTable.getItems().clear();
        }

        //Listerner da tabela
        moradorTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                moradorSelecionado = (Morador) newValue;
            }
        });

        //Limpa e depois preenche a choicebox
        if (cbView != null) {
            if (cbView.size() > 0) {
                cbApartamento.getItems().removeAll(cbView);
                cbApartamento.getItems().addAll(cbView);
            }
        } else {
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

    //Método para salvar Morador
    public void salvaMorador() {
        Morador gravaMorador = new Morador();
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

        this.initialize(null, null);

        textFieldCPF.clear();
        textFieldNome.clear();
        cbApartamento.getItems().clear();
    }

    //Método para editar Morador
    public void editaMorador() {
        editar = true;
        textFieldCPF.setText(moradorSelecionado.getCpf());
        textFieldNome.setText(moradorSelecionado.getNome());
        cbApartamento.getSelectionModel().select(moradorSelecionado.getApt());
    }

    //Método para remover Morador
    public void deletaMorador() {
        interfaceMorador.removerMorador(moradorSelecionado);
        this.initialize(null, null);
    }

    //Ação do botão Salvar
    @FXML
    void salvarMorador(ActionEvent event) {
       salvaMorador();
    }

    //Ação do botão Editar
    @FXML
    void editarMorador(ActionEvent event) {

    }

    //Ação do botão Deletar
    @FXML
    void deletarMorador(ActionEvent event) {
        deletaMorador();
    }

    //Ação do botão Listar
    @FXML
    void chamarListaMorador(ActionEvent event) {
        if ((interfaceMorador.lista() == null) || (interfaceMorador.lista().size() <= 0)) {
            label01.setText("Nada encontrado na base.");
        } else {
            this.initialize(null, null);
        }
    }

}