package br.upe.ProjetoPOO;

import java.beans.EventHandler;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import br.upe.ProjetoPOO.Classes.Almoxarifado;
import br.upe.ProjetoPOO.Classes.Estoque;
import br.upe.ProjetoPOO.Classes.Produto;
import br.upe.ProjetoPOO.Controladores.AlmoxarifadoControlador;
import br.upe.ProjetoPOO.Controladores.AlmoxarifadoControladorInterface;
import br.upe.ProjetoPOO.Controladores.EstoqueControlador;
import br.upe.ProjetoPOO.Controladores.EstoqueControladorInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControleAlmoxarifadoFluxoController implements Initializable{

    @FXML
    private Button buttonVoltar;

    @FXML
    private Button buttonAdicionarItems;

    @FXML
    private Button buttonSalvarFluxo;

    @FXML
    private TextField textFieldData;
    
    @FXML
    private TextField textFieldProduto;

    @FXML
    private TextField textFieldQuantidade;

    @FXML
    private TextField textFieldPreco;

    @FXML
    private ChoiceBox<String> cbTipoFluxo;

    @FXML
    private TableView<Produto> tableViewProdutos;

    @FXML
    private TableColumn<Produto, String> tcFluxoProdutos;

    @FXML
    private TableColumn<Produto, Integer> tcFluxoQuantidade;

    @FXML
    private TableColumn<Produto, Float> tcFluxoPreco;
    
  
    //Regra de negócio de Almoxarifado
    AlmoxarifadoControladorInterface interfaceAlmoxarifado = AlmoxarifadoControlador.getINSTANCE();
    //Regra de negócio de Estoque
    EstoqueControladorInterface interfaceEstoque = EstoqueControlador.getINSTANCE();
    
    //Lista visível para preencher a tabela
    private List<Produto> tableView = new ArrayList<>();
    
    //Lista visível para preencher a choicebox
    private List<String> cbOptions = Arrays.asList("Entrada", "Saída");
    
    //Lista que recebe os produtos do fluxo
    private List<Produto> produtosFluxo = new ArrayList<>();
    //Lista que receb os estoques
    private List<Estoque> estoqueFluxo = new ArrayList<>();
    
    //Método Initialize para preencher tabela e choicebox
    @Override
    public void initialize(URL url, ResourceBundle resources) {
    	
    	//Fábricas de dados para as células da tabela
    	tcFluxoProdutos.setCellValueFactory(new PropertyValueFactory<Produto, String>("produto"));
    	tcFluxoQuantidade.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("quant"));
    	tcFluxoPreco.setCellValueFactory(new PropertyValueFactory<Produto, Float>("preco"));
    	
    	tableViewProdutos.getItems().setAll(tableView);
    	
    	//Limpa e preenche a choicebox
    	if(cbOptions.size() > 0) {
    		cbTipoFluxo.getItems().removeAll(cbOptions);
    		cbTipoFluxo.getItems().addAll(cbOptions);
    	}
    }

    @FXML
    void adicionaItemsFluxo(ActionEvent event) {
    	Produto p = new Produto();
    	p.setProduto(textFieldProduto.getText());
    	p.setQuant(Integer.parseInt(textFieldQuantidade.getText()));
    	p.setPreco(Float.parseFloat(textFieldPreco.getText()));
    	
    	Estoque e = new Estoque();
    	e.setNomeProduto(textFieldProduto.getText());
    	e.setQuantidade(Integer.parseInt(textFieldQuantidade.getText()));
    	
    	produtosFluxo.add(p);
    	estoqueFluxo.add(e);
    	
    	textFieldProduto.clear();
    	textFieldQuantidade.clear();
    	textFieldPreco.clear();
    	
    	tableView = produtosFluxo;
    	
    	this.initialize(null, null);
    }

    @FXML
    void salvaFluxo(ActionEvent event) {
    	Almoxarifado a = new Almoxarifado();
    	a.setData(textFieldData.getText());
    	a.setTipo(cbTipoFluxo.getValue());
    	a.setFluxoProdutos(produtosFluxo);
    	
    	interfaceAlmoxarifado.registroAlmoxarifado(a);
    	if(a.getTipo().equals("Entrada")) {
    		interfaceEstoque.adicionaEstoque(estoqueFluxo);
    	}
    	else {
    		interfaceEstoque.retiraEstoque(estoqueFluxo);
    	}

    }   

}
