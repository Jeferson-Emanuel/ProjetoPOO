package br.upe.ProjetoPOO;

import br.upe.ProjetoPOO.Classes.Estoque;
import br.upe.ProjetoPOO.Controladores.EstoqueControlador;
import br.upe.ProjetoPOO.Controladores.EstoqueControladorInterface;
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

public class ControleAlmoxarifadoEstoqueController implements Initializable {

    @FXML
    private TableView<Estoque> tableViewEstoques;

    @FXML
    private TableColumn<Estoque, String> tcEstoqueProduto;

    @FXML
    private TableColumn<Estoque, Integer> tcEstoqueQuantidade;

    @FXML
    private Label label01;

    @FXML
    private TextField textFieldProduto;

    @FXML
    private TextField textFieldQuantidade;

    @FXML
    private Button buttonCadastra;

    @FXML
    private Button buttonLista;

    @FXML
    private Button buttonEdita;

    @FXML
    private Button buttonDeleta;

    //Instancia regra de negocio Estoque
    EstoqueControladorInterface interfaceEstoque = EstoqueControlador.getINSTANCE();

    //Lista visível para preencher tabela Estoque
    private List<Estoque> tableViewEstoque = new ArrayList<>(interfaceEstoque.lista());

    //Objeto que recebe a selecção da tabela
    Estoque estoqueSelecionado = new Estoque();

    //Boolean que sinaliza edição de Estoque
    Boolean edita = false;

    @SuppressWarnings("unchecked")
    @Override
    public void initialize(URL url, ResourceBundle resources) {

        tableViewEstoque = interfaceEstoque.lista();

        //Fábricas de dados para as células da tabela Estoques
        tcEstoqueProduto.setCellValueFactory(new PropertyValueFactory<Estoque, String>("nomeProduto"));
        tcEstoqueQuantidade.setCellValueFactory(new PropertyValueFactory<Estoque, Integer>("quantidade"));

        if (tableViewEstoque.size() > 0) {
            tableViewEstoques.getItems().setAll(tableViewEstoque);
        } else {
            tableViewEstoques.getItems().clear();
        }

        //Listener da tabela
        tableViewEstoques.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                estoqueSelecionado = (Estoque) newValue;
            }
        });

    }

    @FXML
    void cadastraEstoque(ActionEvent event) {

        Estoque novoEstoque = new Estoque();
        List<Estoque> novaListaEstoque = new ArrayList<>();

        if (edita == true) {
            novoEstoque.setId(estoqueSelecionado.getId());
            novoEstoque.setNomeProduto(textFieldProduto.getText());
            novoEstoque.setQuantidade(Integer.parseInt(textFieldQuantidade.getText()));

            interfaceEstoque.editaEstoque(novoEstoque);

            edita = false;
        } else {
            novoEstoque.setNomeProduto(textFieldProduto.getText());
            novoEstoque.setQuantidade(Integer.parseInt(textFieldQuantidade.getText()));

            novaListaEstoque.add(novoEstoque);

            interfaceEstoque.adicionaEstoque(novaListaEstoque);
        }

        textFieldProduto.clear();
        textFieldQuantidade.clear();

        //tableViewEstoque = interfaceEstoque.lista();

        this.initialize(null, null);

    }

    @FXML
    void deletaEstoque(ActionEvent event) {

        interfaceEstoque.removeEstoque(estoqueSelecionado);

        //tableViewEstoque = interfaceEstoque.lista();

        this.initialize(null, null);

    }

    @FXML
    void editaEstoque(ActionEvent event) {

        edita = true;
        textFieldProduto.setText(estoqueSelecionado.getNomeProduto());
        textFieldQuantidade.setText(String.valueOf(estoqueSelecionado.getQuantidade()));

    }

    @FXML
    void listaEstoque(ActionEvent event) {

        this.initialize(null, null);

    }

}
