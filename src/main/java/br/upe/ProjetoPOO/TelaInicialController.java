package br.upe.ProjetoPOO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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


    //Ação do botão Controle de Apartamentos
    @FXML
    void switchToControleApartamentos(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("controleapartamentos.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 480, 480);
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/media/SC_icon.png"));
            stage.setTitle("Controle de Apartamentos");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    @FXML
    void switchToControleMorador() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("controlemorador.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 610, 450);
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/media/SC_icon.png"));
            stage.setTitle("Controle de Moradores");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    @FXML
    void switchToControleVeiculo() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("controleveiculo.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 610, 450);
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/media/SC_icon.png"));
            stage.setTitle("Controle de Veiculos");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
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
