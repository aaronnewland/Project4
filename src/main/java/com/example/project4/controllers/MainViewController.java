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

/**
 * Controller for MainView-view.fxml
 * @author Aaron Newland, Dylan Pina
 */
public class MainViewController {

    /**
     * Action handler for image button for Chicago style pizza.
     * Allows user to open window to order Chicago style pizza.
     * @throws IOException if view is not found.
     */
    @FXML
    protected void handleChicagoView() throws IOException {
        URL url = new File("src/main/resources/com/example/project4/ChicagoView-view.fxml").toURI().toURL();;
        Parent root = FXMLLoader.load(url);
        Stage stage = new Stage();
        stage.setTitle("Chicago Style Pizza");
        stage.setScene(new Scene(root, 650, 700));
        stage.show();
    }

    /**
     * Action handler for image button for New York style pizza.
     * Allows user to open window to order New York style pizza.
     * @throws IOException if view is not found.
     */
    @FXML
    protected void handleNewYorkView() throws IOException {
        URL url = new File("src/main/resources/com/example/project4/NewYorkView-view.fxml").toURI().toURL();;
        Parent root = FXMLLoader.load(url);
        Stage stage = new Stage();
        stage.setTitle("New York Style Pizza");
        stage.setScene(new Scene(root, 650, 700));
        stage.show();
    }

    /**
     * Action handler for image button for displaying current order.
     * Allows user to open window displaying current order.
     * @throws IOException if view is not found.
     */
    @FXML
    protected void handleCurrentOrderView() throws IOException {
        URL url = new File("src/main/resources/com/example/project4/CurrentOrderView-view.fxml").toURI().toURL();;
        Parent root = FXMLLoader.load(url);
        Stage stage = new Stage();
        stage.setTitle("Order Detail");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    /**
     * Action handler for image button for displaying all store orders.
     * Allows user to open window displaying all store orders.
     * @throws IOException if view is not found.
     */
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