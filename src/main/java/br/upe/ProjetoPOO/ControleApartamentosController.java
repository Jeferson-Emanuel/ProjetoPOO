package br.upe.ProjetoPOO;

import br.upe.ProjetoPOO.Classes.Apartamento;
import br.upe.ProjetoPOO.Controladores.ApartamentoControlador;
import br.upe.ProjetoPOO.Controladores.ApartamentoControladorInterface;
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

public class ControleApartamentosController implements Initializable {

    //IDs dos objetos FXML
    @FXML
    private Button apSalvar;
    @FXML
    private Button apEditar;
    @FXML
    private Button apDeletar;
    @FXML
    private TableView<Apartamento> apTable;
    @FXML
    private TableColumn<Apartamento, String> apTableBloco;
    @FXML
    private Button apListar;
    @FXML
    private TextField textFieldBloco;
    @FXML
    private Label apLabel;

    //Regra de negócio de Apartamento
    ApartamentoControladorInterface interfaceApartamento = ApartamentoControlador.getINSTANCE();

    //Lista visível para preencher a tabela
    private List<Apartamento> tableView = new ArrayList<>();

    //Objeto que recebe dados da linha selecionada na tabela
    private Apartamento selecionado;
    //Boolean que sinaliza edição de apartamento
    Boolean editar = false;

    //Preenchimento da tabela
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tableView = interfaceApartamento.lista();

        apTableBloco.setCellValueFactory(new PropertyValueFactory<Apartamento, String>("Bloco"));

        //Checa se a lista visível é nula e em seguida não vazia e então preenche a a tabela
        tableView = interfaceApartamento.lista();
        if (tableView != null) {
            if (tableView.size() > 0) {
                apTable.getItems().setAll(tableView);
            }
        } else {
            apTable.getItems().clear();
        }

        //Extrai valores da linha selecionada na tabela para objeto
        apTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionado = (Apartamento) newValue;
            }
        });
    }

    //Método para salvar apartamento
    public void salvaApartamento() {

        Apartamento gravaApartamento = new Apartamento();

        try {

            if (editar == true) {
                gravaApartamento.setId(selecionado.getId());
                gravaApartamento.setBloco(textFieldBloco.getText());
                editar = false;
            } else {
                gravaApartamento.setBloco(textFieldBloco.getText());
            }

            interfaceApartamento.criarApartamento(gravaApartamento);
            apLabel.setText("Apartamento cadastrado.");
            textFieldBloco.clear();

        } catch (Exception e) {
            apLabel.setText("Apartamento já cadastrado.");
        } finally {
            this.initialize(null, null);
        }
    }

    //Método para editar apartamento
    public void editaApartamento() {
        editar = true;
        textFieldBloco.setText(selecionado.getBloco());
    }

    //Método para deletar apartamento
    public void deletaApartamento() {

        try {
            interfaceApartamento.removerApartamento(selecionado);
            apLabel.setText("Apartamento deletado.");
        } catch (Exception e) {
            apLabel.setText("Apartamento não existe.");
        }
        finally{
            this.initialize(null, null);
        }

    }

    //Ação do botão Salvar
    @FXML
    void salvarAP(ActionEvent event) {
        salvaApartamento();
    }

    //Ação do botão Editar
    @FXML
    void editarAP(ActionEvent event){
        editaApartamento();
    }

    //Ação do botão Deletar
    @FXML
    void deletarAP(ActionEvent event){
        deletaApartamento();
    }

    //Ação do botão Listar
    @FXML
    void chamarListaAP(ActionEvent event) {
        this.initialize(null, null);
    }

}