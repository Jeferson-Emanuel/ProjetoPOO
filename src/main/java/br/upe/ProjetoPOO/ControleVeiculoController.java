package br.upe.ProjetoPOO;

import br.upe.ProjetoPOO.Classes.Apartamento;
import br.upe.ProjetoPOO.Classes.Veiculo;
import br.upe.ProjetoPOO.Controladores.ApartamentoControlador;
import br.upe.ProjetoPOO.Controladores.ApartamentoControladorInterface;
import br.upe.ProjetoPOO.Controladores.VeiculoControlador;
import br.upe.ProjetoPOO.Controladores.VeiculoControladorInterface;
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
public class ControleVeiculoController implements Initializable {

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

    //Regra de neg�cio de Veiculo
    VeiculoControladorInterface interfaceVeiculo = VeiculoControlador.getINSTANCE();

    //Regra de neg�cio de Apartamento
    ApartamentoControladorInterface interfaceApartamento = ApartamentoControlador.getINSTANCE();

    //Lista vis�vel para preencher a tabela
    private List<Veiculo> tableView = new ArrayList<>();

    //Lista vis�vel para preencher a choicebox
    private List<Apartamento> cbView = new ArrayList<Apartamento>();

    //Objeto que recebe dados da linha selecionada na tabela
    private Veiculo veiculoSelecionado;

    //Boolean para confirmar edi��o
    Boolean editar = false;

    //Objeto que recebe dados do objeto da choicebox
    private Apartamento apartamentoSelecionado;

    //Preenchimento da choicebox e tabela
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tableView = interfaceVeiculo.lista();
        cbView = interfaceApartamento.lista();

        //F�bricas de dados pras c�lulas das tabelas
        veiculoTablePlaca.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("placa"));
        veiculoTableDescricao.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("descricao"));
        veiculoTableApartamento.setCellValueFactory(new PropertyValueFactory<Veiculo, AsString>("apartamento"));

        //Preenche a tabela
        if (tableView != null && tableView.size() > 0) {
            veiculoTable.getItems().setAll(tableView);

        } else {
            veiculoTable.getItems().clear();
        }

        //Listerner da tabela
        veiculoTable.getSelectionModel().
                selectedItemProperty().
                addListener(new ChangeListener() {
                    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                        veiculoSelecionado = (Veiculo) newValue;
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
     * M�todo para salvar Veiculo.
     */
    public void salvaVeiculo() {
        Veiculo gravaVeiculo = new Veiculo();
        try {
            if (editar == true) {
                gravaVeiculo.setId(veiculoSelecionado.getId());
                gravaVeiculo.setPlaca(veiculoSelecionado.getPlaca());
                gravaVeiculo.setDescricao(textFieldDescricao.getText());
                gravaVeiculo.setApartamento(cbApartamento.getValue());
                editar = false;
            } else {
                gravaVeiculo.setPlaca(textFieldPlaca.getText());
                gravaVeiculo.setDescricao(textFieldDescricao.getText());
                gravaVeiculo.setApartamento(cbApartamento.getValue());
            }
            interfaceVeiculo.criarVeiculo(gravaVeiculo);
            label01.setText("Ve�culo cadastrado.");
            textFieldPlaca.clear();
            textFieldDescricao.clear();
            cbApartamento.getItems().clear();
        } catch (Exception e) {
            label01.setText("Placa j� cadastrada.");
        } finally {
            this.initialize(null, null);
        }
    }

    /**
     * M�todo para editar Veiculo.
     */
    public void editaVeiculo() {
        editar = true;
        textFieldPlaca.setText(veiculoSelecionado.getPlaca());
        textFieldDescricao.setText(veiculoSelecionado.getDescricao());
        cbApartamento.getSelectionModel().select(veiculoSelecionado.getApartamento());
    }

    /**
     * M�todo para deletar Veiculo.
     */
    public void deletaVeiculo() {
        try {
            interfaceVeiculo.removerVeiculo(veiculoSelecionado);
            label01.setText("Ve�culo deletado.");
        } catch (Exception e) {
            label01.setText("Ve�culo n�o existe.");
        } finally {
            this.initialize(null, null);
        }
    }

    //A��o do bot�o Salvar
    @FXML
    void salvarVeiculo(ActionEvent event) {
        salvaVeiculo();
    }

    //A��o do bot�o Editar
    @FXML
    void editarVeiculo(ActionEvent event) {
        editaVeiculo();
    }

    //A��o do bot�o Deletar
    @FXML
    void deletarVeiculo(ActionEvent event) {
        deletaVeiculo();
    }

    //A��o do bot�o Listar
    @FXML
    void chamarListaVeiculo(ActionEvent event) {
        if ((interfaceVeiculo.lista() == null) || (interfaceVeiculo.lista().size() <= 0)) {
            label01.setText("Nada encontrado na base.");
        } else {
            this.initialize(null, null);
        }
    }
}
