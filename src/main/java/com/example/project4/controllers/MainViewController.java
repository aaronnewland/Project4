package com.example.project4.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MainViewController {

    @FXML
    protected void handleChicagoView() throws IOException {
        URL url = new File("src/main/resources/com/example/project4/ChicagoView-view.fxml").toURI().toURL();;
        Parent root = FXMLLoader.load(url);
        Stage stage = new Stage();
        stage.setTitle("Chicago Style Pizza");
        stage.setScene(new Scene(root, 650, 700));
        stage.show();
    }

    @FXML
    protected void handleNewYorkView() throws IOException {
        URL url = new File("src/main/resources/com/example/project4/NewYorkView-view.fxml").toURI().toURL();;
        Parent root = FXMLLoader.load(url);
        Stage stage = new Stage();
        stage.setTitle("New York Style Pizza");
        stage.setScene(new Scene(root, 650, 700));
        stage.show();
    }

    @FXML
    protected void handleCurrentOrderView() throws IOException {
        URL url = new File("src/main/resources/com/example/project4/CurrentOrderView-view.fxml").toURI().toURL();;
        Parent root = FXMLLoader.load(url);
        Stage stage = new Stage();
        stage.setTitle("Order Detail");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    @FXML
    protected void handleStoreOrdersView() throws IOException {
        URL url = new File("src/main/resources/com/example/project4/StoreOrdersView-view.fxml").toURI().toURL();;
        Parent root = FXMLLoader.load(url);
        Stage stage = new Stage();
        stage.setTitle("Store Orders");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
}