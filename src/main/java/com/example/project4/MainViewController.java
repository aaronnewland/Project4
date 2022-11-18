package com.example.project4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {

    @FXML
    protected void handleChicagoView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ChicagoView-view.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Chicago Style Pizza");
        stage.setScene(new Scene(root, 650, 700));
        stage.show();
    }

    @FXML
    protected void handleNewYorkView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("NewYorkView-view.fxml"));
        Stage stage = new Stage();
        stage.setTitle("New York Style Pizza");
        stage.setScene(new Scene(root, 650, 700));
        stage.show();
    }

    @FXML
    protected void handleCurrentOrderView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CurrentOrderView-view.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Order Detail");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    @FXML
    protected void handleStoreOrdersView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StoreOrdersView-view.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Store Orders");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
}