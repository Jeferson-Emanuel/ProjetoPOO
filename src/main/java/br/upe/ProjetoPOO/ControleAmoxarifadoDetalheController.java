package br.upe.ProjetoPOO;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.sun.javafx.binding.SelectBinding.AsInteger;

import br.upe.ProjetoPOO.Classes.Almoxarifado;
import br.upe.ProjetoPOO.Classes.Produto;
import br.upe.ProjetoPOO.Controladores.AlmoxarifadoControlador;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControleAmoxarifadoDetalheController implements Initializable{
	
	@FXML
    private Label labelData;

    @FXML
    private Label labelTipo;

    @FXML
    private TableView<Produto> tableViewProdutosFluxo;

    @FXML
    private TableColumn<Produto, String> textFieldProduto;

    @FXML
    private TableColumn<Produto, AsInteger> textFieldQuantidade;

    @FXML
    private TableColumn<Produto, Float> textFieldPreco;
    
    AlmoxarifadoControlador controladorAlmoxarifado = AlmoxarifadoControlador.getINSTANCE();
    
    //Objeto para receber dados da janela anterior
    Almoxarifado detalhe = new Almoxarifado();
    
    //Recebe objeto da janela anterior
    public void setData(Almoxarifado fluxoSelecionado) {
    	detalhe = fluxoSelecionado;
    	produtosFluxo = fluxoSelecionado.getFluxoProdutos();
    	//Preenche labels
    	labelData.setText(detalhe.getData());
    	labelTipo.setText(detalhe.getTipo());
    	
    	this.initialize(null, null);
    }    
    
    //Lista visível para preencher a tabela
    private List<Produto> produtosFluxo = new ArrayList<>();
    
    //Preenche a tabela
    @Override
    public void initialize(URL url, ResourceBundle resources) {
    	
    	textFieldProduto.setCellValueFactory(new PropertyValueFactory<Produto, String>("produto"));
    	textFieldQuantidade.setCellValueFactory(new PropertyValueFactory<Produto, AsInteger>("quant"));
    	textFieldPreco.setCellValueFactory(new PropertyValueFactory<Produto, Float>("preco"));
    	
    	//produtosFluxo = detalhe.getFluxoProdutos();
    	
    	if(produtosFluxo.size() > 0) {
    		tableViewProdutosFluxo.getItems().setAll(produtosFluxo);
    	}
    	else {
    		tableViewProdutosFluxo.getItems().clear();
    	}
   
    }

}
