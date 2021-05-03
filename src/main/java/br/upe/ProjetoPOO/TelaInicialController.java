package br.upe.ProjetoPOO;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TelaInicialController {

    @FXML
    private Button controleApartamentos;

    @FXML
    private Button controleMorador;

    @FXML
    private Button controleVeiculos;

    @FXML
    private Button controleFuncionario;

    @FXML
    private Button almoxarifado;

    @FXML
    private Button controleReservas;
    
    @FXML
    private void switchToControleApartamentos() throws IOException {
            App.setRoot("controleapartamentos");
        }
    
    @FXML
    private void switchToControleMorador() throws IOException {
            App.setRoot("controlemorador");
        }
    
    @FXML
    private void switchToControleVeiculo() throws IOException {
            App.setRoot("controleveiculo");
        }
    
    @FXML
    private void switchToControleFuncionario() throws IOException {
            App.setRoot("controlefuncionario");
        }
    
    @FXML
    private void switchToAlmoxarifado() throws IOException {
            App.setRoot("almoxarifado");
        }
    
    @FXML
    private void switchToControleReservas() throws IOException {
            App.setRoot("controlereservas");
        }

}
